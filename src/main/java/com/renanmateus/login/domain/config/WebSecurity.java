package com.renanmateus.login.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurity  extends WebSecurityConfigurerAdapter{

    @Bean 
    public CustomAuthenticationSuccessHandler successHandler() {
    	return new CustomAuthenticationSuccessHandler();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/user").hasAnyRole("ADMIN", "USER")
		.antMatchers("/admin").hasRole("ADMIN")
		.anyRequest().authenticated().and().csrf().disable().formLogin()
		.loginPage("/login").failureUrl("/login?error=true")
		.successHandler(successHandler())
		.usernameParameter("username")
		.passwordParameter("password");
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("renan")
		.password(codificasenha().encode("renan"))
		.roles("ADMIN")
		.and()
		.withUser("aline")
		.password(codificasenha().encode("aline"))
		.roles("USER");

	}
	@Bean
	public PasswordEncoder codificasenha() {
		return new BCryptPasswordEncoder();

	}
	@Override
	public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web)
			throws Exception {
		web
		.ignoring()
		.antMatchers("/static/**", "/fontawesome-free/**", "/css/**", "/js/**", "/image/**");
	}
}
