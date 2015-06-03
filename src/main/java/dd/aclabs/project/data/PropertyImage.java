package dd.aclabs.project.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PropertyImage extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column
	@NotEmpty
	private int sortId;
	
	@Column
	@NotEmpty
	private byte[] imageData;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
	private Property property;
	
	public int getSortId() {
		return sortId;
	}
	
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	
	public byte[] getImageData() {
		return imageData;
	}
	
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	public Property getProperty() {
		return property;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
}
