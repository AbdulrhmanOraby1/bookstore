package com.bookstore.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.repository.BookRepository;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {

        };
    }
}
