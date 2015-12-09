package br.com.persistence.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entidade que armazena uma especificação detalhada de um celular.
 * Corresponde sempre a um tipo de especificação que diz respeito à característica genérica.
 * Enquanto o tipo de especificação seria "Preço", a especificação seria "R$1000,00"
 * 
 * @author Juliana
 */
@Entity
public class Specification implements Serializable {
	
	private static final long serialVersionUID = -8533969084340583503L;
	
	public Specification() {
	}
	
	public Specification(String id, String value, int position, SpecificationType type) {
		this.id = id;
		this.value = value;
		this.position = position;
		this.type = type;
	}

	@Id
	private String id;

	private String value;
	
	private int position;
	
	@ManyToOne
	private SpecificationType type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public SpecificationType getType() {
		return type;
	}

	public void setType(SpecificationType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + position;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Specification other = (Specification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (position != other.position)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}
