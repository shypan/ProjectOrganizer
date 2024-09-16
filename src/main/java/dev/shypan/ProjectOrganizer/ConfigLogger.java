package dev.shypan.ProjectOrganizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ConfigLogger {

    @Value("${DB_NAME:NOT_FOUND}")
    private String database;

    @Value("${DB_USER:NOT_FOUND}")
    private String user;

    @Value("${DB_PASSWORD:NOT_FOUND}")
    private String password;

    @Value("${DB_CLUSTER:NOT_FOUND}")
    private String cluster;

    @PostConstruct
    public void logEnvVars() {
   	
        System.out.println("DB_DATABASE: " + database);
        System.out.println("DB_USER: " + user);
        System.out.println("DB_PASSWORD: " + password);
        System.out.println("DB_CLUSTER: " + cluster);
    }
}
