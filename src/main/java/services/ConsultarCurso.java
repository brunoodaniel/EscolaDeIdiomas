package services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Curso;

public class ConsultarCurso {
	public void consultar(){
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Digite o código do curso que deseja consultar:");
        int codCurso = scanner.nextInt();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
    	EntityManager em = emf.createEntityManager();

        Curso curso = em.find(Curso.class, codCurso);

        if (curso != null) {
            System.out.println("Curso encontrado:");
            System.out.println(curso.toString());
        } else {
            System.out.println("Curso não encontrado.");
        }
	}
}
