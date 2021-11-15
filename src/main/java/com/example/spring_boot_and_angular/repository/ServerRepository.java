package com.example.spring_boot_and_angular.repository;

import com.example.spring_boot_and_angular.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {

    Server findByIpAddress(String ipAddress);
}
