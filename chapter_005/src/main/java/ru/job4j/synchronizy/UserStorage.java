package ru.job4j.synchronizy;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 17.11.2018
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Set<User> userSet;

    public UserStorage() {
        this.userSet = new HashSet<>();
    }

    public synchronized boolean add(User user) {
        return userSet.add(user);
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        if (delete(user)) {
            result = userSet.add(user);
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        return userSet.remove(user);
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        if (findById(fromId).getAmount() >= amount) {
            findById(fromId).setAmount(findById(fromId).getAmount() - amount);
            findById(toId).setAmount(findById(toId).getAmount() + amount);
            result = true;
        }
        return result;
    }

    public synchronized User findById(int id) {
        User result = null;
        for (User user : userSet
                ) {
            if (user.getId() == id) {
                result = user;
                break;
            }
        }
        return result;
    }
}
