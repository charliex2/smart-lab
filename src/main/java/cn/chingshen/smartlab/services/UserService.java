package cn.chingshen.smartlab.services;

import cn.chingshen.smartlab.mappers.UserMapper;
import cn.chingshen.smartlab.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;



    public int createUser(User user) {
//        user.setPassword();
//        user.setPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        bCryptPasswordEncoder.
        return userMapper.insert(user);
    }
}
