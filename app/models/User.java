package models;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    private String email;
    
    private String password;

    private String fullname;

    private Boolean isAdmin;

    private Integer age;

    public Long getId() {
    	return this.id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getEmail() {
    	return this.email;
    }

    public void setEmail(String email) {
    	this.email = email;
    }

    public String getPassword() {
    	return this.password;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public String getFullname() {
    	return this.fullname;
    }

    public void setFullname(String fullname) {
    	this.fullname = fullname;
    }

    public Boolean getIsAdmin() {
    	return this.isAdmin;
    }

    public  void setIsAdmin(Boolean isAdmin) {
    	this.isAdmin = isAdmin;
    }

    public Integer getAge() {
    	return this.age;
    }

    public void setAge(Integer age) {
    	this.age = age;
    }

}