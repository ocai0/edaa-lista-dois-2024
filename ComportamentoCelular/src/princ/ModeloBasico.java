package princ;

public class ModeloBasico implements Celular {
    private boolean _status;

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
    }

    @Override
    public void enviarMensagem(String numero, String mensagem) {
        if (!_status) {
            System.out.println("Celular Desligado");
            return;
        }
        System.out.println("Enviando mensagem para: " + numero);
        System.out.println(mensagem);
    }

}
