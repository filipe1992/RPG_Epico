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
        this.nivel = 0;
        this.setLifemaximo((byte) life);
        this.setLife(life);
        armas = new ArrayList<>();
        itens = new ArrayList<>();
    }

    public Heroi() {
        this.niveldebondade = 0;
        this.life = 100;
        this.lifemaximo = 100;
        this.nivel = 0;
        armas = new ArrayList<>();
        itens = new ArrayList<>();
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

    public final void setLifemaximo(byte lifemaximo) {
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
    public final void setLife(byte life) {
        if (life > this.lifemaximo) {
            this.life = this.lifemaximo;
        } else {
            this.life = life;
        }
    }

    public void setNivel(int nivel) {
        if (nivel < 0)
            nivel = 0;
        this.nivel = nivel;
    }

    @Override
    public void setDinheiro(float dinheiro) {
        if (dinheiro < 0)
            dinheiro = 0;
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
            String[] esc = {"digite o item a ser comprado: ", "*********Armaduras*******", "**********Remedios*********"};
            String escolha = (String) JOptionPane.showInputDialog(frame, "Escolha !!!!", "Heroi", JOptionPane.QUESTION_MESSAGE, null, esc, esc[0]);
            if (escolha == null) {
                escolha = "0";
            }
            switch (escolha) {
                case "*********Armaduras*******":
                    System.out.println("*********Armaduras*******");
                    novo = new Armaduras();
                    novo.escolher(this);
                    itens.add(novo);
                    nsair = false;
                    break;
                case "**********Remedios*********":
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
        boolean nsair = false;

        System.out.println("digite o item a ser ultilizado: ");
        do {
            String[] vet1 = {"1<- para remedios", "2<- para armadura"};
            String escolha = (String) JOptionPane.showInputDialog(frame, "Escolha um heroi !!!!", "Heroi", JOptionPane.QUESTION_MESSAGE, null, vet1, vet1[0]);
            if (escolha == null) {
                escolha = "0";
            }
            if (itens.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Voce não possui Itens !!!! (sepol)");
            } else {
                switch (escolha) {
                    case "1<- para remedios":
                        System.out.println("Voce possui os seguintes remedios: ");
                        for (int i = 0; i < itens.size(); i++) {
                            if (itens.get(i) instanceof Remedios) {
                                System.out.println("Codigo: " + i);
                                System.out.println(itens.get(i));
                            }
                        }
                        nsair = false;
                        break;
                    case "2<- para armadura":
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
            }
        } while (nsair);
        if (!(itens.isEmpty())) {
            System.out.println("digite o codigo do que voce quer usar: ");
            int escolha = in.nextInt();
            itens.get(escolha).usar(this);
            itens.remove(escolha);
        }
    }

    /**
     * @return @see Interfaces.Personagem#usarArmarnatural()
     */
    @Override
    public int usarArma() {
        String escarmas[];
        escarmas = new String[armas.size()];
        for (int i = 0; i < armas.size(); i++) {
            escarmas[i] = i + " " + armas.get(i).toString();
        }
        String esc = (String) JOptionPane.showInputDialog(frame, "Qual arma voce deseja usar ?? ", "Arma", JOptionPane.QUESTION_MESSAGE, null, escarmas, escarmas[0]);
        if (esc == null) {
            return 0;
        }
        return (((int) esc.charAt(0)) - 48);
    }

    public void comprarArma() {
        String[] escolha = {"Arco e Flecha", "Cajado", "Espada", "Machado"};
        String esc = (String) JOptionPane.showInputDialog(frame, "Qual arma voce deseja comprar ?? ", "Armas", JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
        if (esc == null) {
            esc = "0";
        }
        switch (esc) {
            case "Arco e Flecha":
                if (this.getDinheiro() >= 10) {
                    armas.add(new ArcoEFlecha());
                    this.setDinheiro(this.getDinheiro() - 10);
                } else {
                    JOptionPane.showMessageDialog(frame, "não possui dinheiro para isso");
                }

                break;
            case "Cajado":
                if (this.getDinheiro() >= 10) {
                    armas.add(new Cajado());
                    this.setDinheiro(this.getDinheiro() - 10);
                } else {
                    JOptionPane.showMessageDialog(frame, "não possui dinheiro para isso");
                }
                break;
            case "Espada":
                if (this.getDinheiro() >= 10) {
                    armas.add(new Espada());
                    this.setDinheiro(this.getDinheiro() - 10);
                } else {
                    JOptionPane.showMessageDialog(frame, "não possui dinheiro para isso");
                }
                armas.add(new Espada());
                break;
            case "Machado":
                if (this.getDinheiro() >= 10) {
                    armas.add(new Machado());
                    this.setDinheiro(this.getDinheiro() - 10);
                } else {
                    JOptionPane.showMessageDialog(frame, "não possui dinheiro para isso");
                }
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Digite um valor valido...");

        }
    }

    @Override
    public String toString() {
        return " Este Heroi possui: \n"
                + "niveldebondade= " + niveldebondade
                + "\nlife= " + life
                + "\nlifemaximo= " + lifemaximo + "\n"
                + "nivel= " + nivel + "\n"
                + "armadura= " + armadura + "\n"
                + "Dinheiro= " + dinheiro;
    }

}
