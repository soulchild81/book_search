package com.soulchild.work.model;

import lombok.Data;

import java.util.List;

@Data
public class NaverBookMeta {
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<NaverBook> items;
}
