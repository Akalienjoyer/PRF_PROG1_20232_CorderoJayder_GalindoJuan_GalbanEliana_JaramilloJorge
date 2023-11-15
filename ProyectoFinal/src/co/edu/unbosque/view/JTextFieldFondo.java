package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextField;

public class JTextFieldFondo extends JTextField {
    private static final long serialVersionUID = 1L;
    private String textoDeFondo;
    private Color colorDeTextoDeFondo;

    public JTextFieldFondo(String textoDeFondo) {
        this.textoDeFondo = textoDeFondo;
    }

    public void setColorDeTextoDeFondo(Color colorDeTextoDeFondo) {
        this.colorDeTextoDeFondo = colorDeTextoDeFondo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty()) {
            int y = (getHeight() - g.getFontMetrics().getHeight()) / 2 + g.getFontMetrics().getAscent();
            g.drawString(textoDeFondo, getInsets().left, y);
        }
    }
}

