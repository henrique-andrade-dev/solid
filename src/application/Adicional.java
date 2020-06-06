package application;

public enum Adicional {
	VEGANO(3.9), PORCO(5.9), BOI(7.9),

	CARNE_EXTRA(4), CREME_ALHO(1.5), CHILLI(2.5), CROUTONS(2), SHITAKE(6.9),

	REFRIGERANTE(5.9), O_CHA_VERDE(3.9), KO_CHA_PRETO(0);

	private double _preco;

	Adicional(double preco) {
		_preco = preco;
	}

	double preco() {
		return _preco;
	}
}
