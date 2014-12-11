package concretas.armas;

import Interfaces.Personagem;
import abstratas.ArmaCorpoACorpo;
import abstratas.*;

public class Machado extends ArmaCorpoACorpo {

    private int amolacao;

    @Override
    public void subirDeNivel(Personagem p) {
        System.out.println("o preço deste upgrade é: " + (2 * this.amolacao));
        if (p.getDinheiro() >= 2 * this.amolacao) {
            p.setDinheiro(p.getDinheiro() - 2 * this.amolacao);
            this.amolacao += 1;
            System.out.println(this);
        }else
            System.out.println("voce não possui dinheiro para isso!!!!");

    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public Machado() {
        super();
        this.amolacao = 1;
    }

    public Machado(int amolacao, int dano) {
        super(dano);
        this.setAmolacao(amolacao);
    }

    public int getAmolacao() {
        return amolacao;
    }

    public final void setAmolacao(int amolacao) {
        this.amolacao = amolacao;
    }

    @Override
    public boolean causarDanos(Personagem h, Personagem v) {
        if ((rand.nextInt(10) + 1) % (20 - this.amolacao) == 0) {
            if (this.dano >= ((Vilao) v).getLife()) {
                System.out.println("voce tera que enferntar muitos outros inimigos ");
                v.setLife((byte) 0);
            }else{
                v.setLife((byte) (v.getLife()-this.dano));
            }
            h.setDinheiro(h.getDinheiro() + v.getDinheiro() );
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nMachado\n" + "\n"
                + "amolacao=" + amolacao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Machado other = (Machado) obj;
        if (this.amolacao != other.amolacao) {
            return false;
        }
        return true;
    }

}
