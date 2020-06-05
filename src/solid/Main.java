package solid;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Adicional[] adicionais = { Adicional.BOI, Adicional.REFRIGERANTE };

		Pedido pedido = new Pedido(TamanhoPrato.MEDIO, Arrays.asList(adicionais));

		Restaurante ichiranRamenShop = new Restaurante();

		ichiranRamenShop.adicionaPedido(pedido);

		exibeDadosRestaurante(ichiranRamenShop);
		// FALTA IMPLEMENTAR CLASSES DE ERRO
	}
	
	static void exibeDadosRestaurante(Restaurante restaurante) {
		exibePedidosRealizados(restaurante);
		exibeBalancoFinal(restaurante);
	}

	static void exibePedidosRealizados(Restaurante restaurante) {
		System.out.println("--\r\n");
		System.out.println("Pedidos realizados:\r\n");

		for (Pedido pedido : restaurante.retornaPedidosRealizados()) {
			System.out.println("  Senha do cliente: " + pedido.retornaSenhaCliente());
			System.out.println("  Tamanho do prato: " + pedido.retornaTamanhoPrato());
			System.out.println("  Adicionais: " + pedido.retornaListaAdicionais());
			System.out.println("  Retirado: " + pedido.foiRetirado());
			System.out.println("  Preço total: " + pedido.retornaPrecoTotal());
		}
	}

	static void exibeBalancoFinal(Restaurante restaurante) {
		System.out.println("\r\n--");
		System.out.println("\r\nBalanço final: " + restaurante.retornaBalancoFinal());
	}
}
