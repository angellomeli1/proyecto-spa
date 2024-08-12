package com.proyectospand.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class confUI {
    public static void applyCustomFont(float fontSize, JLabel... labels) {
        try (InputStream is = confUI.class.getClassLoader().getResourceAsStream("Oswald-Semibold.ttf")) {
            if (is != null) {
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, is);
                for (JLabel label : labels) {
                    label.setFont(customFont.deriveFont(fontSize));
                }
            } else {
                System.err.println("No se pudo encontrar la fuente: Oswald-Semibold.ttf");
            }
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void setImageComponent(JComponent component, String rutaImg) {
        try (InputStream is = confUI.class.getClassLoader().getResourceAsStream(rutaImg)) {
            if (is != null) {
                BufferedImage image = ImageIO.read(is);
                Image resizedImage = image.getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
    
                if (component instanceof JLabel) {
                    ((JLabel) component).setIcon(icon);
                } else if (component instanceof JButton) {
                    ((JButton) component).setIcon(icon);
                }
            } else {
                System.err.println("No se pudo encontrar la imagen: " + rutaImg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
