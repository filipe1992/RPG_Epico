package abstratas;

import Interfaces.Armas;
import Interfaces.Personagem;

public abstract class ArmaCorpoACorpo implements Armas {

    protected int dano;

    public ArmaCorpoACorpo(int dano) {
        this.dano = dano;
    }
    
    public ArmaCorpoACorpo() {
        this.dano = 1;
    }

    /**
     * @param h
     * @param v
     * @see Interfaces.Armas#causarDanos()
     */
    @Override
    public abstract void causarDanos(Personagem h, Personagem v);

}
