package com.example.spring_boot_and_angular;

import com.example.spring_boot_and_angular.enumeration.Status;
import com.example.spring_boot_and_angular.model.Server;
import com.example.spring_boot_and_angular.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootAndAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndAngularApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepository serverRepository){
        return args -> {
            serverRepository.save(new Server(null, "192.168.1.1", "Ubuntu Linux1", "16GB", "Personal PC",
                    "http://localhost:8080/server/image/server1.png", Status.SERVER_DOWN));
            serverRepository.save(new Server(null, "192.168.1.2", "Ubuntu Linux2", "16GB", "Personal PC",
                    "http://localhost:8080/server/image/server2.png", Status.SERVER_UP));
            serverRepository.save(new Server(null, "192.168.1.3", "Ubuntu Linux3", "16GB", "Personal PC",
                    "http://localhost:8080/server/image/server3.png", Status.SERVER_UP));
            serverRepository.save(new Server(null, "192.168.1.4", "Ubuntu Linux4", "16GB", "Personal PC",
                    "http://localhost:8080/server/image/server4.png", Status.SERVER_UP));
        };
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
