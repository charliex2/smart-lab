package cn.chingshen.smartlab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@MapperScan("cn.chingshen.smartlab.mappers")
public class SmartLabApplication implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;

    public SmartLabApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SmartLabApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("encode Password");
        System.out.println(passwordEncoder.encode("test"));
    }
}
