import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        // Número
        System.out.println("Por favor, digite o número da Conta !");
        numero = scanner.nextInt();
        scanner.nextLine();

        // Agência
        System.out.println("Por favor, digite o número da Agência !");
        agencia = scanner.nextLine();

        // Nome
        System.out.println("Por favor, digite o nome do Cliente !");
        nomeCliente = scanner.nextLine();

        // Saldo
        System.out.println("Por favor, digite o Saldo da conta !");
        saldo = scanner.nextDouble();

        scanner.close();

        // Mensagem

        System.out.println(
                "Olá ".concat(nomeCliente)
                        .concat(", obrigado por criar uma conta em nosso banco, sua agência é ")
                        .concat(agencia)
                        .concat(", conta ")
                        .concat(String.valueOf(numero))
                        .concat(" e seu saldo ")
                        .concat(String.valueOf(saldo))
                        .concat("já está disponível para saque"));

    }
}
