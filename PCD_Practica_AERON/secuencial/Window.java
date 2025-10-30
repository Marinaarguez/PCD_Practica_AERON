package PCD_Practica_AERON.secuencial;

import javax.swing.*;

public class Window {
    private JFrame frame;
    private JTextArea area;

    public Window(String title) {
        frame = new JFrame(title);
        area = new JTextArea(20, 50);
        area.setEditable(false);
        frame.add(new JScrollPane(area));
        frame.pack();
        frame.setVisible(true);
    }

    public void mostrarEvento(String mensaje) {
        area.append(mensaje + "\n");
    }
}
