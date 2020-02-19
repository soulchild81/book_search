package com.soulchild.work.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
public class Popular {
    @Id
    @GeneratedValue
    @Column(name="popular_id")
    private int popular_id;

    @Column(name="count" , nullable = false)
    private int count;

    @Column(name="word" , nullable = false)
    private String word;
}
