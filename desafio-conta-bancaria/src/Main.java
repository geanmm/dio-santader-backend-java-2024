
public class Main {

	public static void main(String[] args) {
		Cliente fulano = new Cliente();
		fulano.setNome("Fulano");

		Conta corrente = new ContaCorrente(fulano);
		Conta poupanca = new ContaPoupanca(fulano);
		ContaInvestimento investimento = new ContaInvestimento(fulano);

		corrente.depositar(1000);
		corrente.transferir(150, poupanca);
		corrente.transferir(600, investimento);

		corrente.imprimirExtrato();
		poupanca.imprimirExtrato();
		investimento.imprimirExtrato();

		investimento.investir(7);
		System.out.println("====== Após " + investimento.getTempoInvestimento() + " meses =====");
		investimento.imprimirExtrato();
	}

}
