package dd.aclabs.project.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column
	@NotEmpty
	private String username;
	
	@Column
	@NotEmpty
	private String password;
	
	@Column
	private boolean accountNonExpired;
	
	@Column
	private boolean accountNonLocked;
	
	@Column
	private boolean locked;
	
	@Column
	private boolean enabled;
	
	@Column
	private boolean credentialsNonExpired;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private FavoriteProperties favorites;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getAccountNonExpired() {
		return accountNonExpired;
	}
	
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	
	public boolean getAccountNonLocked() {
		return accountNonLocked;
	}
	
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	public boolean getLocked() {
		return locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	public FavoriteProperties getFavorites() {
		return favorites;
	}
	
	public void setFavorites(FavoriteProperties favorites) {
		this.favorites = favorites;
	}
}
