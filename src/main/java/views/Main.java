package views;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
            System.out.println("--- Escolha uma opção --");
            System.out.println("1. Administrador");
            System.out.println("2. Aluno");
            System.out.println("0. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                	AdministradorView adm = new AdministradorView();
                	adm.exibirMenu();
                    break;
                case 2:
                	AlunoView aluno = new AlunoView();
                	aluno.exibirMenu();
                    break;
                case 0:
                    System.out.println("Encerrando... Até mais! ;)");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }	
	}
}