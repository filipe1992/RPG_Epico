package abstratas;

import Interfaces.Personagem;

public abstract class Vilao implements Personagem {

    protected int niveldemaldade;

    protected float dinheiro;

    protected byte life;

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

    @Override
    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    @Override
    public byte getLife() {
        return life;
    }

    @Override
    public void setLife(byte life) {
        this.life = life;
    }

    /**
     * @return 
     * @see Interfaces.Personagem#usarArmarnatural()
     */
    @Override
    public boolean usarArmarnatural() {
        return false;
    }

    /**
     * @return 
     * @see Interfaces.Personagem#usarArmaSobrehumano()
     */
    @Override
    public boolean usarArmaSobrehumano() {
        return false;
    }

}
