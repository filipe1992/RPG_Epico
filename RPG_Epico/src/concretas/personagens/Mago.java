package concretas.personagens;

import Interfaces.Personagem;
import abstratas.Heroi;

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

    
    public void fabricarMaisPocoes() {

    }

    public void curar() {

    }

    public void golpeespelho() {

    }

    @Override
    public void fugir() {

    }

    @Override
    public void subirdenivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atacar(Personagem outro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
