package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete item ===");
        boolean rsl = false;
        int id = input.askInt("Enter id: ");
        if (memTracker.findById(id) != null) {
            memTracker.delete(id);
            rsl = true;
        }
        if (memTracker.findById(id) == null && rsl) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
