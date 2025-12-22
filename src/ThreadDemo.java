// Method 1: Extending Thread class
class TestThread extends Thread {
    public void run() {
        System.out.println("Thread running using Thread class");
    }
}

// Method 2: Implementing Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running using Runnable interface");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {

        // Using Thread class
        TestThread t1 = new TestThread();
        t1.start();

        // Using Runnable interface
        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t2.start();
    }
}
