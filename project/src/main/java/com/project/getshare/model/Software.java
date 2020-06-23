package com.project.getshare.model;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Software {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(unique=true, name="nome", nullable=false)
	private String name;
	
	@Column(name="descrizione", nullable=false)
    private String description;
	
	@Column(name="data_di_pubblicazione", nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publish;
	
	@Column(name="prezzo", nullable=false)
    private Float price;
	
	@Column(name="dimensione", nullable=false)
    private Integer size;
	
	@Column(name="versione", nullable=false)
    private String version;
    
    @ManyToOne
    @JoinColumn(name="softwarehouse_id")
	private SoftwareHouse softwarehouse;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Software(){

    }

	public Software(String name, String description, LocalDate publish, Float price, Integer size, String version) {
		this.name=name;
        this.description=description;
        this.publish=publish;
        this.price=price;
        this.size=size;
        this.version=version;
	}

    public Software(String name, String description, LocalDate publish, Integer size, String version) {
		this.price = 0.f;
        this.name=name;
        this.description=description;
        this.publish=publish;
        this.size=size;
        this.version=version;
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
		Software other = (Software) obj;
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
    	return this.id;
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

	public LocalDate getPublish() {
		return publish;
	}

	public void setPublish(LocalDate publish) {
		this.publish = publish;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public SoftwareHouse getSoftwarehouse() {
		return softwarehouse;
	}

	public void setSoftwarehouse(SoftwareHouse softwarehouse) {
		this.softwarehouse = softwarehouse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Software [name=" + name + ", description=" + description + ", publish=" + publish + ", price=" + price
				+ ", size=" + size + ", version=" + version + "]";
	}
    
    

}
