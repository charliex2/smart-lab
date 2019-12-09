package cn.chingshen.smartlab.mappers;

import cn.chingshen.smartlab.models.User;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@TableName(value = "user")
public interface UserMapper extends BaseMapper<User> {
}
