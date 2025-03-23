package onlinefooddelivery.OnlineFoodDelivery.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty (message = "Name is mandatory")
	@Size(min =2,max =100, message = "Name must be between 2 to 100 characters")
	private String name;
	@NotEmpty(message = "mobileno is not null")
	@Size (message = "MobileNo must have 10 digits ")
	private String mobileno;
	@NotEmpty
	private String address;
	
	@NotEmpty (message = "Email is mondatory")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotEmpty (message = "Password is mandatory")
	@Size(min=6 ,message = "Password should have 6 characters")
	private String password;
	//private String Role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id,
			@NotEmpty(message = "Name is mandatory") @Size(min = 2, max = 100, message = "Name must be between 2 to 100 characters") String name,
			@NotEmpty(message = "mobileno is not null") @Size(message = "MobileNo must have 10 digits ") String mobileno,
			@NotEmpty String address,
			@NotEmpty(message = "Email is mondatory") @Email(message = "Email should be valid") String email,
			@NotEmpty(message = "Password is mandatory") @Size(min = 6, message = "Password should have 6 characters") String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", address=" + address + ", email="
				+ email + ", password=" + password + "]";
	}
 
	
}