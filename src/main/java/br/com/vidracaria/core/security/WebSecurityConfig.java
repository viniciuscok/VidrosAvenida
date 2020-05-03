//usando authenticação com basic
package br.com.vidracaria.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("vinicius")
			.password(passwordEncoder().encode("123"))
			.roles("ADMIN") //obrigatório informar as permissões
			.and()
			.withUser("nayara")
			.password(passwordEncoder().encode("123"))
			.roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic()
			.and().authorizeRequests() //autorizando as requisições
			.antMatchers("/estados/{sigla}", "/estados", "/lancamentos/{id}").permitAll() //Permissão para acessar sem está authenticado
			.anyRequest().authenticated() //para todas as requisições devemos está autheticado.
			.and().cors()
			.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //não vamos usar session na nossa segurança
			.and()
				.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
