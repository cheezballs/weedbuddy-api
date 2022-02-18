package us.mattroberts.weedbuddy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "wb_user")
@Builder
@AllArgsConstructor
public class WBUser implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Max(250)
	@NotNull
	@Column(name = "idp_identifier", columnDefinition = "varchar", length = 250)
	@Getter
	@Setter
	private String idpIdentifier;

	@Max(100)
	@NotNull
	@Column(name = "first_name", columnDefinition = "varchar", length = 100, nullable = false)
	@Getter
	@Setter
	private String firstName;

	@Max(100)
	@NotNull
	@Column(name = "last_name", columnDefinition = "varchar", length = 100, nullable = false)
	@Getter
	@Setter
	private String lastName;

	@Max(25)
	@NotNull
	@Column(name = "username", columnDefinition = "varchar", length = 25, nullable = false)
	@Getter
	@Setter
	private String username;

	@Max(250)
	@Column(name = "email", columnDefinition = "varchar", length = 250)
	@Getter
	@Setter
	private String email;

	@Max(1000)
	@Column(name = "avatar_url", columnDefinition = "varchar", length = 1000)
	@Getter
	@Setter
	private String avatarUrl;

	@Column(name = "date_created", columnDefinition = "datetime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Getter
	@Setter
	private Date dateCreated;

	public WBUser() {
	}

	/*
		These methods are used to implement the Spring UserDetails interface, most aren't going to be used.
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
