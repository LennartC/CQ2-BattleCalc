/*
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * Lennart Coopmans <coopmansl@gmail.com> wrote this file. As long as you
 * retain this notice you can do whatever you want with this stuff. If we meet
 * some day, and you think this stuff is worth it, you can buy me a beer in
 * return.
 * ----------------------------------------------------------------------------
 */


package be.lacerta.cq2.battlecalc.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;

@SuppressWarnings("serial")
public class GridBagPanel extends MPanel {

  private GridBagLayout layout;
  private GridBagConstraints constraints;

  public GridBagPanel() {
  super();
  layout = new GridBagLayout();
  constraints = new GridBagConstraints();
  super.setLayout(layout);
  constraints.fill = GridBagConstraints.BOTH;
}


  public GridBagPanel(URL imageURL, Color bgcolor) {
    super(imageURL, bgcolor);
    layout = new GridBagLayout();
    constraints = new GridBagConstraints();
    super.setLayout(layout);
    constraints.fill = GridBagConstraints.BOTH;
  }

  public void weight(int x, int y) {
    constraints.weightx = x; // mag mee vergroten horizontaal
    constraints.weighty = y; // mag niet mee vergroten vertikaal
  }

  public void add(Component component, int row, int column, int width, int height) {
    constraints.gridx = column;
    constraints.gridy = row;
    constraints.gridwidth = width;
    constraints.gridheight = height;

    layout.setConstraints(component, constraints);
    add(component);
  }

}
