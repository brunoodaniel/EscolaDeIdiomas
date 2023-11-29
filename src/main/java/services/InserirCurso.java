package services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Curso;

public class InserirCurso {
	
	public void inserir(){
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Digite o nome do curso:");
        String nome = scanner.nextLine();
        
        System.out.println("Digite a descrição do curso:");
        String descricao = scanner.nextLine();

        Curso curso = new Curso(null, nome, descricao);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
		EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
                
        em.close();

        System.out.println("Curso adicionado com sucesso!");
	}
}
