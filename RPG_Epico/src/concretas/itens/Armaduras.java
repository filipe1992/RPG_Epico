package concretas.itens;

import Interfaces.Itens;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Heroi;
import javax.swing.JOptionPane;

public class Armaduras implements Itens {

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
        System.out.println("e possui " + p.getDinheiro() + " R$");
        String[] escolha = {"escolha o nivel de Armadura","20 -- 30,00 R$","40 -- 60,00 R$","60 -- 90.00 R$","80 -- 120,00 R$\n","100 -- 150,00 R$"};
            String esc = (String) JOptionPane.showInputDialog(frame, "Escolha uma armadura !!!!", "Heroi", JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
            if (esc == null)
                esc="0";
            switch (esc) {
                case "20 -- 30,00 R$":
                    if (((Heroi) p).getDinheiro() > 30) {
                        System.out.println("Você adquiriu uma armadura de nível 20% e gastou 300,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 300) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 30);
                        this.protecao = 20;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "40 -- 60,00 R$":
                    if (((Heroi) p).getDinheiro() > 60) {
                        System.out.println("Você adquiriu uma armadura de nível 40% e gastou 600,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 600) + " R$.");
                        p.setDinheiro(p.getDinheiro()- 60);
                        this.protecao = 40;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "60 -- 90.00 R$":
                    if (p.getDinheiro() > 90) {
                        System.out.println("Você adquiriu uma armadura de nível 60% e gastou 900,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 900) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 90);
                        this.protecao = 60;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "80 -- 120,00 R$":
                    if (p.getDinheiro() > 120) {
                        System.out.println("Você adquiriu uma armadura de nível 80% e gastou 1200,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1200) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 120);
                        this.protecao = 80;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "100 -- 150,00 R$":
                    if (p.getDinheiro() > 150) {
                        System.out.println("Você adquiriu uma armadura de nível 100% e gastou 1500,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1500) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 150);
                        this.protecao = 100;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "escolha o nivel de Armadura":
                    if (p.getDinheiro() > 150) {
                        System.out.println("Você adquiriu uma armadura de nível 200% e gastou 1000,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1000) + " R$.");
                        p.setDinheiro(p.getDinheiro()- 100);
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
        System.out.println("Tranzação realisada com sucesso  ;-)");
    }

    /**
     * @param p @see Interfaces.Itens#usar()
     */
    @Override
    public void usar(Personagem p) {
        ((Heroi) p).setArmadura(this.protecao);
    }

    @Override
    public String toString() {
        return "Esta Armadura possui: " + "\n"
                + "protecao=" + protecao;
    }
    
    

}
