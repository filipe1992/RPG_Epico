package abstratas;

import Interfaces.Personagem;

public abstract class Vilao implements Personagem {

    protected int niveldemaldade;

    protected float dinheiro;

    protected int life;

    public void ataca() {

    }

    public Vilao() {

    }

    public Vilao(int niveldemaldade, float dinheiro) {

    }

    public int getNiveldemaldade() {
        return niveldemaldade;
    }

    public void setNiveldemaldade(int niveldemaldade) {
        this.niveldemaldade = niveldemaldade;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int nivel) {
        this.life = nivel;
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
