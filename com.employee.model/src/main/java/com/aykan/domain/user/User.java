package com.aykan.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findByEmail", query="SELECT u FROM User u LEFT OUTER JOIN FETCH u.role WHERE u.email = :email"),
	@NamedQuery(name="User.findByUsername", query="SELECT u FROM  User u LEFT OUTER JOIN FETCH u.role WHERE u.username = :username"),
	@NamedQuery(name="User.findById", query="SELECT u FROM User u LEFT OUTER JOIN FETCH u.role WHERE u.id = :id")
})
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 15)
	private String firstName;
	
	@Column(length = 15)
	private String lastName;
	
	private String username;
	
	private String email;
	
	@Column(length = 60)
	private String password;

	private boolean enabled;
	//User emailini aktif ettimi? 
	
	private boolean accountNonExpired;
	//User'�n hesab� sonland�r�ld�m� banned tarzi
	
	private boolean credentialsNonExpired;
	//User'�n kimligi sonland�r�ld�m�
	
	private boolean accountNonLocked;
	//User'�n hesab� kitlendimi

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	private Role role;

	public User() {
		this.accountNonExpired=true;
		this.credentialsNonExpired=true;
		this.accountNonLocked=true;
		this.enabled = false;
	}

	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.accountNonExpired=true;
		this.credentialsNonExpired=true;
		this.accountNonLocked=true;
		this.enabled = false;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	
}
