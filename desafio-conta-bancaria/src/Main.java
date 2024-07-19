import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Cliente fulano = new Cliente();
		fulano.setNome("Fulano");

		Conta corrente = new ContaCorrente(fulano);
		Conta poupanca = new ContaPoupanca(fulano);
		ContaInvestimento investimento = new ContaInvestimento(fulano);

		corrente.depositar(2000);
		corrente.transferir(230, poupanca);
		corrente.transferir(680, investimento);
		investimento.investir(7);

		Banco bancoN = new Banco();
		bancoN.setNome("Banco N");
		bancoN.setContas(Arrays.asList(corrente, poupanca, investimento));
		bancoN.getContas().forEach(Conta::imprimirExtrato);
		;
	}

}
