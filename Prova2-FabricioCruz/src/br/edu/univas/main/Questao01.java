package br.edu.univas.main;

import java.util.Scanner;

import br.edu.univas.vo.Conta;

public class Questao01 {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int option;
		int qtd = 100;
		int contadorContas = 0;
		
		float totalDespesas = 0;
		float totalReceitas = 0;
		
		Conta[] listaContas = new Conta[qtd];
		
		do {
			imprimeMenu();
			option = scanner.nextInt();
			scanner.nextLine();
			
			if(option == 1) {
				
				listaContas[contadorContas] = cadastroDeContas();
				
				contadorContas++;
			}
			else if (option == 2){
				
				float saldo = calculaSaldo(listaContas, totalDespesas, totalReceitas);
		
				System.out.println("Saldo da Conta: " + saldo + "\n");
			}
			
		}while(option != 3);
	
		scanner.close();
	}
	
	public static void imprimeMenu() {
		
		System.out.println("Programa de Controle de Contas::::\n");
		System.out.println("1 - Cadastro");
		System.out.println("2 - Ver Saldo");
		System.out.println("3 - Sair");
		
	}
	
	public static Conta cadastroDeContas() {
		
		System.out.println("\nCadastrar Conta:::\n");
		
		Conta cadastroConta = new Conta();
		
		System.out.println("Descrição da Conta:");
		cadastroConta.descricao = scanner.nextLine();
		
		System.out.println("\nValor da Conta:");
		cadastroConta.valor = scanner.nextFloat();
		scanner.nextLine();
		
		System.out.println("\nData de Vencimento da Conta:");
		cadastroConta.dataVencimento = scanner.nextLine();
		
		System.out.println("\nTipo de Conta: Despesa ou Receita?");
		cadastroConta.tipo = scanner.nextLine();
		
		System.out.println("\nConta cadastrada com sucesso!\n");
		return cadastroConta;
	}
	
	public static float calculaSaldo(Conta[] listaDeContas, float totalDasDespesas, float totalDasReceitas) {
		
		for (int i = 0; i < listaDeContas.length; i++) {
			if(listaDeContas[i] != null && listaDeContas[i].tipo.contentEquals("Despesa")) {
				totalDasDespesas += listaDeContas[i].valor;
			}
			else if (listaDeContas[i] != null && listaDeContas[i].tipo.contentEquals("Receita")) {
				totalDasReceitas += listaDeContas[i].valor;
			}
		}
		
		return (totalDasReceitas - totalDasDespesas);
	}
}
