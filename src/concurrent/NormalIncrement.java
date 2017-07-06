package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by qinbingbing on 06/07/2017.
 * <p>
 *     test result:
 * </p>
 */
public class NormalIncrement {
    private int value;
    private CountDownLatch countDownLatch = new CountDownLatch(100);

    private boolean increment() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        value++;
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("NormalIncrement:" + value);
        return value == 100 * 1000;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            result.add(new NormalIncrement().increment());
        int expectResultTimes = 0;
        for (Boolean b : result)
            if (b) expectResultTimes++;
        System.out.println("expectResultTimes:" + expectResultTimes + ", brokenResultTimes:" + (result.size() - expectResultTimes));
    }
}
