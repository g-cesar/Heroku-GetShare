package com.project.getshare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderline")
public class CartLine {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="numero_riga")
	private Integer n_line;
	
	@Column(name="prezzo_parziale")
	private Float subTotal;
	
	@ManyToOne
	private Cart cart;
	
	public CartLine() {
		
	}
	
	public CartLine(Integer n_line, Float subTotale) {
		super();
		this.n_line = n_line; //progressivo ???
		this.subTotal = subTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CartLine other = (CartLine) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getN_line() {
		return n_line;
	}
	
	public void setN_line(Integer n_line) {
		this.n_line = n_line;
	}
	
	public Float getSubTotale() {
		return subTotal;
	}
	
	public void setSubTotale(Float subTotal) {
		this.subTotal = subTotal;
	}
	
}
