package abstratas;

import Interfaces.Armas;
import Interfaces.Itens;
import Interfaces.Personagem;
import concretas.armas.ArcoEFlecha;
import concretas.armas.Cajado;
import concretas.armas.Espada;
import concretas.armas.Machado;
import concretas.itens.Armaduras;
import concretas.itens.Remedios;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public abstract class Heroi implements Personagem {

    //para facilitar
    protected static Scanner in = new Scanner(System.in);
    //para o uso nos metodos;

    protected int niveldebondade;

    protected byte life;

    protected byte lifemaximo;

    protected int nivel;

    protected int armadura;

    protected static float dinheiro = 100;

    protected static ArrayList<Itens> itens;

    protected static ArrayList<Armas> armas;

    public Heroi(int niveldebondade, byte life) {
        this.niveldebondade = niveldebondade;
        this.life = life;
        this.nivel = 0;
        this.lifemaximo = life;
    }

    public Heroi() {
        this.niveldebondade = 0;
        this.life = 100;
        this.lifemaximo = 100;
        this.nivel = 0;
        armas = new ArrayList<>();
        armas.add(new ArcoEFlecha());
        armas.add(new Cajado());
        armas.add(new Espada());
        armas.add(new Machado());
        
    }

    //funções gets{
    public int getArmadura() {
        return armadura;
    }

    public int getNiveldebondade() {
        return niveldebondade;
    }

    @Override
    public byte getLife() {
        return life;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public float getDinheiro() {
        return dinheiro;
    }

    public static ArrayList<Itens> getItens() {
        return itens;
    }

    public static ArrayList<Armas> getArmas() {
        return armas;
    }

    public void setLifemaximo(byte lifemaximo) {
        this.lifemaximo = lifemaximo;
    }

    //}fim funções gets;
    //funções sets{
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public void setNiveldebondade(int niveldebondade) {
        this.niveldebondade = niveldebondade;
    }

    @Override
    public void setLife(byte life) {
        if (life > this.lifemaximo) {
            this.life = this.lifemaximo;
        } else {
            this.life = life;
        }
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public void setDinheiro(float dinheiro) {
        Heroi.dinheiro = dinheiro;
    }

    public byte getLifemaximo() {
        return lifemaximo;
    }

    //fim funçoes sets;
    //para realisar a busca por uma batalha ele devera devouver seu nivel para encontrar um oponete a altura.
    //que sera usada na função batalha do main.
    public int buscarBatalhas() {
        System.out.println("Seu heroi possui: ");
        System.out.println(this);
        return (int) (((this.nivel * 3) + (this.niveldebondade * 2)) / 5);
    }

    public void comprarItens() {
        Itens novo;
        boolean nsair;
        System.out.println("dinheiro: " + dinheiro);
        do {
            System.out.println("digite o item a ser comprado: ");
            switch (in.nextInt()) {
                case 1:
                    System.out.println("*********Armaduras*******");
                    novo = new Armaduras();
                    novo.escolher(this);
                    itens.add(novo);
                    nsair = false;
                    break;
                case 2:
                    System.out.println("**********Remedios*********");
                    novo = new Remedios();
                    novo.escolher(this);
                    itens.add(novo);
                    nsair = false;
                    break;
                default:
                    System.out.println("digite um dalor valido!!!!");
                    nsair = true;
            }
        } while (nsair);

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
                    for (int i = 0; i < itens.size(); i++) {
                        if (itens.get(i) instanceof Remedios) {
                            System.out.println("Codigo: " + i);
                            System.out.println(itens.get(i));
                        }
                    }
                    nsair = false;
                    break;
                case 2:
                    System.out.println("Voce possui as seguintes armaduras: ");
                    for (int i = 0; i < itens.size(); i++) {
                        if (itens.get(i) instanceof Armaduras) {
                            System.out.println("Codigo: " + i);
                            System.out.println(itens.get(i));
                        }
                    }
                    nsair = false;
                    break;
                default:
                    System.out.println("digite um valor valido!!!!");
                    nsair = true;
            }
        } while (nsair);

        System.out.println("digite o codigo do que voce quer usar: ");
        int escolha = in.nextInt();
        itens.get(escolha).usar(this);
        itens.remove(escolha);
    }

    /**
     * @return @see Interfaces.Personagem#usarArmarnatural()
     */
    @Override
    public int usarArma() {
        String escarmas[];
        escarmas = new String[armas.size()+1];
        escarmas[0] = "0 Escolha uma arma !!!!";
        for (int i = 1; i <= armas.size(); i++) {
            escarmas[i] = i + " " + armas.get(i-1).toString();
        }
        return (((int) (((String) JOptionPane.showInputDialog(frame,"Qual arma voce deseja usar ?? ","Arma",JOptionPane.QUESTION_MESSAGE,null,escarmas,escarmas[0])).charAt(0)))-48);
    }

    @Override
    public String toString() {
        return " Este Heroi possui: \n"
                + "niveldebondade=" + niveldebondade
                + "life=" + life
                + "\nlifemaximo=" + lifemaximo + "\n"
                + "nivel=" + nivel + "\n"
                + "armadura=" + armadura;
    }

}
