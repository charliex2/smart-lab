package cn.chingshen.smartlab.services;

import cn.chingshen.smartlab.mappers.DepartmentMapper;
import cn.chingshen.smartlab.models.test.Department;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    public DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public List<Department> selectList() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<Department>();
        return departmentMapper.selectList(queryWrapper);
    }

    public Department selectById(Integer id) {
        return departmentMapper.selectById(id);
    }

    public Integer updateById(Department line) {
        return departmentMapper.updateById(line);
    }

    public Integer deleteById(Integer id) {
        return departmentMapper.deleteById(id);
    }

    public Integer insert(Department line) {
        return departmentMapper.insert(line);
    }

}
