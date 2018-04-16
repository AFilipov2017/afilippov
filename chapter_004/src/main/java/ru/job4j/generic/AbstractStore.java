package ru.job4j.generic;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> base = new SimpleArray<>(new Object[100]);

    @Override
    public void add(T model) {
        base.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T mod = findById(id);
        int index = base.getIndex(mod);
        base.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        Base mod = findById(id);
        base.delete(base.getIndex(mod));
        return true;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T model : base) {
            if (model.getId().equals(id)) {
                result = model;
                break;
            }
        }
        return result;
    }

    public T getModel(int index) {
        return (T) base.get(index);
    }
}
