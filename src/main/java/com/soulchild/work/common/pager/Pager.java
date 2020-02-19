package com.soulchild.work.common.pager;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pager implements PagerContainer {
    public static final int DEFAULT_SET_SIZE = 10;

    private int page;
    @JsonProperty("total_count")
    private int totalCount;
    @JsonProperty("page_size")
    private int pageSize;
    @JsonProperty("set_size")
    private int setSize;

    @JsonProperty("first_page")
    private int firstPage;
    @JsonProperty("last_page")
    private int lastPage;
    @JsonProperty("prev_page")
    private int prevPage;
    @JsonProperty("next_page")
    private int nextPage;
    @JsonProperty("first")
    private boolean first;
    @JsonProperty("last")
    private boolean last;

    private List<Integer> list;

    @JsonProperty("remain_count")
    private int remainCount;

    public Pager(int page, int totalCount, int pageSize, int setSize) {
        super();
        this.page = page;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.setSize = setSize;

        build();
    }

    public Pager(int page, int totalCount, int pageSize) {
        this(page, totalCount, pageSize, DEFAULT_SET_SIZE);
    }

    /**
     * 생성자에서 입력받은 정보를 바탕으로 이전, 다음 등 페이징 정보 생성
     */
    protected void build() {
        list = new ArrayList<Integer>();

        lastPage = (totalCount > 0 && pageSize != 0) ? (int)(totalCount + pageSize - 1) / pageSize : 1;
//        lastPage = (totalCount / pageSize) + (((totalCount % pageSize) > 0) ? 1 : 0);

		/*
		if(lastPage == 0) {
			list.add(1);
			return;
		}
		*/

        if(page > lastPage){
            page = lastPage;
        }

        if(page < 1){
            page = 1;
        }

        if(page == 1){
            first = true;
        }

        if(first == true) {
            prevPage = 1;
        }
        else {
            prevPage = page - 1;
        }

        last = (page == lastPage);
        if (last == true) {
            nextPage = lastPage;
        }
        else {
            nextPage = page + 1;
        }

        firstPage = 1;
        for(int i = 0, start = ((page - 1) / setSize) * setSize + 1; i < setSize; i++) {
            list.add(start + i);
        }

        if(page < lastPage) {
            remainCount = totalCount - (page * pageSize);
        }
    }

}
