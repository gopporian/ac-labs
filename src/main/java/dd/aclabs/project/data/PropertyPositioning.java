package dd.aclabs.project.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PropertyPositioning extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column
	@NotEmpty
	private double latitude;
	
	@Column
	@NotEmpty
	private double longitude;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Property property;
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public Property getProperty() {
		return property;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
}
