package ch10.item66.fixedStopThread1;

import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 06/07/2017.
 */
public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long beginTime = System.currentTimeMillis();
                int i = 0;
                while (!stopRequested())
                    System.out.println("fixedStopThread1 " + i++);
                System.out.println("fixedStopThread1 run " + (System.currentTimeMillis() - beginTime));
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
