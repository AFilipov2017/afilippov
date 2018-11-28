package ru.job4j.nonblockingalgoritm;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 25.11.2018
 */
public class NonBlockingCache {
    private ConcurrentHashMap<Integer, Base> cash;

    public NonBlockingCache() {
        this.cash = new ConcurrentHashMap<>();
    }

    public void add(Base model) {
        cash.putIfAbsent(model.getId(), model);
    }

    public void update(Base model) {
        int currentVer = cash.get(model.getId()).getVersion();
        cash.computeIfPresent(model.getId(), (integer, base) -> {
            if (currentVer == base.getVersion()) {
                model.setVersion(model.getId() + 1);
            } else {
                throw new OptimisticException("Object changed by another thread");
            }
            return model;
        });
    }

    public void delete(Base model) {
        cash.remove(model.getId(), model);
    }

    public int getSize() {
        return cash.size();
    }
}
