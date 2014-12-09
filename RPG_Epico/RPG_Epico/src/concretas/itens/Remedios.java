package concretas.itens;

import Interfaces.Itens;
import Interfaces.Personagem;
import abstratas.Heroi;

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
        do {
            System.out.println("escolha o nivel do remédio :\n"
                    + "1<- 20 -- 300,00 R$\n"
                    + "2<- 40 -- 600,00 R$\n"
                    + "3<- 60 -- 900.00 R$\n"
                    + "4<- 80 -- 1200,00 R$\n"
                    + "5<- 100 -- 1500,00 R$: ");
            switch (in.nextInt()) {
                case 1:
                    if (p.getDinheiro() > 300) {
                        System.out.println("Você adquiriu um remédio de nível 20 e gastou 300,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 300) + " R$.");
                        p.setDinheiro(p.getDinheiro()- 300);
                        this.melhorarem = 20;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 2:
                    if (((Heroi) p).getDinheiro() > 600) {
                        System.out.println("Você adquiriu um remédio de nível 40 e gastou 600,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 600) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 600);
                        this.melhorarem = 40;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 3:
                    if (p.getDinheiro() > 900) {
                        System.out.println("Você adquiriu um remédio de nível 60 e gastou 900,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 900) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 900);
                        this.melhorarem = 60;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 4:
                    if (p.getDinheiro() > 1200) {
                        System.out.println("Você adquiriu um remédio de nível 80 e gastou 1200,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1200) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 1200);
                        this.melhorarem = 80;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 5:
                    if (((Heroi) p).getDinheiro() > 1500) {
                        System.out.println("Você adquiriu um remédio de nível 100 e gastou 1500,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1500) + " R$.");
                        p.setDinheiro(((Heroi) p).getNivel() - 1500);
                        this.melhorarem = 100;
                    } else {
                        System.out.println("Você não possui dinheiro suficiente para esta compra !!!!");
                    }
                    nsair = false;
                    break;
                case 13:
                    if (p.getDinheiro() > 1500) {
                        System.out.println("Você adquiriu um remédio de nível 200 e gastou 1000,00 R$ seu dinheiro atual é: " + (((Heroi) p).getNivel() - 1000) + " R$.");
                        p.setDinheiro(p.getDinheiro() - 1000);
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
        } while (nsair);
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
