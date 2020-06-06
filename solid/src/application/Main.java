package application;

import java.util.ArrayList;

import exceptions.ExcecaoAdicionaPedidoDuplicado;
import exceptions.ExcecaoProdutoRetirado;

public class Main {
	public static void main(String[] args) throws ExcecaoProdutoRetirado, ExcecaoAdicionaPedidoDuplicado {
		ArrayList<Adicional> adicionais = new ArrayList<Adicional>();
		adicionais.add(Adicional.BOI);
		adicionais.add(Adicional.BOI);
		adicionais.add(Adicional.REFRIGERANTE);

		Pedido pedido = new Pedido(TamanhoPrato.MEDIO, adicionais);
		pedido.removeAdicional(Adicional.BOI);

		ArrayList<Adicional> adicionais2 = new ArrayList<Adicional>();
		adicionais2.add(Adicional.PORCO);
		adicionais2.add(Adicional.KO_CHA_PRETO);

		Pedido pedido2 = new Pedido(TamanhoPrato.PEQUENO, adicionais2);
		pedido2.removeAdicional(Adicional.BOI);

		IchiranRamenShop ichiranRamenShop = IchiranRamenShop.getInstance();
		ichiranRamenShop.adicionaPedido(pedido);
		ichiranRamenShop.adicionaPedido(pedido2);
		ichiranRamenShop.removePedido(pedido);

		exibeDadosRestaurante(ichiranRamenShop);
	}

	private static void exibeDadosRestaurante(IchiranRamenShop restaurante) {
		exibePedidosRealizados(restaurante);
		exibeBalancoFinal(restaurante);
	}

	private static void exibePedidosRealizados(IchiranRamenShop restaurante) {
		System.out.println("Pedidos realizados:");

		for (Pedido pedido : restaurante.retornaPedidosRealizados()) {
			System.out.println("\r\n  Senha do cliente: " + pedido.retornaSenhaCliente());
			System.out.println("  Tamanho do prato: " + pedido.retornaTamanhoPrato());
			System.out.println("  Adicionais: " + pedido.retornaListaAdicionais());
			System.out.println("  Retirado: " + pedido.foiRetirado());
			System.out.println("  Preço total: R$ " + String.format("%,.2f", pedido.retornaPrecoTotal()));
		}
	}

	private static void exibeBalancoFinal(IchiranRamenShop restaurante) {
		System.out.println("\r\n--");
		System.out.println("\r\nBalanço final: R$ " + String.format("%,.2f", restaurante.retornaBalancoFinal()));
	}
}
