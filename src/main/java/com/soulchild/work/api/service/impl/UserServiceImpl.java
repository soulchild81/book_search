package com.soulchild.work.api.service.impl;

import com.soulchild.work.api.service.UserService;
import com.soulchild.work.common.Constants;
import com.soulchild.work.common.utils.Aes256Util;
import com.soulchild.work.model.User;
import com.soulchild.work.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Boolean joinUser(User user){
        Boolean result;
        try{
            user.setPassword(Aes256Util.encrypt(user.getPassword() , Constants.encryptKkey));
            userRepository.save(user);
            result = true;
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public User login(String id , String pw){
        User user = new User();
        try{
            user = userRepository.findByIdEqualsAndPasswordEquals(id , Aes256Util.encrypt(pw , Constants.encryptKkey));
        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Constants.RESULT_CODE effectivenessCheck(User user){
        try{
            if(user.getId().isEmpty()||user.getPassword().isEmpty()){
                return Constants.RESULT_CODE.REQUIRE_ELEMENT;
            }else {
                User dbUser = userRepository.findById(user.getId());
                if(dbUser!=null){
                    return Constants.RESULT_CODE.RESIST_ID;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}













