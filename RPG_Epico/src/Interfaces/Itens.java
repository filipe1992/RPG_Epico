package Interfaces;

import java.util.Scanner;

public interface Itens {
    
    
    //para facilitar
    static Scanner in = new Scanner(System.in);
    //para o uso nos metodos;

    public void escolher(Personagem p);

    public void usar(Personagem p);

}
