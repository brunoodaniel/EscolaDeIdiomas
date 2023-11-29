package views;

import java.util.Scanner;

import services.CancelarMatricula;
import services.ConsultarAlunoCurso;
import services.ConsultarCursos;
import services.MatricularAluno;

public class AlunoView {
	public void exibirMenu() {
		Scanner scanner = new Scanner(System.in);
				
		while (true) {
	        System.out.println("\n--- Escolha uma opção ---");
	        System.out.println("1. Realizar matrícula");
	        System.out.println("2. Consultar cursos");
	        System.out.println("3. Cancelar matrícula");
	        System.out.println("0. Sair");

	        int escolha = scanner.nextInt();

	        switch (escolha) {
	            case 1:
	            	MatricularAluno matricular = new MatricularAluno();
	            	matricular.matricular();
	                break;
	            case 2:
	            	ConsultarCursos consultar = new ConsultarCursos();
	            	consultar.consultarCursos();
	                break;  
	            case 3:
	            	CancelarMatricula cancelar = new CancelarMatricula();
	            	cancelar.cancelarMatricula();
	                break;       
	            case 0:
	                 break;
	            default:
	                System.out.println("Opção inválida. Tente novamente!");
	        }
	        
	        break;
		}
	 }
}
