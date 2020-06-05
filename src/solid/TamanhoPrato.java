package solid;

public enum TamanhoPrato {
	PEQUENO(3.9), MEDIO(12.9), GRANDE(15.9);

	private final double _preco;

	TamanhoPrato(double preco) {
		_preco = preco;
	}

	double preco() {
		return _preco;
	}
}
