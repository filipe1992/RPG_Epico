package concretas.personagens;

import Interfaces.Armas;
import Interfaces.Personagem;
import abstratas.Heroi;
import concretas.armas.ArcoEFlecha;
import javax.swing.JOptionPane;

public class Arqueiro extends Heroi {

    private int acertos;

    private int erros;

    public Arqueiro(int acertos, int erros, int niveldebondade, byte life) {
        super(niveldebondade, life);
        this.acertos = acertos;
        this.erros = erros;
    }

    public Arqueiro() {
        super();
        this.acertos = 0;
        this.erros = 0;

    }

    public void flechaComVeneno(Personagem vilao) {
        Armas usar = null;
        int index;
        boolean refaz;
        do {
            System.out.println("usar flecha com veneno !!!");
            index = this.usarArma();
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
        if (usar.causarDanos(this, vilao)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, vilao.toString());
            this.acertos+=1;
            vilao.setLife((byte) (vilao.getLife() - 5));
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.erros+=1;
        }

    }

    public void FlechaComum(Personagem vilao) {
        Armas usar = null;
        int index;
        boolean refaz;
        do {
            System.out.println("usar flecha comum !!!");
            index = this.usarArma();
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
        } while (refaz && usar != null);

        if (usar.causarDanos(this, vilao)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, vilao.toString());
            this.acertos += 1;
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.erros += 1;
        }
    }

    @Override
    public void subirdenivel() {
        if (((this.acertos * 100) / (this.acertos + this.erros) >= 60) && this.acertos > 10) {
            this.nivel += 1;
            JOptionPane.showMessageDialog(frame, "seu nivel agora é: " + this.nivel);
            this.niveldebondade += 5;
            this.lifemaximo += 10;
            this.acertos = 0;
            this.erros = 0;
        }
    }

    @Override
    public void atacar(Personagem vilao) {
        boolean refaz;
        String[] ataques = {"flecha com veneno", "flecha comum"};
        do {
            String esc = (String) JOptionPane.showInputDialog(frame, "qual o tipo de ataque ??", "Ataques ", JOptionPane.QUESTION_MESSAGE, null, ataques, ataques[1]);
            if (esc != null) {
                switch (esc) {
                    case "flecha com veneno":
                        this.flechaComVeneno(vilao);
                        break;
                    case "flecha comum":
                        this.FlechaComum(vilao);
                        break;
                }
                refaz = false;
            } else {
                if (JOptionPane.showConfirmDialog(frame, "tem certesa disso ????\nDeseja abandonar o ataque ??!!") == 0) {
                    refaz = false;
                    JOptionPane.showMessageDialog(frame, "voce não quis atacar\n(pena!!. Seu inimigo ira atacar )");
                } else {
                    refaz = true;
                }
            }
        } while (refaz);

    }

    @Override
    public void fugir() {
        JOptionPane.showConfirmDialog(frame, "Vou salvar minha vida !!!!");
    }

    @Override
    public String toString() {
        return "Arqueiro: " + "\nAcertos=" + acertos + "\nErros=" + erros + "\n"+super.toString();
    }

    
}