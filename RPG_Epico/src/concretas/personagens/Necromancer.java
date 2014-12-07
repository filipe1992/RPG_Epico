package concretas.personagens;

import Interfaces.Armas;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Vilao;
import concretas.armas.ArcoEFlecha;
import concretas.armas.Cajado;
import javax.swing.JOptionPane;

public class Necromancer extends Vilao {

    private int energia;
    private int maldicoescomefeito;
    private int maldicoessemefeito;

    public Necromancer(int energia, int maldicoescomefeito, int maldicoessemefeito, int niveldemaldade, float dinheiro) {
        super(niveldemaldade, dinheiro);
        this.energia = energia;
        this.maldicoescomefeito = maldicoescomefeito;
        this.maldicoessemefeito = maldicoessemefeito;
    }

    public Necromancer() {
        super();
        this.energia = 0;
        this.maldicoescomefeito = 0;
        this.maldicoessemefeito = 0;
    }

    public void maldicaofinal(Personagem heroi) {
        Armas usar = null;
        int index;
        boolean refaz;
        do {
            System.out.println("maldição final !!!");
            index = this.usarArma();
            if (index != 0) {
                refaz = false;
                usar = armas.get(index - 1);
                if (usar instanceof Cajado) {
                    JOptionPane.showMessageDialog(frame, "Uso correto de arma ;-) ");
                } else {
                    JOptionPane.showMessageDialog(frame, "Uso incorreto de armamento  :-( ");
                }
            } else {
                refaz = true;
            }
        } while (refaz);

        if (usar.causarDanos(this, heroi)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, heroi.toString());
            this.maldicoescomefeito += 1;
            this.subirdenivel();
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.maldicoessemefeito += 1;
        }
    }

    public void canificina(Personagem heroi) {
        Armas usar = null;
        System.out.println("Carnificina !!!");
        usar = armas.get(rand.nextInt(2));
        if (usar instanceof ArcoEFlecha) {
            JOptionPane.showMessageDialog(frame, "Uso correto de arma ;-) ");
        } else {
            JOptionPane.showMessageDialog(frame, "Uso incorreto de armamento  :-( ");
        }
        this.life -= 3;
        if (usar.causarDanos(this, heroi)) {
            JOptionPane.showMessageDialog(frame, "causou dano !!!!");
            JOptionPane.showMessageDialog(frame, heroi.toString());
            this.maldicoescomefeito += 1;
            heroi.setLife((byte) (heroi.getLife() - 5));
        } else {
            JOptionPane.showMessageDialog(frame, "a Arma falhou !!!!");
            this.maldicoessemefeito += 1;
        }

    }

    @Override
    public void subirdenivel() {
        if (((this.maldicoescomefeito * 100) / (this.maldicoescomefeito + this.maldicoessemefeito) >= 60) && this.maldicoessemefeito > 10) {
            this.energia += 1;
            JOptionPane.showMessageDialog(frame, "seu nivel de energia agora é: " + this.energia);
            this.niveldemaldade += 5;
            this.life += 10;
            this.maldicoescomefeito = 0;
            this.maldicoessemefeito = 0;
        }
    }

    @Override
    public void atacar(Personagem outro) {
        switch(rand.nextInt(2)){
            case 0:
                this.maldicaofinal(outro);
                break;
            case 1:
                this.canificina(outro);
                break;
        }
    }

    @Override
    public void fugir() {
        JOptionPane.showConfirmDialog(frame, "Vou salvar minha vida !!!!");
    }

    @Override
    public String toString() {
        return "Necromancer: " + "\n"
                + "energia = " + energia + "\n"
                + "maldicoes com efeito = " + maldicoescomefeito + "\n"
                + "maldicoes sem efeito = " + maldicoessemefeito + 
                super.toString();
    }
    
}
