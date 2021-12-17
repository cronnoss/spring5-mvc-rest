package com.cronnoss.bootstrap;

import com.cronnoss.domain.Category;
import com.cronnoss.domain.Customer;
import com.cronnoss.repositories.CategoryRepository;
import com.cronnoss.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
    }

    private void loadCategories() {

        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Categories Loaded = " + categoryRepository.count());
    }

    private void loadCustomers() {

        Customer joanne = new Customer();
        joanne.setFirstName("Joanne");
        joanne.setLastName("Rowling");

        Customer jimmy = new Customer();
        jimmy.setFirstName("Jimmy");
        jimmy.setLastName("Jarmusch");

        customerRepository.save(joanne);
        customerRepository.save(jimmy);

        System.out.println("Customers Loaded = " + customerRepository.count());
    }
}
