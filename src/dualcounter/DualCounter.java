package dualcounter;

public class DualCounter {
    private int countA = 0;
    private int countB = 0;
    private Object lockA = new Object();
    private Object lockB = new Object();

    public void incrementA() {
        synchronized (lockA) {
            countA++;
        }
    }

    public void incrementB() {
        synchronized (lockB) {
            countB++;
        }
    }

    public int getCountA() {
        return countA;
    }

    public int getCountB() {
        return countB;
    }

    static void main() throws InterruptedException {
        DualCounter dualCounter = new DualCounter();
        int iterations = 10;

        Thread tA = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                dualCounter.incrementA();
            }
        });

        Thread tB = new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                dualCounter.incrementB();
            }
        });


        tA.start();
        tB.start();

        tB.join();
        tA.join();


        int countAValue = dualCounter.getCountA();
        int countBValue = dualCounter.getCountB();

        System.out.printf("CountA Result: %d \nCountB Result: %d", countAValue, countBValue);

    }
}
