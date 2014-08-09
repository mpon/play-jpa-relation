package models;

import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Constraints.Required
    private String name;
    
    @OneToMany(mappedBy = "post")
    private List<PostTag> postTags;
    
    public Long getId() {
    	return this.id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getName() {
    	return this.name;
    }

    public void setName(String name) {
    	this.name = name;
    }

    public List<PostTag> getPostTags() {
    	return this.postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
    	this.postTags = postTags;
    }

    public static List<Tag> findAll() {
        return JPA.em().createQuery("select t from Tag t", Tag.class).getResultList();
    }

    public static Tag findById(Long id) {
        return JPA.em().find(Tag.class, id);
    }

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Tag tag : Tag.findAll()) {
            options.put(String.valueOf(tag.getId()), tag.getName());
        }
        return options;
    }

    public void save() {
        JPA.em().persist(this);
        JPA.em().flush();
    }

    public void update(Long id) {
        this.setId(id);
        JPA.em().merge(this);
        JPA.em().flush();
    }

    public void delete() {
        JPA.em().remove(this);
        JPA.em().flush();
    }

}