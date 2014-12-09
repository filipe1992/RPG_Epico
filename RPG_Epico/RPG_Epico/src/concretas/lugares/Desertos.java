package concretas.lugares;

import Interfaces.Locais;

public class Desertos implements Locais {

    private static final String descricao = "Um lugar terrível os inimigos deste local são muito mais ferozes que outros lugares.\n" +
"Aqui não há tréguas não há desistências não há nada que possa lhe salvar a não ser você mesmo. \n" +
"Placa de entrada: <<A ESPERANÇA DEIXOU ESTE LUGAR>>";

    /**
     * @return 
     * @see Interfaces.Locais#mudarDeLocal()
     */
    @Override
    public String chegando() {
        return "voce esta chegando ao deserto!!\n"
                + "tome cuidado com inimigos!!!!";
    }

    @Override
    public String saindo() {
        return "voce sobrevivel ao deserto !!!\n"
                + "não são todos que saem com vida daqui. ";
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
