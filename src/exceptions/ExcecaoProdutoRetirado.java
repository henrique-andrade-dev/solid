package exceptions;

public class ExcecaoProdutoRetirado extends Exception {
	private static final long serialVersionUID = 1L;

	public ExcecaoProdutoRetirado() {
		super("N�o � mais poss�vel fazer qualquer tipo de altera��o neste pedido, pois o produto j� foi retirado.");
	}
}
