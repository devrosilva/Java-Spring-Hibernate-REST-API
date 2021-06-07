package orange.talents.restapi.challenge.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable{

	private static final long serialVersionUID = -1268613183866183129L;

	@Id
	@GeneratedValue(generator = "vehicle_id_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "vehicle_id_sequence", sequenceName = "vehicle_id_sequence", allocationSize = 10)
	@Column(name = "id")
	private Integer id;
		
	@Column(name = "licence_plate", length = 8, unique = true)
	private String licencePlate;
	
	@Column(name = "vehicle_type", length = 9)
	private String vehicleType;
	
	@Column(name = "brand", length = 50)
	private String brand;
	
	@Column(name = "model", length = 50)
	private String model;
	
	@Column(name = "year", length = 50)
	private String year;
	
	@Column(name = "vehicle_price", length = 30)
	private String price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("vehicle")
	private User user;

	
	@Column(name = "traffic_restriction_day", length = 20)
	private String trafficRestrictionDay;
	
	@Column(name = "traffic_restriction_status")
	private boolean trafficRestrictionStatus;

	public Vehicle() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTrafficRestrictionDay() {
		return trafficRestrictionDay;
	}

	public void setTrafficRestrictionDay(String trafficRestrictionDay) {
		this.trafficRestrictionDay = trafficRestrictionDay;
	}

	public boolean isTrafficRestrictionStatus() {
		return trafficRestrictionStatus;
	}

	public void setTrafficRestrictionStatus(boolean trafficRestrictionStatus) {
		this.trafficRestrictionStatus = trafficRestrictionStatus;
	}
}