package concretas.armas;

import Interfaces.Personagem;
import abstratas.ArmaCorpoACorpo;
import abstratas.Heroi;
import abstratas.Vilao;

public class Espada extends ArmaCorpoACorpo {

    private int tamanho;

    public void almentarEspada() {

    }

    public void almentar(Personagem p){
        if (p.getDinheiro() >= 2*this.tamanho){
            p.setDinheiro((float) p.getDinheiro()-2*this.tamanho);
            this.tamanho+=1;
        }else
            System.out.println("voce não possui dinheiro suficiente para essa compra");
    }

    public Espada() {
        super();
        this.setTamanho(4);

    }

    public Espada(int tamanho, int dano) {
        super(dano);
        this.setTamanho(tamanho);
    }

    public int getTamanho() {
        return tamanho;
    }

    public final void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

     @Override
    public void causarDanos(Personagem h, Personagem v) {
        if ((rand.nextInt(100) + 1) % (20 - this.tamanho) == 0) {
            if (this.dano >= v.getLife()) {
                System.out.println("voce tera que enferntar muitos outros inimigos ");
                v.setLife(((byte)0));
            }else{
                v.setLife((byte) (v.getLife() - this.dano));
            }
        }
        ((Vilao) v).setLife(((Vilao) v).getLife());
    }
}