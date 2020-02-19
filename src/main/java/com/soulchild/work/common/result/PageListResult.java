package com.soulchild.work.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.soulchild.work.common.pager.PageList;
import com.soulchild.work.common.pager.PagerContainer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper=false)
public class PageListResult<T> extends CommonResult {

    public PageListResult() {
        super();
    }

    public PageListResult(PageList<T> list) {
        super();
        this.list = list;
    }

    private PageList<T> list;

    @JsonProperty("pager")
    public PagerContainer getPager() {
        return list == null ? null : list.getPager();
    }

}
