package models;

import javax.persistence.*;

import play.db.jpa.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "age")
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

    public static List<User> findAll() {
        return JPA.em().createQuery("select u from User u", User.class).getResultList();
    }

    public void save() {
        JPA.em().persist(this);
        JPA.em().flush();
    }

}