package concretas.personagens;

import Interfaces.Armas;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Vilao;
import concretas.armas.Espada;
import concretas.armas.Machado;
import javax.swing.JOptionPane;

public class Ogro extends Vilao {

    private int poderdastrevas;
    private int exitos;
    private int falhas;

    public void baterComMachado(Personagem heroi) {
        Armas usar = null;
        System.out.println("Usar Machado !!!");
        usar = armas.get(rand.nextInt(armas.size()));
        if (usar instanceof Machado) {
            JOptionPane.showMessageDialog(frame, "Uso correto de arma ;-) ");
        } else {
            JOptionPane.showMessageDialog(frame, "Uso incorreto de armamento  :-( ");
        }
        if (usar.causarDanos(this, heroi)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, heroi.toString());
            this.exitos += 1;
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.falhas += 1;
        }
    }

    public void baterComEspada(Personagem heroi) {
        Armas usar = null;
        System.out.println("usar Espada !!!");
        usar = armas.get(rand.nextInt(armas.size()));
        if (usar instanceof Espada) {
            JOptionPane.showMessageDialog(frame, "Uso correto de arma  ;-) ");
        } else {
            JOptionPane.showMessageDialog(frame, "Uso incorreto de armamento  :-( ");
        }
        if (usar.causarDanos(this, heroi)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, heroi.toString());
            this.exitos += 1;
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.falhas += 1;
        }
    }

    public Ogro() {

    }

    public Ogro(int Poderdastrevas, int niveldemaldade, float dinheiro) {

    }

    @Override
    public void subirdenivel() {
       if (((this.exitos * 100) / (this.exitos + this.falhas) >= 60) && this.exitos > 10) {
            this.poderdastrevas += 1;
            JOptionPane.showMessageDialog(frame, "seu poder das trevas  agora é: " + this.poderdastrevas);
            this.niveldemaldade += 5;
            this.life += 10;
            this.exitos = 0;
            this.falhas = 0;
        }
    }

    @Override
    public void atacar(Personagem outro) {
        switch(rand.nextInt(2)){
            case 0:
                this.baterComEspada(outro);
                break;
            case 1:
                this.baterComMachado(outro);
        }
    }

    @Override
    public void fugir() {
     JOptionPane.showConfirmDialog(frame, "Vou salvar minha vida !!!!");
    }

    public Ogro(int niveldemaldade, float dinheiro) {
        super(niveldemaldade, dinheiro);
    }

    @Override
    public String toString() {
        return "Ogro: " + "\n"
                + "poder das trevas=" + poderdastrevas + "\n"
                + "exitos=" + exitos + "\n"
                + "falhas=" + falhas + super.toString();
    }
    
    

}
