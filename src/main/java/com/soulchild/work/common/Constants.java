package com.soulchild.work.common;

public class Constants {

    public static String kakaoAuthKey = "KakaoAK 26866d3e33a8fbc777cdf5b6709d814c";

    public static String encryptKkey = "encrypt_test_key_1234567";

    public static String naverAuthId = "ctKh3a86Ot6RVp_iG2ZZ";

    public static String naverAuthSecret = "2B1y7NtsBQ";

    public static enum RESULT_CODE {
        SUCCESS(0, "성공하였습니다."),
        REQUIRE_ELEMENT(100, "필수 요소가 누락되어 있습니다."),
        RESIST_ID(200, "이미 등록된 ID 입니다."),
        INCORRECT_INFO(300, "ID 와 PASWORD 를 확인해주세요."),
        API_ERROR(400, "OPENAPI 가 오류입니다.");

        private int code;
        private String msg;

        private RESULT_CODE(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
        public int getCode() {
            return code;
        }
        public String getMsg() {
            return msg;
        }
    };
}
