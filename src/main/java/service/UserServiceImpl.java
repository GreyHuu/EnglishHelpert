package service;

import java.util.List;

import dao.UserDao;
import entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public List<UserEntity> getAllUser() {
        //但本例没有业务逻辑，就不用写。

        //访问数据库的代码，不会出现在service这一层
        //交给dao来操作数据库
        List<UserEntity> myUserList = userDao.getAllUser();

        //进行其它的业务逻辑操作，比如增加多一个选项，是否过期
        //本例不需要
        //....

        return myUserList;
    }

}
