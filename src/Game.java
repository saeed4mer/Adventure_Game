import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, legendarySkin;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    ImageIcon logo = new ImageIcon(".//res//jackfrost.jpg");


    public static void main(String[] args) {

        new Game();
    }

    public Game() {

        window = new JFrame();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(480, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Adventure");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(670, 500, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.red);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(480, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(400, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(600, 500, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.green);
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.red);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.yellow);
        choice3.setForeground(Color.black);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


        playerPanel = new JPanel();
        playerPanel.setBounds(500, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        weaponLabel.setBackground(Color.red);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }

    public void playerSetup() {

        playerHP = 15;
        monsterHP = 20;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate() {
        position = "townGate";
        if (legendarySkin == 1) {
            mainTextArea.setText("You are at the gate of the Town.\nThe Guard is waiting for you.\n\nWhat do you do?");
            choice1.setText("Talk to the guard");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else {
            mainTextArea.setText("You are at the gate of the Town. \nAn Armed Guard is standing in front of you. \n\nWhat do you do?");
            choice1.setText("Talk to the guard");
            choice2.setText("Attack the guard");
            choice3.setText("Leave");
            choice4.setText("");
        }
    }
    public void talkGuard() {
        position = "talkGuard";
        mainTextArea.setText("Guard: You seem to be a brave adventurer. If you wish to enter the town, you need to prove yourself.\n\nChoose wisely:\n- Go North to explore the river\n- Go East to find better equipment\n- Go West for potential danger" );
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }


    public void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText("Guard: You can't win against me!\nBut force me enough and I might just kill you\n\nThe guard fought back and hit you hard.\n(You receive 3 damage)");
        //playerHP = playerHP -3;
        playerHP -= 5;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go South, To go Town");
        choice4.setText("Go West");
    }

    public void north() {
        position = "north";
        mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2)");
        playerHP = playerHP + 2;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Go South");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void east() {
        position = "east";
        mainTextArea.setText("You walked into a forest and found a Long Iron Sword!\n\n(You obtained a Long Sword)");
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        choice1.setText("Go West");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void west() {
        position = "west";
        mainTextArea.setText("You encounter a Wild Wolf!");
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void fight() {
        position = "fight";
        mainTextArea.setText("Wild Wolf HP: " + monsterHP + "\n\nWhat do you do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack() {
        position = "playerAttack";

        int playerDamage = 0;

        if (weapon.equals("Knife")) {
            playerDamage = new java.util.Random().nextInt(3);
        } else if (weapon.equals("Long Sword")) {
            playerDamage = new java.util.Random().nextInt(12);
        }

        mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");

        monsterHP = monsterHP - playerDamage;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void monsterAttack() {
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText("The Wild Wolf attacked you and gave " + monsterDamage + " damage!");

        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void win() {
        position = "win";

        mainTextArea.setText("You defeated the Wild Wolf!\nThe Wild Wolf dropped a Legendary Skin!\n\n(You obtained a Legendary Skin)\n\n\nReport Back to the Guard ");

        legendarySkin = 1;

        choice1.setText("Go east");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void lose() {
        position = "lose";

        mainTextArea.setText("You are Dead! Try Again\n\nGAME OVER");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void talkToGuardAfterWolf() {
        position = "talkToGuardAfterWolf";
        mainTextArea.setText("Guard: I see you have slain the Wolf!\n\nThank you for your bravery. You are welcome to enter our town.\n\nTHE END");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void ending() {
        position = "ending";

        mainTextArea.setText("Guard: What do you want?\nThank you so much. You are true hero!\nWelcome to our town!\n\nTHE END");

        choice1.setText("I have Killed the Wolf");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }


    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            createGameScreen();
        }
    }


    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            if (legendarySkin == 1) {
                                talkToGuardAfterWolf();
                            } else {
                                talkGuard();
                            }
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                    }
                    break;
                case "talkGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "crossRoad":
                    switch (yourChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            east();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            west();
                            break;
                    }
                    break;
                case "north":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "east":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "west":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "fight":
                    switch (yourChoice) {
                        case "c1":
                            playerAttack();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "playerAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (monsterHP < 1) {
                                win();
                            } else {
                                monsterAttack();
                            }
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP < 1) {
                                lose();
                            } else {
                                fight();
                            }
                            break;
                    }
                    break;
                case "win":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
            }
        }
    }
}
