package exceptions;

public class ExcecaoProdutoRetirado extends Exception {
	private static final long serialVersionUID = 1L;

	public ExcecaoProdutoRetirado() {
		super("Não é mais possível fazer qualquer tipo de alteração neste pedido, pois o produto já foi retirado.");
	}
}
