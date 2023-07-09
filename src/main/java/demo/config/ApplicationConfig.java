package demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationConfig {

	// Spring Security - Define UserDetailsService and Password Encoder
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		var user = List.of(
			User.withUsername("user").password("123").authorities("read").build()
		);

		return new InMemoryUserDetailsManager(user);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	  return NoOpPasswordEncoder.getInstance();
	}
	
	// Spring Security - Security Filter Chain
	
	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {

	    http.httpBasic(Customizer.withDefaults());
	    
	    http.authorizeHttpRequests(
	      c -> c.anyRequest().authenticated()
	    );
	    
		return http.build();
	}
	 

}
