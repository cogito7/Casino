/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import casino.Casino;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author TheMy
 */
public class CasinoUi implements ActionListener {
    private JFrame frame;
    public Casino casino;
    public PlayerUi playerUi;
    private JPanel casinoPanel;
    private JPanel buttonPanel;
    private JPanel gamePanel;
    private JPanel blackJackPanel;
    private JPanel scratchOffPanel;
    private JPanel slotsPanel;
    private JButton slots;
    private JButton blackJack;
    private JButton scratchers;
    private SlotsUi slotsUi;
    private ScratchOffsUi scratchOffsUi;
    private BlackJackUi blackJackUi;
    
    public static final String SLOTS = "Slots";
    public static final String BLACK_JACK = "Black Jack";
    public static final String SCRATCH_OFFS = "Scratch Offs";
    
    private CardLayout cardLayout;
    
    public CasinoUi (Casino casino) {
        this.casino = casino;
        initObjects();
        initComponents();
        
        
    }
    public void initObjects() {
        playerUi = new PlayerUi(casino.getPlayer());
        
        cardLayout = new CardLayout();
    }
    
    public void initComponents() {
        frame = new JFrame("Knights Casino");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        buttonPanel = new JPanel();
        blackJackUi = new BlackJackUi(playerUi.getPlayer(), this);
        blackJack = new JButton(BLACK_JACK);
        blackJack.addActionListener(this);
        buttonPanel.add(blackJack);
        slotsUi = new SlotsUi(playerUi.getPlayer(), this);
        slots = new JButton(SLOTS);
        slots.addActionListener(this);
        buttonPanel.add(slots);
        scratchOffsUi = new ScratchOffsUi(playerUi.getPlayer(), this);
        scratchers = new JButton(SCRATCH_OFFS);
        scratchers.addActionListener(this);
        buttonPanel.add(scratchers);
        gamePanel = new JPanel();
        gamePanel.setLayout(cardLayout);
        gamePanel.setPreferredSize(new Dimension(200,200));
        gamePanel.setBorder(BorderFactory.createTitledBorder("Games"));
        gamePanel.add(blackJackUi, BLACK_JACK);
        gamePanel.add(slotsUi, SLOTS);
        gamePanel.add(scratchOffsUi, SCRATCH_OFFS);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(playerUi, BorderLayout.WEST);
        frame.add(gamePanel);
        frame.setVisible(true);
        
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        cardLayout.show(gamePanel, ae.getActionCommand());
        frame.revalidate();
        frame.repaint();
        
    }
    
    public void updatePlayerUi() {
        int playerCash = playerUi.getPlayer().getCash();
        String playerCashString = Integer.toString(playerCash);
        playerUi.getCashBalance().setText(playerCashString);
    }
    
}
