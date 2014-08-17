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

    // you must anotate orphanRemoval when deleting a postTag element
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
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
                    .createQuery("select p from Post p where author.id = :userId order by p.id asc", Post.class)
                    .setParameter("userId", userId)
                    .getResultList();
    }

    /**
     * create a post
     *
     * This is called when submit new form
     *
     * @param user author Of this post
     */
    public void save(User user) {
        // post doesn't know author in binding form
        // so you must set author before save
        this.setAuthor(user);

        // if you submit no tags in creating post, `this.postTags` is null
        // so you must check null
        if (this.postTags != null) {
            // tags have set by binding from request but not post
            // so you must set post to postTag
            for (PostTag postTag : this.postTags) {
                postTag.setPost(this);
            }
        }
        JPA.em().persist(this);
        JPA.em().flush();
    }

    /**
     * update a post
     *
     * This is called when edit existing model
     *
     * @param id post that you want to edit
     */
    public void update(Long id) {
        Post post = Post.findById(id);
        // first, you have to clear all tags
        // and flush, not merge
        post.getPostTags().clear();
        JPA.em().flush();

        // second, you set edit value
        // `this` means form values by submitting
        post.setTitle(this.title);
        post.setContent(this.content);
        post.setPostedAt(new Date(System.currentTimeMillis()));

        // third, you set tags
        // if you submit no tags in creating post, `this.postTags` is null
        // so you must check null
        if (this.postTags != null) {
            for (PostTag postTag : this.postTags) {
                // tags have set by binding from request but not post
                // so you must set post to postTag
                postTag.setPost(post);

                // you must add tag, so you clear all tags in first
                post.getPostTags().add(postTag);
            }
        }

        // forth, you call flush not merge
        // because, this post is fetched by database
        JPA.em().flush();
    }

    public void delete() {
        JPA.em().remove(this);
        JPA.em().flush();
    }

}