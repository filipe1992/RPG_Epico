package concretas.itens;

import Interfaces.Itens;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Heroi;
import javax.swing.JOptionPane;

public class Remedios implements Itens {

    protected int melhorarem;

    protected static String descricao;

    /**
     * @param p
     * @see Interfaces.Itens#escolher()
     */
    @Override
    public void escolher(Personagem p) {
        boolean nsair;
        System.out.println("seu nivel é " + ((Heroi) p).getNivel());
        System.out.println("e possui " + ((Heroi) p).getDinheiro() + " R$");
            String[] escolha = {"escolha o nivel do remédio","20 -- 30,00 R$","40 -- 60,00 R$","60 -- 90.00 R$","80 -- 120,00 R$","100 -- 150,00 R$"};
            String esc = (String) JOptionPane.showInputDialog(frame, "Escolha !!!!", "Heroi", JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
            switch (esc) {
                case "20 -- 30,00 R$":
                    if (p.getDinheiro() > 30) {
                        System.out.println("Você adquiriu um remédio de nível 20 e gastou 300,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 300) + " R$.");
                        p.setDinheiro(p.getDinheiro()- 30);
                        this.melhorarem = 20;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "40 -- 60,00 R$":
                    if (((Heroi) p).getDinheiro() > 60) {
                        System.out.println("Você adquiriu um remédio de nível 40 e gastou 600,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 600) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 60);
                        this.melhorarem = 40;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "60 -- 90.00 R$":
                    if (p.getDinheiro() > 90) {
                        System.out.println("Você adquiriu um remédio de nível 60 e gastou 900,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 900) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 90);
                        this.melhorarem = 60;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "80 -- 120,00 R$":
                    if (p.getDinheiro() > 120) {
                        System.out.println("Você adquiriu um remédio de nível 80 e gastou 1200,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1200) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 120);
                        this.melhorarem = 80;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "100 -- 150,00 R$":
                    if (((Heroi) p).getDinheiro() > 150) {
                        System.out.println("Você adquiriu um remédio de nível 100 e gastou 1500,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1500) + " R$.");
                        p.setDinheiro(((Heroi) p).getNivel() - 150);
                        this.melhorarem = 100;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case "escolha o nivel do remédio":
                    if (p.getDinheiro() > 150) {
                        System.out.println("Você adquiriu um remédio de nível 200 e gastou 1000,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1000) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 100);
                        this.melhorarem = 200;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                default:
                    System.out.println("digite um valor válido!!!!");
                    nsair = true;
            }
        System.out.println("Transação realisada com sucesso  ;-)");
    }

    /**
     * @param p
     * @see Interfaces.Itens#usar()
     */
    @Override
    public void usar(Personagem p) {
        ((Heroi) p).setLife((byte) (((this.melhorarem / 100)*((Heroi) p).getLifemaximo()) + ((Heroi) p).getLife()));
    }

    @Override
    public String toString() {
        return "Este Remedio pode: " + "\n"
                + "melhorar su life em=" + melhorarem;
    }
    
    

}
