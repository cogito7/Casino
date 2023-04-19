/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import casino.Player;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author TheMy
 */
public class PlayerUi extends JPanel {

    public PlayerUi(Player player) {
        this.player = player;
        initComponents();
    }

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public JLabel getCashLabel() {
        return cashLabel;
    }

    public void setCashLabel(JLabel cashLabel) {
        this.cashLabel = cashLabel;
    }

    public JLabel getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(JLabel cashBalance) {
        this.cashBalance = cashBalance;
    }
    private JLabel cashLabel;
    private JLabel cashBalance;

    public void initComponents() {
        String babyYoda = JOptionPane.showInputDialog(null, "Enter the name of player");
        player.setName(babyYoda);
        String Mando = JOptionPane.showInputDialog(null, "Enter cash to play");
        player.setCash(Integer.parseInt(Mando));
        this.setPreferredSize(new Dimension(100, 900));
        this.setBorder(BorderFactory.createTitledBorder(player.getName()));
        cashLabel = new JLabel("Cash Balance: $");
        cashBalance = new JLabel(Integer.toString(player.getCash()));
        this.add(cashLabel);
        this.add(cashBalance);
        
    }
}
