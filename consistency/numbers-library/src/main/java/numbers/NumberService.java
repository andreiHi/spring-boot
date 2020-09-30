package numbers;

import java.util.concurrent.ThreadLocalRandom;

public class NumberService {

    private final int bound;

    /*
    Производит добавление проперти с помощью @Value
        public NumberService(@Value("${numbers.bound}") int bound) {
            this.bound = bound;
        }
     */

    public NumberService(NumberProperties np) {
        this.bound = np.getBound();
    }

    public int generateRandomNumber() {
        final ThreadLocalRandom th = ThreadLocalRandom.current();
        return th.nextInt(this.bound);
    }
}
