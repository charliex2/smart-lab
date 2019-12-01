package cn.chingshen.smartlab.services;

import cn.chingshen.smartlab.mappers.LineMapper;
import cn.chingshen.smartlab.models.test.Department;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    public LineMapper lineMapper;

    public DepartmentService(LineMapper lineMapper) {
        this.lineMapper = lineMapper;
    }

    public List<Department> selectList() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<Department>();
        return lineMapper.selectList(queryWrapper);
    }

    public Department selectById(Integer id) {
        return lineMapper.selectById(id);
    }

    public Integer updateById(Department line) {
        return lineMapper.updateById(line);
    }

    public Integer deleteById(Integer id) {
        return lineMapper.deleteById(id);
    }

    public Integer insert(Department line) {
        return lineMapper.insert(line);
    }

}
