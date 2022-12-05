package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Класс описывает банковский сервис, который позволяет добавлять\ удалять пользователя,
 *  добавлять  банковские счета,
 * переводить деньги с разных счетов.
 * @author Сергей
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение данных о пользователях  и их счетах осуществляется в коллекции типа map.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет поьзователя в базу.
     * Метод не дает добавить пользователя который уже есть в базе.
     * @param user пользователь который добавляется в базу.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());

    }

    /**
     * метод удаляет пользователя по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает true  если пользователь удален
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * метод добавляет новый счет к пользователю, если пользователь существует
     * и у него нет такого счета
     * @param passport номер паспорта пользователя
     * @param account новый счет для добавеления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
                if (!accounts.contains(account)) {
                    accounts.add(account);
            }
        }
    }

    /**
     * метод ищет пользователя по номеру пвспорта
     * @return возвращает пользователя с указанным паспотом
     * или null если такого пользователя нет
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод позволяет получеть счет пользователя по поспорту и реквезитам
     * @param requisite реквезиты счета пользователя
     * @return данные о счете если они есть или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * метод перевода денег с одного счета на другой
     * @param srcPassport - паспортные данные пользователи, которые перечисляет деньги.
     * @param srcRequisite - реквизиты счета, с которого перечисляются деньги.
     * @param destPassport - паспортные данные пользователи, которму перечисляются деньги.
     * @param destRequisite - реквизиты счета, на который перечисляются деньги.
     * @param amount - перчисляемая сумма.
     * @return - возвращает true если операция перечисленя прошла успешно.
     * Если остутствует счет-источник и/или счет назанчение,
     * либо паспортные данные пользователя-отправителя и/или пользователя-получателя неверные,
     * либо на счете-источнике недостаточно средств, метод возвращает false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accsrc = findByRequisite(srcPassport, srcRequisite);
        Account accdest = findByRequisite(destPassport, destRequisite);
        if (accsrc != null && accdest != null && accsrc.getBalance() >= amount) {
            accsrc.setBalance(accsrc.getBalance() - amount);
            accdest.setBalance(accdest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод позволяет получить список счетов пользователя
     * @param user - информация о пользователе.
     * @return - возвращает список счетов, которые есть у пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
