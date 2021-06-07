package orange.talents.restapi.challenge.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -7976529705209170645L;

	@Id
	@GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_id_sequence", sequenceName = "user_id_sequence", allocationSize = 10)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 255)
	private String name;
	
	@Column(name = "email", length = 50, unique = true)
	private String email;
	
	@Column(name = "cpf", length = 14, unique = true)
	private String cpf;

	@Column(name = "birth_date", length = 10)
	private String birthDate;
	
	@OneToMany(mappedBy = "user", cascade= CascadeType.ALL)
	@JsonIgnoreProperties("user")
	private List<Vehicle> vehicle;

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

}
