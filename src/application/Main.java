package application;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
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

		IchiranRamenShop ichiranRamenShop = new IchiranRamenShop();
		ichiranRamenShop.adicionaPedido(pedido);
		ichiranRamenShop.adicionaPedido(pedido2);
		ichiranRamenShop.removePedido(pedido);

		exibeDadosRestaurante(ichiranRamenShop);
	}
	
	static void exibeDadosRestaurante(IchiranRamenShop restaurante) {
		exibePedidosRealizados(restaurante);
		exibeBalancoFinal(restaurante);
	}

	static void exibePedidosRealizados(IchiranRamenShop restaurante) {
		System.out.println("Pedidos realizados:");

		for (Pedido pedido : restaurante.retornaPedidosRealizados()) {
			System.out.println("\r\n  Senha do cliente: " + pedido.retornaSenhaCliente());
			System.out.println("  Tamanho do prato: " + pedido.retornaTamanhoPrato());
			System.out.println("  Adicionais: " + pedido.retornaListaAdicionais());
			System.out.println("  Retirado: " + pedido.foiRetirado());
			System.out.println("  Preço total: R$ " + String.format("%,.2f", pedido.retornaPrecoTotal()));
		}
	}

	static void exibeBalancoFinal(IchiranRamenShop restaurante) {
		System.out.println("\r\n--");
		System.out.println("\r\nBalanço final: R$ " + String.format("%,.2f", restaurante.retornaBalancoFinal()));
	}
}
