package services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Curso;

public class AtualizarCurso {
	public void atualizar() {
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Digite o código do curso que deseja alterar:");
        int codCurso = scanner.nextInt();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
    	EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Curso curso = em.find(Curso.class, codCurso);

        if (curso != null) {
        		System.out.println("Digite o novo nome do curso:");
        		scanner.nextLine();
        		curso.setNome(scanner.nextLine());

        		System.out.println("Digite a nova descrição do curso:");
        		curso.setDescricao(scanner.nextLine());

        		em.merge(curso);
        		em.getTransaction().commit();

        		System.out.println("Curso alterado com sucesso!");
        } else {
            System.out.println("Curso não encontrado.");
        }
	}
}
