package com.library.library_management_system.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",length=15)
    private long authorId;

    @Column(name = "author_name",length = 100)
    private String authorName;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    public Author(long authorId,String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Author(){

    }

    public long getAuthorId() {
        return authorId;
    }



    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}



