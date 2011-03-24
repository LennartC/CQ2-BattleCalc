package be.lacerta.cq2.battlecalc;
/*
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * Lennart Coopmans <coopmansl@gmail.com> wrote this file. As long as you
 * retain this notice you can do whatever you want with this stuff. If we meet
 * some day, and you think this stuff is worth it, you can buy me a beer in
 * return.
 * ----------------------------------------------------------------------------
 */

import be.lacerta.cq2.battlecalc.gui.MainFrame;

public class Starter {
    /** start the program */
    public Starter() {
      MainFrame main = new MainFrame();
      main.setVisible(true);
      main.setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE );
    }

    public static void main(String[] args) {
       new Starter();
    }



}
