package services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Curso;

public class ConsultarAlunosPorCurso {
		public void consultarAlunosPorCurso() {
			Scanner scanner = new Scanner(System.in);
			
	        System.out.println("Digite o código do curso que deseja consultar os alunos:");
	        int codigo = scanner.nextInt();
	        
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
	    	EntityManager em = emf.createEntityManager();
	    	
	        Curso curso = em.find(Curso.class, codigo);
	        
	        if (curso != null) {
	        	if(curso.getAlunos() != null) {
	        		System.out.println("\nAlunos matriculados nesse curso:");
		            System.out.println(curso.getAlunos() + "\n");
	        	} else {
	        		System.out.println("Não há nenhum aluno matriculado nesse curso no momento!");
	        	}
	        	
	            
	        } else {
	            System.out.println("Curso não encontrado.");
	        }

		}
}
