package com.ssmstudy.crud.test;

import com.ssmstudy.crud.bean.Department;
import com.ssmstudy.crud.bean.Employee;
import com.ssmstudy.crud.dao.DepartmentMapper;
import com.ssmstudy.crud.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static java.util.UUID.randomUUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSessionTemplate sqlSession;
    @Test
    public void testCRUD(){

        System.out.println(departmentMapper);
//
//        departmentMapper.insertSelective(new Department(null, "技术部"));
//        departmentMapper.insertSelective(new Department(null, "开发部"));
//        departmentMapper.insertSelective(new Department(null, "销售部"));

//        employeeMapper.insertSelective(new Employee(null, "petteran", "M", "petteran.h@qq.com", 1));

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid= randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Employee(null, uid, "M", uid + "@qq.com", 1));
        }
    }
}
