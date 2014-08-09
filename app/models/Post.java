package models;

import javax.validation.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

import java.util.List;
import java.sql.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "content")
    private String content;

    @Column(name = "posted_at")
    private Date postedAt = new Date(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "post")
    private List<PostTag> postTags;


    public Long getId() {
    	return this.id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getTitle() {
    	return this.title;
    }

    public void setTitle(String title) {
    	this.title = title;
    }

    public String getContent() {
    	return this.content;
    }

    public void setContent(String content) {
    	this.content = content;
    }

    public Date getPostedAt() {
    	return this.postedAt;
    }

    public void setPostedAt(Date postedAt) {
    	this.postedAt = postedAt;
    }

    public User getAuthor() {
    	return this.author;
    }

    public void setAuthor(User author) {
    	this.author = author;
    }

    public List<PostTag> getPostTags() {
        return this.postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }

    public static Post findById(Long id) {
        return JPA.em().find(Post.class, id);
    }

    public static List<Post> findAllByUserId(Long userId) {
        return JPA.em()
                    .createQuery("select p from Post p where author.id = :userId", Post.class)
                    .setParameter("userId", userId)
                    .getResultList();
    }

    public void save(User user) {
        this.setAuthor(user);
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