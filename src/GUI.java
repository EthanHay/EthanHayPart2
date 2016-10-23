/**
 * Created by Ethan on 24-Oct-16.
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


public class GUI extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Mineral SuperTrump - Ethan Hay");
    final int WIDTH = 1200;
    final int HEIGHT = 900;

    //global defines
    Font titleFont = new Font("Arial", Font.BOLD, 20);
    Font subtitleFont = new Font("Arial", Font.BOLD, 16);
    Font textFont = new Font("Arial", Font.BOLD, 12);

    //main menu
    JLabel menuTitle = new JLabel("Mineral SuperTrump");
    JLabel menuIntro = new JLabel("Welcome to Mineral SuperTrump!");
    JButton startButton = new JButton("Start Game");
    JButton exitButton = new JButton("Exit");

    //game screen
    JLabel gameIntro = new JLabel("Select the card you wish to play.");
    JLabel test = new JLabel(new ImageIcon("images/Slide01"));
    JButton cardButton0 = new JButton();
    JButton cardButton1 = new JButton();
    JButton cardButton2 = new JButton();
    JButton cardButton3 = new JButton();
    JButton cardButton4 = new JButton();
    JButton cardButton5 = new JButton();
    JButton cardButton6 = new JButton();
    JButton cardButton7 = new JButton();


    //panels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();


    public void createMainMenu() {

        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(3,1));

        //edit elements
        menuTitle.setFont(titleFont);
        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        menuIntro.setFont(subtitleFont);
        menuIntro.setHorizontalAlignment(JLabel.CENTER);
        panel1.setLayout(new GridLayout(2,1));
        panel3.setLayout(new FlowLayout());

        //add elements

        panel1.add(menuTitle);
        panel1.add(menuIntro);
        panel2.add(startButton);
        panel3.add(exitButton);

        add(panel1);
        add(panel2);
        add(panel3);


        //add listeners
        startButton.addActionListener(this);
        exitButton.addActionListener(this);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createGameGUI() {
        ArrayList currentCards, currentCard, card;
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(3,1));

        //edit elements
        menuTitle.setFont(titleFont);
        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        gameIntro.setFont(subtitleFont);
        gameIntro.setHorizontalAlignment(JLabel.CENTER);
        gameIntro.setVerticalAlignment(SwingConstants.BOTTOM);
        panel1.setLayout(new GridLayout(2,1));
        panel2.setLayout(new GridLayout(1,4));
        panel3.setLayout(new GridLayout(1,4));

        try {
            currentCards = (ArrayList) initPlayer.getPlayerCards(0);
            currentCard = (ArrayList) currentCards.toArray()[0];
            for(int i = 0; i< currentCard.toArray().length ; i++) {
                card = (ArrayList) currentCard.toArray()[i];
                Image img = ImageIO.read(getClass().getResource("images/" + card.toArray()[0]));
                Image newimg = img.getScaledInstance( 180, 260,  java.awt.Image.SCALE_SMOOTH ) ;
                switch(i) {
                    case 0:
                        cardButton0.setIcon(new ImageIcon(newimg));
                        cardButton0.setSize(10,20);
                        break;
                    case 1:
                        cardButton1.setIcon(new ImageIcon(newimg));
                        break;
                    case 2:
                        cardButton2.setIcon(new ImageIcon(newimg));
                        break;
                    case 3:
                        cardButton3.setIcon(new ImageIcon(newimg));
                        break;
                    case 4:
                        cardButton4.setIcon(new ImageIcon(newimg));
                        break;
                    case 5:
                        cardButton5.setIcon(new ImageIcon(newimg));
                        break;
                    case 6:
                        cardButton6.setIcon(new ImageIcon(newimg));
                        break;
                    case 7:
                        cardButton7.setIcon(new ImageIcon(newimg));
                        break;

                }

            }
            } catch (IOException ex){

        }

        //add elements

        panel1.add(menuTitle);
        panel1.add(gameIntro);
        panel2.add(cardButton0);
        panel2.add(cardButton1);
        panel2.add(cardButton2);
        panel2.add(cardButton3);
        panel3.add(cardButton4);
        panel3.add(cardButton5);
        panel3.add(cardButton6);
        panel3.add(cardButton7);
        panel4.add(exitButton);

        add(panel1);
        add(panel2);
        add(panel3);
        //add(panel4);


        //add listeners
        startButton.addActionListener(this);
        exitButton.addActionListener(this);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e) {
        //all actions from buttons ect

        if(e.getSource() == startButton){
            //String input = JOptionPane.showInputDialog(this, "How many bots do you want to verse? (2 - 4)", null);
           // int numOfPlayers = Integer.parseInt(input);
            //if (numOfPlayers == 4) {
                dispose();
                GUI gameGUI = new GUI();
                gameGUI.createGameGUI();
                gameGUI.setTitle("Mineral SuperTrump - Ethan Hay");
                gameGUI.setVisible(true);
                initGame.startGameLoop();
            //}
        }
        if (e.getSource() == exitButton){
            //force close
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}



