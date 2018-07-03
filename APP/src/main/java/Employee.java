import java.sql.Date;


public class Employee {
	
	private String name;
	private int id;
	private String adress;
	private Date date_of_birth;
	private String cpf;
	private String email;
	private String phone;
	private int store_id;
	
	public Employee(String name, String adress, Date date_of_birth, String cpf, String email, String phone,int store_id) {
		super();
		this.name = name;
		this.adress = adress;
		this.date_of_birth = date_of_birth;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
		this.setStore_id(store_id);
	}

	public Employee() {
		
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}


}
