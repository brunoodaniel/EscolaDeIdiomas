package services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.Aluno;
import models.Curso;

public class MatricularAluno {

    public void matricular() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF do aluno:");
        int cpf = scanner.nextInt();

        if (isAlunoMatriculado(cpf)) {
            System.out.println("Este aluno já está matriculado. Matrícula cancelada.\n");
            return;
        }

        System.out.println("Digite o nome do aluno:");
        String nome = scanner.next();

        System.out.println("Digite o ID do curso que deseja matricular o aluno:");
        int idCurso = scanner.nextInt();

        Aluno aluno = new Aluno(null, nome, cpf, null);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Curso curso = em.find(Curso.class, idCurso);

        if (curso != null) {
            aluno.setCurso(curso);
            em.persist(aluno);
            em.getTransaction().commit();
            
            curso.adicionarAluno(aluno);
            em.getTransaction().begin();
    		em.merge(curso);
    		em.getTransaction().commit();

            System.out.println("Aluno matriculado com sucesso!");
        } else {
            System.out.println("Curso não encontrado. Matrícula cancelada.");
        }

        em.close();
    }

    private boolean isAlunoMatriculado(int cpf) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT COUNT(a) FROM Aluno a WHERE a.cpf = :cpf");
        query.setParameter("cpf", cpf);

        Long count = (Long) query.getSingleResult();

        em.close();

        return count > 0;
    }
}
