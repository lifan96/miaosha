package cn.lifan.controller;


import cn.lifan.controller.viewobject.UserVO;
import cn.lifan.error.BusinessException;
import cn.lifan.response.CommonReturnType;
import cn.lifan.service.UserService;
import cn.lifan.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id") Integer id) throws BusinessException {
        //调用service服务获取对应id的用户对象比返回给前端
        UserModel userModel = userService.getUserById(id);


        //若获取的对应用户信息不存在
        if(userModel == null){
            userModel.setEncrptPassword("123");
            //throw  new BusinessException(EmBusinessError.USER_NOT_EXIT);
        }

        //将核心领域model对象转化为可供UI使用的viewobject
        UserVO userVO =  convertFromMode(userModel);

        //返回通用对象
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromMode(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}

