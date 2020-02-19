package com.soulchild.work.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Translators {

    @Id
    public int book_id;

    @Column(length = 100, nullable = false)
    public String translator;



}
