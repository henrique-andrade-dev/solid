package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Adicional;
import application.Pedido;
import application.TamanhoPrato;

class PedidoTest {

	private Pedido _pedido;

	@BeforeEach
	void initializePedido() {
		ArrayList<Adicional> adicionais = new ArrayList<Adicional>();
		adicionais.add(Adicional.BOI);

		this._pedido = new Pedido(TamanhoPrato.MEDIO, adicionais);
	}

	@Test
	void retornaSenhaCliente() {
		assertEquals(4, this._pedido.retornaSenhaCliente());
	}

	@Test
	void retornaTamanhoPrato() {
		assertEquals(TamanhoPrato.MEDIO, this._pedido.retornaTamanhoPrato());
	}

	@Test
	void retornaListaAdicionais() {
		ArrayList<Adicional> adicionais = new ArrayList<Adicional>();
		adicionais.add(Adicional.BOI);

		assertEquals(adicionais, this._pedido.retornaListaAdicionais());
	}

	@Test
	void foiRetirado() {
		assertEquals(false, this._pedido.foiRetirado());
	}

	@Test
	void retirarPedido() {
		this._pedido.retirarPedido();

		assertTrue(this._pedido.foiRetirado());
	}

	@Test
	void retornaPrecoTotal() {
		assertEquals(20.8, this._pedido.retornaPrecoTotal());
	}
}
