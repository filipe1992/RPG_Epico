package concretas.personagens;

import Interfaces.Armas;
import Interfaces.Personagem;
import abstratas.Heroi;
import concretas.armas.ArcoEFlecha;
import javax.swing.JOptionPane;

public class Arqueiro extends Heroi {

    private int acertos;

    private int erros;

    public boolean flechaComVeneno(Personagem vilao) {
        Armas usar;
        int index;
        System.out.println("usar flecha com veneno !!!");
        index = this.usarArma();
        if (index != 0){
            usar = armas.get(index);
            if (usar instanceof ArcoEFlecha){
                JOptionPane.showMessageDialog(frame,"Uso correto de arma" );                
            }
        }
            
    }

    public void FlechaComum() {

    }

    public Arqueiro() {

    }

    public Arqueiro(int acertos, int erros, int niveldebondade, int life) {

    }

    @Override
    public void subirdenivel() {
        if (((this.acertos * 100) / (this.acertos + this.erros) >= 60) && this.acertos > 10) {
            this.nivel += 1;
            System.out.println("seu nivel agora é: " + this.nivel);
            this.niveldebondade+=5;
            this.lifemaximo+=10;
            this.acertos=0;
            this.erros=0;
        }
    }

    @Override
    public void atacar(Personagem vilao){
        
    }

    @Override
    public void fugir() {

    }

}
