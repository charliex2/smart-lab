package cn.chingshen.smartlab.controllers;

import cn.chingshen.smartlab.models.test.Department;
import cn.chingshen.smartlab.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LineController {

    public DepartmentService lineService;

    public LineController(DepartmentService lineService) {
        this.lineService = lineService;
    }

    public List<Department> index() {
        return lineService.selectList();
    }

    @GetMapping("lines/{id}")
    public Department show(@PathVariable Integer id) {
        return lineService.selectById(id);
    }

    @DeleteMapping("lines/{id}")
    public void delete(@PathVariable Integer id) {
        lineService.deleteById(id);
    }

    @PutMapping("lines/{id}")
    public void update(@PathVariable String id, Department line) {

    }
}
