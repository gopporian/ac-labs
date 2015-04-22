package dd.aclabs.lab1.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Feedback {

	@Id
	@GeneratedValue
	private long id;

	@Column
	@NotEmpty
	private String name;

	@Column
	@NotEmpty
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ", message=" + message + "]";
	}

}
