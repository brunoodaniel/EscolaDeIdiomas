package views;

import java.util.Scanner;

import services.AtualizarCurso;
import services.ConsultarAlunoCurso;
import services.ConsultarAlunosPorCurso;
import services.ConsultarCurso;
import services.DeletarCurso;
import services.InserirCurso;

public class AdministradorView {
	
	 public void exibirMenu() {
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Digite a senha do administrador: ");
        int senha = scanner.nextInt();
        
        if (senha == 123) {
        	while (true) {
    	        System.out.println("\n--- Escolha uma opção ---");
    	        System.out.println("1. Inserir curso");
    	        System.out.println("2. Atualizar curso");
    	        System.out.println("3. Deletar curso");
    	        System.out.println("4. Consultar curso");
    	        System.out.println("5. Consultar alunos por curso");
    	        System.out.println("6. Consultar aluno e curso");
    	        System.out.println("0. Sair");

    	        int escolha = scanner.nextInt();

    	        switch (escolha) {
    	            case 1:
    	            	InserirCurso inserir = new InserirCurso();
    	            	inserir.inserir();
    	                break;
    	            case 2:
    	            	AtualizarCurso atualizar = new AtualizarCurso();
    	            	atualizar.atualizar();
    	                break;
    	            case 3:
    	            	DeletarCurso deletar = new DeletarCurso();
    	            	deletar.deletar();
    	                break;
    	            case 4:
    	            	ConsultarCurso consultar = new ConsultarCurso();
    	            	consultar.consultar();
    	                break;
    	            case 5:
    	            	ConsultarAlunosPorCurso consultarAlunos = new ConsultarAlunosPorCurso();
    	            	consultarAlunos.consultarAlunosPorCurso();
    	                break;    
    	            case 6:
    	            	ConsultarAlunoCurso consultarAC = new ConsultarAlunoCurso();
    	            	consultarAC.consultarAC();
    	                break;    
    	            case 0:    
    	                break;
    	            default:
    	                System.out.println("Opção inválida. Tente novamente!");
    	        }
    	        
    	        break;
    	        
    		}
        }else {
            System.out.println("\nSenha incorreta. Tente novamente!\n");

        }

				
		
	 }
}
