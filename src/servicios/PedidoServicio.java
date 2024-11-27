package servicios;

import constantes.Estado;
import modelos.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class PedidoServicio {
    private List<Pedido> pedidos;

    public PedidoServicio() {
        this.pedidos = new ArrayList<>();
    }

    public List<Pedido> getPedidos(){
        return this.pedidos;
    }

    public List<Pedido> listaPedidosporEstado(Estado estado){
        List<Pedido> pedidosEstado = new ArrayList<>();
        this.pedidos.forEach(p -> {
            if(p.getEstadoDelPedido().equals(estado)){
                pedidosEstado.add(p);
            }
        });
        return pedidosEstado;
    }

    public void crearPedido() {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del cliente: ");
            String cliente = sc.nextLine();
            sc.nextLine();
            System.out.println("Ingresa los productos que va a tener tu pedido, separados por comas (,): ");
            String producto = sc.nextLine();
            String[] listaPedidos = producto.split(",");
            sc.nextLine();
            System.out.println("Ingresa el número del pedido");
            int numeroPedido = sc.nextInt();
            Estado estado = Estado.EN_TRANSITO; //Así, porque cada pedido nuevo va a estar en tránsito

            Pedido miPedido = new Pedido();
                miPedido.setCliente(cliente);
                miPedido.setNumeroPedido(numeroPedido);
                miPedido.setListaDeProductos(listaPedidos);
                miPedido.setEstadoDelPedido(estado);

            this.pedidos.add(miPedido);
        }
    }
    public void actualizarEstadoPedido(Pedido pedido, Estado estado) {
        AtomicReference<Pedido> miPedido = new AtomicReference<>();
        this.pedidos.forEach(p ->{
            if(p.equals(pedido)){
                miPedido.set(p);
            }
        });
        miPedido.get().setEstadoDelPedido(estado);
        System.out.println("Estado actualizado exitosamente");
    }
}
