package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Adicional;
import application.IchiranRamenShop;
import application.Pedido;
import application.TamanhoPrato;
import exceptions.ExcecaoAdicionaPedidoDuplicado;

class IchiranRamenShopTest {

	private IchiranRamenShop _ichiranRamenShop;

	@BeforeEach
	void initializeIchiranRamenShop() {
		this._ichiranRamenShop = IchiranRamenShop.getInstance();
	}

	@Test
	void retornaPedidosRealizados() {
		assertEquals(new ArrayList<Pedido>(), _ichiranRamenShop.retornaPedidosRealizados());
	}

	@Test
	void adicionaPedido() throws ExcecaoAdicionaPedidoDuplicado {
		ArrayList<Adicional> adicionais = new ArrayList<Adicional>();

		Pedido pedido = new Pedido(TamanhoPrato.MEDIO, adicionais);

		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(pedido);

		_ichiranRamenShop.adicionaPedido(pedido);

		assertEquals(pedidos, _ichiranRamenShop.retornaPedidosRealizados());

		_ichiranRamenShop.removePedido(pedido);
	}

	@Test
	void removePedido() throws ExcecaoAdicionaPedidoDuplicado {
		ArrayList<Adicional> adicionais = new ArrayList<Adicional>();

		Pedido pedido = new Pedido(TamanhoPrato.MEDIO, adicionais);

		IchiranRamenShop ichiranRamenShop = IchiranRamenShop.getInstance();
		ichiranRamenShop.adicionaPedido(pedido);
		ichiranRamenShop.removePedido(pedido);

		assertEquals(new ArrayList<Pedido>(), ichiranRamenShop.retornaPedidosRealizados());

		ichiranRamenShop = null;

		System.gc();
	}

	@Test
	void retornaBalancoFinal() throws ExcecaoAdicionaPedidoDuplicado {
		ArrayList<Adicional> adicionais = new ArrayList<Adicional>();
		adicionais.add(Adicional.BOI);
		adicionais.add(Adicional.BOI);
		adicionais.add(Adicional.REFRIGERANTE);

		Pedido pedido = new Pedido(TamanhoPrato.MEDIO, adicionais);

		IchiranRamenShop ichiranRamenShop = IchiranRamenShop.getInstance();
		ichiranRamenShop.adicionaPedido(pedido);

		assertEquals(34.6, ichiranRamenShop.retornaBalancoFinal());

		ichiranRamenShop = null;

		System.gc();
	}
}
