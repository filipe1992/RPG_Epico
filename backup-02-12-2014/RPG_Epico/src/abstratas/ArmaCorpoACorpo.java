package abstratas;

import Interfaces.Armas;
import Interfaces.Personagem;

public abstract class ArmaCorpoACorpo implements Armas {

    protected int dano;

    /**
     * @param h
     * @param v
     * @see Interfaces.Armas#causarDanos()
     */
    @Override
    public void causarDanos(Personagem h, Personagem v) {

    }

}
