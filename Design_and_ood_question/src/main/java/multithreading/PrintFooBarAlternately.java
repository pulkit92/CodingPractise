package multithreading;

public class PrintFooBarAlternately {
    private int n;
    volatile boolean isFoo = true;

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!isFoo) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                //   printFoo.run();
                System.out.println("foo");
                isFoo = false;
                notify();
            }
        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (isFoo) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                //printBar.run();
                System.out.println("bar");
                    notify();
                isFoo = true;

            }
        }
    }

    public static void main(String args[]) {
        PrintFooBarAlternately printFooBarAlternately = new PrintFooBarAlternately(2);
        Foo foo=new Foo(printFooBarAlternately);
        Thread t1=new Thread(foo);
       Bar bar=new Bar(printFooBarAlternately);
       Thread t2=new Thread(bar);
        t1.start();
        t2.start();

    }

}

class Bar implements Runnable {
    PrintFooBarAlternately printFooBarAlternately;

    public Bar(PrintFooBarAlternately printFooBarAlternately) {
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
class Foo implements Runnable {
    PrintFooBarAlternately printFooBarAlternately;

    public Foo(PrintFooBarAlternately printFooBarAlternately) {
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
