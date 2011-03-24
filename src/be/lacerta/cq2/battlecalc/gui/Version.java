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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class Version {
  private int version = 304;
  private boolean checking = false;

  public Version() {

  }

  public void checkUpdate() {
    checkVersion cv = new checkVersion();
    cv.start();
  }

  public void display(boolean err, String msg) {
    if (err)
      JOptionPane.showMessageDialog(null,
        "Unable to get version information.\n\nError message:\n"+msg,
                                    "Unable to check version",JOptionPane.ERROR_MESSAGE);
    else
      JOptionPane.showMessageDialog(null,msg);
  }

  class checkVersion extends Thread {
    @SuppressWarnings("deprecation")
	public void run() {
      if (checking) this.stop();
        checking = true;
        try {
          URL url = new URL("http://cq2.lacerta.be/version");

          StringBuffer result = new StringBuffer();
          BufferedReader reader = null;
          reader = new BufferedReader(new InputStreamReader(url.openStream()));
          String line = null;
          while ( (line = reader.readLine()) != null) {
            result.append(line);
          }
          int newVersion = Integer.parseInt(result.toString());
          if (newVersion(newVersion))
            display(false,
                "Newer version available for download.\nhttp://cq2.lacerta.be");
          else
            display(false, "No newer version available.");
        }
        catch (MalformedURLException ex) { display(true, ex.toString()); }
        catch (IOException ex) { display(true, ex.toString()); }
        catch (NumberFormatException ex) { display(true, ex.toString()); }
        checking = false;
      this.stop();
    }
  }

  private boolean newVersion(int version) {
    return (version > this.version);
  }

  public String getVersion() {
    int main = version / 100;
    int sub = version - (main*100);
    return main+"."+sub;
  }

}
