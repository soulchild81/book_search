package com.soulchild.work.common.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.soulchild.work.common.Constants;
import lombok.Data;

@Data
public class CommonResult {
    public CommonResult() {
        this.result_code = Constants.RESULT_CODE.SUCCESS;
    }

    public CommonResult(Constants.RESULT_CODE resultCode) {
        super();
        this.result_code = resultCode;
    }

    @JsonIgnore
    private Constants.RESULT_CODE result_code;
    @JsonIgnore
    private int ret_code;
    @JsonIgnore
    private String custom_msg;

    @JsonProperty("ret_code")
    public int getRetCode() {
        return result_code.getCode();
    }

    @JsonProperty("ret_msg")
    public String getRetMsg() {
        return result_code.getMsg();
    }
}
