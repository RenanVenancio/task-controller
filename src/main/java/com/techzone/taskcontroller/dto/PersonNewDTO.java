package com.techzone.taskcontroller.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.techzone.taskcontroller.domain.Person;
import com.techzone.taskcontroller.util.FormatDate;

public class PersonNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Campo obrigatório")
	@Length(min = 2, max = 80, message = "Deve conter entre 5 e 80 caracteres")
	private String firstName;
	private String lastName;
	@NotNull(message = "Campo obrigatório")
	@Email(message = "Forneça um email válido")
	private String email;
	@NotNull(message = "Campo obrigatório")
	private String phoneNumber;
	@NotNull(message = "Campo obrigatório")
	private Integer department;

	private Date hireDate;

	public PersonNewDTO() {

	}
	
	public PersonNewDTO(Person person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.email = person.getEmail();
		this.phoneNumber = person.getPhoneNumber();
	}

	public PersonNewDTO(String firstName, String lastName, String email, String phoneNumber,
			Integer department, String hireDate) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.department = department;
		this.hireDate = FormatDate.parse(hireDate, "dd/MM/yyyy");
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
		this.hireDate = FormatDate.parse(hireDate, "dd/MM/yyyy");
	}


}