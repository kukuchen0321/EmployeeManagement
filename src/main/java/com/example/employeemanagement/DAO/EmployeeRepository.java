package com.example.employeemanagement.DAO;

import com.example.employeemanagement.Model.Employee;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class EmployeeRepository {
    static List<Employee> employees;

    static {
        employees = new ArrayList<>();

        employees.add(new Employee(1,"Jack","SALESMAN","2012-09-13",1,2000.00));
        employees.add(new Employee(2,"Peter","BOSS","2013-07-24",1,1000.00));
    }

    public List<Employee> getAllEmployees(){
        return employees;
    }

    public Employee getEmployeeById(int id){
        return employees.stream().filter(e -> id == e.getId()).findFirst().orElse(null);
    }

    public void updateEmployee(int id, Employee temp){
        Employee target = this.getEmployeeById(id);
        target.setName(temp.getName());
    }

    public void updateEmployee(Employee temp){
        Employee target = employees.stream().filter(e -> temp.getId() == e.getId()).findFirst().orElse(null);
        if(target != null){
            target.setName(temp.getName());
        }
    }

    public void newEmployee(Employee temp){
        //temp should not exist already in employees -- sanity check
        int maxId = employees.stream().mapToInt(e -> e.getId()).max().getAsInt();
        temp.setId(maxId + 1);
        employees.add(temp);
    }

    public void deleteEmployeeById(int id){
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext()){
            Employee temp = it.next();
            if(id == temp.getId()){
                it.remove();
            }
        }
    }

    public void deleteAllEmployees(){
        //  employees = new ArrayList<>();
        employees.clear();
    }
}
