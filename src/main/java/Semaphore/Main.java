package Semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

    }
}

class Person extends Thread{
    String name;
    Semaphore semaphore;

    public Person(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }


}


