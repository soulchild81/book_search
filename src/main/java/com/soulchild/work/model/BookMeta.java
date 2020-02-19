package com.soulchild.work.model;

import lombok.Data;

import java.util.List;

@Data
public class BookMeta {

    public List<Book> documents;

    public PageInfo meta;

}
