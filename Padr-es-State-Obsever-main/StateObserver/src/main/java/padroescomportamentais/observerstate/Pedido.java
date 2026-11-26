package padroescomportamentais.observerstate;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private String descricao;
    private PedidoEstado estado;
    private List observadores = new ArrayList<>();

    public Pedido(String descricao) {
        this.descricao = descricao;
        this.estado = PedidoEstadoAberto.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        notificarObservadores();
    }

    public void adicionarObservador(PedidoObserver observer) {
        this.observadores.add(observer);
    }

    public void notificarObservadores() {
        for (PedidoObserver observer : observadores) {
            observer.update(this);
        }
    }

    public boolean pagar() {
        return estado.pagar(this);
    }

    public boolean enviar() {
        return estado.enviar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public String getDescricao() {
        return descricao;
    }
}