package padroescomportamentais.observerstate;

public class Cliente implements PedidoObserver {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    @Override
    public void update(Pedido pedido) {
        this.ultimaNotificacao = "Olá " + this.nome + ", seu pedido mudou para o estado: " + pedido.getNomeEstado();
    }
}