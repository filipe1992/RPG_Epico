package abstratas;

import Interfaces.Armas;
import Interfaces.Personagem;
import java.util.ArrayList;

public abstract class Vilao implements Personagem {

    protected int niveldemaldade;

    protected float dinheiro;

    protected byte life;
    
    protected ArrayList<Armas> armas; 

    public void ataca(Personagem p) {
        
    }

    public Vilao() {
        this.niveldemaldade = 1;
        this.dinheiro = (this.getNiveldemaldade() * 2);
        this.life = 100;
    }

    public Vilao(int niveldemaldade, float dinheiro) {
        this.life=100;
    }

    public final int getNiveldemaldade() {
        return niveldemaldade;
    }

    public void setNiveldemaldade(int niveldemaldade1) {
        if (niveldemaldade1 < 1)
            niveldemaldade1 = 1;
        this.niveldemaldade = niveldemaldade1;
    }

    @Override
    public float getDinheiro() {
        return dinheiro;
    }

    @Override
    public void setDinheiro(float dinheiro1) {
        if (dinheiro1 <= 0)
            dinheiro1 = 1;
        this.dinheiro = dinheiro1;
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
        return !armas.isEmpty();
    }

    /**
     * @return 
     * @see Interfaces.Personagem#usarArmaSobrehumano()
     */
    @Override
    public boolean usarArmaSobrehumano() {
        return !armas.isEmpty();
    }

}
