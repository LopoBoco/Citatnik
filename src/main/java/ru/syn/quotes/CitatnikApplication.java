package ru.syn.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.syn.quotes.services.BashParser;
import ru.syn.quotes.services.QuoteService;

import java.util.Map;

@SpringBootApplication
public class CitatnikApplication implements CommandLineRunner {

    @Autowired
    QuoteService service;

    public static void main(String[] args) {
        SpringApplication.run(CitatnikApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
