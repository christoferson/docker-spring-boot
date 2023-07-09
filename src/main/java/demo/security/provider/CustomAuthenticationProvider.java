package demo.security.provider;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//@Component //Enable to use Custom Implementation
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());

		if ("user".equals(username) && "12345".equals(password)) {
			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
		} else {
			throw new AuthenticationCredentialsNotFoundException("Error!");
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
	}
}
