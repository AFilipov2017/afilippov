package ru.job4j.notify;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Filippov (afilipov1980@gmail.com)
 * @version 0.1
 * @since 22.11.2018
 */
public class SimpleBlockingQueueTest {

    @Test
    public void whenTheQueueIsEmpty() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

        Thread tPoll = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread tOffer = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.offer(5);
            }
        });

        tPoll.start();
        tOffer.start();
        tPoll.join();
        tOffer.join();
        queue.offer(1);
        queue.offer(2);
        assertThat(queue.poll(), is(1));
    }

    @Test
    public void whenTheQueueIsFull() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

        Thread tPoll = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread tOffer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 6; i++) {
                    queue.offer(i);
                }
            }
        });
        tOffer.start();
        tPoll.start();
        tOffer.join();
        tPoll.join();

        assertThat(queue.poll(), is(2));
    }

    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(
                () -> {
                    IntStream.range(0, 5).forEach(
                            queue::offer
                    );
                }
        );
        producer.start();
        Thread consumer = new Thread(
                () -> {
                    while (queue.getSize() !=0 || !Thread.currentThread().isInterrupted()) {
                        try {
                            buffer.add(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
    }
}
