package service.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        if (args.length == 1 ) {
            LocalBrokerService.arrayList = Arrays.asList(args[0].split(","));
        }
        SpringApplication.run(Application.class, args);
    }

}
