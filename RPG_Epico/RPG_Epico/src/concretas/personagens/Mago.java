package concretas.personagens;

import Interfaces.Armas;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Heroi;
import concretas.armas.Cajado;
import javax.swing.JOptionPane;

public class Mago extends Heroi {

    private int fenticoscomefeito;
    private int fenticossemefeito;

    public Mago(int fenticoscomefeito, int fenticossemefeito, int niveldebondade, byte life) {
        super(niveldebondade, life);
        this.fenticoscomefeito = fenticoscomefeito;
        this.fenticossemefeito = fenticossemefeito;
    }

    public Mago() {
        super();
        this.fenticoscomefeito = 0;
        this.fenticossemefeito = 0;
    }

    public void setFenticoscomefeito(int fenticoscomefeito) {
        if (fenticoscomefeito < 0) {
            fenticoscomefeito = 0;
        }
        if (fenticoscomefeito > 100) {
            fenticoscomefeito = 100;
        }
        this.fenticoscomefeito = fenticoscomefeito;
    }

    public void setFenticossemefeito(int fenticossemefeito) {
        if (fenticossemefeito < 0) {
            fenticossemefeito = 0;
        }
        if (fenticossemefeito > 100) {
            fenticossemefeito = 100;
        }
        this.fenticossemefeito = fenticossemefeito;
    }

    public int getFenticossemefeito() {
        return fenticossemefeito;
    }

    public int getFenticoscomefeito() {
        return fenticoscomefeito;
    }

    public void sugralife(Personagem vilao) {
        Armas usar = null;
        int index;
        boolean refaz;
        do {
            System.out.println("sugar life !!!");
            index = this.usarArma();
            if (index != 0) {
                refaz = false;
                usar = armas.get(index - 1);
                if (usar instanceof Cajado) {
                    JOptionPane.showMessageDialog(frame, "Uso correto de arma ;-) ");
                    this.setLife((byte) (((Cajado) usar).getDano()/2));
                } else {
                    JOptionPane.showMessageDialog(frame, "Uso incorreto de armamento  :-( ");
                }
            } else {
                refaz = true;
            }
        } while (refaz);
        
        if (usar.causarDanos(this, vilao)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, vilao.toString());
            this.fenticoscomefeito+=1;
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.fenticossemefeito+=1;
        }
    }

    public void golpeespelho(Personagem vilao) {
        vilao.atacar(vilao);
        this.setLife((byte) (this.getLife() - 5));
        this.subirdenivel();
    }

    @Override
    public void fugir() {
        JOptionPane.showConfirmDialog(frame, "Vou salvar minha vida !!!!");
    }

    @Override
    public void subirdenivel() {
        if (((this.fenticoscomefeito * 100) / (this.fenticoscomefeito + this.fenticossemefeito) >= 60) && this.fenticoscomefeito > 10) {
            this.nivel += 1;
            JOptionPane.showMessageDialog(frame, "seu nivel agora é: " + this.nivel);
            this.niveldebondade += 5;
            this.lifemaximo += 10;
            this.fenticoscomefeito = 0;
            this.fenticossemefeito = 0;
        }
    }

    @Override
    public void atacar(Personagem vilao) {
        boolean refaz;
        String[] ataques = {"sugar life", "Ataque espelho"};
        do {
            String esc = (String) JOptionPane.showInputDialog(frame, "qual o tipo de ataque ??", "Ataques ", JOptionPane.QUESTION_MESSAGE, null, ataques, ataques[1]);
            if (esc != null) {
                switch (esc) {
                    case "sugar life":
                        this.golpeespelho(vilao);
                        break;
                    case "Ataque espelho":
                        this.golpeespelho(vilao);
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
    public String toString() {
        return "Mago: \n"
                + "fenticos com efeito=" + fenticoscomefeito + "\n"
                + " fenticos sem efeito=" + fenticossemefeito + "\n"+
                super.toString();
    }

}
