package dd.aclabs.project.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class PropertyDetails extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Property property;
	
	@Column
	private String airConditioningType;
	
	@Column
	private String heatingType;
	
	@Column
	private String internetType;
	
	public Property getProperty() {
		return property;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public String getAirConditioningType() {
		return airConditioningType;
	}
	
	public void setAirConditioningType(String airConditioningType) {
		this.airConditioningType = airConditioningType;
	}
	
	public String getHeatingType() {
		return heatingType;
	}
	
	public void setHeatingType(String heatingType) {
		this.heatingType = heatingType;
	}
	
	public String getInternetType() {
		return internetType;
	}
	
	public void setInternetType(String internetType) {
		this.internetType = internetType;
	}
}
