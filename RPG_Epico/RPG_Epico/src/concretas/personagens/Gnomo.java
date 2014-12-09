package concretas.personagens;

import Interfaces.Armas;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Vilao;
import concretas.armas.ArcoEFlecha;
import javax.swing.JOptionPane;

public class Gnomo extends Vilao {

    private int poderTerreno;
    private byte acertos;
    private byte erros;

    public Gnomo(int poderTerreno, byte acertos, byte erros, int niveldemaldade, float dinheiro) {
        super(niveldemaldade, dinheiro);
        this.poderTerreno = poderTerreno;
        this.acertos = acertos;
        this.erros = erros;
    }

    public Gnomo() {
        super();
        this.poderTerreno = 0;
        this.acertos = 0;
        this.erros = 0;
    }

    public void flechacomum(Personagem heroi) {
        Armas usar = new ArcoEFlecha();

        System.out.println("usar flecha comum !!!");
        usar = armas.get(rand.nextInt(armas.size()));
        if (usar instanceof ArcoEFlecha) {
            JOptionPane.showMessageDialog(frame, "seu inimigo escolheu corretamente a arma :-( ");
        } else {
            JOptionPane.showMessageDialog(frame, "seu inimigo escolheu incorretamnte o armamento  ;-) ");
        }
        if (usar.causarDanos(this, heroi)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, heroi.toString());
            this.acertos += 1;
            heroi.setLife((byte) (heroi.getLife() - 5));
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.erros += 1;
        }
    }

    public void flechaComFogo(Personagem heroi) {
        Armas usar = new ArcoEFlecha();
        int index;
        boolean refaz;
        do {
            System.out.println("usar flecha com veneno !!!");
            index = rand.nextInt(armas.size());
            if (index != 0) {
                refaz = false;
                usar = armas.get(index - 1);
                if (usar instanceof ArcoEFlecha) {
                    JOptionPane.showMessageDialog(frame, "Uso correto de arma ;-) ");
                } else {
                    JOptionPane.showMessageDialog(frame, "Uso incorreto de armamento  :-( ");
                }
            } else {
                refaz = true;
            }
        } while (refaz);
        this.life -= 3;
        JOptionPane.showMessageDialog(frame, " Droga me queimei @#%*&!$sepol !!!!  :-( ");
        if (usar.causarDanos(this, heroi)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, heroi.toString());
            this.acertos += 1;
            heroi.setLife((byte) (heroi.getLife() - 5));
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.erros += 1;
        }
    }

    @Override
    public void subirdenivel() {
        if (((this.acertos * 100) / (this.acertos + this.erros) >= 60) && this.acertos > 10) {
            this.poderTerreno += 1;
            JOptionPane.showMessageDialog(frame, "seu poder da terra agora é: " + this.poderTerreno);
            this.niveldemaldade += 5;
            this.life += 10;
            this.acertos = 0;
            this.erros = 0;
        }
    }

    @Override
    public void atacar(Personagem outro) {
        switch (rand.nextInt(2)) {
            case 1:
                this.flechacomum(outro);
                break;
            case 0:
                this.flechaComFogo(outro);
        }
    }

    @Override
    public void fugir() {
        JOptionPane.showConfirmDialog(frame, "Vou salvar minha vida !!!!");
    }

    @Override
    public String toString() {
        return "Gnomo:" + "\n"
                + "poder Terreno=" + poderTerreno + "\n"
                + "acertos=" + acertos + "\n"
                + "erros=" + erros + super.toString();
    }

}
