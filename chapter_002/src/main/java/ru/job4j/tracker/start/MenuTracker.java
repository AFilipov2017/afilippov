package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Item> item = tracker.findByName(name);
        for (Item index : item) {
            System.out.println(String.format("id:%s, name:%s, desc:%s, creationTime:%d", index.getId(), index.getName(), index.getDescription(), index.created));
        }
    }
}

public class MenuTracker {
    private Input input;
    private ITracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private int position = 0;

    public MenuTracker(Input input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        this.actions.add(position++, this.new AddItem(0, "Add item"));
        this.actions.add(position++, new MenuTracker.ShowAllItems(1, "Show all items"));
        this.actions.add(position++, new EditItem(2, "Edit item"));
        this.actions.add(position++, new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(position++, this.new FindItemById(4, "Find item by id"));
        this.actions.add(position++, new FindItemByName(5, "Find item by name"));
        this.actions.add(position++, this.new Exit());
    }

    public void addAction(UserAction action) {
        this.actions.add(action);
    }

    public List<Integer> range() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < actions.size(); i++) {
            arr.add(i, actions.get(i).key());
        }
        return arr;
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, (Tracker) this.tracker);
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