package com.soulchild.work.common.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SimpleResult<T> extends CommonResult {

    public SimpleResult() {
        super();
    }

    public SimpleResult(T result) {
        super();
        this.result = result;
    }

    private T result;

}