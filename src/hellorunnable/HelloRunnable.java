package hellorunnable;


class ExtendThreads extends Thread {
    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Hello Extend Thread");
    }
}


public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "] Hello Runnable");
    }

    static void main() {
        new Thread(new HelloRunnable()).start();
        new ExtendThreads().start();
    }
}
