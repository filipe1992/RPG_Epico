package concretas.itens;

import Interfaces.Itens;
import Interfaces.Personagem;
import abstratas.Heroi;
import java.util.Scanner;

public class Armaduras implements Itens {

    //para facilitar
    private static Scanner in = new Scanner(System.in);
    //para o uso nos metodos;

    protected static final String descricao = "Ideal para batalhas.\n"
            + "Com esta proteção você terá mais chances de destruir seus inimigos.\n"
            + "Você pode escolher entre muitos tipos de armaduras, cada uma com um nível e preço.";

    protected int protecao;

    /**
     * @param p
     * @see Interfaces.Itens#escolher()
     */
    @Override
    public void escolher(Personagem p) {
        boolean nsair;
        System.out.println("seu nivel é " + ((Heroi) p).getNivel());
        System.out.println("e possui " + ((Heroi) p).getDinheiro() + " R$");
        do {
            System.out.println("escolha o nivel de proteção:\n"
                    + "1<- 20 -- 300,00 R$\n"
                    + "2<- 40 -- 600,00 R$\n"
                    + "3<- 60 -- 900.00 R$\n"
                    + "4<- 80 -- 1200,00 R$\n"
                    + "5<- 100 -- 1500,00 R$: ");
            switch (in.nextInt()) {
                case 1:
                    if (((Heroi) p).getDinheiro() > 300) {
                        System.out.println("Você adquiriu uma armadura de nível 20% e gastou 300,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 300) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 300);
                        this.protecao = 20;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 2:
                    if (((Heroi) p).getDinheiro() > 600) {
                        System.out.println("Você adquiriu uma armadura de nível 40% e gastou 600,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 600) + " R$.");
                        p.setDinheiro(p.getDinheiro()- 600);
                        this.protecao = 40;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 3:
                    if (p.getDinheiro() > 900) {
                        System.out.println("Você adquiriu uma armadura de nível 60% e gastou 900,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 900) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 900);
                        this.protecao = 60;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 4:
                    if (p.getDinheiro() > 1200) {
                        System.out.println("Você adquiriu uma armadura de nível 80% e gastou 1200,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1200) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 1200);
                        this.protecao = 80;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 5:
                    if (p.getDinheiro() > 1500) {
                        System.out.println("Você adquiriu uma armadura de nível 100% e gastou 1500,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1500) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 1500);
                        this.protecao = 100;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 13:
                    if (p.getDinheiro() > 1500) {
                        System.out.println("Você adquiriu uma armadura de nível 200% e gastou 1000,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1000) + " R$.");
                        p.setDinheiro(p.getDinheiro()- 1000);
                        this.protecao = 200;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                default:
                    System.out.println("digite um valor válido!!!!");
                    nsair = true;
            }
        } while (nsair);
        System.out.println("Transação realisada com sucesso  ;-)");
    }

    /**
     * @param p @see Interfaces.Itens#usar()
     */
    @Override
    public void usar(Personagem p) {
        ((Heroi) p).setArmadura(this.protecao);
    }

}
