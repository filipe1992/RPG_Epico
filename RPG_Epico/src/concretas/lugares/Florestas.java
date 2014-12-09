package concretas.lugares;

import Interfaces.Locais;

public class Florestas implements Locais {

    private static final String descricao = "Um lugar obscuro onde inimigos o espreitam a espera de uma chance de lhe atacar, contudo aqui você terá mais chances, pois os inimigos são mais fracos.\n"
            + " Não possuem muito dinheiro ou itens.";

    /**
     * @see Interfaces.Locais#mudarDeLocal()
     */
    @Override
    public void chegando() {
        System.out.println("Seja bem vindo e fique atento nem tudo que parece, é...\n"
                + "Entre as arvores e a escuridão, onde a luz do sol não pode chegar, há sempre alguém ou algo lhe observando. \n"
                + "As plantas e os espíritos da floresta não irão ajudar-lhe.");
    }

    @Override
    public void saindo() {
        System.out.println("Parece que o horror da floresta não fez bem pra você.\n"
                + "Fuja para o colo da sua mãe, humano medíocre.\n"
                + "A floresta não é lugar para fracassados.  ");
    }
    
    @Override
    public String toString() {
        return descricao;
    }

   @Override
    public int compareTo(Object o) {
        if (o instanceof Locais)
            if (descricao.compareTo(o.toString())== -1){
                return -1;
            }else{
                if (descricao.compareTo(o.toString())== 1)
                    return 1;
                else
                    return 0;
            }
        return 1;
    }

}
