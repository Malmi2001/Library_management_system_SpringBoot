package com.library.library_management_system.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id",length=15)
    private long bookId;

    @Column(name = "book_name",length=100)
    private String bookName;

    @Column(name = "author_name",length=100)
    private String authorName;

    @Column(name = "genre",length=50)
    private String Genre;

    @Column(name="price",length=10)
    private double price;

    @Column(name = "available",length=6)
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "author_id")  //foreign key
    private Author author;



    public Book(String bookName, String authorName, double price, String genre, boolean available, Author author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.Genre = genre;
        this.price = price;
        this.available = available;
        this.author = author;
    }

    public Book(String bookName,Author author) {
      this.bookName = bookName;
        this.author = author;
    }

    public Book() {

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public long getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

public boolean isAvailable() {return available;}

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", Genre='" + Genre + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }



}
