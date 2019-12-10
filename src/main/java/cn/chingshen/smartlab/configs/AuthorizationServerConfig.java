package cn.chingshen.smartlab.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 数据源
     */
    final
    DataSource dataSource;
    /**
     * 设置保存 token 的方式，一共有5种，这里采用数据库的形式
     */
    final
    TokenStore tokenStore;
    final
    UserDetailsService userDetailsService;
    final
    PasswordEncoder oauthClientPasswordEncoder;
    /**
     * 主任权限验证控制器，来支持 password grant type
     */
    private final AuthenticationManager authenticationManager;

    public AuthorizationServerConfig(AuthenticationManager authenticationManager,
                                     DataSource dataSource,
                                     TokenStore tokenStore,
                                     UserDetailsService userDetailsService,
                                     @Qualifier("ClientPasswordEncoder") PasswordEncoder oauthClientPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.dataSource = dataSource;
        this.tokenStore = tokenStore;
        this.userDetailsService = userDetailsService;
        this.oauthClientPasswordEncoder = oauthClientPasswordEncoder;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
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
        endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
}
