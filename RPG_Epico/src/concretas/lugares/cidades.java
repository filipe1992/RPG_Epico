package concretas.lugares;

import Interfaces.Locais;

public class cidades implements Locais {

    private static final String descricao = "Um belo lugar para descansar entre as batalhas incessantes.\n"
            + "Aqui não há lutas é um lugar para reabastecer suas energias e preparar-se para uma nova jornada em busca de fama dinheiro e poder.";

    /**
     * @see Interfaces.Locais#mudarDeLocal()
     */
    @Override
    public void chegando() {
        System.out.println("seja bem vindo a grande cidade.\n"
                + "Onde os maiores perigos são os moradores de rua e as crianças !!!");
    }

    @Override
    public void saindo() {
        System.out.println("não podera comprar nada, ate voltar aqui.\n"
                + "boa sorte em sua jornada.");
    }

    @Override
    public String toString() {
        return descricao;
    }

}
