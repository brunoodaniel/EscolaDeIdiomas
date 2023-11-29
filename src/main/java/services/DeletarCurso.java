package services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Curso;


public class DeletarCurso {
	
	public void deletar(){
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Digite o código do curso que deseja excluir:");
        int codCurso = scanner.nextInt();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
    	EntityManager em = emf.createEntityManager();
    	em.getTransaction().begin();
    	
        
        Curso curso = em.find(Curso.class, codCurso);


        if (curso != null) {
            em.remove(curso);
            em.getTransaction().commit();
            System.out.println("Curso excluído com sucesso!");
        } else {
            System.out.println("Curso não encontrado.");
            em.getTransaction().rollback();
        }
	}
}
