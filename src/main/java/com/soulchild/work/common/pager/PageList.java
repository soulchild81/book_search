package com.soulchild.work.common.pager;

import java.util.List;

public interface PageList<E> extends List<E> {

    public static final int DEFAULT_NAV_SIZE = 10;


    public int getPage();

    public void setPage(int page);

    public int getRow();

    public void setRow(int row);

    public int getTotal();

    public void setTotal(int total);

    public void setNavSize(int navSize);

    public int getNavSize();

    public PagerContainer getPager();

}
