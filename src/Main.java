import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Criar cliente
		System.out.println("Digite o nome do cliente: ");
		String nomeCliente = scanner.nextLine();
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);

		// Criar conta corrente e conta poupança para o cliente
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

		while (true) {
			System.out.println("\nEscolha uma operação:");
			System.out.println("1 - Depositar na Conta Corrente");
			System.out.println("2 - Sacar da Conta Corrente");
			System.out.println("3 - Transferir da Conta Corrente para a Poupança");
			System.out.println("4 - Imprimir Extrato Conta Corrente");
			System.out.println("5 - Imprimir Extrato Conta Poupança");
			System.out.println("6 - Sair");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					System.out.println("Digite o valor para depositar na Conta Corrente: ");
					double valorDeposito = scanner.nextDouble();
					cc.depositar(valorDeposito);
					System.out.println("Depósito realizado com sucesso!");
					break;
				case 2:
					System.out.println("Digite o valor para sacar da Conta Corrente: ");
					double valorSaque = scanner.nextDouble();
					if (valorSaque <= cc.getSaldo()) {
						cc.sacar(valorSaque);
						System.out.println("Saque realizado com sucesso!");
					} else {
						System.out.println("Saldo insuficiente para saque!");
					}
					break;
				case 3:
					System.out.println("Digite o valor para transferir da Conta Corrente para a Poupança: ");
					double valorTransferencia = scanner.nextDouble();
					if (valorTransferencia <= cc.getSaldo()) {
						cc.transferir(valorTransferencia, poupanca);
						System.out.println("Transferência realizada com sucesso!");
					} else {
						System.out.println("Saldo insuficiente para transferência!");
					}
					break;
				case 4:
					cc.imprimirExtrato();
					break;
				case 5:
					poupanca.imprimirExtrato();
					break;
				case 6:
					System.out.println("Saindo...");
					scanner.close();
					return;
				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
			}
		}
	}
}
