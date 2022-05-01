package com.projet.tp.security;


import com.projet.tp.filter.CustomAuthenticationFilter;
import com.projet.tp.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//WebSecurityConfiguration  a class that contains methode manage the users and the security and the application
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService usetdeatil;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(usetdeatil).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**","/api/token/refresh/**","/user3/tous/**","/user2/tous/**").permitAll();
        http.authorizeRequests().antMatchers("/user3/booth/**").hasAnyAuthority("ROLE_CLIENT","ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/user3/cooperativ/**").hasAnyAuthority("ROLE_CLIENT");
        http.authorizeRequests().antMatchers("/user2/cop/**").hasAnyAuthority("ROLE_COPERATIVE");
        http.authorizeRequests().antMatchers("/cooperativ/**","/administrateur/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/cooperativ/coo/**").hasAnyAuthority("ROLE_COPERATIVE");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);

    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
