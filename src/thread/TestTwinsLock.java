package thread;


import java.util.concurrent.locks.Lock;

public class TestTwinsLock {
    static Lock lock=new TwinsLock();
    static class Worker extends Thread{
        public void run(){
            while (true) {
                lock.lock();
                try {
//                    for(int i=0;i<10;i++) {
                        Thread.sleep(200);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(200);
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread thread=new Worker();
//            thread.setDaemon(true);
            thread.start();
        }
//        for(int i=0;i<10;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(".................................");
//        }

    }

}
