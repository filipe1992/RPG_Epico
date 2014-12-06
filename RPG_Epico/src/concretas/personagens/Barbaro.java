package concretas.personagens;

import Interfaces.Armas;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Heroi;
import concretas.armas.Espada;
import concretas.armas.Machado;
import javax.swing.JOptionPane;

public class Barbaro extends Heroi {

    private int numerodeExito;

    private int numerodefalhas;

    public Barbaro(int numerodeExito, int numerodefalhas, int niveldebondade, byte life) {
        super(niveldebondade, life);
        this.numerodeExito = numerodeExito;
        this.numerodefalhas = numerodefalhas;
    }

    
    public Barbaro() {
        super();
        this.numerodeExito = 0;
        this.numerodefalhas = 0;
    }
    
    public void ComMachado(Personagem vilao) {
        Armas usar = null;
        int index;
        boolean refaz;
        do {
            System.out.println("Usar Machado !!!");
            index = this.usarArma();
            if (index != 0) {
                refaz = false;
                usar = armas.get(index - 1);
                if (usar instanceof Machado) {
                    JOptionPane.showMessageDialog(frame, "Uso correto de arma ;-) ");
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
            this.numerodeExito+=1;
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.numerodefalhas+=1;
        }
    }

    public void comEspada(Personagem vilao) {
        Armas usar = null;
        int index;
        boolean refaz;
        do {
            System.out.println("usar flecha comum !!!");
            index = this.usarArma();
            if (index != 0) {
                refaz = false;
                usar = armas.get(index - 1);
                if (usar instanceof Espada) {
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
            this.numerodeExito+= 1;
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.numerodefalhas += 1;

        }
    }

    @Override
    public void fugir() {
        JOptionPane.showConfirmDialog(frame, "Vou salvar minha vida !!!!");
    }

    @Override
    public void subirdenivel() {
        if (((this.numerodeExito * 100) / (this.numerodeExito + this.numerodefalhas) >= 60) && this.numerodeExito > 10) {
            this.nivel += 1;
            JOptionPane.showMessageDialog(frame, "seu nivel agora é: " + this.nivel);
            this.niveldebondade += 5;
            this.lifemaximo += 10;
            this.numerodeExito = 0;
            this.numerodefalhas = 0;
        }
    }

    @Override
    public void atacar(Personagem vilao) {
        boolean refaz;
        String[] ataques = {"Machado", "Espada"};
        do {
            String esc = (String) JOptionPane.showInputDialog(frame, "qual o tipo de ataque ??", "Ataques ", JOptionPane.QUESTION_MESSAGE, null, ataques, ataques[1]);
            if (esc != null) {
                switch (esc) {
                    case "flecha com veneno":
                        this.ComMachado(vilao);
                        break;
                    case "flecha comum":
                        this.comEspada(vilao);
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
        return "Barbaro: " + "\n"
                + "numerodeExito=" + numerodeExito + "\n"
                + "numerodefalhas=" + numerodefalhas + "\n"
                + super.toString();
    }    
}
