package solid;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
	private List<Pedido> _pedidosRealizados = new ArrayList<Pedido>();

	public Restaurante() {

	}

	List<Pedido> retornaPedidosRealizados() {
		return this._pedidosRealizados;
	}

	void adicionaPedido(Pedido pedido) {
		this._pedidosRealizados.add(pedido);
	}

	void removePedido(int senha) {

	}

	double retornaBalancoFinal() {
		return this._pedidosRealizados.stream().mapToDouble(i -> i.retornaPrecoTotal()).sum();
	}
}
