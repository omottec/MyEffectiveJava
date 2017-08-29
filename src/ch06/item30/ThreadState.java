package ch06.item30;

/**
 * Created by qinbingbing on 29/08/2017.
 */
public final class ThreadState {
    private ThreadState() {}

    public static final ThreadState NEW = new ThreadState();

    public static final ThreadState RUNNABLE = new ThreadState();

    public static final ThreadState BLOCKED = new ThreadState();

    public static final ThreadState WAITING = new ThreadState();

    public static final ThreadState TIMED_WAITING = new ThreadState();

    public static final ThreadState TERMINATED = new ThreadState();
}
