package com.example.employeemanagement.Model;

public class Department {
    public int deptId;
    public String name;

    public Department(){
    }
    public Department(int deptId,String name){
        this.deptId = deptId;
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
