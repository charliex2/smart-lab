package cn.chingshen.smartlab.mappers;

import cn.chingshen.smartlab.models.acl.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    @Select("SELECT role.id role.name FROM roles LEFT JOIN user_role ON role.id=user_role.role_id WHERE user_role.user_id=${userId} ")
    List<Role> getRolesByUserId(@Param("userId") Integer userId);
}
