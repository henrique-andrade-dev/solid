package exceptions;

public class ExcecaoAdicionaPedidoDuplicado extends Exception {
	private static final long serialVersionUID = 1L;

	public ExcecaoAdicionaPedidoDuplicado() {
		super("Não é possível inserir o mesmo pedido mais de 1 vez.");
	}
}
