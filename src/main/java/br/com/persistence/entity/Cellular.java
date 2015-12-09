package br.com.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entidade que armazena as informações do celular como nome, imagem e uma 
 * lista de especificações de acordo com o modelo. 
 * 
 * @author Juliana
 */
@Entity
public class Cellular implements Serializable {
	
	private static final long serialVersionUID = -2503362001921523053L;
	
	public Cellular(){
	}
	
	public Cellular(String name, String image, int favourite) {
		this.name = name;
		this.image = image;
		this.favourite = favourite;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String image;
	
	private int favourite;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Specification> specs;

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

	public List<Specification> getSpecs() {
		return specs;
	}

	public void setSpecs(List<Specification> specs) {
		this.specs = specs;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getFavourite() {
		return favourite;
	}

	public void setFavourite(int favourite) {
		this.favourite = favourite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((specs == null) ? 0 : specs.hashCode());
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
		Cellular other = (Cellular) obj;
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
		if (specs == null) {
			if (other.specs != null)
				return false;
		} else if (!specs.equals(other.specs))
			return false;
		return true;
	}
	
}
