package cn.chingshen.smartlab.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
    @Bean(name = "ClientPasswordEncoder")
    public PasswordEncoder getClientPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Primary
    @Bean(name = "UserPasswordEncoder")
    public PasswordEncoder getUserPasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
