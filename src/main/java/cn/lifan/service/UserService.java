package cn.lifan.service;

import cn.lifan.error.BusinessException;
import cn.lifan.service.model.UserModel;

public interface UserService {
    //通过用户ID获取用户对象的方法
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;
}
