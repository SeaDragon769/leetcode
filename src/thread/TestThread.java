package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class TestThread implements Runnable {
    private int num=0;
    private int num2=0;
    private AtomicInteger num3=new AtomicInteger(3);

    Lock lock=new Mutex();
    @Override
    public void run() {
        try {
            numPlus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        numPlusSafe();
    }

    private void numPlus() throws Exception{
       int i=num;
       Thread.sleep(10);
       i=i+1;
       Thread.sleep(10);
       num=i;
    }

    private void numPlusSafe(){
        lock.lock();
        try{
            int i=num2;
            Thread.sleep(10);
            i=i+1;
            Thread.sleep(10);
            num2=i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    private int getNum(){
        return num;
    }
    private int getNum2(){
        return num2;
    }

    public static void main(String[] args) throws Exception{

        TestThread testThread=new TestThread();
        long time=System.currentTimeMillis();
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(testThread);
            thread.start();
//            thread.join();
        }
        System.out.println(System.currentTimeMillis()-time);
        Thread.sleep(5000);
        System.out.println(testThread.num);
        System.out.println(testThread.num2);
    }

}
