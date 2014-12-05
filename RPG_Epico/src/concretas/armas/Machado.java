package concretas.armas;

import Interfaces.Personagem;
import abstratas.ArmaCorpoACorpo;
import abstratas.*;

public class Machado extends ArmaCorpoACorpo {

    private int amolacao;

    public void afiar(Personagem p) {
        System.out.println("o preço deste up grade é: " + (2 * this.amolacao));
        if (p.getDinheiro() >= 2 * this.amolacao) {
            p.setDinheiro(p.getDinheiro() - 2 * this.amolacao);
            this.amolacao += 1;
            System.out.println(this);
        }

    }

    public void melhorar(float dinheir) {

    }

    public Machado() {

    }

    public Machado(int amolacao, int dano) {

    }

    @Override
    public void causarDanos(Personagem h, Personagem v) {
        if ((rand.nextInt(100) + 1) % (20 - this.amolacao) == 0) {
            if (this.dano >= ((Vilao) v).getLife()) {
                System.out.println("voce tera que enferntar muitos outros inimigos ");
                v.setLife((byte) 0);
            }
        }
        ((Vilao) v).setLife(((Vilao) v).getLife());
    }
}
