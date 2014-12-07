package concretas.armas;

import Interfaces.Personagem;
import abstratas.ArmaADistancia;
import concretas.personagens.Arqueiro;
import concretas.personagens.Gnomo;
import concretas.personagens.Mago;
import concretas.personagens.Necromancer;

public class Cajado extends ArmaADistancia {

    private int joiasdoInfinito;

    public Cajado() {
        super();
        this.setJoiasdoInfinito(0);
    }

    public Cajado(int dano, byte chancesdeerro, int joiasdoinfinito) {
        super(dano, chancesdeerro);
        this.setJoiasdoInfinito(joiasdoInfinito);
    }

    public int getJoiasdoInfinito() {
        return joiasdoInfinito;
    }

    public final void setJoiasdoInfinito(int joiasdoInfinito) {
        if (joiasdoInfinito < 0) {
            joiasdoInfinito = 0;
        }
        this.joiasdoInfinito = joiasdoInfinito;
    }

    @Override
    public void subirDeNivel(Personagem p) {
        System.out.println("Para subir de nivel voce precisa de: " + (4 ^ joiasdoInfinito));
        System.out.println("voce possui: " + p.getDinheiro() + " R$.");
        if (p.getDinheiro() >= (4 ^ joiasdoInfinito)) {
            p.setDinheiro(p.getDinheiro() - (4 ^ joiasdoInfinito));
            this.chancesdeerro -= 1;
            this.dano += 2;
            this.joiasdoInfinito += 1;
            System.out.println(this);
        } else {
            System.out.println("voce não pode comprar este upgrade ");
        }
    }
    
    @Override
    public boolean causarDanos(Personagem h, Personagem v) {
        byte dano1;
        int erro;
        if (h instanceof Mago || h instanceof Necromancer) {
            erro = this.chancesdeerro;
            dano1 = (byte) (this.dano * joiasdoInfinito);
        } else {
            erro = this.chancesdeerro * 2;
            dano1 = (byte) this.dano;
        }
        if (rand.nextInt(100) % erro == 0) {
            if (dano1 > v.getLife()) {
                System.out.println(/* nome da class + */": a vitoria é minha ");
                v.setLife((byte) 0);
            } else {
                if (v instanceof Gnomo || v instanceof Arqueiro) {
                    v.setLife((byte) (v.getLife() - dano1 + (this.joiasdoInfinito / 3)));
                } else {
                    v.setLife((byte) (v.getLife() - dano1));
                }
            }
            h.setDinheiro(h.getDinheiro() + v.getDinheiro() );
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "voce possui: " + joiasdoInfinito + " joiasdoInfinito ";
    }

}
