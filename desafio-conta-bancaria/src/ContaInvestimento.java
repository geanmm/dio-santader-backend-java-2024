public class ContaInvestimento extends Conta {
  private static final double JUROS_RENDIMENTO = 0.0050;
  private int tempoInvestimento = 0;

  public ContaInvestimento(Cliente cliente) {
    super(cliente);
  }

  @Override
  public void imprimirExtrato() {
    System.out.println("=== Extrato Conta Investimento Após" + tempoInvestimento + " Meses ===");
    super.imprimirInfosComuns();
  }

  public int getTempoInvestimento() {
    return tempoInvestimento;
  }

  public void investir(int tempoMeses) {
    double montante = saldo * Math.pow(1 + JUROS_RENDIMENTO, tempoMeses);
    this.tempoInvestimento = tempoMeses;
    this.saldo = montante;
  }
}