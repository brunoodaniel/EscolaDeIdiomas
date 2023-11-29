package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;  // Import correct List interface
import models.Curso;

public class ConsultarCursos {
    
    public void consultarCursos() {  
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Curso> TypedQuery = em.createQuery("SELECT c FROM Curso c", Curso.class);  
        List<Curso> cursos = TypedQuery.getResultList(); 

        System.out.println("Lista de Cursos:");
        for (Curso curso : cursos) {
            System.out.println(curso);
        }

        em.close(); 
        emf.close(); 
    }
}
