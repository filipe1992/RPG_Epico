package abstratas;

import Interfaces.Personagem;

public abstract class Vilao implements Personagem {

	protected int niveldemaldade;

	protected float dinheiro;

	public void ataca() {

	}

	public Vilao() {

	}

	public Vilao(int niveldemaldade, float dinheiro) {

	}


	/**
	 * @see Interfaces.Personagem#usarArmarnatural()
	 */
	public boolean usarArmarnatural() {
		return false;
	}


	/**
	 * @see Interfaces.Personagem#usarArmaSobrehumano()
	 */
	public boolean usarArmaSobrehumano() {
		return false;
	}

}
