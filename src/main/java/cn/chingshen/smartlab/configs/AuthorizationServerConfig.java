package cn.chingshen.smartlab.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.util.DigestUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.xml.ws.spi.http.HttpHandler;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 主任权限验证控制器，来支持 password grant type
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 数据源
     */
    @Autowired
    DataSource dataSource;

    /**
     * 设置保存 token 的方式，一共有5种，这里采用数据库的形式
     */
    @Autowired
    TokenStore tokenStore;

    @Autowired
    private WebResponseExceptionTranslator webResponseExceptionTranslator;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("ClientPasswordEncoder")
    PasswordEncoder oauthClientPasswordEncoder;


    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

//        CorsConfigurationSource corsConfigurationSource = request -> {
//            CorsConfiguration corsConfiguration = new CorsConfiguration();
//            corsConfiguration.addAllowedHeader("*");
//            corsConfiguration.addAllowedOrigin(request.getHeader(HttpHeaders.ORIGIN));
//            corsConfiguration.addAllowedMethod("*");
//            corsConfiguration.setAllowCredentials(true);
//            corsConfiguration.setMaxAge(3600L);
//            return corsConfiguration;
//        };

//        security.tokenKeyAccess("permitAll()")
//                .checkTokenAccess("permitAll()")
//                .allowFormAuthenticationForClients();
//                .addTokenEndpointAuthenticationFilter(new CorsFilter(corsConfigurationSource));
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(oauthClientPasswordEncoder);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        // 开启密码授权类型
//        endpoints.authenticationManager(authenticationManager);
//
//        // 配置 token 存储方式
//        endpoints.tokenStore(tokenStore);
//
//        // 自定义登录或者鉴权失败时返回信息
//        endpoints.exceptionTranslator(webResponseExceptionTranslator);
//
//        // 要是用 refresh_token 的话，需要额外配置 userDetailService
//        endpoints.userDetailsService(userDetailService);

        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).userDetailsService(userDetailsService);

    }


}
