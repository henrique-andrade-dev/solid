package application;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Adicional[] adicionais = { Adicional.BOI, Adicional.REFRIGERANTE };

		Pedido pedido = new Pedido(TamanhoPrato.MEDIO, Arrays.asList(adicionais));
		Pedido pedido2 = new Pedido(TamanhoPrato.PEQUENO, Arrays.asList(adicionais));

		Restaurante ichiranRamenShop = new Restaurante();

		ichiranRamenShop.adicionaPedido(pedido);
		ichiranRamenShop.adicionaPedido(pedido2);

		exibeDadosRestaurante(ichiranRamenShop);
		// FALTA IMPLEMENTAR CLASSES DE ERRO
	}
	
	static void exibeDadosRestaurante(Restaurante restaurante) {
		exibePedidosRealizados(restaurante);
		exibeBalancoFinal(restaurante);
	}

	static void exibePedidosRealizados(Restaurante restaurante) {
		System.out.println("Pedidos realizados:");

		for (Pedido pedido : restaurante.retornaPedidosRealizados()) {
			System.out.println("\r\n  Senha do cliente: " + pedido.retornaSenhaCliente());
			System.out.println("  Tamanho do prato: " + pedido.retornaTamanhoPrato());
			System.out.println("  Adicionais: " + pedido.retornaListaAdicionais());
			System.out.println("  Retirado: " + pedido.foiRetirado());
			System.out.println("  Preço total: R$ " + pedido.retornaPrecoTotal());
		}
	}

	static void exibeBalancoFinal(Restaurante restaurante) {
		System.out.println("\r\n--");
		System.out.println("\r\nBalanço final: R$ " + restaurante.retornaBalancoFinal());
	}
}
