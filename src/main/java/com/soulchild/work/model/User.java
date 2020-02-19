package com.soulchild.work.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    @GeneratedValue
    private int user_srl;

    @Column
    private String id;

    @JsonIgnore
    @Column(length = 1000, nullable = false)
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    public String status;
    public String status_code;


}
