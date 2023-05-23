package jpaMapeamentos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eid;
    private String ename;
    private double salary;
    private String deg;

    @ManyToMany
    @JoinColumn(name = "eid" , referencedColumnName ="id")
    private Set<Department> departmentSet;

    public Employee(int eid, String ename, double salary, String deg, Set<Department> departmentSet) {
        super();
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.deg = deg;
        this.departmentSet = departmentSet;
    }

    public Employee() {
        super();
    }

    public void setEname(String string) {
        // TODO Auto-generated method stub

    }

    public void setSalary(double d) {
        // TODO Auto-generated method stub

    }

    public void setDeg(String string) {
        // TODO Auto-generated method stub

    }

    public void setDepartmentSet(List<Department> departmentSet1) {
        // TODO Auto-generated method stub

    }


}