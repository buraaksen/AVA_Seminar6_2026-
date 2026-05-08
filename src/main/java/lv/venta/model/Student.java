package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Table(name = "StudentTable")
@Entity()
public class Student {
	
	@Column(name = "Sid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid; 
	
	@Column(name = "Name")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,40}")
	private String name; 
	
	@Column(name = "Surname")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,40}")
	private String surname;
	
	@OneToMany(mappedBy = "student")
	private Collection<Grade> grades;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSid() {
		return sid;
	}
	
	
	public Student() {}
	
	public Student (String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	public String toString() {
		return sid+ ": "+ name +" " +surname;
	}
	
}
