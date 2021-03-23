package exams;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class BeamMachineJpanel extends JFrame {

    static JFrame frame;
    static JButton button;

    public static void main(String args[])
    {
        frame = new JFrame("Beam Machine");
        button = new JButton("Simulate");

        JPanel panel = new JPanel();
        panel.add(button);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.show();
    }
}