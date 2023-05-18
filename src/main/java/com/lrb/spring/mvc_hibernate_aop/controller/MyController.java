package com.lrb.spring.mvc_hibernate_aop.controller;

import com.lrb.spring.mvc_hibernate_aop.entity.Employee;
import com.lrb.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    // чтобы вручную не создавать объект DAO, мы здесь
    // пользуеся DI и пробрасываем сюда поле из DAO, для того,
    // чтобы ниже вызвать от него метод getAllEmployees() из DAO,
    // причем тип указываем не класса DAO, а интерфейса:

//    @Autowired
//    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model){
        // вызываем метод getAllEmployees из DAO и записываем в лист:
//        List<Employee> allEmployees = employeeDAO.getAllEmployees();

        List<Employee> allEmployees = employeeService.getAllEmployees();

        // далее, чтобы view мог отобразить значения полей наших работников,
        // нам необходимо в данном методе конроллера создать модель и добавить
        // в нее в качестве атрибута (атрибут назовем allEmps) наших работников:
        model.addAttribute("allEmps", allEmployees);

        // ... и теперь view будет использовать данную модель, возьмет
        // из атрибута "allEmps" всю необходимую информацию для отображения
        // в браузере
        return "all-employees";
    }


    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){

        employeeService.deleteEmployee(id);
        return "redirect:/";
    }


}
