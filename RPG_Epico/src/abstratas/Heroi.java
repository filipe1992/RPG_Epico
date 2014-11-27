package abstratas;

import Interfaces.Armas;
import Interfaces.Itens;
import Interfaces.Personagem;
import java.util.ArrayList;

public abstract class Heroi implements Personagem {

    protected int niveldebondade;

    protected int life;

    protected float dinheiro;

    protected ArrayList<Itens> itens;

    protected ArrayList<Armas> armas;

    protected int nivel;

    public Heroi() {

    }

    public Heroi(int niveldebondade, int life) {

    }

    public abstract void atacar();

    public abstract void fugir();

    public void buscarBatalhas() {

    }

    public void comprarItens() {

    }

    public void usarItem() {

    }

    /**
     * @return @see Interfaces.Personagem#usarArmarnatural()
     */
    @Override
    public boolean usarArmarnatural() {
        return false;
    }

    /**
     * @return @see Interfaces.Personagem#usarArmaSobrehumano()
     */
    @Override
    public boolean usarArmaSobrehumano() {
        return false;
    }

}
