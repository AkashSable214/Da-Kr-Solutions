package com.spring.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
	
	@Id
	@GeneratedValue
	private long id;
	
	 private String passportNumber;

	    @OneToOne(mappedBy = "passport")
	    @JsonBackReference // Prevents infinite recursion
	    private Person person;

	    // Setter for person
	    public void setPerson(Person person) {
	        this.person = person;
	    }
}
