public class ContaInvestimento extends Conta {
  private static final double JUROS_RENDIMENTO = 0.0050;
  private int tempoInvestimento = 0;

  public ContaInvestimento(Cliente cliente) {
    super(cliente);
  }

  @Override
  public void imprimirExtrato() {
    System.out.println("=== Extrato Conta Investimento ===");
    super.imprimirInfosComuns();
  }

  public void investir(int tempoInvestimento) {
    this.tempoInvestimento = tempoInvestimento;
    this.saldo = calcularSaldo();
  }

  public int getTempoInvestimento() {
    return tempoInvestimento;
  }

  private double calcularSaldo() {
    double montante = saldo * Math.pow(1 + JUROS_RENDIMENTO, tempoInvestimento);
    return montante;
  }
}