package Principal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpaMapeamentos.Department;
import jpaMapeamentos.Employee;

import java.util.ArrayList;
import java.util.List;

public class ManyToMany {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("manytomany");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Criando a entidade departamento
        Department department = new Department("Ficcao Cientifica", null);
        Department department2 = new Department("Terror", null);
        Department department3 = new Department("Acao", null);

        entityManager.persist(department); // salvar o departamento no bd
        entityManager.persist(department2); // salvar o departamento2 no bd
        entityManager.persist(department3); // salvar o departamento3 no bd

        // Criando um grupo de departamentos1
        List<Department> departmentSet1 = new ArrayList<>();
        departmentSet1.add(department);
        // departmentSet1.add(department2);

        // Criando um grupo de departamentos2
        List<Department> departmentSet2 = new ArrayList<>();
        departmentSet2.add(department);
        // departmentSet2.add(department2);

        // Criando um grupo de departamentos1
        List<Department> departmentSet3 = new ArrayList<>();
        departmentSet3.add(department);
        // departmentSet3.add(department3);

        Employee employee1 = new Employee();
        employee1.setEname("Camila Oliveira");
        employee1.setSalary(200);
        employee1.setDeg("A Chegada");
        employee1.setDepartmentSet(departmentSet1);

        Employee employee2 = new Employee();
        employee2.setEname("Henrique Cioffi");
        employee2.setSalary(200);
        employee2.setDeg("Intereslelar");
        employee2.setDepartmentSet(departmentSet2);

        Employee employee3 = new Employee();
        employee3.setEname("Leticia");
        employee3.setSalary(300);
        employee3.setDeg("Avatar");
        employee3.setDepartmentSet(departmentSet3);

        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);

        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
}
