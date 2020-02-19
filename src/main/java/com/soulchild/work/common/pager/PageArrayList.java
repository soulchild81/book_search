package com.soulchild.work.common.pager;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Data
@EqualsAndHashCode(callSuper=false)
public class PageArrayList<T> extends ArrayList<T> implements PageList<T> {

    private int page = 1, row;
    private int total;
    private int navSize = DEFAULT_NAV_SIZE;

    public static int startRow(int page, int row) {
        if(page == 0) page = 1;
        return (page - 1) * row + 1;
    }

    public static int endRow(int page, int row) {
        if(page == 0) page = 1;
        return page * row;
    }

    public PageArrayList() {
        super();
        this.navSize = DEFAULT_NAV_SIZE;
    }

    public PageArrayList(Collection<? extends T> collections, int page, int row, int total) {
        super();
        if(collections != null)
            this.addAll(collections);
        this.page = page;
        this.row = row;
        this.total = total;
    }

    @Override
    public PagerContainer getPager() {
        return new Pager(page, total, row, navSize);
    }
}
