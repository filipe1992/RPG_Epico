package Principal;

import static Interfaces.Armas.rand;
import Interfaces.Locais;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Heroi;
import concretas.lugares.Desertos;
import concretas.lugares.Florestas;
import concretas.lugares.cidades;
import concretas.personagens.Arqueiro;
import concretas.personagens.Barbaro;
import concretas.personagens.Gnomo;
import concretas.personagens.Mago;
import concretas.personagens.Necromancer;
import concretas.personagens.Ogro;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {

    public static Personagem jogador;

    public static Personagem adversario;

    public static int numerodebatalhas;

    public static void main(String[] args) {
        Locais lugar = new cidades();
        String[] herois = {"Arqueiro", "Barbaro", "Mago"};
        String escolha = (String) JOptionPane.showInputDialog(frame, "Escolha um heroi !!!!", "Heroi", JOptionPane.QUESTION_MESSAGE, null, herois, herois[0]);
        if (escolha == null) {
            escolha = "0";
        }
        switch (escolha) {
            case "Arqueiro":
                jogador = new Arqueiro();
                JOptionPane.showMessageDialog(frame, "Voce escolheu Arqueiro !!!! (sepol)");
                break;
            case "Barbaro":
                jogador = new Barbaro();
                JOptionPane.showMessageDialog(frame, "Voce escolheu Barbaro !!!! (sepol)");
                break;
            case "Mago":
                jogador = new Mago();
                JOptionPane.showMessageDialog(frame, "Voce escolheu Mago !!!! (sepol)");
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Escolha um heroi válido !!!! (sepol)");
        }
        
        menu(lugar);

    }

    static void menu(Locais lugar){
        String[] escolha = {"ir para outro lugar","buscar batalha","comprar coisas","usar item"};
        String esc = (String) JOptionPane.showInputDialog(frame, "o que deseja fazer ??", "Menu", JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
        if (esc == null)
            esc = "0";
        switch(esc){
            case "ir para outro lugar":
                JOptionPane.showMessageDialog(frame, lugar.saindo());
                String[] nescolha = {"Cidade","Deserto","floresta"};
                esc = (String) JOptionPane.showInputDialog(frame, "Onde voce quer ir ???", "Menu", JOptionPane.QUESTION_MESSAGE, null, nescolha, nescolha[0]);
                if (esc == null)
                    esc = "0";
                switch(esc){
                    case "Cidade":
                        lugar = new cidades();
                        break;
                    case "Deserto":
                        lugar = new Desertos();
                        break;
                    case "floresta":
                        lugar = new Florestas();
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame," vai ficar no mesmo lugar (sepol)");
                }
                JOptionPane.showMessageDialog(frame, lugar.chegando());
                JOptionPane.showMessageDialog(frame, lugar.toString());
                break;
            case "buscar batalha":
                escolha();
                batalha(jogador);
                break;
            case "comprar coisas":
                ((Heroi) jogador).comprarItens();
                break;
            case "usar item":
                ((Heroi) jogador).usarItem();
                break;
            default:
                JOptionPane.showMessageDialog(frame,"nao escolheu uma opçao valida");
        }
    }
    
    
    public static void escolha() {
        switch (rand.nextInt(3)) {
            case 0:
                Principal.adversario = new Gnomo();
                break;
            case 1:
                Principal.adversario = new Ogro();
                break;
            case 2:
                Principal.adversario = new Necromancer();
                break;
        }
    }

    public static void batalha(Personagem jogador) {
        JFrame frame = new JFrame();
        Principal.numerodebatalhas++;
        int i = JOptionPane.showConfirmDialog(frame, "deseja realmente entrar nessa batalha ????");
        while (jogador.getLife() > 0 && adversario.getLife() > 0 && i == 0) {

            jogador.atacar(adversario);
            JOptionPane.showMessageDialog(frame, "Adversario\n" + adversario.toString() + "\n" + jogador.toString());
            adversario.atacar(jogador);
            JOptionPane.showMessageDialog(frame, "Adversario\n" + adversario.toString() + "\n" + jogador.toString());
            if (JOptionPane.showConfirmDialog(frame, "deseja continuar nessa batalha ????") == 0) {
                i = 1;
            }
        }

    }

}
