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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MPanel extends JPanel {

  private ImageIcon imageIcon;
  private Image image = null;
  private Color bgcolor;

  public MPanel(URL imageURL, Color bgcolor) {
    imageIcon = new ImageIcon(imageURL);
    image = imageIcon.getImage(); { setOpaque(false); }
    this.bgcolor = bgcolor;
  }
  
  public MPanel(URL[] imageURLs, Color bgcolor) {
	try {
		int width = 0;
		int height = 0;
		BufferedImage[] images = new BufferedImage[imageURLs.length];
	  	for (int i = 0; i < imageURLs.length; i++) {
			images[i] = ImageIO.read(imageURLs[i]);
			width += images[i].getWidth();
			height = Math.max(height, images[i].getHeight());
	  	}
	  	BufferedImage total = new BufferedImage(width,height,images[0].getType());
	  	Graphics2D g = total.createGraphics();
	  	int w = 0;
	  	for (int i=0; i<images.length; i++) {
	  		g.drawImage(images[i], w, 0, null);
	  		w += images[i].getWidth();
	  	}
	  	g.dispose();
	  	image = total; { setOpaque(false); }
	  	
	} catch (IOException e) {
		e.printStackTrace();
	}
	this.bgcolor = bgcolor;
  }
  
  public MPanel() {
    super();
    this.bgcolor = super.getBackground();
  }

  public void paintComponent(Graphics g) {
    g.setColor(bgcolor);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    if (image != null) {
      g.drawImage(image, 0, 0, (this.getWidth()), (this.getHeight()), this);
    }
    super.paintComponent(g);
  }


}
