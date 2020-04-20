package com.techzone.taskcontroller.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.techzone.taskcontroller.domain.Person;

public class PersonNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Campo obrigatório")
	private String firstName;
	private String lastName;
	@Email(message = "O email informado não é válido")
	private String email;
	private String phoneNumber;
	@NotEmpty(message = "Campo obrigatório")
	private Integer department;
	@NotEmpty(message = "Campo obrigatório")
	private Date hireDate;

	public PersonNewDTO() {

	}
	
	public PersonNewDTO(Person person) {
		this.id = person.getId();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.email = person.getEmail();
		this.phoneNumber = person.getPhoneNumber();
	}

	public PersonNewDTO(Integer id, String firstName, String lastName, String email, String phoneNumber,
			Integer department, String hireDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.department = department;
		this.hireDate = formatHireDate(hireDate);
	}

	private Date formatHireDate(String hire) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse(hire);
			return date;
		} catch (ParseException e) {			
			throw new RuntimeException("Data inválida");
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = formatHireDate(hireDate);
	}


}
