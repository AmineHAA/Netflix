package Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;



@Entity
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	
	 @OneToMany(mappedBy = "category")
	    private List<Film> Films;
	
	
	
	
	// Getters & Setters
	
	
	
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
	
	 @JsonIgnore
	    public List<Film> getfilms() {
	        return Films;
	    }
	    @JsonSetter
	    public void setDocuments(List<Film> Films) {
	        this.Films = Films;
	    }
	
	
}
