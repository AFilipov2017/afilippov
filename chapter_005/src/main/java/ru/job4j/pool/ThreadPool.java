package ru.job4j.pool;

import ru.job4j.notify.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 28.11.2018
 */
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private boolean isAlive = true;

    public ThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < size; i++) {
            threads.add(new Thread(() -> {
                while (isAlive) {
                    try {
                        tasks.poll().run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
        threads.forEach((thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }

    public void work(Runnable job) {
        tasks.offer(job);
    }

    public void shutdown() {
        isAlive = false;
    }
}
