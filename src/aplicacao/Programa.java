package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import model.entidades.Conta;
import model.excecoes.DomainException;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados da conta:");
		
		try {
		System.out.print("Numero: ");
		Integer numero = sc.nextInt();
		System.out.print("Nome: ");
		String nome = sc.next();
		System.out.print("Saldo Inicial: ");
		Double saldo = sc.nextDouble();
		System.out.print("Limite de Retirada: ");
		Double limiteSaque = sc.nextDouble();
		
		Conta conta = new Conta(numero, nome, saldo, limiteSaque);
		
		System.out.println();
		System.out.print("Entre com valor para retirada: ");
		Double valor = sc.nextDouble();
		
		conta.retirada(valor);
		System.out.println("Novo Saldo: " + String.format("%.2f", conta.getSaldo()));
		}
		
		catch (DomainException e) {
			System.out.println("Erro na retirada " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		finally {
			sc.close();
		}
				
	}

}
