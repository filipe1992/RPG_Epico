package Interfaces;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface Armas extends Itens {
    
    static JOptionPane JO = new JOptionPane();
    static JFrame frame = new JFrame();

    //ajudar nas subclasses {
    public static final Random rand = new Random();
    // }

    public abstract boolean causarDanos(Personagem h, Personagem v);

    public void subirDeNivel(Personagem p);

    @Override
    public String toString();

}
