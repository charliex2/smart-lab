package cn.chingshen.smartlab.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    final
    UserDetailsService userDetailsService;

    final
    PasswordEncoder userPasswordEncoder;

    public WebSecurityConfig(UserDetailsService userDetailsService, @Qualifier("UserPasswordEncoder") PasswordEncoder userPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.userPasswordEncoder = userPasswordEncoder;
    }

    // 配置认证管理器AuthenticationManager。说白了就是所有 UserDetails 相关的它都管，包含 PasswordEncoder 密码机。
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(userPasswordEncoder);
    }

    // 支持 password 模式要配置AuthenticationManager
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
