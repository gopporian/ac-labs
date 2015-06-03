package dd.aclabs.project.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class FavoriteProperties extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "favoritesByUsers", cascade = CascadeType.ALL)
	private List<Property> properties;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Property> getProperties() {
		return properties;
	}
	
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
}
