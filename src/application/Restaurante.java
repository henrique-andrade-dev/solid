package application;

import java.util.ArrayList;

public interface Restaurante {
	public ArrayList<Pedido> retornaPedidosRealizados();	
	public void adicionaPedido(Pedido pedido);
	public void removePedido(Pedido pedido);
	public double retornaBalancoFinal();
}
