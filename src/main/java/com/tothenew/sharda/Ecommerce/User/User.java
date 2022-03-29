package com.tothenew.sharda.Ecommerce.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class User implements UserDetails {


	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "user_sequence")
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	private Boolean isDeleted = false;
	private Boolean locked = false;
	private Boolean enabled = false;
	private Integer invalidAttemptCount;
	private LocalDateTime passwordUpdateDate;
	@Transient
	private String confirmPassword;
	private String contact;
	private String companyName;
	private String gstNumber;
	
	
	
	public User(String firstName, String lastName, String email, String password, UserRole userRole, String contact, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.contact = contact;
		this.confirmPassword = confirmPassword;
	}
	public User(String firstName, String lastName, String email, String password, UserRole userRole,
				String contact,
				String confirmPassword,
				String companyName,
				String gstNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
		this.contact = contact;
		this.confirmPassword = confirmPassword;
		this.companyName = companyName;
		this.gstNumber = gstNumber;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(authority);
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}
}