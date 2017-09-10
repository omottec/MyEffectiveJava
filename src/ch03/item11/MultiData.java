package ch03.item11;

/**
 * Created by omottec on 10/09/2017.
 */
public class MultiData implements Cloneable {
    public int i;
    public boolean b;
    public char c;
    public float f;
    public double d;
    public String s;
    public MultiData next;

    @Override
    protected MultiData clone() {
        try {
            return (MultiData) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        MultiData multiData = new MultiData();
        multiData.i = 1;
        multiData.b = true;
        multiData.c = '&';
        multiData.f = 2f;
        multiData.d = 3d;
        multiData.s = "omottec";
        MultiData m = new MultiData();
        m.i = 11;
        m.b = false;
        m.c = '$';
        m.f = 22f;
        m.d = 33d;
        m.s = "Daniel Bond";
        multiData.next = m;
        MultiData clone = multiData.clone();
//        clone.next = multiData.next.clone();

        System.out.println(multiData.s);
        System.out.println(clone.s);
        clone.s = "~" + clone.s;
        System.out.println(multiData.s);
        System.out.println(clone.s);

        System.out.println(multiData.next.s);
        System.out.println(clone.next.s);
        clone.next.s = "~" + clone.next.s;
        System.out.println(multiData.next.s);
        System.out.println(clone.next.s);
    }
}
