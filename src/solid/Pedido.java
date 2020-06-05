package solid;

import java.util.List;

public class Pedido {
	private int _senhaCliente;
	private TamanhoPrato _tamanhoPrato;
	private List<Adicional> _adicionais;
	private boolean _retirado;

	public Pedido(TamanhoPrato tamanhoPrato, List<Adicional> adicionais) {
		atribuiSenhaCliente();
		atribuiTamanhoPrato(tamanhoPrato);
		atribuiAdicionais(adicionais);
		atribuiFlagRetirado();
	}

	int retornaSenhaCliente() {
		return this._senhaCliente;
	}

	TamanhoPrato retornaTamanhoPrato() {
		return this._tamanhoPrato;
	}

	List<Adicional> retornaListaAdicionais() {
		return this._adicionais;
	}

	boolean foiRetirado() {
		return this._retirado;
	}

	private void atribuiSenhaCliente() {
		this._senhaCliente = this._senhaCliente++;
	}

	void atribuiTamanhoPrato(TamanhoPrato tamanhoPrato) {
		this._tamanhoPrato = tamanhoPrato;
	}

	void atribuiAdicionais(List<Adicional> adicionais) {
		this._adicionais = adicionais;
	}

	private void atribuiFlagRetirado() {
		this._retirado = false;
	}

	void acrecentaAdicional(Adicional adicional) {
		this._adicionais.add(adicional);
	}

	void removeAdicional(Adicional adicional) {
		this._adicionais.remove(adicional);
	}

	void retirarPedido() {
		this._retirado = true;
	}

	double retornaPrecoTotal() {
		return this._tamanhoPrato.preco() + this._adicionais.stream().mapToDouble(i -> i.preco()).sum();
	}
}
