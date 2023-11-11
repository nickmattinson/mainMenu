package src;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Screen extends JFrame implements MouseListener {

    // declare variables
    int width, height;

    // create frame for screen
    public JFrame gameFrame = new JFrame();
    public JPanel gamePanel = new JPanel();

    // create the different panels used for the game
    public JPanel game = new JPanel();
    public JPanel menu = new JPanel();
    public JPanel settings = new JPanel();

    // create JPanels for main menu panel
    public JPanel toolBar = new JPanel();;
    public JPanel leftSide = new JPanel();;
    public JPanel rightSide = new JPanel();;
    public JPanel centerSpace = new JPanel();;
    public JPanel buttonsPanel = new JPanel();;

    // create layouts for the panels
    CardLayout cardLayout = new CardLayout();
    BorderLayout borderLayout = new BorderLayout();   

    // create icons to add to the button labels
    public Icon playButtonIcon = new ImageIcon(getClass().getResource("/images/play.png"));
    public Icon playButtonHighlightedIcon = new ImageIcon(getClass().getResource("/images/playHighlighted.png"));
    public Icon quitButtonIcon = new ImageIcon(getClass().getResource("/images/quit.png"));
    public Icon quitButtonHighlightedIcon = new ImageIcon(getClass().getResource("/images/quitHighlighted.png"));
    public Icon settingsButtonIcon = new ImageIcon(getClass().getResource("/images/settings.png"));
    public Icon settingsButtonHighlightedIcon = new ImageIcon(getClass().getResource("/images/settingsHighlighted.png"));
    public Icon backButtonIcon = new ImageIcon(getClass().getResource("/images/back.png"));
    public Icon backButtonHighlightedIcon = new ImageIcon(getClass().getResource("/images/backHighlighted.png"));
    public Icon novaFluxIcon = new ImageIcon(getClass().getResource("/images/novaFluxTitle.png"));

    // create buttons as labels
    JLabel playButton = new JLabel(playButtonIcon);
    JLabel settingsButton = new JLabel(settingsButtonIcon);
    JLabel quitButton = new JLabel(quitButtonIcon);
    JLabel backButton = new JLabel(backButtonIcon);
    JLabel novaFluxTitle = new JLabel(novaFluxIcon);   
    
    Dimension leftSideDimension = new Dimension(220,580);
    Dimension rightSideDimension = new Dimension(220,580);
    Dimension toolBarDimension = new Dimension(1670,60);
    Dimension centerSpaceDimension = new Dimension(1220,580);
    Dimension buttonPanelDimension = new Dimension(1670, 220);

    // constructor
    public Screen(int width, int height){
        this.width = width;
        this.height = height;

        // change size of buttons
        playButton.setSize(400,400);
        novaFluxTitle.setSize(1220,580);

        gamePanel.setLayout(cardLayout);
        setupMainMenu();
        addButtons();
        // set names to panels
        cardLayout.show(gamePanel, "Menu");

        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("main menu example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();
    }

    // methods
    public void setupMainMenu(){
        // add components to each panel
        leftSide.setPreferredSize(leftSideDimension);
        leftSide.setBackground(Color.LIGHT_GRAY);
        toolBar.setPreferredSize(toolBarDimension);
        toolBar.setBackground(Color.LIGHT_GRAY);
        rightSide.setPreferredSize(rightSideDimension);
        rightSide.setBackground(Color.LIGHT_GRAY);
        centerSpace.setPreferredSize(centerSpaceDimension);
        centerSpace.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.setPreferredSize(buttonPanelDimension);
        buttonsPanel.setBackground(Color.LIGHT_GRAY);

        // add panels to the main window
        menu.add(toolBar, BorderLayout.PAGE_START);
        menu.add(leftSide, BorderLayout.LINE_START);
        menu.add(centerSpace, BorderLayout.CENTER);
        menu.add(rightSide, BorderLayout.LINE_END);
        menu.add(buttonsPanel, BorderLayout.PAGE_END);
    }

    private void addButtons(){
        playButton.addMouseListener(this);
        settingsButton.addMouseListener(this);
        backButton.addMouseListener(this);
        quitButton.addMouseListener(this);

        // set the buttons visible
        playButton.setVisible(true);
        settingsButton.setVisible(true);
        backButton.setVisible(true);
        quitButton.setVisible(true);

        // add buttons to menu
        buttonsPanel.add(playButton);
        buttonsPanel.add(settingsButton);
        buttonsPanel.add(quitButton);

        // add title to center space panel
        centerSpace.add(novaFluxTitle);
        

        // add buttons to game
        game.add(backButton);

        // add buttons to settings
        settings.add(backButton);

        gamePanel.add(menu, "Menu");
        gamePanel.add(game, "Game");
        gamePanel.add(settings, "Settings");

        add(gamePanel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();

        if (source == quitButton){
            System.exit(0);
        }   else if(source == playButton){
            cardLayout.show(gamePanel, "Game");
            game.add(backButton);
        } else if(source == settingsButton){
            cardLayout.show(gamePanel, "Settings");
            settings.add(backButton);
        } else if (source == backButton){
            cardLayout.show(gamePanel, "Menu");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();

        if (source == quitButton){
            quitButton.setIcon(quitButtonHighlightedIcon);
        }   else if(source == playButton){
            playButton.setIcon(playButtonHighlightedIcon);
        } else if(source == settingsButton){
            settingsButton.setIcon(settingsButtonHighlightedIcon);
        } else if (source == backButton){
            backButton.setIcon(backButtonHighlightedIcon);
        } else {
            System.out.println("error in mouse entered method.");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();

        if (source == quitButton){
            quitButton.setIcon(quitButtonIcon);
        }   else if(source == playButton){
            playButton.setIcon(playButtonIcon);
        } else if(source == settingsButton){
            settingsButton.setIcon(settingsButtonIcon);
        } else if (source == backButton){
            backButton.setIcon(backButtonIcon);
        } else {
            System.out.println("error in mouse exited method.");
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {  
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {  
    }
}
