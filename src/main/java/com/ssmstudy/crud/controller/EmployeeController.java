package com.ssmstudy.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmstudy.crud.bean.Employee;
import com.ssmstudy.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 处理员工增删改查
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    /**
     * 员工数据分页查询
     *
     * @return
     */
    @RequestMapping("/emps")
    public String getEmp(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //引入分页插件
        //在查询之前只用调用,转入页码和每页的大小
        PageHelper.startPage(pn, 5);
        //startpage 后面紧跟的就是分页查询
        List<Employee> emps = employeeService.getAll();
        //使用 pageinfo 包装查询的结果,只需要将 pageinfo 交给页面即可
        PageInfo page = new PageInfo(emps, 5);
        model.addAttribute("pageInfo", page);
        return "list";
    }

}
