package ch10.item66.brokenStopThread;

import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 06/07/2017.
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long beginTime = System.currentTimeMillis();
                int i = 0;
                while (!stopRequested)
                    System.out.println("brokenStopThread " + i++);
                System.out.println("brokenStopThread run " + (System.currentTimeMillis() - beginTime));
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
