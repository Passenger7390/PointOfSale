package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

// TODO ALWAYS BASE ON UML!!!
// TODO create a account for new users bsaed on uml
//TODO create a class for cart based on uml
public class Main {

    private static JFrame main;
    private JPanel pN;
    private JPanel pW;
    private JPanel pE;
    private JPanel pS;
    private JPanel pC;
    private final Color mainColor = new Color(25,69,105);
    ImageIcon mylogo = new ImageIcon("src/main/resources/logo.png");
    private final Font font = new Font("Verdana", Font.PLAIN, 20);
    ImageIcon midi = new ImageIcon("src/main/resources/midi.png");
    ImageIcon spkr = new ImageIcon("src/main/resources/speaker.png");
    ImageIcon stands = new ImageIcon("src/main/resources/stands.png");
    ImageIcon piano = new ImageIcon("src/main/resources/piano.png");
    ImageIcon mic = new ImageIcon("src/main/resources/microphone.png");
    ImageIcon mic1 = new ImageIcon("src/main/resources/mic1.png");
    ImageIcon foam = new ImageIcon("src/main/resources/foamsaspeaker.png");
    ImageIcon drmstck = new ImageIcon("src/main/resources/drumstick.png");
    ImageIcon drumset = new ImageIcon("src/main/resources/drumset.png");
    ImageIcon chair = new ImageIcon("src/main/resources/chair.png");
    ImageIcon cables = new ImageIcon("src/main/resources/cables.png");
    ImageIcon audio = new ImageIcon("src/main/resources/audiointerface.png");
    ImageIcon ewan = new ImageIcon("src/main/resources/anotawagdito.png");
    ImageIcon cart = new ImageIcon("src/main/resources/cart.png");

    public static void main(String[] args) {
        Main main = new Main();
    }

    class Mainframe extends JFrame{
        Mainframe(String t) {

            main = new JFrame(t);
            main.setVisible(true);
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setLayout(new BorderLayout());
            main.getContentPane().setBackground(mainColor);
            main.setSize(1500, 900);
            main.setIconImage(mylogo.getImage());
            main.setLocationRelativeTo(null);
            main.setResizable(false);
            pN = new JPanel();
            pN.setBackground(mainColor);
            pN.setPreferredSize(new Dimension(100, 100));
            main.add(pN, BorderLayout.NORTH);

            pW = new JPanel();
            pW.setBackground(mainColor);
            pW.setPreferredSize(new Dimension(200, 200));
            main.add(pW, BorderLayout.WEST);

            pE = new JPanel();
            pE.setBackground(mainColor);
            pE.setPreferredSize(new Dimension(200, 200));
            main.add(pE, BorderLayout.EAST);

            pS = new JPanel();
            pS.setBackground(mainColor);
            pS.setPreferredSize(new Dimension(100, 100));
            main.add(pS, BorderLayout.SOUTH);

            pC = new JPanel();
            pC.setBackground(mainColor);
            pC.setPreferredSize(new Dimension(100, 100));
            pC.setLayout(new GridLayout());
            main.add(pC, BorderLayout.CENTER);


        }
    }
    public void reFrame() {                                                 // FUNCTION TO REFRESH FRAME
        main.invalidate();
        main.validate();
        main.repaint();
    }

    public void resetFrame() {
        pC.removeAll();
        pS.removeAll();
        pE.removeAll();
        pW.removeAll();
    }

    public void recolor() {
        pC.setBackground(mainColor);
        pE.setBackground(mainColor);
        pS.setBackground(mainColor);
        pW.setBackground(mainColor);
        main.getContentPane().setBackground(mainColor);
    }
    Main() {

        new Mainframe("Login");
        JButton enter = new JButton();
        enter.setIcon(mylogo);
        enter.setPreferredSize(new Dimension(100, 100));
        enter.setBackground(mainColor);
        enter.setBorderPainted(false);
        pC.add(enter);
        reFrame();
        // BUTTON ICON
        enter.addActionListener(e -> {
            pC.remove(enter);
            main.dispose();
            new Home(0);
            reFrame();
        });
    }

    class Choice {
        Choice() {
            main.add(pC, BorderLayout.CENTER);  main.add(pW, BorderLayout.WEST);    main.add(pE, BorderLayout.EAST);
            main.add(pS, BorderLayout.SOUTH);
            pC.setPreferredSize(new Dimension(100,100));
            pW.setPreferredSize(new Dimension(100,100));
            pS.setPreferredSize(new Dimension(100,100));
            pE.setPreferredSize(new Dimension(100,100));
            resetFrame();
            reFrame();

            JButton user, admin;
            user = new Button("User");
            admin = new Button("Admin");
            pC.setLayout(null);
            pC.add(user);    pC.add(admin);

            pC.setBackground(new Color(207,185,151));
           // user.setPreferredSize(new Dimension(100,50));
            //admin.setPreferredSize(new Dimension(100,50));
            user.setBounds(400,pC.getHeight()/2-35,200,70);
            admin.setBounds(700,pC.getHeight()/2-35,200,70);
            user.setFont(new Font("Monospaced", Font.BOLD, 50));
            admin.setFont(new Font("Monospaced", Font.BOLD, 50));
            //TODO create a choice interface to continue as user or admin

            admin.addActionListener(s -> {
                new Login();
            });
        }
    }


    class Login {
        Login() {
            main.add(pC, BorderLayout.CENTER);  main.add(pW, BorderLayout.WEST);    main.add(pE, BorderLayout.EAST);
            pC.setPreferredSize(new Dimension(100,100));
            pE.setPreferredSize(new Dimension(100,100));
            pW.setPreferredSize(new Dimension(100,100));
            pS.setPreferredSize(new Dimension(100,100));
            pC.removeAll();
            resetFrame();
            reFrame();

            pC.setBackground(new Color(207,185,151));
            pC.setLayout(null);

            Font loginFont = new Font("Serif", Font.PLAIN,30);


            JLabel loginlabel = new JLabel("Login");
            JLabel userLabel = new JLabel("Username");
            JLabel pwLabel = new JLabel("Password");
            JTextField userTX = new JTextField();
            JPasswordField pwTX = new JPasswordField();
            JButton loginBTN = new JButton("Login");
            JButton resetBTN = new JButton("Reset");
            JLabel create = new JLabel("Create an account");

            loginBTN.setFocusable(false);
            loginBTN.setFont(loginFont);
            resetBTN.setFocusable(false);
            resetBTN.setFont(loginFont);


            pwTX.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String p1 = String.valueOf(pwTX.getPassword());
                        String u = userTX.getText();

                        if (u.equals("admin") && p1.equals("admin")) {
                            pC.removeAll();
                            reFrame();
                            pC.setBackground(mainColor);
                            main.dispose();
                            new Home(0);
                        } else {
                            JOptionPane.showMessageDialog(null,"The Username or Password is incorrect!", "Login Failed", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) {}
            });

            userTX.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String p1 = String.valueOf(pwTX.getPassword());
                        String u = userTX.getText();

                        if (u.equals("admin") && p1.equals("admin")) {
                            pC.removeAll();
                            reFrame();
                            pC.setBackground(mainColor);
                            main.dispose();
                            new Home(0);
                        } else {
                            JOptionPane.showMessageDialog(null,"The Username or Password is incorrect!", "Login Failed", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                @Override
                public void keyReleased(KeyEvent e) {}
            });

            // LOGIN BUTTON
            loginBTN.addActionListener(e -> {
                String p1 = String.valueOf(pwTX.getPassword());
                String u = userTX.getText();

                if (u.equals("admin") && p1.equals("admin")) {
                    pC.removeAll();
                    reFrame();
                    pC.setBackground(mainColor);
                    main.dispose();
                    new Home(0);
                } else {
                    JOptionPane.showMessageDialog(null,"The Username or Password is incorrect!", "Login Failed", JOptionPane.WARNING_MESSAGE);
                    userTX.setText("");
                    pwTX.setText("");
                }
            });

            // RESET BUTTON
            resetBTN.addActionListener(e -> {
                userTX.setText("");
                pwTX.setText("");
            });

            loginlabel.setFont(new Font("Serif", Font.BOLD, 48));
            userLabel.setFont(loginFont);
            pwLabel.setFont(loginFont);

            pC.add(loginlabel);
            pC.add(userLabel);
            pC.add(userTX);
            pC.add(pwLabel);
            pC.add(pwTX);   pC.add(create);
            pC.add(loginBTN);   pC.add(resetBTN);

            loginlabel.setBounds(pC.getWidth()/2-75,90, 150, 60);
            userLabel.setBounds(pC.getWidth()/2-75,200, 150, 40);
            userTX.setBounds((pC.getWidth()/2)-115,250, 200,30);
            pwLabel.setBounds(pC.getWidth()/2-75,340,150,40);
            pwTX.setBounds(pC.getWidth()/2-115,390,200,30);
            loginBTN.setBounds(450,550,150,50);
            resetBTN.setBounds(650,550,150,50);

            create.setBounds(pC.getWidth()/2-75,450,150,40);
            create.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Hello!");
                }
            });

        }


    }

    public class User {
        private String name;
        private int age;
        private String contact;
        private String email;
        private int userId;
        private String shippingAddr;

        // ------------------- Setters ---------------------
        void setName(String n) {
            if (n != null && !n.isEmpty() && !n.isBlank()) {
                name = n;
            } else {
                JOptionPane.showMessageDialog(null,
                        "The name is too short. Please input name correctly!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        void setAge(int a) {
            if (a > 0) {
                age = a;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Please input age greater than 1",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        void setContact(String n) {
            contact = n;
        }

        void setEmail(String n) {
            int a = n.indexOf('@');

            if (a != 0 && a <= 1) {
                email = n;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Please input a correct email",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        void setShippingAddr(String n) {
            if (n != null && !n.isEmpty() && !n.isBlank()) {
                shippingAddr = n;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Please input a valid shipping address!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        // ------------------ Getters ----------------------
        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        String getContact() {
            return contact;
        }

        String getEmail() {
            return  email;
        }

        String getShippingAddr() {
            return shippingAddr;
        }
    }

    class Button extends JButton{
        Button(String t) {
            this.setText(t);
            this.setFocusable(false);
            this.setBorderPainted(false);
            this.setBackground(mainColor);
            this.setForeground(Color.white);

        }
        Button(ImageIcon n) {
            this.setIcon(n);
            this.setFocusable(false);
            this.setBorderPainted(false);
            this.setBackground(mainColor);
           // this.setForeground(Color.white);
        }
    }

    class Label extends JLabel {
        Label(String t) {
            this.setText(t);
            this.setFocusable(false);
            this.setFont(font);
            this.setForeground(Color.white);
        }
    }
    class Home implements ActionListener{
        Button[] funcBtn = new Button[6];
        Button hm, abtUs, delivery, ordrNw, profile,myCart, logout, login;
        JButton logo = new JButton();
        JLabel lb;
        Image img,newHpic, hpic, newIMG;

        ImageIcon newLogo, homepage, finalpic;
        Home(int n){

            homepage = new ImageIcon("src/main/resources/home.jpg");
            hpic = homepage.getImage().getScaledInstance(main.getWidth(),main.getHeight(),Image.SCALE_SMOOTH);

            newHpic = cart.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
            cart = new ImageIcon(newHpic);
            finalpic = new ImageIcon(hpic);
            finalpic = new ImageIcon(hpic);
            lb = new JLabel(finalpic);


            switch (n) {
                case 0 -> {
                    new Mainframe("Main");
                    pN.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 10));
                    pN.setBackground(new Color(25, 69, 105, 50));
                    img = mylogo.getImage();
                    newIMG = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                    newLogo = new ImageIcon(newIMG);
                    pS.add(lb);
                    logo.setPreferredSize(new Dimension(80, 80));
                    logo.setIcon(newLogo);
                    logo.setBorderPainted(false);
                    logo.setFocusable(false);
                    pN.add(logo);
                    reFrame();
                    logo.addActionListener(this);
                    hm = new Button("Home");
                    abtUs = new Button("About Us");
                    delivery = new Button("Delivery");
                    myCart = new Button(cart);
                    ordrNw = new Button("Products");
                    profile = new Button("Profile");
                    login = new Button("Log In");
                    funcBtn[0] = hm;
                    funcBtn[1] = abtUs;
                    funcBtn[2] = delivery;
                    funcBtn[3] = ordrNw;
                    funcBtn[4] = myCart;
                    funcBtn[5] = login;
                    for (int i = 0; i < 6; i++) {
                        pN.add(funcBtn[i]);
                        funcBtn[i].addActionListener(this);
                        funcBtn[i].setFont(new Font("Monospaced", Font.BOLD, 30));
                    }
                    main.remove(pE);
                    main.remove(pW);
                    main.remove(pC);
                    pS.setPreferredSize(new Dimension(100, 900));
                    reFrame();
                }
                case 1 -> {
                    main.setTitle("Home");
                    main.add(pS, BorderLayout.SOUTH);
                    pS.setPreferredSize(new Dimension(100, 900));
                    resetFrame();
                    reFrame();
                    pS.add(lb);

                    main.remove(pE);
                    main.remove(pW);
                    main.remove(pC);
                    reFrame();
                }

                case 2 -> {
                    main.setTitle("Home");
                    main.add(pS, BorderLayout.SOUTH);
                    pS.setPreferredSize(new Dimension(100, 900));
                    resetFrame();
                    reFrame();
                    pS.add(lb);
                    logout = new Button("Log Out");
                    funcBtn[5] = logout;

                    pN.add(funcBtn[5]);
                    funcBtn[5].addActionListener(this);
                    funcBtn[5].setFont(new Font("Monospaced", Font.BOLD, 30));

                    main.remove(pE);
                    main.remove(pW);
                    main.remove(pC);
                    reFrame();
                }
                default -> {
                }
            }
        }



        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == hm) {
                new Home(1);
            }

            if (e.getSource() == logo) {
                new Home(1);
            }

            if (e.getSource() == abtUs) {

                new AboutUs();
            }

            if (e.getSource() == delivery) {
                new Delivery();
            }


            if (e.getSource() == ordrNw) {
                new Order();
            }

            if (e.getSource() == profile) {
                new Profile();
            }

            if (e.getSource() == myCart) {
                new MyCart();
            }

            if (e.getSource() == logout) {
                JOptionPane.showMessageDialog(null,"Logged Out Succussfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
                resetFrame();
                pN.removeAll();
                reFrame();
                main.dispose();

                new Main();
            }

            if (e.getSource() == login) {
                new Choice();
            }

        }
    }

    class AboutUs {
        JLabel label = new JLabel();
        JLabel l2 = new JLabel();

        AboutUs() {
            main.setTitle("About Us");
            main.add(pC, BorderLayout.CENTER);  main.add(pW, BorderLayout.WEST);    main.add(pE, BorderLayout.EAST);
            pC.setPreferredSize(new Dimension(100,100));
            pE.setPreferredSize(new Dimension(100,100));
            pW.setPreferredSize(new Dimension(100,100));
            pS.setPreferredSize(new Dimension(100,100));
            resetFrame();
            pC.removeAll();
            recolor();
            pC.setSize(600,400);
            pC.setLayout(new GridLayout(2,1,10,10));

            l2.setText("About Us");
            l2.setFont(new Font("Verdana", Font.BOLD,48));
            l2.setForeground(Color.white);
            pC.add(l2);
            l2.setVisible(true);

            l2.setVerticalAlignment(JLabel.CENTER);
            l2.setHorizontalAlignment(JLabel.CENTER);

            label.setBounds(0,50,100,0);
            label.setFont(new Font("Verdana", Font.PLAIN,30));
            label.setForeground(Color.white);
            pC.add(label);
            String txt="<html>We started Studio Gear in 2022 at the age of 20. We became fascinated by the idea of helping other people, especially musicians to achieve their dream by making it easier to start, and build a studio. We believe that everyone"
                    + " is an artist in their own way, and because we love supporting artists, we created a shop where we can sell high quality yet affordable studio equipments. <h1>";
            label.setText(txt);
            label.setVisible(true);
            label.setVerticalAlignment(JLabel.NORTH);
            label.setHorizontalAlignment(JLabel.CENTER);


        }
    }

    class Profile {
        Label[] infoLabel = new Label[7];
        Label fName, mName, lName, date, phNum, eMail, sex, regDate, user;
        JTextField[] inp = new JTextField[5];
        JTextField inpFName, inpMName, inpLName, inpPhNum, inpEmail;
        JRadioButton male, female;

        Button save, clear;

        Profile() {
            main.setTitle("User Information");
            main.add(pC, BorderLayout.CENTER);  main.add(pW, BorderLayout.WEST);    main.add(pE, BorderLayout.EAST);

            resetFrame();
            main.remove(pS);
            reFrame();

            Date current = new Date();
            SimpleDateFormat dateformat = new SimpleDateFormat("EEEE MMM dd, yyy");

            pW.setSize(300,900);
            pC.setSize(500,300);

            pC.setLayout(null);

            male = new JRadioButton("Male");
            female = new JRadioButton("Female");
            save = new Button("Save");
            clear = new Button("Clear");

            save.setFont(new Font("Verdana", Font.BOLD, 24));
            save.setBackground(new Color(207,185,151));
            save.setForeground(Color.BLACK);
            clear.setFont(new Font("Verdana", Font.BOLD, 24));
            clear.setBackground(new Color(207,185,151));
            clear.setForeground(Color.BLACK);

            ButtonGroup a = new ButtonGroup();
            a.add(male);    a.add(female);

            pC.add(male);    pC.add(female);    pC.add(save);   pC.add(clear);

            fName = new Label("First Name : ");
            mName = new Label("Middle Name : ");
            lName = new Label("Last Name : ");
            sex = new Label("Sex : ");
            date = new Label("Date of Registration : ");
            phNum = new Label("Mobile Number : ");
            eMail = new Label("Email : ");

            user = new Label("User Information");
            user.setFont(new Font("Verdana", Font.BOLD, 48));
            user.setBounds(10,10,600,50);

            infoLabel[0] = fName;       infoLabel[1] = mName;
            infoLabel[2] = lName;       infoLabel[3] = sex;
            infoLabel[4] = date;   infoLabel[5] = phNum;
            infoLabel[6] = eMail;

            pC.add(user);

            for (Label n : infoLabel) {
                pC.add(n);
                n.setFont(font);
                reFrame();
            }

            infoLabel[0].setBounds(50,150,300,30);
            infoLabel[1].setBounds(50, 210, 300, 30);
            infoLabel[2].setBounds(50,270,300,30);
            infoLabel[3].setBounds(50,330,300,30);
            infoLabel[4].setBounds(50,390,300,30);
            infoLabel[5].setBounds(50,450,300,30);
            infoLabel[6].setBounds(50,510,300,30);

            inpFName = new JTextField("Juan");
            inpMName = new JTextField("Lopez");
            inpLName = new JTextField("Dela Cruz");
            inpPhNum = new JTextField("09XXXXXXXXX");
            inpEmail = new JTextField("example@email.com");

            inp[0] = inpFName;      inp[1] = inpMName;
            inp[2] = inpLName;      inp[3] = inpPhNum;
            inp[4] = inpEmail;

            for (JTextField n: inp) {
                pC.add(n);
                n.setFont(font);
                reFrame();
            }

            regDate = new Label(dateformat.format(current));
            inp[0].setBounds(500,150,500,30);
            inp[1].setBounds(500,210,500,30);
            inp[2].setBounds(500,270,500,30);
            inp[3].setBounds(500,450,500,30);
            inp[4].setBounds(500,510,500,30);

            male.setBounds(500,330,100,30);
            female.setBounds(600,330,100,30);
            save.setBounds(500,700,150,30);
            clear.setBounds(700,700,150,30);

            male.setBackground(mainColor);
            female.setBackground(mainColor);

            male.setForeground(Color.white);
            female.setForeground(Color.white);

            male.setFont(font);
            female.setFont(font);

            male.setFocusable(false);
            female.setFocusable(false);

            pC.add(regDate);
            regDate.setBounds(500,390,500,30);
            regDate.setForeground(Color.white);

            inp[0].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inp[0].getText().equals("Juan")) {
                        inp[0].setText("");
                        inp[0].setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inp[0].getText().isEmpty()) {
                        inp[0].setForeground(Color.GRAY);
                        inp[0].setText("Juan");
                    }
                }
            });

            inp[1].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inp[1].getText().equals("Lopez")) {
                        inp[1].setText("");
                        inp[1].setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inp[1].getText().isEmpty()) {
                        inp[1].setForeground(Color.GRAY);
                        inp[1].setText("Lopez");
                    }
                }
            });

            inp[2].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inp[2].getText().equals("Dela Cruz")) {
                        inp[2].setText("");
                        inp[2].setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inp[2].getText().isEmpty()) {
                        inp[2].setForeground(Color.GRAY);
                        inp[2].setText("Dela Cruz");
                    }
                }
            });

            inp[3].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inp[3].getText().equals("09XXXXXXXXX")) {
                        inp[3].setText("");
                        inp[3].setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inp[3].getText().isEmpty()) {
                        inp[3].setForeground(Color.GRAY);
                        inp[3].setText("09XXXXXXXXX");
                    }
                }
            });

            inp[4].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (inp[4].getText().equals("example@email.com")) {
                        inp[4].setText("");
                        inp[4].setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (inp[4].getText().isEmpty()) {
                        inp[4].setForeground(Color.GRAY);
                        inp[4].setText("example@email.com");
                    }
                }
            });
        }
    }

    class Delivery {
        Label[] txt = new Label[6];
        JRadioButton gcash, paypal, cod;
        Label housenum, street, city, region, country, brgy, addr, payment;
        JTextField[] inp = new JTextField[4];
        JTextField inpHnum,inpstrt,inpbrgy,inpct;
        ImageIcon gcashico = new ImageIcon("src/main/resources/gcash.png");
        ImageIcon paypalico = new ImageIcon("src/main/resources/paypal.png");

        Image test;

        String[] regions = {"NCR, First District", "NCR, Second District", "NCR, Third District",
                "NCR, Fourth District", "CORDILLERA ADMINISTRATIVE REGION(CAR)", "REGION I(Ilocos Region)",
                "REGION II(Cagayan Valley)", "REGION III(Central Luzon)", "REGION IV-A(CALABARZON)", "MIMAROPA REGION",
                "REGION V(Bicol Region)", "REGION VI(Western Visayas)", "REGION VII(Central Visayas)",
                "REGION VIII(Eastern Visayas)", "REGION IX(Zamboanga Peninsula)", "REGION X(Northern Mindanao)",
                "REGION X1(Davao Region)", "REGION XII(SOCCSKSARGEN)", "REGION XIII(Caraga)",
                "AUTONOMOUS REGION IN MUSLIM MINDANAO(ARMM)", "NEGROS ISLAND REGION(NIR)"};

        Delivery() {

            main.setTitle("Delivery");
            recolor();
            main.add(pC, BorderLayout.CENTER);  main.add(pW, BorderLayout.WEST);    main.add(pE, BorderLayout.EAST);
            resetFrame();
            main.remove(pS);
            reFrame();
            pC.setLayout(null);

            JComboBox cntry = new JComboBox(getAllCountries());
            JComboBox rgns = new JComboBox(regions);

            pC.add(cntry);
            cntry.setBounds(750,230,300,30);
            cntry.setSelectedItem("Philippines");
            pC.add(rgns);
            rgns.setBounds(750,150,300,30);

            housenum = new Label("House #");
            street = new Label("Street");
            brgy = new Label("Baranggay");
            city = new Label("City");
            country = new Label("Country");
            region = new Label("Region");

            txt[0] = housenum;      txt[1] = street;    txt[2] = brgy;          txt[3] = city;
            txt[4] = region;        txt[5] = country;

            for (Label n : txt) {
                pC.add(n);
                reFrame();
            }

            txt[0].setBounds(50,120,300,30);
            txt[1].setBounds(400,120,300,30);
            txt[2].setBounds(50,200,300,30);
            txt[3].setBounds(400,200,300,30);
            txt[4].setBounds(750,120,300,30);
            txt[5].setBounds(750,200,300,30);

            addr = new Label("Shipping Address");
            pC.add(addr);
            addr.setFont(new Font("Verdana", Font.BOLD,48));
            addr.setBounds(10,10,600,70);

            inpHnum = new JTextField();
            inpstrt = new JTextField();
            inpbrgy = new JTextField();
            inpct = new JTextField();

            inp[0] = inpHnum;       inp[1] = inpstrt;   inp[2] = inpbrgy;       inp[3] = inpct;


            for (JTextField n : inp) {
                pC.add(n);
                reFrame();
            }

            inp[0].setBounds(50,150,300,30);
            inp[1].setBounds(400,150,300,30);
            inp[2].setBounds(50,230,300,30);
            inp[3].setBounds(400,230,300,30);

            // *******************************************************

            payment = new Label("Payment Method");

            test = gcashico.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
            gcashico = new ImageIcon(test);

            test = paypalico.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
            paypalico = new ImageIcon(test);

            gcash = new JRadioButton("Gcash",gcashico);
            gcash.setFont(font);
            gcash.setBackground(mainColor);
            gcash.setForeground(Color.white);

            paypal = new JRadioButton("Paypal",paypalico);
            paypal.setFont(font);
            paypal.setBackground(mainColor);
            paypal.setForeground(Color.white);

            cod = new JRadioButton("Cash on Delivery");
            cod.setFont(font);
            cod.setBackground(mainColor);
            cod.setForeground(Color.white);

            pC.add(payment);    pC.add(gcash);      pC.add(paypal);     pC.add(cod);

            payment.setFont(new Font("Verdana", Font.BOLD, 48));

            payment.setBounds(10,350,600,70);
            gcash.setBounds(10,450,200,70);
            paypal.setBounds(400,450,200,70);
            cod.setBounds(850,450,300,70);

            ButtonGroup b = new ButtonGroup();
            b.add(paypal);      b.add(gcash);       b.add(cod);

        }
        public String[] getAllCountries() {
            String[] countries = new String[Locale.getISOCountries().length];
            String[] countryCodes = Locale.getISOCountries();
            for (int i = 0; i < countryCodes.length; i++) {
                Locale obj = new Locale("", countryCodes[i]);
                countries[i] = obj.getDisplayCountry();
            }

            Arrays.sort(countries);
            return countries;
        }
    }

    static class Buttons extends JButton {
        Buttons() {
            setText("Buy");
            setFocusable(false);
            setBorderPainted(false);
            setBackground(new Color(18, 142, 34));
            setForeground(Color.white);
            setBounds(100,200,50,50);


        }
    }
    static class Panel extends JPanel{
        Panel() {

        }
        Panel(Buttons n) {
            JPanel t,b;
            t = new JPanel();
            b = new JPanel();

            this.setLayout(new BorderLayout());
            add(t, BorderLayout.NORTH); add(b, BorderLayout.SOUTH);
            //t.setBackground(Color.blue);
            //b.setBackground(Color.green);
            b.add(n);

        }
        Panel(Buttons n, JLabel m) {
            JPanel t,b;
            t = new JPanel();
            b = new JPanel();

            this.setLayout(new BorderLayout());
            add(t, BorderLayout.NORTH); add(b, BorderLayout.SOUTH);
            t.setBackground(new Color(41,182,214));
            b.setBackground(new Color(41,182,214));

            b.add(n);
            t.add(m);
        }
    }

    class Order {

        JTabbedPane tp = new JTabbedPane();
        JPanel p1,p2,p3;

        Buttons q1 = new Buttons();     Buttons q2 = new Buttons();
        Buttons q3 = new Buttons();     Buttons q4 = new Buttons();
        Buttons q5 = new Buttons();     Buttons q6 = new Buttons();
        Buttons q7 = new Buttons();     Buttons q8 = new Buttons();
        Buttons q9 = new Buttons();     Buttons q10 = new Buttons();
        Buttons q11 = new Buttons();    Buttons q12 = new Buttons();
        Buttons q13 = new Buttons();

        GridLayout gl = new GridLayout(2,3,10,10);

        JPanel[] jp1 = new JPanel[6];
        JPanel[] jp2 = new JPanel[6];
        JPanel[] jp3 = new JPanel[6];
        Panel u1,u2,u3,u4,u5,u6;
        Panel t1,t2,t3,t4,t5,t6; // First tab
        Panel y1,y2,y3,y4,y5,y6; // Second Tab
        Dimension d1 = new Dimension(100,100);

        // *********************************************************



        // =========================================================

        Order() {
            main.setTitle("Order");

            main.add(pC, BorderLayout.CENTER);  main.add(pW, BorderLayout.WEST);    main.add(pE, BorderLayout.EAST);
            main.add(pS, BorderLayout.SOUTH);
            pC.setPreferredSize(new Dimension(100,100));
            pW.setPreferredSize(new Dimension(20,100));
            pS.setPreferredSize(new Dimension(100,20));
            pE.setPreferredSize(new Dimension(250,100));
            resetFrame();
            reFrame();
            pC.setBackground(mainColor);
            pC.setLayout(null);
            reFrame();

            p1 = new JPanel();  p2 = new JPanel();  p3 = new JPanel();

            p1.setLayout(gl);   p2.setLayout(gl);   p3.setLayout(gl);

            tp.add("1", p1);    tp.add("2", p2);    tp.add("3", p3);

            pC.add(tp);
            tp.setTabPlacement(JTabbedPane.BOTTOM);
            tp.setFont(new Font("Verdana", Font.PLAIN,20));
            tp.setBounds(0,0,pC.getWidth(),pC.getHeight());

            midi = icon(midi);
            spkr = icon(spkr);
            stands = icon(stands);
            piano = icon(piano);
            mic = icon(mic);
            mic1 = icon(mic1);
            foam = icon(foam);
            drmstck = icon(drmstck);
            drumset = icon(drumset);
            chair = icon(chair);
            cables = icon(cables);
            audio = icon(audio);
            ewan = icon(ewan);

            t1 = new Panel(q1,label(midi,"Midi Controller"));
            t2 = new Panel(q2,label(spkr,"Studio Monitor"));
            t3 = new Panel(q3,label(stands,"Studio Monitor Stands"));
            t4 = new Panel(q4,label(piano,"Piano"));
            t5 = new Panel(q5,label(mic,"Microphone"));
            t6 = new Panel(q6,label(mic1,"Microphone"));

            jp1[0] = t1;
            jp1[1] = t2;
            jp1[2] = t3;
            jp1[3] = t4;
            jp1[4] = t5;
            jp1[5] = t6;

            for (JPanel n:jp1) {
                p1.add(n);
            }

            y1 = new Panel(q7,label(foam,"Isolation Pads"));
            y2 = new Panel(q8,label(drmstck,"Drum Sticks"));
            y3 = new Panel(q9,label(drumset,"Drum Set"));
            y4 = new Panel(q10,label(chair, "Studio Chair"));
            y5 = new Panel(q11,label(cables,"Snake Cables"));
            y6 = new Panel(q12,label(audio, "Audio Interface"));

            jp2[0] = y1;    jp2[1] = y2;    jp2[2] = y3;
            jp2[3] = y4;    jp2[4] = y5;    jp2[5] = y6;

            for (JPanel n : jp2) {
                p2.add(n);
            }

            u1 = new Panel(q13,label(ewan, "Control Surface"));
            u2 = new Panel();
            u3 = new Panel();
            u4 = new Panel();
            u5 = new Panel();
            u6 = new Panel();

            jp3[0] = u1;    jp3[1] = u2;    jp3[2] = u3;
            jp3[3] = u4;    jp3[4] = u5;    jp3[5] = u6;

            for (JPanel n: jp3) {
                p3.add(n);
            }
            reFrame();

        }
        ImageIcon icon(ImageIcon n) {
            Image test;
            test = n.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
            n = new ImageIcon(test);
            return n;
        }

        JLabel label(ImageIcon n, String t) {
            JLabel l = new JLabel(t);
            l.setIcon(n);
            l.setHorizontalTextPosition(JLabel.CENTER);
            l.setVerticalTextPosition(JLabel.BOTTOM);
            l.setIconTextGap(-50);
            l.setOpaque(true);
            l.setFont(new Font("Verdana", Font.BOLD,24));
            l.setForeground(new Color(215,139,40));
            return l;
        }
    }

    class MyCart {

        MyCart() {
            System.out.println("New Cart");
        }
    }

    class Create {
        //TODO create a "create an account page"
    }

}
