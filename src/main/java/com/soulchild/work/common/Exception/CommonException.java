package com.soulchild.work.common.Exception;

import com.soulchild.work.common.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CommonException extends RuntimeException {

    public CommonException() {
        super();
    }

    public CommonException(Constants.RESULT_CODE resultCode) {
        super();
        this.result_code = resultCode;
    }

    public CommonException(Constants.RESULT_CODE resultCode, String customMsg) {
        super();
        this.result_code = resultCode;
        this.custom_msg = customMsg;
    }

    private Constants.RESULT_CODE result_code;
    private String custom_msg;

}
