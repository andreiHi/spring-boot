package com.demo.service;

import com.demo.domain.CustomerCreated;
import com.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class CustomerCreatedListener {
    private final CustomerRepository customerRepository;
    private final TokenGenerator tokenGenerator;

    @TransactionalEventListener
    @Async
    //@Transactional(propagation = Propagation.REQUIRES_NEW) for first test withOut async
    public void handle(CustomerCreated event) {
      this.customerRepository.findById(event.getCustomerId())
              .ifPresent(tokenGenerator::generateToken);
    }
}
