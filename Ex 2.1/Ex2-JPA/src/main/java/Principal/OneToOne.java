package Principal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpaMapeamentos.Department;
import jpaMapeamentos.Employee;
import jpaMapeamentos.Log;

import java.io.IOException;
import java.util.logging.Level;

public class OneToOne {

    public static void main(String[] args) throws IOException {
        // LOGGER
        Log meuLogger = new Log("Log.txt");
        try {
            // Log meuLogger = new Log("Log.txt");
            meuLogger.logger.setLevel(Level.FINE);
            meuLogger.logger.info("Log de informação");
            meuLogger.logger.warning("Log de Aviso");
            meuLogger.logger.severe("Log Severo");

        } catch (Exception e) {
            meuLogger.logger.info("Exception:" + e.getMessage());
            e.printStackTrace();

        }

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("onetoone");
        EntityManager entitymanager = emfactory.createEntityManager();
        meuLogger.logger.info("\nA entidade manager factory ManyToOne foi criada!!");

        entitymanager.getTransaction().begin();


        Department department = new Department();

        department.setName("Development");

        entitymanager.persist(department);


        Employee employee1 = new Employee();
        employee1.setEname("Camila Oliveira");
        employee1.setSalary(200);
        employee1.setDeg("A Chegada");
        employee1.setDepartment(department);


        Employee employee2 = new Employee();
        employee2.setEname("Henrique Cioffi");
        employee2.setSalary(200);
        employee2.setDeg("Interestelar");
        employee2.setDepartment(department);


        entitymanager.persist(employee1);
        entitymanager.persist(employee2);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();
    }

}
