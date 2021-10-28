package multithreading;

import java.util.concurrent.Semaphore;

public class PrintFooBarAlternately1 {
    private int n;

    Semaphore semaphore1=new Semaphore(1);
    Semaphore semaphore2=new Semaphore(1);


    public PrintFooBarAlternately1(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
           semaphore1.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                //   printFoo.run();
                System.out.println("foo");

               semaphore1.release();

        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                //printBar.run();
                System.out.println("bar");
semaphore2.release();
            }
        }


    public static void main(String args[]) {
        PrintFooBarAlternately1 printFooBarAlternately = new PrintFooBarAlternately1(2);
        FooNew foo=new FooNew(printFooBarAlternately);
        Thread t1=new Thread(foo);
        BarNew bar=new BarNew(printFooBarAlternately);
        Thread t2=new Thread(bar);
        t1.start();
        t2.start();

    }

}

class BarNew implements Runnable {
    PrintFooBarAlternately1 printFooBarAlternately;

    public BarNew(PrintFooBarAlternately1 printFooBarAlternately) {
        this.printFooBarAlternately = printFooBarAlternately;
    }

    public void run() {
        try {
            printFooBarAlternately.bar();

        }
        catch (Exception e){

        }
    }

}
class FooNew implements Runnable {
    PrintFooBarAlternately1 printFooBarAlternately;

    public FooNew(PrintFooBarAlternately1 printFooBarAlternately) {
        this.printFooBarAlternately = printFooBarAlternately;
    }

    public void run() {
        try {
            printFooBarAlternately.foo();

        }
        catch (Exception e){

        }
    }

}
