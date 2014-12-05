package concretas.armas;

import Interfaces.Personagem;
import abstratas.ArmaADistancia;
import abstratas.Heroi;
import abstratas.Vilao;
import concretas.personagens.Ogro;

public class ArcoEFlecha extends ArmaADistancia {

    private int nivel;

    public void subirDenivel(Personagem p) {
        System.out.println("para subir de nivel voce nescecita de: " + (2 ^ (this.nivel + 1) - 1) + " R$.");
        System.out.println("voce possui: " + ((Heroi) p).getDinheiro() + " R$.");
        if (((Heroi) p).getDinheiro() >= (2 ^ (this.nivel + 1) - 1)) {
            this.nivel += 1;
            this.chancesdeerro -= 1;
            this.dano += 2;
            System.out.println(this);
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
    public void causarDanos(Personagem h, Personagem v) {
        if ((rand.nextInt(100) + 1) % this.chancesdeerro == 0) {
            if (this.dano > ((Vilao) v).getLife()) {
                System.out.println("voce venceu esta mas, não me derrotou!!!");
                ((Vilao) v).setLife(0);
            } else {
                if (v instanceof Ogro) {
                    ((Vilao) v).setLife(((Vilao) v).getLife() - this.dano);
                } else {
                    ((Vilao) v).setLife(((Vilao) v).getLife() - (this.dano - this.nivel));
                }
            }
        }
    }

    @Override
    public String toString() {
        return "seu nivel atual é:" + nivel + "\n" + super.toString();
    }

}
