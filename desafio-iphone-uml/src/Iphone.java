public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    // --- Reprodutor Musical
    @Override
    public void selecionarMusica(String musica) {
        // Selecionar música
        // ...
    }

    @Override
    public void tocar() {
        // Tocar música
        // ...
    }

    @Override
    public void pausar() {
        // Pausar música
        // ...
    }

    // --- Navegador de Internet
    @Override
    public void exibirPagina(String url) {
        // Exibir página da web
        // ...
    }

    @Override
    public void adicionarNovaAba() {
        // Adicionar nova aba
        // ...
    }

    @Override
    public void atualizarPagina() {
        // atualizar página
        // ...
    }

    // --- Aparelho telefônico
    @Override
    public void ligar(String numero) {
        // Ligar para número
        // ...
    }

    @Override
    public void atender() {
        // Atender ligação
        // ...
    }

    @Override
    public void iniciarCorreioVoz() {
        // iniciar correio de voz
        // ...
    }

}
