package ru.job4j.tracker;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public List<Item> itemList = new ArrayList<>();

    private static void createItemList(List<Item> itemList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Item item = new Item();
            item.setName(resultSet.getString("name"));
            item.setId(resultSet.getInt("id"));
            Timestamp timestamp  = resultSet.getTimestamp("created");
            LocalDateTime localDateTime = timestamp.toLocalDateTime();
            item.setCreated(localDateTime);
            itemList.add(item);
        }
    }

    private void init() {
        try (InputStream in = new FileInputStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("INSERT INTO items (name, created) VALUES (?, ?)",
                             /* вставляем автоматически сгенерирумый ключ*/
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getTime()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = true;
        item.setId(id);
        try (PreparedStatement statement = cn.prepareStatement(
                "UPDATE items SET name = ? WHERE id = ?;")) {
            statement.setString(1, item.getName());
            statement.setInt(2, item.getId());
            statement.execute();
            if (statement.getUpdateCount() == 0) {
                rsl = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement =
                cn.prepareStatement("DELETE FROM items WHERE id = ?;")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        try (PreparedStatement statement =
                     cn.prepareStatement("SELECT * FROM items")) {
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                SqlTracker.createItemList(itemList, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        try (PreparedStatement statement =
                cn.prepareStatement("SELECT * FROM items WHERE name = ?;")) {
            statement.setString(1, key);
            statement.execute();
            try (ResultSet resultSet = statement.executeQuery()) {
                SqlTracker.createItemList(itemList, resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        try (PreparedStatement statement = cn.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item.setId(resultSet.getInt("id"));
                    item.setName(resultSet.getString("name"));
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    }
