package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.Date;

class EditItem implements UserAction {

    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter task`s id: ");
        String name = input.ask("Please enter task`s name: ");
        String desc = input.ask("Please enter task`s desc: ");
        Date date = new Date();
        long created = date.getTime();
        String[] comm = new String[10];
        Item items = new Item(name, desc, created, comm);
        items.setId(id);
        tracker.replace(id, items);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit item.");
    }
}

class FindItemByName implements UserAction {

    public int key() {
        return 5;
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please enter task`s name: ");
        Item[] item = tracker.findByName(name);
        for (Item index : item) {
            System.out.println(String.format("id:%s, name:%s, desc:%s, creationTime:%d", index.getId(), index.getName(), index.getDescription(), index.created));
        }
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Find item by name.");
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = this.new FindItemById();
        this.actions[5] = new FindItemByName();
        this.actions[6] = this.new Exit();
    }

    public int[] range() {
        int[] arr = new int[this.actions.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = actions[i].key();
        }
        return arr;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter task`s name: ");
            String desc = input.ask("Please enter task`s desc: ");
            Date date = new Date();
            long created = date.getTime();
            String[] comm = new String[10];
            tracker.add(new Item(name, desc, created, comm));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    private static class ShowAllItems implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("id:%s, name:%s, desc:%s, creationTime:%d", item.getId(), item.getName(), item.getDescription(), item.created));
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    private static class DeleteItem implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task`s id: ");
            tracker.delete(id);
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    private class FindItemById implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task`s id: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("id:%s, name:%s, desc:%s, creationTime:%d", item.getId(), item.getName(), item.getDescription(), item.created));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }

    private class Exit implements UserAction {

        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println("");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit program.");
        }
    }
}