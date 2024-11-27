package modelos;

import constantes.Estado;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Pedido {

    private String cliente;
    private int numeroPedido;
    private String[] listaDeProductos;
    private Estado estadoDelPedido;

    public Pedido() {
        System.out.println("Estás creando un pedido");
        Random dim = new Random();
        this.listaDeProductos = new String[dim.nextInt(10 + 1)];    //Para que tenga máximo 10 productos
    }
    public Pedido(String cliente, int numeroPedido, String[] listaDeProductos, Estado estadoDelPedido) {
        this();
        this.numeroPedido = numeroPedido;
        this.listaDeProductos = listaDeProductos;
        this.estadoDelPedido = estadoDelPedido;
    }

    public String getCliente() {
        return this.cliente;
    }
        public int getNumeroPedido() {
            return this.numeroPedido;
        }
            public String[] getListaDeProductos() {
                return this.listaDeProductos;
            }
                public Estado getEstadoDelPedido() {
                    return this.estadoDelPedido;
                }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
        public void setNumeroPedido(int numeroPedido) {
            this.numeroPedido = numeroPedido;
        }
            public void setListaDeProductos(String[] listaDeProductos) {
                this.listaDeProductos = listaDeProductos;
            }
                public void setEstadoDelPedido(Estado estado) {
                    this.estadoDelPedido = estado;
                }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return numeroPedido == pedido.numeroPedido && Objects.equals(cliente, pedido.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, numeroPedido);
    }
}
