package model;

import java.util.List;

public class Branch extends Bank{
    private String address ;
    private int phone ;
    private int branchId ;
    private List<Employee> employees;
    private Employee boss ;

    public Branch(int id, String name, String address, int phone, int branchId, List<Employee> employees, Employee boss) {
        super(id, name);
        this.address = address;
        this.phone = phone;
        this.branchId = branchId;
        this.employees = employees;
        this.boss = boss;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }
}
