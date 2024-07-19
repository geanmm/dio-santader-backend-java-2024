import br.edu.dio.desafio.dominio.*;

public class App {
    public static void main(String[] args) throws Exception {
        Curso cursoJava = new Curso("Curso Java", "Descricao Curso Java", 10);
        Curso cursoJavaScript = new Curso("Curso JavaScript", "Descricao Curso JavaScript", 8);

        Mentoria mentoria = new Mentoria("Mentoria Java", "Descrição Mentoria Java.");

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoJavaScript);
        bootcamp.getConteudos().add(mentoria);

        Dev devABC = new Dev("Dev ABC");
        devABC.inscrever(bootcamp);
        devABC.progredir(bootcamp);
        devABC.imprimirInformacoes();

        System.out.println("---------------------------------------------");
        Dev devXYZ = new Dev("Dev XYZ");
        devXYZ.inscrever(bootcamp);
        devXYZ.progredir(bootcamp);
        devXYZ.progredir(bootcamp);
        devXYZ.imprimirInformacoes();

    }
}
