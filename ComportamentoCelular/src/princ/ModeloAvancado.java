package princ;

import java.util.ArrayList;

public class ModeloAvancado implements Celular {
    private boolean _status;
    private ArrayList<String> mensagens;
    private ArrayList<String> historicoChamadas;

    public ModeloAvancado() {
        this.mensagens = new ArrayList<String>();
        this.historicoChamadas = new ArrayList<String>();
    }

    @Override
    public void ligar() {
        this._status = true;
    }

    @Override
    public void desligar() {
        this._status = false;
    }

    @Override
    public void fazerLigacao(String numero) {
        if (!_status) {
            System.out.println("Celular Desligado");
            return;
        }
        System.out.println("Ligando para " + numero);
        this.adicionarHistoricoLigacao(numero);
    }

    public String obterHistoricoLigacoes() {
        if (this.historicoChamadas.size() == 0) {
            return "Não há histórico de chamadas";
        }
        String resultado = "";
        for (String ligacao : this.historicoChamadas)
            resultado += ligacao + "\n";
        return resultado;
    }

    public String obterHistoricoMensagens() {
        if (this.mensagens.size() == 0) {
            return "Não há histórico de mensagens";
        }
        String resultado = "";
        for (String mensagem : this.mensagens)
            resultado += mensagem + "\n";
        return resultado;
    }

    private void adicionarHistoricoMensagens(String numero, String mensagem) {
        this.mensagens.add("Número: " + numero + "\nMensagem: " + mensagem);
    }

    private void adicionarHistoricoLigacao(String numero) {
        this.historicoChamadas.add(numero);
    }

    @Override
    public void enviarMensagem(String numero, String mensagem) {
        if (!_status) {
            System.out.println("Celular Desligado");
            return;
        }
        System.out.println("Enviando mensagem para: " + numero);
        System.out.println(mensagem);
        this.adicionarHistoricoMensagens(numero, mensagem);
    }
}
