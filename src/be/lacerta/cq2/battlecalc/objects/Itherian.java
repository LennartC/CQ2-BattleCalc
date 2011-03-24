/*
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * Lennart Coopmans <coopmansl@gmail.com> wrote this file. As long as you
 * retain this notice you can do whatever you want with this stuff. If we meet
 * some day, and you think this stuff is worth it, you can buy me a beer in
 * return.
 * ----------------------------------------------------------------------------
 */
package be.lacerta.cq2.battlecalc.objects;

public class Itherian {
  public int damage = 0, defence = 0;
  public int health = 0;
  
  public Itherian() {
	  this(0,0,0);
  }
  
  /**
   * itherian
   * @param dmg damage added by the itherian
   * @param hlt health added by the itherian
   * @param def defence added by the itherian
   */
  public Itherian(int dmg, int hlt, int def) {
    damage = dmg;
    health = hlt;
    defence = def;
  }
  /** @return damage added by the itherian */
  public int getDamage() { return damage; }
  /** @return health added by the itherian */
  public int getHealth() { return health; }
  /** @return defence added by the itherian */
  public int getDefence() { return defence; }
  /** @param dmg damage added by the itherian */
  public void setDamage(int dmg) { damage = dmg; }
  /** @param hlt health added by the itherian */
  public void setHealth(int hlt) { health = hlt; }
  /** @param def defence added by the itherian */
  public void setDefence(int def) { defence = def; }

}
