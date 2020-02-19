package com.soulchild.work.common.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class ListResult<T> extends CommonResult {

    public ListResult() {
        super();
    }

    public ListResult(List<T> list) {
        super();
        this.list = list;
    }

    private List<T> list;

}

