//usando o authorization

//package br.com.vidracaria.core.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http
//			.authorizeRequests() //autorizando as requisições
//				.anyRequest().authenticated() //para todas as requisições devemos está autheticado.
//			.and()
//			.oauth2ResourceServer().opaqueToken();
//			
//	}
//}
