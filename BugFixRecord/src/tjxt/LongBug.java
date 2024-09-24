package tjxt;

public class LongBug {

    public static void main(String[] args) {
        Long a = 100L;
        Long b = 129L;

        Long a2 = 100L;
        Long b2 = 129L;

        int a3= 1000;
        int a4 = 1000;
        System.out.println(a3 == a4);

        System.out.println(a == a2);// true
        System.out.println(b == b2);// true
    }

}
