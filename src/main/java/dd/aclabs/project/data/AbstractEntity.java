package dd.aclabs.project.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class AbstractEntity implements Serializable {
	
	@Id
	@GeneratedValue
	private long id;
	
	private static final long serialVersionUID = 1L;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "AbstractEntity [id=" + id + "]";
	}
}
