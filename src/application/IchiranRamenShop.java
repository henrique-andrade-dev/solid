package application;

import java.util.ArrayList;

public class IchiranRamenShop implements Restaurante {
	private ArrayList<Pedido> _pedidosRealizados;

	public IchiranRamenShop() {
		atribuiPedidosRealizados();
	}

	public ArrayList<Pedido> retornaPedidosRealizados() {
		return this._pedidosRealizados;
	}
	
	private void atribuiPedidosRealizados() {
		this._pedidosRealizados = new ArrayList<Pedido>();
	}

	public void adicionaPedido(Pedido pedido) {
		this._pedidosRealizados.add(pedido);
	}

	public void removePedido(Pedido pedido) {
		this._pedidosRealizados.remove(pedido);
	}

	public double retornaBalancoFinal() {
		return this._pedidosRealizados.stream().mapToDouble(i -> i.retornaPrecoTotal()).sum();
	}
}
