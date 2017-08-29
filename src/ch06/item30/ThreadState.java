package ch06.item30;

/**
 * Created by qinbingbing on 29/08/2017.
 */
public final class ThreadState {
    private final String name;

    private final int ordinal;

    private ThreadState(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public String name() { return name; }

    public int ordinal() { return ordinal; }

    public static final ThreadState NEW = new ThreadState("NEW", 0);

    public static final ThreadState RUNNABLE = new ThreadState("RUNNABLE", 1);

    public static final ThreadState BLOCKED = new ThreadState("BLOCKED", 2);

    public static final ThreadState WAITING = new ThreadState("WAITING", 3);

    public static final ThreadState TIMED_WAITING = new ThreadState("TIMED_WAITING", 4);

    public static final ThreadState TERMINATED = new ThreadState("TERMINATED", 5);

    public static ThreadState[] values() {
        return new ThreadState[]{ NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED };
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
