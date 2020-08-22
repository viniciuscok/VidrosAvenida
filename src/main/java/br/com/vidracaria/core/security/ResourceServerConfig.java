//usando o authorization

package br.com.vidracaria.core.security;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@EnableWebSecurity
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http
//			.formLogin()
//			.and()
//			.authorizeRequests() //autorizando as requisições
//				.antMatchers("/oauth/**")
//				.authenticated() //para todas as requisições devemos está autheticado.
//			.and()
//				.csrf().disable()
//				.cors()
//			.and()
//				.oauth2ResourceServer().jwt();
		http
		.authorizeRequests() //autorizando as requisições
			.anyRequest().authenticated() //para todas as requisições devemos está autheticado.
		.and()
			.csrf().disable()
			.cors()
		.and()
			.oauth2ResourceServer().jwt();
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("vinicius")
			.password(passwordEncoder().encode("123"))
			.roles("ADMIN"); //obrigatório informar as permissões
	}
	
	@Bean
	public JwtDecoder jwtDecoder() {
		var secrekey = new SecretKeySpec("antonioviniciussilvacarmo123456789".getBytes(), "HmacSHA256");//precisa possuir 32 bytes
		return NimbusJwtDecoder.withSecretKey(secrekey).build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}
}
