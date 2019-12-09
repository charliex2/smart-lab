package cn.chingshen.smartlab.services.security;

import cn.chingshen.smartlab.mappers.RoleMapper;
import cn.chingshen.smartlab.mappers.UserMapper;
import cn.chingshen.smartlab.models.User;
import cn.chingshen.smartlab.models.acl.Role;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    private final RoleMapper roleMapper;

    public UserDetailService(UserMapper userMapper, RoleMapper roleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        if (null != user) {
            List<Role> roles = roleMapper.getRolesByUserId(user.getId());
            user.setAuthorities(roles);
            return user;
        }
        throw new UsernameNotFoundException(username);
    }

}
