package Interfaces;

import java.util.Random;

public interface Armas {
    
    //ajudar nas subclasses {
    public static final Random rand = new Random();
    // }
    
    public abstract void causarDanos(Personagem h,Personagem v);

}
