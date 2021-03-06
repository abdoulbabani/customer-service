package com.example.inventoryservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
class Product{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

}
@RepositoryRestResource
interface  ProductRepository extends JpaRepository<Product,Long>{

}

@SpringBootApplication
public class InventoryServiceApplication{

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {

            productRepository.save(new Product(null,"ord HP 878",8700));
            productRepository.save(new Product(null,"ord Mac Book Pro",12000));
            productRepository.save(new Product(null,"Imprimante Epson",8700));

        };
    }
}
