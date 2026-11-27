package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {

    private JButton exportarImagemButton;
    private JButton exportarTerrenoButton;
    private JButton gerarTerrenoButton;
    private JComboBox<String> seletorAlgoritmo;
    private JComboBox<String> seletorPaleta;
    private JLabel textoAlgoritmo;
    private JLabel textoAltMaxima;
    private JLabel textoAltMinima;
    private JLabel textoAltura;
    private JLabel textoPaleta;
    private JLabel textoTamLargura;
    private JLabel textoTamanho;
    private JLabel textoTamAltura;
    private JTextField campoAltMaxima;
    private JTextField campoAltMinima;
    private JTextField campoTamAltura;
    private JTextField campoTamLargura;
    private JPanel mainPanel;

    public Interface() {
        setContentPane(mainPanel);
        setTitle("Gerador de terreno");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        System.out.println("Construtor executado!");
        System.out.println(seletorAlgoritmo);
        seletorAlgoritmo.addItem("Value Noise");
        seletorAlgoritmo.addItem("Diamond-Square");
        System.out.println("Quantidade de opções: " + seletorAlgoritmo.getItemCount());
        gerarTerrenoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
    }

    static void main(String[] args) {
        new Interface();
    }
}
