package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.Date;

class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
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
}

class FindItemByName extends BaseAction {

    public FindItemByName(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please enter task`s name: ");
        Item[] item = tracker.findByName(name);
        for (Item index : item) {
            System.out.println(String.format("id:%s, name:%s, desc:%s, creationTime:%d", index.getId(), index.getName(), index.getDescription(), index.created));
        }
    }
}

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        this.actions[position++] = this.new AddItem(0, "Add item");
        this.actions[position++] = new MenuTracker.ShowAllItems(1, "Show all items");
        this.actions[position++] = new EditItem(2, "Edit item");
        this.actions[position++] = new MenuTracker.DeleteItem(3, "Delete item");
        this.actions[position++] = this.new FindItemById(4, "Find item by id");
        this.actions[position++] = new FindItemByName(5, "Find item by name");
        this.actions[position++] = this.new Exit();
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
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

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter task`s name: ");
            String desc = input.ask("Please enter task`s desc: ");
            Date date = new Date();
            long created = date.getTime();
            String[] comm = new String[10];
            tracker.add(new Item(name, desc, created, comm));
        }
    }


    private static class ShowAllItems extends BaseAction {

        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("id:%s, name:%s, desc:%s, creationTime:%d", item.getId(), item.getName(), item.getDescription(), item.created));
            }
        }
    }

    private static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task`s id: ");
            tracker.delete(id);
        }
    }

    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please enter task`s id: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("id:%s, name:%s, desc:%s, creationTime:%d", item.getId(), item.getName(), item.getDescription(), item.created));
        }
    }

    private class Exit implements UserAction {

        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit program.");
        }
    }
}