package com.soulchild.work.api.v1;

import com.soulchild.work.api.service.UserService;
import com.soulchild.work.common.Constants;
import com.soulchild.work.common.result.SimpleResult;

import com.soulchild.work.common.utils.Aes256Util;
import com.soulchild.work.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/v1/member")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/join")
    public SimpleResult<Boolean> UserJoin(@ModelAttribute User user){
        SimpleResult result = new SimpleResult();
        Constants.RESULT_CODE code = userService.effectivenessCheck(user);
        Boolean isResult;

        if(code == null){
            isResult = userService.joinUser(user);
        }else {
            isResult = false;
            result.setCustom_msg(code.getMsg());
            result.setResult_code(code);
        }

        result.setResult(isResult);
        return result;
    }

    @PostMapping("/login")
    public SimpleResult<User> login(@RequestParam(value = "id", required = true) String id,
                                    @RequestParam(value = "password", required = true) String pw,
                                    HttpServletResponse response,
                                    HttpSession session){

        User user = userService.login(id , pw);
        if(user == null) {
            User emptyUser = new User();
            emptyUser.setStatus(Constants.RESULT_CODE.INCORRECT_INFO.getMsg());
            emptyUser.setStatus_code(Constants.RESULT_CODE.INCORRECT_INFO.name());
            user = emptyUser;
        }else{
            Cookie cookie =new Cookie("bookuser", session.getId());
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
        }

        return new SimpleResult<User>(user);
    }

}
