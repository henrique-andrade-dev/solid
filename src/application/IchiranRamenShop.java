package application;

import java.util.ArrayList;

import exceptions.ExcecaoAdicionaPedidoDuplicado;

public class IchiranRamenShop implements Restaurante {
	private static final IchiranRamenShop INSTANCE = new IchiranRamenShop();
	private ArrayList<Pedido> _pedidosRealizados;

	private IchiranRamenShop() {
		atribuiPedidosRealizados();
	}
	
	public static IchiranRamenShop getInstance() {
		return INSTANCE;
	}

	public ArrayList<Pedido> retornaPedidosRealizados() {
		return this._pedidosRealizados;
	}

	private void atribuiPedidosRealizados() {
		this._pedidosRealizados = new ArrayList<Pedido>();
	}

	public void adicionaPedido(Pedido pedido) throws ExcecaoAdicionaPedidoDuplicado {
		if (!this._pedidosRealizados.contains(pedido))
			this._pedidosRealizados.add(pedido);
		else
			throw new ExcecaoAdicionaPedidoDuplicado();
	}

	public void removePedido(Pedido pedido) {
		this._pedidosRealizados.remove(pedido);
	}

	public double retornaBalancoFinal() {
		return this._pedidosRealizados.stream().mapToDouble(i -> i.retornaPrecoTotal()).sum();
	}
}
