package services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.Aluno;

public class CancelarMatricula {
    public void cancelarMatricula() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite o número da matrícula que deseja excluir:");

            int codMatricula;
            if (scanner.hasNextInt()) {
                codMatricula = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida para matrícula. Certifique-se de inserir um número válido.");
                scanner.next();
                return;
            }


            EntityManagerFactory emf = Persistence.createEntityManagerFactory("database-EscolaDeIdiomas");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Aluno aluno = em.find(Aluno.class, codMatricula);

            if (aluno != null) {
                Query query = em.createNativeQuery("DELETE FROM curso_aluno WHERE aluno_id = :alunoId");
                query.setParameter("alunoId", codMatricula);
                query.executeUpdate();

                em.remove(aluno);
                em.getTransaction().commit();
                System.out.println("Matrícula excluída com sucesso!");
            } else {
                System.out.println("Matrícula não encontrada.");
                em.getTransaction().rollback();

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a execução do programa: " + e.getMessage());
        }
    }
}
