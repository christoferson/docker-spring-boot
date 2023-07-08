package demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ApplicationConfig {

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

}
