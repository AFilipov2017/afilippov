package ru.job4j.nonblockingalgoritm;


import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 26.11.2018
 */
public class NonBlockingCacheTest {
    @Ignore
    @Test
    public void whenValueIsChangedByAnotherThread() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        NonBlockingCache cache = new NonBlockingCache();
        Base model = new Base(1, 1);
        cache.add(model);
        Thread t = new Thread(() -> {
            try {
                cache.update(model);
            } catch (OptimisticException e) {
                ex.set(e);
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                cache.update(model);
            } catch (OptimisticException e) {
                ex.set(e);
            }
        });

        t.start();
        t1.start();
        t.join();
        t1.join();
        assertThat(ex.get().getMessage(), is("Object changed by another thread"));
        assertThat(model.getVersion(), is(2));
    }

    @Test
    public void whenDeletedObject() {
        NonBlockingCache cache = new NonBlockingCache();
        Base model = new Base(1, 1);
        Base modelTwo = new Base(2, 1);
        Base modelThree = new Base(3, 1);
        cache.add(model);
        cache.add(modelTwo);
        cache.add(modelThree);
        assertThat(cache.getSize(), is(3));
        cache.delete(modelTwo);
        assertThat(cache.getSize(), is(2));
        cache.delete(model);
        assertThat(cache.getSize(), is(1));
    }
}

