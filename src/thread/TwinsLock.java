package thread;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TwinsLock implements Lock {
    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private final Sync sync=new Sync(2);

    private static class Sync extends AbstractQueuedSynchronizer{
        Sync(int state){
            setState(state);
        }
        protected int tryAcquireShared(int arg) {
            while (true) {
                int currentState = getState();
                int newState = currentState - arg;
                if (newState < 0) {
                    return newState;
                }
                if (compareAndSetState(currentState, newState)) {
//                System.out.println("[tryAcquireShared] new State"+getState());
                    return newState;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true) {
                int currentState = getState();
                int newState = currentState + arg;
                if (compareAndSetState(currentState, newState)) {
                    return true;
                }
            }
//            System.out.println("[tryReleaseShared] new State"+getState());
//            return result;
        }
    }
}
