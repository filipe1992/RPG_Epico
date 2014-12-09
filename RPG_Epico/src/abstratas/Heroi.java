package abstratas;

import Interfaces.Armas;
import Interfaces.Itens;
import Interfaces.Personagem;
import concretas.Armaduras;
import concretas.Remedios;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Heroi implements Personagem {

    //para facilitar
    private static Scanner in = new Scanner(System.in);
    //para o uso nos metodos;

    protected int niveldebondade;

    protected byte life;

    protected int nivel;

    protected static float dinheiro = 0;

    protected static ArrayList<Itens> itens;

    protected static ArrayList<Armas> armas;

    public Heroi(int niveldebondade, byte life) {
        this.niveldebondade = niveldebondade;
        this.life = life;
        this.nivel = 0;
    }

    public Heroi() {
        this.niveldebondade = 0;
        this.life = 100;
        this.nivel = 0;
    }

    public abstract void atacar();

    public abstract void fugir();

    //para realisar a busca por uma batalha ele devera devouver seu nivel para encontrar um oponete a altura.
    //que sera usada na função batalha do main.
    public int buscarBatalhas() {
        System.out.println("Seu heroi possui: ");
        System.out.println(this);
        return (int) (((this.nivel * 3) + (this.niveldebondade * 2)) / 5);
    }

    public void comprarItens() {
        System.out.println("dinheiro: " + dinheiro);
    }

    public void usarItem() {
        boolean nsair;

        System.out.println("digite o item a ser ultilizado: ");
        do {
            System.out.println("1<- para remedios\n"
                    + "2<- para armadura: ");
            switch (in.nextInt()) {
                case 1:
                    System.out.println("Voce possui os seguintes remedios: ");
                    for (Itens iten : itens) {
                        if (iten instanceof Remedios) {
                            System.out.println(iten);
                        }
                    }
                    nsair = false;
                    break;
                case 2:
                    System.out.println("Voce possui as seguintes armaduras: ");
                    for (Itens iten : itens) {
                        if (iten instanceof Armaduras) {
                            System.out.println(iten);
                        }
                    }
                    nsair = false;
                    break;
                default:
                    System.out.println("digite um valor valido!!!!");
                    nsair = true;
            }
        } while (nsair);

    }

    /**
     * @return @see Interfaces.Personagem#usarArmarnatural()
     */
    @Override
    public boolean usarArmarnatural() {
        return !armas.isEmpty();
    }

    /**
     * @return @see Interfaces.Personagem#usarArmaSobrehumano()
     */
    @Override
    public boolean usarArmaSobrehumano() {
        return !armas.isEmpty();
    }

}
