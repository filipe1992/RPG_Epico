package concretas;

import Interfaces.Locais;

public class Desertos implements Locais {

    private static final String descricao = "Um lugar terrível os inimigos deste local são muito mais ferozes que outros lugares.\n" +
"Aqui não há tréguas não há desistências não há nada que possa lhe salvar a não ser você mesmo. \n" +
"Placa de entrada: <<A ESPERANÇA DEIXOU ESTE LUGAR>>";

    /**
     * @see Interfaces.Locais#mudarDeLocal()
     */
    @Override
    public void chegando() {
        System.out.println("voce esta chegando ao deserto!!\n"
                + "tome cuidado com inimigos!!!!");
    }

    @Override
    public void saindo() {
        System.out.println("voce sobrevivel ao deserto !!!\n"
                + "não são todos que saem com vida daqui. ");
    }

    @Override
    public String toString() {
        return descricao;
    }
}
