package ch06.item30;

import java.util.Arrays;

/**
 * Created by qinbingbing on 29/08/2017.
 */
public class EnumStateTest {
    public static void main(String[] args) {
        Thread.State[] values = Thread.State.values();
        System.out.println(Arrays.toString(values));

        ThreadState[] threadStates = ThreadState.values();
        System.out.println(Arrays.toString(threadStates));


        Thread.State.NEW.ordinal();
    }
}
