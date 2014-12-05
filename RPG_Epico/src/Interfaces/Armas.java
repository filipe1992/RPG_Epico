package Interfaces;

import java.util.Random;

public interface Armas {

    //ajudar nas subclasses {
    public static final Random rand = new Random();
    // }

    public abstract boolean causarDanos(Personagem h, Personagem v);

    public void subirDeNivel(Personagem p);

    @Override
    public String toString();

}
