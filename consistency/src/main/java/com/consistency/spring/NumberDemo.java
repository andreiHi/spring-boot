package com.consistency.spring;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import numbers.NumberService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Log4j2
public class NumberDemo {

    private final NumberService numberService;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        final int randomNumber = this.numberService.generateRandomNumber();
        log.info("New random number: {}", randomNumber);
    }
}
