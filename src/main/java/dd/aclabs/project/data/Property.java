package dd.aclabs.project.data;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Property extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column
	@NotEmpty
	private String title;
	
	@Column
	@NotEmpty
	private String city;
	
	@Column
	@NotEmpty
	private String zone;
	
	@Column
	@NotEmpty
	private double surface;
	
	@Column
	@NotEmpty
	private int roomCount;
	
	@Column
	@NotEmpty
	private int propertyFloor;
	
	@Column
	@NotEmpty
	private int propertyFloorCount;
	
	@Column
	@NotEmpty
	private Date created;
	
	@Column
	@NotEmpty
	private Date updated;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "favoritesByUsersId", referencedColumnName = "id", nullable = false)
	private FavoriteProperties favoritesByUsers;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "property", cascade = CascadeType.ALL)
	private List<PropertyImage> images;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "property", cascade = CascadeType.ALL)
	private PropertyDetails details;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "property", cascade = CascadeType.ALL)
	private PropertyPositioning position;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZone() {
		return zone;
	}
	
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public double getSurface() {
		return surface;
	}
	
	public void setSurface(double surface) {
		this.surface = surface;
	}
	
	public int getRoomCount() {
		return roomCount;
	}
	
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	
	public int getPropertyFloor() {
		return propertyFloor;
	}
	
	public void setPropertyFloor(int propertyFloor) {
		this.propertyFloor = propertyFloor;
	}
	
	public int getPropertyFloorCount() {
		return propertyFloorCount;
	}
	
	public void setPropertyFloorCount(int propertyFloorCount) {
		this.propertyFloorCount = propertyFloorCount;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	public FavoriteProperties getFavoritesByUsers() {
		return favoritesByUsers;
	}
	
	public void setFavoritesByUsers(FavoriteProperties favoritesByUsers) {
		this.favoritesByUsers = favoritesByUsers;
	}
	
	public List<PropertyImage> getImages() {
		return images;
	}
	
	public void setImages(List<PropertyImage> images) {
		this.images = images;
	}
	
	public PropertyDetails getDetails() {
		return details;
	}
	
	public void setDetails(PropertyDetails details) {
		this.details = details;
	}
	
	public PropertyPositioning getPosition() {
		return position;
	}
	
	public void setPosition(PropertyPositioning position) {
		this.position = position;
	}
}
