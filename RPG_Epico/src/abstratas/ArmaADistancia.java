package abstratas;

import Interfaces.Armas;

public abstract class ArmaADistancia implements Armas {

	protected int dano;

	protected byte chancesdeerro;

	public void atirar() {

	}

	public ArmaADistancia() {

	}

	public ArmaADistancia(int dano, byte chacesdeerro) {

	}


	/**
	 * @see Interfaces.Armas#causarDanos()
	 */
        @Override
	public void causarDanos() {

	}

}
