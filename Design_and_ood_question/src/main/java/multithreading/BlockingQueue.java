package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BlockingQueue {
    Queue<Integer> queue;
    int capacity;


    public BlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (this) {
            while (queue.size() == capacity) {
                wait();
            }
            queue.add(element);
            notify();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                wait();
            }
            int elem=queue.poll();

             notify();
             return elem;
        }
    }

    public int size() {
        return queue.size();
    }

    public static void main(String args[]) throws Exception {
        BlockingQueue blockingQueue = new BlockingQueue(2);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Enqueue(blockingQueue, 1));
        executorService.submit(new Deque(blockingQueue));
        executorService.submit(new Deque(blockingQueue));
        executorService.submit(new Enqueue(blockingQueue, 0));
        executorService.submit(new Enqueue(blockingQueue, 2));
        executorService.submit(new Enqueue(blockingQueue, 3));
        executorService.submit(new Enqueue(blockingQueue, 4));
        executorService.submit(new Deque(blockingQueue));
    }
}

class Enqueue implements Runnable {
    BlockingQueue blockingQueue;
    private int elem;

    public Enqueue(BlockingQueue blockingQueue, int elem) {
        this.blockingQueue = blockingQueue;
        this.elem = elem;
    }

    @Override
    public void run() {
        try {
            blockingQueue.enqueue(elem);
        } catch (InterruptedException exception) {

        }
    }
}

class Deque implements Runnable {
    BlockingQueue blockingQueue;

    public Deque(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.dequeue();
        } catch (InterruptedException exception) {
        }
    }

}