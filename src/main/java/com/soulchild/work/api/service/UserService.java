package com.soulchild.work.api.service;

import com.soulchild.work.common.Constants;
import com.soulchild.work.model.User;

public interface UserService {
    public Boolean joinUser(User user);

    public User login(String Id , String pw);

    public Constants.RESULT_CODE effectivenessCheck(User user);
}
