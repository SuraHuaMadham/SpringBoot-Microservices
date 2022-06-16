package com.dcb.department.controller;

import com.dcb.department.entity.Department;
import com.dcb.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside save method of controller");
        return departmentService.saveDepartment(department);
    }
           @GetMapping("/{id}")
            public Department findByDepartmentId(@PathVariable("id") Long departmentId){
            log.info("Inside find method of controller");
            return departmentService.findByDepartmentId(departmentId);
        }
    }

