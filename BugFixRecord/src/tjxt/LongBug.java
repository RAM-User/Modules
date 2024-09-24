package tjxt;

public class LongBug {
    public class test {
        public void main(String[] args) {
            Long a = 100L;
            Long b = 129L;
            Long a2 = 100L;
            Long b2 = 129L;

            System.out.println(a == a2);
            System.out.println(b == b2);
        }
    }

}
