package com.powerjasper.carlease;

import com.powerjasper.carlease.entity.CustomerEntity;
import com.powerjasper.carlease.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistDatabase {
    private static final Logger log = LoggerFactory.getLogger(PersistDatabase.class);

    private CustomerEntity customer = CustomerEntity.builder()
            .name("testCustomer")
            .street("testStreet")
            .houseNumber("1")
            .zipCode("1234AB")
            .place("testville")
            .emailAddress("test@test.test")
            .phoneNumber("+31612345678")
            .build();;

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository){
        return args -> {
            log.info("generating customer: " + customerRepository.save(customer));

        };
    }
}
