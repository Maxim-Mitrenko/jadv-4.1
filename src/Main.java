import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    private static final long START_WORK = 1000;

    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        ATC atc = new ATC(queue);
        Operator operator1 = new Operator(queue);
        Operator operator2 = new Operator(queue);
        Operator operator3 = new Operator(queue);
        new Thread(atc::work).start();
        try {
            Thread.sleep(START_WORK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(operator1::work, "Оператор 1").start();
        new Thread(operator2::work, "Оператор 2").start();
        new Thread(operator3::work, "Оператор 3").start();
    }
}
