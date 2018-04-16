package ru.job4j.generic;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 1
 * @since
 */
public class RoleStore<T extends Role> extends AbstractStore<T> {

    @Override
    public void add(T model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public T findById(String id) {
        return super.findById(id);
    }

    @Override
    public T getModel(int index) {
        return super.getModel(index);
    }
}
