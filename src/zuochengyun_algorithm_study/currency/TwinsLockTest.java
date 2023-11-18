package zuochengyun_algorithm_study.currency;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
    static final Lock lock = new TwinsLock();
    public static void main(String[] args) {
        for (int i = 0;i < 10 ;i++){
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }
        for (int i = 0;i < 10;i++){
            SleepUtils.second(1);
            System.out.println();
        }
    }
    static class Worker extends Thread{
        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    SleepUtils.second(1);
                    System.out.println(Thread.currentThread().getName());
                    SleepUtils.second(1);
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
