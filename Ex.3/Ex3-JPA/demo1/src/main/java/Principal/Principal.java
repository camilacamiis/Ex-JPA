package Principal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpaMapeamentos.Classe;
import jpaMapeamentos.Professor;

import java.util.Arrays;
import java.util.Collections;

public class Principal {

    public static void main(String[] args) {


        Classe classe1 = new Classe();
        classe1.setCnome("Historia");

        Classe classe2 = new Classe();
        classe2.setCnome("Sociologia");

        Classe classe3 = new Classe();
        classe3.setCnome("Literatura");

        Professor prof1 = new Professor();
        prof1.setTnome("Allan");
        prof1.setAssunto("Sociologia");
        prof1.setClasse(Arrays.asList(classe2, classe3));

        Professor prof2 = new Professor();
        prof2.setTnome("Joao");
        prof2.setAssunto("Literatura");
        prof2.setClasse(Collections.singletonList(classe1));


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex3");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();


        em.persist(prof1);
        em.persist(prof2);
        em.persist(classe1);
        em.persist(classe2);
        em.persist(classe3);

        tx.commit();

        em.close();
        emf.close();


    }

}
