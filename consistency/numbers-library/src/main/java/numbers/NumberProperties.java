package numbers;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*
Класс производящий обработку Properties
с префиксом numbers
 */

@ConfigurationProperties(prefix = "numbers")
public class NumberProperties {
    private int bound;

    public NumberProperties(int bound) {
        this.bound = bound;
    }

    public NumberProperties() {
    }

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }
}
