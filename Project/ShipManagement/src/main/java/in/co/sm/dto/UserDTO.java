package in.co.sm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "s_user")
@Setter
@Getter
public class UserDTO extends BaseDTO {

	@Column(name = "first_name", length = 255)
	private String firstName;
	@Column(name = "last_name", length = 255)
	private String lastName;
	@Column(name = "gender", length = 255)
	private String gender;
	@Column(name = "mobile_no", length = 255)
	private String mobileNo;
	@Column(name = "login", length = 255)
	private String login;
	@Column(name = "password", length = 255)
	private String password;
	@Column(name = "role_id", length = 255)
	private long roleId;
	@Transient
	private String confirmPassword;
	@Column(name = "role_name",length = 225)
	private String roleName;
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
