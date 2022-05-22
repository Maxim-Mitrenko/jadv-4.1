import java.util.Queue;

public class Operator {

    private static final long WAIT = 3000;
    private final Queue<String> queue;

    public Operator(Queue<String> queue) {
        this.queue = queue;
    }

    public void work() {
        try {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll() + " разговаривает с " + Thread.currentThread().getName());
                Thread.sleep(WAIT);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
