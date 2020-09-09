package application;

import java.util.ArrayList;

import exceptions.ExcecaoAdicionaPedidoDuplicado;

public interface Restaurante {
	public ArrayList<Pedido> retornaPedidosRealizados();

	public void adicionaPedido(Pedido pedido) throws ExcecaoAdicionaPedidoDuplicado;

	public void removePedido(Pedido pedido);

	public double retornaBalancoFinal();
}
