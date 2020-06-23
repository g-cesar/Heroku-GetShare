package com.project.getshare.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.PrePersist;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nome", nullable=false)
	private String firstName;
	
	@Column(name="cognome", nullable=false)
    private String lastName;
	
	@Column(name="data_di_nascita", nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DOB;
	
	@Column(name="data_di_registrazione", nullable=false)
    private LocalDate registrationDate;
	
	@OneToOne
	protected Cart cart;
	
	@OneToMany(mappedBy="user", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<SoftwareHouse> softwarehouseList;
	
	@OneToMany(mappedBy="user", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Software> softwareList;

	public User() {
    		
    }
    
    public User(String firstName, String lastName, LocalDate dob, LocalDate registrationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOB = dob;
		this.registrationDate = registrationDate;
	}
    
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	@PrePersist
	protected void onPersist() {
		this.registrationDate = LocalDate.now();
	}

	public Long getId() {
    	return this.id;
    }
    
    public void setId(Long id) {
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
	
	public LocalDate getDOB() {
		return this.DOB;
	}
	
	public void setDOB(LocalDate dob) {
		this.DOB = dob;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<SoftwareHouse> getSoftwarehouseList() {
		return softwarehouseList;
	}

	public void setSoftwarehouseList(List<SoftwareHouse> softwarehouseList) {
		this.softwarehouseList = softwarehouseList;
	}
	
	public List<Software> getSoftwareList() {
		return softwareList;
	}

	public void setSoftwareList(List<Software> softwareList) {
		this.softwareList = softwareList;
	}

	public void addSoftwarehouse(String name, String description, LocalDate foundation){
        SoftwareHouse softwarehouse = new SoftwareHouse(name, description, foundation);
        this.softwarehouseList.add(softwarehouse);
    }

}
