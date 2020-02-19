package com.soulchild.work.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private int book_id;

    @Column(length = 2000, nullable = false)
    private String contents;

    @Column
    private Date datetime;

    @JsonIgnore
    @Column
    private String isbn;

    @Column
    private int price;

    @Column
    private String publisher;

    @Column
    private int sale_price;

    @Column
    private String status;

    @Column
    private String thumbnail;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 600, nullable = false)
    private String url;

    @ElementCollection
    @CollectionTable(name = "AUTHORS", joinColumns = @JoinColumn(name="book_id"))
    @Column(name = "AUTHOR")
    public List<String> authors;

    @ElementCollection
    @CollectionTable(name = "TRANSLATORS", joinColumns = @JoinColumn(name="book_id"))
    @Column(name = "TRANSLATOR")
    public List<String> translators;
}

















