package com.spring.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "passport_id", referencedColumnName = "id")
	    @JsonManagedReference // Manages the forward part of the relationship
	    private Passport passport;

	    // Setter for passport with bidirectional linking
	    public void setPassport(Passport passport) {
	        this.passport = passport;
	        if (passport != null) {
	            passport.setPerson(this);  // Ensure bidirectional link is maintained
	        }
	    }

}
