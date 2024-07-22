package com.ust.spring_jpastreamer.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.spring_jpastreamer.controller.EmployeeController;
import com.ust.spring_jpastreamer.model.Employee;
import com.ust.spring_jpastreamer.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepo repo;

    public final JPAStreamer streamer;

    @Autowired
    public EmployeeService(final  JPAStreamer streamer) {
        this.streamer = streamer;
    }

    public List<Employee> getall() {
        return streamer.stream(Employee.class)
                .collect(Collectors.toList());
    }

    public List<Employee> saveemployees(List<Employee> employees) {
        return repo.saveAll(employees);
    }

    public List<Employee> getByAgeRange(int minAge, int maxAge) {
        return streamer.stream(Employee.class)
                .filter(employee -> employee.getAge()> minAge && employee.getAge() < maxAge)
                .collect(Collectors.toList());
    }


    public Map<String, Long> getGenderCount() {
        return streamer.stream(Employee.class)
               .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

    public List<Employee> getByJoiningYear(int joiningYear) {
        return streamer.stream(Employee.class)
               .filter(employee -> employee.getJoiningYear() == joiningYear)
               .collect(Collectors.toList());
    }

    public Map<Float, Map<String, Long>> getGenderGroupByJoiningDate() {
        return streamer.stream(Employee.class)
               .collect(Collectors.groupingBy(employee -> employee.getJoiningYear(),
                        Collectors.groupingBy(Employee::getGender, Collectors.counting())));
    }

    public Map<String, Long> getEducation() {
        return streamer.stream(Employee.class)
               .collect(Collectors.groupingBy(Employee::getEducation, Collectors.counting()));
    }

    public List<Employee> getByEducationJoiningYearGenderExperience(String education, int joiningYear, String gender, int experience) {
        return streamer.stream(Employee.class)
               .filter(employee -> employee.getEducation().equals(education) && employee.getJoiningYear() == joiningYear && employee.getGender().equals(gender) && employee.getPaymentTier() >= experience)
               .collect(Collectors.toList());
    }
}
