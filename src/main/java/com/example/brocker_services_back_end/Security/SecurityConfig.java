package com.example.brocker_services_back_end.Security;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private UserDetailsImpl userDetails;
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        PasswordEncoder passwordEncoder = passwordEncoder();
//        return new InMemoryUserDetailsManager(
//                User.withUsername("user1").password(passwordEncoder.encode("1234")).authorities("USER").build(),
//                User.withUsername("user2").password(passwordEncoder.encode("1234")).authorities("USER","ADMIN").build()
//        );
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(sf->sf.disable())
                .authorizeHttpRequests(au-> {
                    au.requestMatchers("/profile/**").permitAll();
                    au.anyRequest().authenticated();
                })
                .oauth2ResourceServer(oa->oa.jwt(Customizer.withDefaults()))
                .userDetailsService(userDetails)
                .build();
    }
    @Bean
    JwtEncoder jwtEncoder(){
        String secretKey ="A9b#5cH8pQ2rL!mE7fG3sK1dX6oV4tZyN0iU2jWqBxPzOvR9";
        return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));
    }
    @Bean
    JwtDecoder jwtDecoder(){
        String secretKey ="A9b#5cH8pQ2rL!mE7fG3sK1dX6oV4tZyN0iU2jWqBxPzOvR9";
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(),"RSA");
        return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
    }

    @Bean
    AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetails);
        return new ProviderManager(daoAuthenticationProvider);
    }

}
