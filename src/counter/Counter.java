package counter;

public class Counter {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public synchronized int getCounter() {
        return counter;
    }

    static void main() throws InterruptedException {
        Counter counter = new Counter();
        int iterations = 100_000;

        // Thread 1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                counter.increment();
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                counter.decrement();
            }
        });

        // start both threads concurrently
        t1.start();
        t2.start();

        // wait for both threads to finish before reading the result
        t1.join();
        t2.join();

        int c = counter.getCounter();
        System.out.println("Final Counter Value: " + c);
    }
}
