package cn.lifan.service;

import cn.lifan.error.BusinessException;
import cn.lifan.service.model.UserModel;
import java.lang.String;

public interface UserService {
    //通过用户ID获取用户对象的方法
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;
    /*
    telphone:用户注册手机
    password:用户加密后的密码
     */

    UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException;
}
