import java.sql.Date;

public class Client {
	
	private String name;
	private int id;
	private String adress;
	private Date date_of_birth;
	private String cpf;
	private String email;
	private String phone;
	private String passwd;

	public Client(String name, String adress, Date date_of_birth, String cpf, String email, String phone,
			String passwd) {
		super();
		this.name = name;
		this.adress = adress;
		this.date_of_birth = date_of_birth;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
		this.passwd = passwd;
	}

	public Client() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
