package edu.escuelaing.arep.jpa;

import edu.escuelaing.arep.jpa.entities.Customer;
import edu.escuelaing.arep.jpa.entities.Property;
import edu.escuelaing.arep.jpa.repositories.CustomerRepository;
import edu.escuelaing.arep.jpa.repositories.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoProperty(PropertyRepository repository) {
        return (args) -> {
            // save a few properties
            repository.save(new Property("Cra 1 # 1-1", 100000000.0, 100, "Casa de 2 pisos"));
            repository.save(new Property("Cra 2 # 2-2", 200000000.0, 200, "Casa de 3 pisos"));
            repository.save(new Property("Cra 3 # 3-3", 300000000.0, 300, "Casa de 4 pisos"));
            repository.save(new Property("Cra 4 # 4-4", 400000000.0, 400, "Casa de 5 pisos"));
            repository.save(new Property("Cra 5 # 5-5", 500000000.0, 500, "Casa de 6 pisos"));


            // fetch all properties
            log.info("Properties found with findAll():");
            log.info("-------------------------------");
            for (Property property : repository.findAll()) {
                log.info(property.toString());
            }
            log.info("");

            // fetch an individual property by ID
            Property property = repository.findById(1L);
            log.info("Property found with findById(1L):");
            log.info("--------------------------------");
            log.info(property.toString());
            log.info("");

        };
    }

    @Bean
    public CommandLineRunner demoCustomer(CustomerRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(customer -> {
                log.info(customer.toString());
            });
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }


}
