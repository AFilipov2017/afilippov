package ru.job4j.synchronizy;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 18.11.2018
 */
public class SimpleListWrapperTest {

    @Test
    public void whenWeAddedByTwoThread() throws InterruptedException {
        SimpleListWrapper list = new SimpleListWrapper();
        ThreadTest test1 = new ThreadTest(list);
        ThreadTest test2 = new ThreadTest(list);
        test1.start();
        test2.start();
        test1.join();
        test2.join();
        assertThat(list.getSize(), is(20));
        assertThat(list.get(17), is(7));
    }

    public class ThreadTest extends Thread {
        SimpleListWrapper wrapp;

        public ThreadTest(SimpleListWrapper wrapp) {
            this.wrapp = wrapp;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                this.wrapp.add(i);
            }
        }
    }

    public class IterTest extends Thread {
        SimpleListWrapper wrapp;
        int iter = 0;

        public IterTest(SimpleListWrapper wrapp) {
            this.wrapp = wrapp;
        }

        public int getIter() {
            return iter;
        }

        @Override
        public void run() {
            Iterator iterator = wrapp.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                iter++;
            }
        }
    }

    @Test
    public void testIterationsInThreads() throws InterruptedException {
        SimpleListWrapper list = new SimpleListWrapper();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        IterTest iter1 = new IterTest(list);
        IterTest iter2 = new IterTest(list);
        iter1.start();
        iter2.start();
        iter1.join();
        iter2.join();
        assertThat(iter1.getIter(), is(10));
        assertThat(iter2.getIter(), is(10));
    }
}
