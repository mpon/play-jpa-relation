package models;

import javax.validation.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "email")
    @Constraints.Required
    @Constraints.Email
    @Constraints.MaxLength(value = 255)
    private String email;
    
    @Column(name = "password")
    @Constraints.Required
    private String password;

    @Column(name = "fullname")
    @Constraints.Required
    @Constraints.MaxLength(value = 255)
    private String fullname;

    @Column(name = "is_admin")
    private Boolean isAdmin = false;

    @Column(name = "age")
    @Constraints.Required
    @Constraints.Min(value = 0)
    private Integer age;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

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

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static User findById(Long id) {
        return JPA.em().find(User.class, id);
    }

    public static List<User> findAll() {
        return JPA.em().createQuery("select u from User u", User.class).getResultList();
    }

    public void save() {
        this.address.setOwner(this);
        JPA.em().persist(this);
        JPA.em().flush();
    }

    public void update(Long id){
        this.setId(id);
        this.address.setOwner(this);
        this.address.setId(id);
        JPA.em().merge(this);
        JPA.em().flush();
    }

    public void delete() {
        JPA.em().remove(this);
        JPA.em().flush();
    }

}