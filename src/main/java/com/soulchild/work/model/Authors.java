package com.soulchild.work.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
@Entity
@Builder
public class Authors {

    @Id
    public int book_id;

    @Column(length = 300)
    public String Author;
}
