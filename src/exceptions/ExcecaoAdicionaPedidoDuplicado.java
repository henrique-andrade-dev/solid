package exceptions;

public class ExcecaoAdicionaPedidoDuplicado extends Exception {
	private static final long serialVersionUID = 1L;

	public ExcecaoAdicionaPedidoDuplicado() {
		super("N�o � poss�vel inserir o mesmo pedido mais de 1 vez.");
	}
}
