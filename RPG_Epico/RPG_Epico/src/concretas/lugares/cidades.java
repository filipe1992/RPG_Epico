package concretas.lugares;

import Interfaces.Locais;

public class cidades implements Locais {

    private static final String descricao = "Um belo lugar para descansar entre as batalhas incessantes.\n"
            + "Aqui não há lutas é um lugar para reabastecer suas energias e preparar-se para uma nova jornada em busca de fama dinheiro e poder.";

    /**
     * @return 
     * @see Interfaces.Locais#mudarDeLocal()
     */
    @Override
    public String chegando() {
        return "seja bem vindo a grande cidade.\n"
                + "Onde os maiores perigos são os moradores de rua e as crianças !!!";
    }

    @Override
    public String saindo() {
        return "não podera comprar nada, ate voltar aqui.\n"
                + "boa sorte em sua jornada.";
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