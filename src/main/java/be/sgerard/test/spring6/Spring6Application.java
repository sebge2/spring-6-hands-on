package be.sgerard.test.spring6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(DemoRuntimeHints.class)
public class Spring6Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring6Application.class, args);
    }

}
