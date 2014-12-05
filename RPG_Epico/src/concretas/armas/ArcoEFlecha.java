package concretas.armas;

import Interfaces.Personagem;
import abstratas.ArmaADistancia;
import concretas.personagens.Arqueiro;
import concretas.personagens.Barbaro;
import concretas.personagens.Gnomo;
import concretas.personagens.Ogro;

public class ArcoEFlecha extends ArmaADistancia {

    private int nivel;

    @Override
    public void subirDeNivel(Personagem p) {
        //String[] strings = {"para subir de nivel voce nescecita de: " + (2 ^ (this.nivel + 1) - 1) + " R$.","voce possui: " + p.getDinheiro() + " R$."};
        System.out.println("para subir de nivel voce nescecita de: " + (2 ^ (this.nivel + 1) - 1) + " R$.");
        System.out.println("voce possui: " + p.getDinheiro() + " R$.");
        
        if (p.getDinheiro() >= (2 ^ (this.nivel + 1) - 1)) {
            p.setDinheiro(p.getDinheiro() - (2 ^ (this.nivel + 1) - 1));
            this.nivel += 1;
            this.chancesdeerro -= 1;
            this.dano += 2;
            System.out.println(this);
        } else {
            System.out.println("voce não pode comprar este upgrade ");
        }
    }

    public ArcoEFlecha(int nivel, int dano, byte chacesdeerro) {
        super(dano, chacesdeerro);
        setNivel(nivel);

    }

    public final void setNivel(int nivel) {
        if (nivel < 1) {
            nivel = 1;
        }
        this.nivel = nivel;
    }

    public ArcoEFlecha() {
        super();
        setNivel(1);
    }

    /**
     * @see Interfaces.Armas#causarDanos()
     */
    @Override
    public void causarDanos(Personagem h, Personagem v) {//h ataca v;
        int erro;
        if (h instanceof Arqueiro || h instanceof Gnomo) {
            erro = this.chancesdeerro;
        } else {
            erro = this.chancesdeerro * 2;
        }
        if ((rand.nextInt(100) + 1) % erro == 0) {
            if (this.dano > v.getLife()) {
                System.out.println("voce venceu esta mas, não me derrotou!!! my name is << Sepol >>");
                v.setLife((byte) 0);
            } else {
                if (v instanceof Ogro || v instanceof Barbaro) {
                    v.setLife((byte) (v.getLife() - this.dano + (this.nivel / 2)));
                } else {
                    v.setLife((byte) (v.getLife() - this.dano));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "seu nivel atual é:" + nivel + "\n" + super.toString();
    }

}
