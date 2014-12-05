package Interfaces;

import java.util.Random;

public interface Armas {
    
    public static final Random rand = new Random();

    public void causarDanos(Personagem h,Personagem v);

}
