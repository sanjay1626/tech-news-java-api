package com.technews.model;
//Using  Spring Data JPA, entity models serve as the blueprints for database tables and columns.
// We'll use the Spring Data JPA for table creation, primary key creation and auto-generation,
// foreign key constraint and table relationship creation, column creation, and data validations.

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//Creating class annotation for User-Class



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "user")

//Create the Instance Variable-Level Annotations for the User Class


    public class User implements Serializable {
    //Proper instance-level annotations

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;

    @Column(unique = true)
    private String email;
    private String password;

    @Transient
    boolean loggedIn;

    //Create Table Relationships for the User Class
    /** create relationships for the tables in the database. Remember one-to-many relationships in SQL? Well, in Java,
     * we can use an annotation called @OneToMany, which will create the relationships between the tables automatically.*/
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> posts;
    // Need to use FetchType.LAZY to resolve multiple bags exception
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comments;
    /**Note that the Posts variable gets the FetchType of EAGER,
     *  meaning that this list will gather all of its necessary information immediately after being created,
     *  while the variables designated as LAZY only gather information as they need it.
     *  You can only ever designate a single list as EAGER.*/

    //Generate the Methods for the User Class
    public User() {
    }

    public User(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return loggedIn == user.loggedIn && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(posts, user.posts) && Objects.equals(votes, user.votes) && Objects.equals(comments, user.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, loggedIn, posts, votes, comments);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                ", posts=" + posts +
                ", votes=" + votes +
                ", comments=" + comments +
                '}';
    }
}
