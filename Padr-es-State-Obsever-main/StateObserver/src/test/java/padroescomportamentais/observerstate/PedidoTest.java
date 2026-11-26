package padroescomportamentais.observerstate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    public void deveNotificarClienteSobreMudancaDeEstado() {
        Pedido pedido = new Pedido("Notebook Gamer");
        Cliente cliente = new Cliente("Alexandre");

        pedido.adicionarObservador(cliente);

        pedido.pagar();

        assertEquals("Pago", pedido.getNomeEstado());
        assertEquals("Olá Alexandre, seu pedido mudou para o estado: Pago", cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarMultiplasMudancasDeEstado() {
        Pedido pedido = new Pedido("Smartphone");
        Cliente cliente = new Cliente("Maria");

        pedido.adicionarObservador(cliente);

        pedido.pagar();
        assertEquals("Olá Maria, seu pedido mudou para o estado: Pago", cliente.getUltimaNotificacao());

        pedido.enviar();
        assertEquals("Olá Maria, seu pedido mudou para o estado: Enviado", cliente.getUltimaNotificacao());

        pedido.entregar();
        assertEquals("Olá Maria, seu pedido mudou para o estado: Entregue", cliente.getUltimaNotificacao());
    }
}