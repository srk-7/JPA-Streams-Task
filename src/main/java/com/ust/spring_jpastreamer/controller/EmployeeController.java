package com.ust.spring_jpastreamer.controller;

import com.ust.spring_jpastreamer.model.Employee;
import com.ust.spring_jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    public EmployeeService empservice;

    @GetMapping("/findall")
    public List<Employee> getAllEmployees() {
        return empservice.getall();
    }

    @PostMapping("/saveemployees")
    public List<Employee> saveEmployee(@RequestBody  List<Employee> employees) {
        return empservice.saveemployees(employees);
    }

    @GetMapping("/agerange")
    public List<Employee> getEmployeesByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
        return empservice.getByAgeRange(minAge, maxAge);
    }

    @GetMapping("/getgendercount")
    public Map<String, Long> getGenderCount() {
        return empservice.getGenderCount();
    }

    @GetMapping("/getbyjoiningyear")
    public List<Employee> getEmployeesByJoiningYear(@RequestParam int joiningYear) {
        return empservice.getByJoiningYear(joiningYear);
    }

    @GetMapping("/getgendergroupbyjoiningdate")
    public Map<Float ,Map<String,Long>> getGenderGroupByJoiningDate(){
        return empservice.getGenderGroupByJoiningDate();
    }

    @GetMapping("/getgroupbyeducation")
    public Map<String, Long> getEducation(){
        return empservice.getEducation();
    }

    @GetMapping("/filterbyeducationjoiningyeargenderexperience")
    public List<Employee> getEmployeesByEducationJoiningYearGenderExperience(@RequestParam String education, @RequestParam int joiningYear, @RequestParam String gender, @RequestParam int experience){
        return empservice.getByEducationJoiningYearGenderExperience(education, joiningYear, gender, experience);
    }
}
