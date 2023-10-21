package se.backtus.backend;

import org.springframework.boot.SpringApplication;

public class TestBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(BackendApplication::main)
                .with(SharedTestContainerConfig.class)
                .run(args);
    }
}
