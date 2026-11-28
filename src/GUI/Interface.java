package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {

    private JButton exportarImagemButton;
    private JButton exportarTerrenoButton;
    private JButton gerarTerrenoButton;
    private JComboBox<AlgoritmoEnum> seletorAlgoritmo;
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
        seletorAlgoritmo.addItem("Value Noise");
        seletorAlgoritmo.addItem("Diamond-Square");
        gerarTerrenoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int altura_min;
                int altura_max;
                int largura;
                int altura;
                if (campoAltMinima.getText().trim().isEmpty() || campoAltMaxima.getText().trim().isEmpty()
                        || campoTamLargura.getText().trim().isEmpty()
                        || campoTamAltura.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Nenhum dos campos podem estar vazios!");
                    return;
                }
                try {
                    String algoritmo = (String) seletorAlgoritmo.getSelectedItem();
                    altura_min = Integer.parseInt(campoAltMinima.getText().trim());
                    altura_max = Integer.parseInt(campoAltMaxima.getText().trim());
                    largura = Integer.parseInt(campoTamLargura.getText().trim());
                    altura = Integer.parseInt(campoTamAltura.getText().trim());

                    if (largura <= 0 || altura <= 0) {
                        JOptionPane.showMessageDialog(mainPanel,
                                "A altura e/ou largura da matriz deve(m) ser maior(es) que zero!");
                        return;
                    }
                    if (altura_min > altura_max) {
                        JOptionPane.showMessageDialog(mainPanel,
                                "A altura mínima não podem ser maior que a altura máxima!");
                        return;
                    }

                    System.out.println("Algoritmo: " + algoritmo + "\n" +
                            "Altura mínima: " + Integer.toString(altura_min) + "\n" +
                            "Altura máxima: " + Integer.toString(altura_max) + "\n" +
                            "Largura da matriz: " + Integer.toString(largura) + "\n" +
                            "Altura da matriz: " + Integer.toString(altura));
                } catch (NumberFormatException erro) {
                    JOptionPane.showMessageDialog(mainPanel, "Os campos não aceitam valores que não sejam inteiros!");
                    return;
                }
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Interface();
    }
}
