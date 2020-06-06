package application;

import java.util.ArrayList;

import exceptions.ExcecaoProdutoRetirado;

public class Pedido {
	private static int count = 0;
	private int _senhaCliente;
	private TamanhoPrato _tamanhoPrato;
	private ArrayList<Adicional> _adicionais;
	private boolean _retirado;

	public Pedido(TamanhoPrato tamanhoPrato, ArrayList<Adicional> adicionais) {
		try {
			atribuiSenhaCliente();
			atribuiTamanhoPrato(tamanhoPrato);
			atribuiAdicionais(adicionais);
			atribuiFlagRetirado();
		} catch (ExcecaoProdutoRetirado e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
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

	public void atribuiTamanhoPrato(TamanhoPrato tamanhoPrato) throws ExcecaoProdutoRetirado {
		if (!this._retirado)
			this._tamanhoPrato = tamanhoPrato;
		else
			throw new ExcecaoProdutoRetirado();
	}

	private void atribuiAdicionais(ArrayList<Adicional> adicionais) {
		this._adicionais = adicionais;
	}

	private void atribuiFlagRetirado() {
		this._retirado = false;
	}

	public void acrecentaAdicional(Adicional adicional) throws ExcecaoProdutoRetirado {
		if (!this._retirado)
			this._adicionais.add(adicional);
		else
			throw new ExcecaoProdutoRetirado();
	}

	public void removeAdicional(Adicional adicional) throws ExcecaoProdutoRetirado {
		if (!this._retirado)
			this._adicionais.remove(adicional);
		else
			throw new ExcecaoProdutoRetirado();
	}

	public void retirarPedido() {
		this._retirado = true;
	}

	public double retornaPrecoTotal() {
		return this._tamanhoPrato.preco() + this._adicionais.stream().mapToDouble(adicional -> adicional.preco()).sum();
	}
}
