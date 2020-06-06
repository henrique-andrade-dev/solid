package application;

import java.util.ArrayList;

public class Pedido {
	private static int count = 0;
	private int _senhaCliente;
	private TamanhoPrato _tamanhoPrato;
	private ArrayList<Adicional> _adicionais;
	private boolean _retirado;

	public Pedido(TamanhoPrato tamanhoPrato, ArrayList<Adicional> adicionais) {
		atribuiSenhaCliente();
		atribuiTamanhoPrato(tamanhoPrato);
		atribuiAdicionais(adicionais);
		atribuiFlagRetirado();
	}

	public int retornaSenhaCliente() {
		return this._senhaCliente;
	}

	public TamanhoPrato retornaTamanhoPrato() {
		return this._tamanhoPrato;
	}

	public ArrayList<Adicional> retornaListaAdicionais() {
		return this._adicionais;
	}

	public boolean foiRetirado() {
		return this._retirado;
	}

	private void atribuiSenhaCliente() {
		this._senhaCliente = count++;
	}

	public void atribuiTamanhoPrato(TamanhoPrato tamanhoPrato) {
		this._tamanhoPrato = tamanhoPrato;
	}

	private void atribuiAdicionais(ArrayList<Adicional> adicionais) {
		this._adicionais = adicionais;
	}

	private void atribuiFlagRetirado() {
		this._retirado = false;
	}

	public void acrecentaAdicional(Adicional adicional) {
		if (!this._retirado)
			this._adicionais.add(adicional);
	}

	public void removeAdicional(Adicional adicional) {
		if (!this._retirado)
			this._adicionais.remove(adicional);
	}

	public void retirarPedido() {
		this._retirado = true;
	}

	public double retornaPrecoTotal() {
		return this._tamanhoPrato.preco() + this._adicionais.stream().mapToDouble(adicional -> adicional.preco()).sum();
	}
}
