package abstratas;

import Interfaces.Armas;
import Interfaces.Personagem;

public abstract class ArmaADistancia implements Armas {

    protected int dano;

    protected byte chancesdeerro;
    
    public abstract void subirDeNivel(Personagem P);

    public ArmaADistancia() {
        setChancesdeerro(((byte) 10));
        setDano(1);
        
    }

    public ArmaADistancia(int dano, byte chacesdeerro) {
        setDano(dano);
        setChancesdeerro(chancesdeerro);
    }

    public int getDano() {
        return dano;
    }

    public final void setDano(int dano) {
        if (dano<=0)
            dano=1;
        this.dano = dano;
    }

    public byte getChancesdeerro() {
        return chancesdeerro;
    }

    public final void setChancesdeerro(byte chancesdeerro) {
        if (chancesdeerro < 1)
            chancesdeerro=10;
        this.chancesdeerro = chancesdeerro;
    }
    
    

    /**
     * @param h
     * @param v
     * @see Interfaces.Armas#causarDanos()
     */
    @Override
    public abstract void causarDanos(Personagem h,Personagem v);

    @Override
    public String toString() {
        return "dano atual: " + dano + "\n chances de erro: 1 para " + chancesdeerro;
    }

}
