package models;

import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

import java.util.List;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "city")
    @Constraints.Required
    private String city;
    
    @Column(name = "zip_code")
    @Constraints.Required
    @Constraints.Pattern(value = "\\d{7}")
    private String zipCode;

    // This is One to One relationship with shared primary key
    // so you must anotate `@MapsId`
    @MapsId 
    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "user_id")
    private User owner;
    
    public Long getId() {
    	return this.id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getCity() {
    	return this.city;
    }

    public void setCity(String city) {
    	this.city = city;
    }

    public String getZipCode() {
    	return this.zipCode;
    }

    public void setZipCode(String zipCode) {
    	this.zipCode = zipCode;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}