package com.jzy.webcrud.controller;

import com.jzy.webcrud.dao.DepartmentDao;
import com.jzy.webcrud.dao.EmployeeDao;
import com.jzy.webcrud.entities.Department;
import com.jzy.webcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
@Autowired
    EmployeeDao employeeDao;
@Autowired
    DepartmentDao departmentDao;
    @GetMapping(value = "/emps")
    public String empsList(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }

    @GetMapping(value = "/emp")
    public String toAddEmp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping(value = "/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping(value = "/emp/{id}")
    public String toEditEmp(@PathVariable Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping(value = "/emp")
    public  String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping(value = "/emp/{id}")
    public String deleteEmp(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
