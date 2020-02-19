package com.soulchild.work.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class Keyword {
    @Id
    @GeneratedValue
    @Column(name="keyword_id")
    private int keyword_id;

    @Column(name="word" , length = 500, nullable = false)
    private String word;

    @JsonIgnore
    @Column(nullable = false)
    private Date regDate;

    @JsonProperty("time")
    public Long getTime() {
        return this.regDate.getTime();
    }
}
