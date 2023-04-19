/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import casino.Player;
import constants.Constants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author TheMy
 */
public class SlotsUi extends JPanel {

    private CasinoUi casinoUi;
    private Player player;
    private JLabel data;
    private JLabel bet;
    private JButton spin;
    private JPanel headerPanel;
    private JPanel slotsPanel;
    private ArrayList<ImageIcon> images;
    private Random rand;
    private ArrayList<Integer> spinNums;

    class SpinListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            spin();
            results();
        }

    }

    public SlotsUi(Player player, CasinoUi casinoUi) {
        this.player = player;
        this.casinoUi = casinoUi;

        rand = new Random();
        initImages();
        initComponents();

    }

    public void initComponents() {
        data = new JLabel("Welcome to Knights Casino Slots");
        bet = new JLabel("The bet is $" + Constants.BET);
        spin = new JButton("Spin");
        spin.addActionListener(new SpinListener());
        headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(3, 1));
        headerPanel.add(data);
        headerPanel.add(bet);
        headerPanel.add(spin);
        slotsPanel = new JPanel();
        slotsPanel.setLayout(new GridLayout(1, 3));
        slotsPanel.setBorder(BorderFactory.createTitledBorder("Your spin"));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(headerPanel);
        this.add(slotsPanel);

    }

    public void initImages() {
        images = new ArrayList<ImageIcon>();
        images.add(createImageIcon("../images/slots/Banana.png", "Banana"));
        images.add(createImageIcon("../images/slots/Bar.png", "Bar"));
        images.add(createImageIcon("../images/slots/Bell.png", "Bell"));
        images.add(createImageIcon("../images/slots/Cherry.png", "Cherry"));
        images.add(createImageIcon("../images/slots/Chip-100.png", "Chip-100"));
        images.add(createImageIcon("../images/slots/Chip-50.png", "Chip-50"));
        images.add(createImageIcon("../images/slots/Chip-25.png", "Chip-25"));
        images.add(createImageIcon("../images/slots/Chip-5.png", "Chip-5"));
        images.add(createImageIcon("../images/slots/Clover.png", "Clover"));
        images.add(createImageIcon("../images/slots/Coin.png", "Coin"));
        images.add(createImageIcon("../images/slots/Diamond.png", "Diamond"));
        images.add(createImageIcon("../images/slots/Gold.png", "Gold"));
        images.add(createImageIcon("../images/slots/Money.png", "Money"));
        images.add(createImageIcon("../images/slots/Plum.png", "Plum"));
        images.add(createImageIcon("../images/slots/Seven.png", "Seven"));
        images.add(createImageIcon("../images/slots/Trollface.png", "Trollface"));
        images.add(createImageIcon("../images/slots/Watermelon.png", "Watermelon"));
    }

    public ImageIcon createImageIcon(String filePath, String descript) {
        java.net.URL imgURL = getClass().getResource(filePath);
        ImageIcon imageIcon;
        if (imgURL != null) {
            imageIcon = new ImageIcon(imgURL, descript);
            imageIcon = imageResize(imageIcon);
            return imageIcon;

        } else {
            System.out.println("File could not be found");
            return null;

        }

    }

    public ImageIcon imageResize(ImageIcon begins) {
        Image image = begins.getImage();
        Image newImage = image.getScaledInstance(100, 75, java.awt.Image.SCALE_SMOOTH);
        begins = new ImageIcon(newImage);
        return begins;

    }

    public void spin() {
        int randNum;
        player.setCash(player.getCash() - 5);
        casinoUi.playerUi.updateUI();
        spinNums = new ArrayList<Integer>();
        slotsPanel.removeAll();
        for (int i = 0; i < 3; i++) {
            JLabel jlabel = new JLabel();
            int num = rand.nextInt(images.size());
            ImageIcon image = images.get(num);
            jlabel.setIcon(image);
            spinNums.add(num);
            slotsPanel.add(jlabel);
        }
        slotsPanel.revalidate();
        slotsPanel.repaint();

    }

    public void results() {
        if (spinNums.get(0) == spinNums.get(1) && spinNums.get(1) == spinNums.get(2)) {
            // TODO
            JOptionPane.showMessageDialog(null, "Three symbols matched, you won $50!");
            int currentCash = player.getCash();
            player.setCash(currentCash + 50);
        } else if (spinNums.get(0) == spinNums.get(1) || spinNums.get(1) == spinNums.get(2) || spinNums.get(0) == spinNums.get(2)) {
            // TODO
            JOptionPane.showMessageDialog(null, "Two symbols matched, you won $5!");
            int currentCash = player.getCash();
            player.setCash(currentCash + 5);
        } else {
            // you lose
            JOptionPane.showMessageDialog(null, "No symbols matched");
           
        }
        casinoUi.updatePlayerUi();
        
    }
}
