package com.tothenew.sharda.Ecommerce.User;

import com.tothenew.sharda.Ecommerce.Registration.Token.ConfirmationToken;
import com.tothenew.sharda.Ecommerce.Registration.Token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{

	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
	}

	public String signUpUser(User user) {
		boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
		if (userExists) {
			throw new IllegalStateException("Email already taken!!");
		}
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		String encodedConfirmPassword = bCryptPasswordEncoder.encode(user.getConfirmPassword());
		user.setPassword(encodedPassword);
		user.setConfirmPassword(encodedConfirmPassword);
		userRepository.save(user);
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				user
		);
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		return token;
	}

	public int enableUser(String email) {
		return userRepository.enableUser(email);
	}
} 