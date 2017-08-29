package ch10.item66.brokenStopThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by qinbingbing on 06/07/2017.
 */
public class StopMultiThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        int testNum = 1;
        List<Boolean> result = new ArrayList<>(testNum);
        CountDownLatch countDownLatch = new CountDownLatch(testNum);
        for (int i = 0; i < testNum; i++) {
            int copy = i;
            Thread backgroundThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    long beginTime = System.currentTimeMillis();
                    int j = 0;
                    while (!stopRequested) {
                        /*try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }*/
                        j++;
//                        System.out.println("brokenStopMultiThread " + copy + " " + j++);
                    }
                    long runTime = System.currentTimeMillis() - beginTime;
                    System.out.println("brokenStopMultiThread " + copy + " run " + runTime);
                    result.add(runTime < 1500);
                    countDownLatch.countDown();
                }
            });
            backgroundThread.start();
        }
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
        countDownLatch.await();
        System.out.println("result:" + result);
        int expectedTimes = 0;
        for (Boolean b : result)
            if (b)
                expectedTimes++;
        System.out.println("expectedTimes:" + expectedTimes + ", brokenTimes:" + (result.size() - expectedTimes));
    }
}
