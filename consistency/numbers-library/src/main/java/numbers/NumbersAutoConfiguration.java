package numbers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Класс создает библиотеку которую можно подключить как зависимость в свой проект
 */
@ConditionalOnClass(ThreadLocalRandom.class)
@Configuration
@EnableConfigurationProperties(NumberProperties.class)
public class NumbersAutoConfiguration {

    @Bean
    NumberService numberProperties(NumberProperties properties) {
        return new NumberService(properties);
    }


    @Configuration
    @ConditionalOnClass(RouterFunction.class)
    public static class WebConfig {

        @Bean
        RouterFunction<ServerResponse> routes(NumberService ns) {
            return route()
                    .GET("/number", request -> ok().bodyValue(
                            Collections.singletonMap("numbers", ns.generateRandomNumber())))
                    .build();
        }
    }
}


