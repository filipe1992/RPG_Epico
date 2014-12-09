package Principal;

import static Interfaces.Armas.rand;
import Interfaces.Personagem;
import static Interfaces.Personagem.frame;
import abstratas.Vilao;
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

        }
    }

    public static void batalha(Personagem jogador, Personagem adversario) {
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
