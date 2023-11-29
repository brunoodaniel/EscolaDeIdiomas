package services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Aluno;


public class ConsultarAlunoCurso {
	public void consultarAC() {
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Digite a matrícula do aluno que deseja consultar:");
        int matricula = scanner.nextInt();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
    	EntityManager em = emf.createEntityManager();

        Aluno aluno = em.find(Aluno.class, matricula);
        
        if (aluno != null) {
            System.out.println("Aluno encontrado:");
            System.out.println(aluno.toString());
        } else {
            System.out.println("Aluno não encontrado.\n");
        }

	}
}
