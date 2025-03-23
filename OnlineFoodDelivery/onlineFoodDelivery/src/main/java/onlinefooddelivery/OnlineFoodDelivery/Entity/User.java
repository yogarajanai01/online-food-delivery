package onlinefooddelivery.OnlineFoodDelivery.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@NotEmpty
	@Size(min = 3,message = "User name must be Greatwer than 3 letters")
	private String Name;
	@NotEmpty
	@Email(message = "Email is not valid")
	@Column(name = "Email_Id",unique = true,length = 20)
	private String email;
	@NotEmpty
	@Size(min = 8,message = "Password must be Greater than 8 characters")
	private String Password;
	public int getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setId(int id) {
		Id = id;
	}
	public User(int id, @NotEmpty @Size(min = 3, message = "User name must be Greatwer than 3 letters") String name,
			@NotEmpty @Email(message = "Email is not valid") String email,
			@NotEmpty @Size(min = 8, message = "Password must be Greater than 8 characters") String password)
			 {
		super();
		Id = id;
		Name = name;
		this.email = email;
		Password = password;

	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", email=" + email + ", Password=" + Password
				+ "]";
	}
	
	

}
