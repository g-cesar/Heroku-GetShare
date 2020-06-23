package com.project.getshare.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="softwarehouses")
public class SoftwareHouse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true, name="nome", nullable=false)
	private String name;
	
	@Column(name="descrizione")
	private String description;
	
	@Column(name="data_di_fondazione")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate foundation;
	
	@OneToMany(mappedBy="softwarehouse", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Software> softwareList;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public SoftwareHouse() {
		this.softwareList = new ArrayList<Software>();
	}
	
	public SoftwareHouse(String name, String description, LocalDate foundation) {
		this.name=name;
		this.description=description;
		this.foundation=foundation;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SoftwareHouse other = (SoftwareHouse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getFoundation() {
		return foundation;
	}

	public void setFoundation(LocalDate foundation) {
		this.foundation = foundation;
	}

	public List<Software> getSoftwareList() {
		return softwareList;
	}

	public void setSoftwareList(List<Software> softwareList) {
		this.softwareList = softwareList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SoftwareHouse [id=" + id + ", name=" + name + ", description=" + description + ", foundation="
				+ foundation + ", softwareList=" + softwareList + "]";
	}

	public void addSoftware(String name, String description, LocalDate publish, Float price, Integer size, String version) {
        Software software = new Software(name, description, publish, price, size, version);
        this.softwareList.add(software);
    }

	public void addSoftware(String name, String description, LocalDate publish, Integer size, String version) {
        Software software = new Software(name, description, publish, size, version);
        this.softwareList.add(software);
    }
	
}
