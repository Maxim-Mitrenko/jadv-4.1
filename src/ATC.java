import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;

public class ATC {

    private static final long WAIT = 200;
    private final Queue<String> queue;
    private Random random = new Random();

    public ATC(Queue<String> queue) {
        this.queue = queue;
    }

    public void work() {
        try {
            for (int i = 0; i < 100; i++) {
                String number = "+7" + random.ints(10, 0, 9).mapToObj(String::valueOf).collect(Collectors.joining());
                queue.add(number);
                Thread.sleep(WAIT);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
