package com.blogpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class BlogPostPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogPostPocApplication.class, args);
    }

}
