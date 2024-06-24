
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/*
 * @author mrtab
 */
public class Ray_Final_Escape extends JFrame
{  
    My_ActionListener objActionListener = new My_ActionListener();
    My_FocusGained objFocusGained = new My_FocusGained();
    Mouse_Game objMouseGame = new Mouse_Game();
    Mouse_Hallway objMouseHallway = new Mouse_Hallway();

    NumberFormat usdFormat = NumberFormat.getCurrencyInstance(); //declare CurrencyFormatter object
    
    int currentYear = Calendar.getInstance().get(Calendar.YEAR); //to find current year
    
    //////CURRENT TIME DECLARATIONS
    JLabel jLabelTextCurrentTime = new JLabel("The current time is: ");        
    
    //JFRAME AND JPANELS
    JPanel jPanelMain = new JPanel();
    JFrame jFrameFeatures = new JFrame();
    JPanel jPanelFeatures = new JPanel();
    JPanel jPanelScroll = new JPanel();
    
    //AUDIO CLIPS
    Clip clipWelcome,
         clipGameOptoin,
         cliphHallway, 
         clipGate,
         clipFreedom,
         clipFailure,
         clipMouseClick;        


    //////BUTTONS DECLARATIONS
    JButton jBGoHomePg = new JButton("Home");
    JButton jBGoSummaryExitPg = new JButton("Exit");
    JButton jBGoOverviewPg1 = new JButton();
    JButton jBGoOverviewRegFeePg = new JButton("Reg-Fees");
    JButton jBGoLoginPg = new JButton();
    JButton jBGoRegPgIfIDValid = new JButton("Login");
    JButton jBRegisterData = new JButton("Register");
    JButton jBResetRegForm = new JButton("Reset Form");
    JButton jBGoToFeatureSelectPg = new JButton("Continue");
    JButton jBBackToRegUserInfoPg = new JButton();
    JButton jBSubmitFeaturs = new JButton("Submit");
    JButton jBGoToGameOptionPg = new JButton();
    
    //loginUserPage();
//    JTextField jTextFieldID = new JTextField("3333");
    JTextField jTextFieldID = new JTextField("Enter your ID");
//    JPasswordField jPasswordFieldID = new JPasswordField("escape");
    JPasswordField jPasswordFieldID = new JPasswordField("password");
    JLabel jLTextLoginErrorMessage = new JLabel();
    
    //registerUserPersonalInfoPage();
//    JTextField jTextFieldAlias = new JTextField("Reza");
    JTextField jTextFieldAlias = new JTextField("Required");
    JTextField jTextFieldGender = new JTextField("Optional");
    JTextField jTextFieldAstroSign = new JTextField("Optional");
//    JTextField jTextFieldBirthYear = new JTextField("2000");
    JTextField jTextFieldBirthYear = new JTextField("Between 1901 - 2016 ");
//    JTextField jTextFieldDeposit = new JTextField("100");
    JTextField jTextFieldDeposit = new JTextField("Between $1 - $1000");
    JLabel jLTextRegBurpBack = new JLabel("<html> <blockquote> Please fill out all fields and then click on the Register button. <br> Your confirmation will appear here.</blockquote></html>");
    
    //selectFeaturesPage();
    JRadioButton jrbMiniPlayer = new JRadioButton("$2.50 for a Mini Player (age under 4)");
    JRadioButton jrbJuniorPlayer = new JRadioButton("$5.00 for a Junior Player (ages 4 - 12)");
    JRadioButton jrbPowerPlayer = new JRadioButton("$7.50 for a Power Player (ages 13 – 17)");
    JRadioButton jrbXtremePlayer = new JRadioButton("$9.75 for an Xtreme Player (ages +18)");
    JLabel jLTextWarnSelectLevelAndAgeChecker = new JLabel();
    
    JCheckBox jCheckBoxBeer = new JCheckBox("Beer Bottle");
    JCheckBox jCheckBoxCoin = new JCheckBox("Gold Coin");
    JCheckBox jCheckBoxLifevest = new JCheckBox("Lifevest");
    JCheckBox jCheckBoxMap = new JCheckBox("Island's Map");       
    JCheckBox jCheckBoxPasscode = new JCheckBox("Passcode 1St Digit");
    JCheckBox jCheckBoxGuard = new JCheckBox("Guards");    

    //displayRegInfoLastPg();
    JLabel jLTextRegInfoBurpBack = new JLabel();
    
    //displaySummaryPg();
    JLabel jLTextAccountSummary = new JLabel();
    JButton jBRayIdInfoPg = new JButton();
    
    //showGameOptions();
    JButton jBGoToGameOptionPgNoRecord = new JButton();
    JButton jBGoInstructionPg = new JButton("Instructions");
    JButton jBGoPlayPg = new JButton("Play");
    JButton jBGoHistoryPg = new JButton("History");
    JButton jBSolutionPath = new JButton("Solution");
    JButton jBSecondDeposit = new JButton("Deposit Money");
    JLabel jLTextLowBalanceMessage = new JLabel();
    JLabel jLTextAdminUserMode = new JLabel();
    JTextField jTextFieldSecondDeposit = new JTextField("Amount");

    //exitProgram
    JButton jBExitProgram = new JButton("End!");
    JButton jBGoToMedia = new JButton("Media");
    JButton jBGoToShowStars = new JButton("Stars");

    //showNumLockPg()
    JTextField jTextFieldPassDigit1 = new JTextField("Required");
    JTextField jTextFieldPassDigit2 = new JTextField("Required");
    JTextField jTextFieldPassDigit3 = new JTextField("Required");
    JLabel jLTextPassResult1 = new JLabel("3rd Two-Digits ");
    JLabel jLTextPassResult2 = new JLabel("3rd Two-Digits ");
    JLabel jLTextPassResult3 = new JLabel("3rd Two-Digits ");
    JLabel jLTextPasslockWarningMessage = new JLabel();
    JLabel jLTextPasslockTreasureMessage = new JLabel();
    
    
    //showFirstHallwayPg();
    JLabel jLTextHallwayMessage = new JLabel();
    JLabel jLTextHallwayMessageShadow = new JLabel();
    JLabel jLPicHallwayBG = new JLabel();

    //showYourRoomPg();
    JLabel jLTextYourRoomMessage = new JLabel();
    JLabel jLTextYourRoomMessageShadow = new JLabel();    
    JLabel jLPicYourRoomBG = new JLabel();
    JLabel jLPicIndoorMap = new JLabel(); //indoor map feature
        
    //showCoinRoomPg();
    JLabel jLPicCoinRoomBG = new JLabel();
    JLabel jLTextCoinRoomMessage= new JLabel();
    JLabel jLTextCoinRoomMessageShadow = new JLabel();
    JLabel jLPicCoin = new JLabel();
    
    //showFirstTonnelPg();
    JLabel jLPicFirstTonnelBG = new JLabel();
    JLabel jLTextFirstTonnelMessage = new JLabel("");
    JLabel jLTextFirstTonnelMessageShadow = new JLabel("");    
    JLabel jLPicCreatureGuard = new JLabel();    
    JLabel jLTextCreatureMessage = new JLabel();
    
    //showLifevistGuardPg();
    JLabel jLPicLifevestBG = new JLabel();
    
    //showBeerRoomPg();
    JLabel jLPicBeerRoomBG = new JLabel();    
    JLabel jLTextBeerRoomMessage = new JLabel();
    JLabel jLTextBeerRoomMessageShadow = new JLabel();
    JLabel jLPicBeer = new JLabel();
    
    //showTonnelOutdoorPg();
    JLabel jLPicTonnelOutdoorBG = new JLabel();
    JLabel jLTextTonnelOutdoorMessage = new JLabel();
    JLabel jLTextTonnelOutdoorMessageShadow = new JLabel();
        
    //showOutdoorMapPg();
    JLabel jLPicOutdoorMapBG = new JLabel();
    
    //showNumLockPg();
    JButton jBUnlock = new JButton("Unlock");
    
    //showOpenGatePg();
    JLabel jLPicOpenGateBG = new JLabel();
    JLabel jLTextOpenGateMessage = new JLabel();
    JLabel jLTextOpenGateMessageShadow = new JLabel();
    
    //showHistoryPg()
    JLabel jLTextHistoryTitle = new JLabel("<< Account History >>");
    JLabel jLTextHistoryLeft = new JLabel();
    JButton jBGoToGameOptionPgNoCalc = new JButton();
    JButton jBCalcHistoryShow = new JButton("Game History");
    
    JButton jBHisotyWriteToDisk = new JButton("Save History");
    JButton jBHisotyReadFromDisk = new JButton("Retrieve History");
    JLabel jLTextHistoryLeftShadow = new JLabel();
    JScrollPane scrollPaneHistory = new JScrollPane();
    JTextArea jLTextHistoryRight = new JTextArea(); //goes inside scrollPaneHistory
    JLabel jLTextSort = new JLabel();

    //CounterShow in all clickable pages
    JLabel jLTextCounterShow = new JLabel();

    
    ////////////////////////////////////////////////////////////
    /////////////PROCESSING VARIABLE DICLARATIONS //////////////
    final int FINAL_MY_WIDTH = 1200,
              FINAL_MY_HEIGHT = 800,
              FINAL_BUTTON_W = 200,
              FINAL_BUTTON_H = 60,
              FINAL_BUTTON_LEFT_X = 90,
              FINAL_BUTTON_RIGHT_X = 880,
              FINAL_BUTTON_CENTER_X = 485,
              FINAL_BUTTON_Y = 630,
              FINAL_BUTTON_Y_LOWER = 670,
              FINAL_BOTTON_Q_W_H = 75,
              FINAL_LEFT_CORNER_X = 0,
              FINAL_BOTTOM_EDGE_Y = 680,
              FINAL_LOCKPASS_TREASURE_TRY= 10,
              FINAL_LOCKPASS_LIMIT_TRY = 15,
              FINAL_CLICK_LIMIT = 50,
              FINAL_RIGHT_CORNER_COUNTER_X = 1010;
    
    final double FINAL_EACH_FEATURE_COST = 1.25,
                 FINAL_DEPOSIT_LIMIT = 1000.0,
                 FINAL_REQUIRED_BALANCE = 25.0,
                 FINAL_EACH_GAME_COST = 25.0,
                 FINAL_WIN_TREASURE_PRISE = 200.0,
                 FINAL_WIN_PRISE = 100.0;
                    
                         
    final String STRING_URL = "library\\";
    
    ArrayList<Integer> arrayLIntClicks = new ArrayList<>();
    
    String stringStartTime,
           stringEndTime,
           stringLoginUsernameEntered = "",
           stringLoginPasswordEntered = "",
           stringNameOfUser,
           stringRegAliasEntered,
           stringRegGenderEntered,
           stringRegAstroEntered,
           userStatus,
           stringJRbAgeLevelSelected = "",
           stringJChBTreasureSelected = "",
           stringJChBKeysSelected = "",
           stringJChBCreatureSelected = "",
           stringSuccessFail = "a failed",
           historyResultString = "",
           unsortedClickString = "",
           unsortedClickMessageString = "",
           sortedClickString = "",
           sortedClickMessageString = "",
           leastAndMostMessageString,
           jLTextHistoryWrite = "",
           writeHistoryString = "";    
    
    int    intRegBirthYEntered = 0,
           intUserAge = 0,
           intCountFeature = 0,
           intSceneNumber = 0,
           intCountGameNum = 0,
           intCountMouseClickEachGame = 0,
           intCountMouseClickTotal = 0,
           intCountEscapedSuccess = 0,
           intCountEscapeFailed = 0,
           intPassSet1 = 0, //showNumLockPg()
           intPassSet2 = 0, //showNumLockPg()
           intPassSet3 = 0, //showNumLockPg()
           intCountPasscodeTries = 0;
    
    
    double doubleDepositRegPg = 0.0,
           doubleDepositGameOptionPg = 0.0,
           doubleAgeLevelCost = 0.0,
           doubleCostBasicFeeAndFeature = 0.0,
           doubleCostFeature = 0.0,
           doubleCostTotalGame = 0.0,
           doubleAccountBalance = 0.0,
           doubleTotalDeposit = 0.0,
           doubleWinningsBalance = 0.0,
           doubleLossesBalance = 0.0;
        
    boolean boolSoundWelcome = false,
            boolSoundGameOption = false,
            boolUserPassValidity = false,
            boolMasterPass = false, //checks if the password is master
            boolFoundCoinTreasure = false, //it checks if the coin treasure is found and not used. 
            boolIndoorMap = false, //This boolean is used to make sure the user cannot go to the next room before the mission of each room is done.
            boolGameover = false,  //if the user has no treasure and is caught with guard will be taken to execution room. Game over
            boolSolutions = false, //if solution button is clicked it becomes true. 
            boolBeerFound = false, //if bottle beer is found, it becomes true to get the outdoor map. 
            boolPassLockMatched1 = false, //1st: if user entry matches the generated passcode
            boolPassLockMatched2 = false, //2nd: if user entry matches the generated passcode
            boolPassLockMatched3 = false, //3rd: if user entry matches the generated passcode
            boolSuccessFailEscape = false, //if user escapes successfully it becomes true
            boolShowHistoryBtn = false,
            boolSwitchColor = false; //switch the color of text between two colors

    

    
    
    //NAME:             main()
    //DESCRIPTION:      main method of the program.
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            Ray_Final_Escape()
    //CALLED BY:        none    
    public static void main(String[] args) throws Exception
    {
        Ray_Final_Escape ray_P2 = new Ray_Final_Escape();
    }

    public Ray_Final_Escape()
    {
        //MAIN JFRAME AND JPANEL DEFUALT SETUP
        setSize(FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        add(jPanelScroll);
        add(jPanelMain);
        
        //FEATURES JFRAME AND JPANEL DEFUALT SETUP
        jFrameFeatures.add(jPanelFeatures);
        jFrameFeatures.setUndecorated(true);
        jFrameFeatures.getRootPane().setWindowDecorationStyle(JRootPane.NONE);        
        
        jBCalcHistoryShow.setEnabled(false); //disable show history button at first. Enable it only if the user plays

        
        displayWelcomeUserPg();
        
//        displayOverviewDescriptionPg();
       
//        displayOverviewRegFeesPg();
        
//        displayLoginUserPg();
        
//        displayRegisterUserPersonalInfoPg();
       
//        displaySelectFeaturesPg();

//        showSummaryExitPg();
        
//        displayRegInfoConfirmPg();

//        showGameOptionsPg();

//        showFirstHallwayPg();

//        showYourRoomPg();;

//        showCoinRoomPg();

//        showFirstTonnelPg();

//        showLifevistGuardPg();

//        showBeerRoomPg();

//        showTonnelOutdoorPg();

//        showOutdoorMapPg();

//        showNumLockPg();

//        showOpenGatePg();

//        showFreedomPg();

//        showHistoryPg();

//        showFailurePg();

//        showIdInfoPg();

//        showStars();
        
//        JOptionPane.showMessageDialog(null, "Stop before System.exit(0);");
//        System.exit(0);
    }

    
    
    //NAME:             displayWelcomeUserPg
    //DESCRIPTION:      welcome page with: Game theme, show current time and Buttons: Overview, Login, Exit
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        Ray_Final_Escape()
    public void displayWelcomeUserPg()
    {     
        //SET JFRAME TITLE
        setTitle("Home Page!");
        show();
        
        jPanelMain.removeAll();
        
        jPanelScroll.setOpaque(false);
        
        if (!boolSoundWelcome)
        {
            try
            {
                clipWelcome = AudioSystem.getClip();
                clipWelcome.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"00-s-start.wav")));
                clipWelcome.start();   
                clipWelcome.loop(10);
                boolSoundWelcome = true; //to stop playing the sound if coming from Overview page
            }

            catch (Exception error)
            {
                JOptionPane.showMessageDialog( null, "Warning: 00-s-start.wav file is not available"
                        + " Error Message - " + error);								
            }
        }
        
        //WELCOME IMAGE - GAME THEME
        JLabel jLabelPicWelcome = new JLabel();
                jLabelPicWelcome.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLabelPicWelcome.setIcon(new ImageIcon(STRING_URL +"001-escape-theme.jpg"));
                
        
        //WELCOME TITLE - Two title for especial effect on font.        
        JLabel jLabelTitle_1 = new JLabel();
                jLabelTitle_1.setText("Welcome To Reza's Game, Escape From");
                jLabelTitle_1.setFont(new Font("Times New Roman", Font.BOLD , 60));
                jLabelTitle_1.setForeground(new Color(4, 13, 183));
                jLabelTitle_1.setBounds(70, 0, 1200, 200);
        JLabel jLabelTitle_2 = new JLabel();
                jLabelTitle_2.setText("Welcome To Reza's Game, Escape From");
                jLabelTitle_2.setFont(new Font("Times New Roman", Font.BOLD , 61));
                jLabelTitle_2.setForeground(new Color(247, 176, 7));
                jLabelTitle_2.setBounds(62, 0, 1200, 200);
                
                
        ////////////////////        
        //CURRENT TIME
        Date thisDate = new Date(); //declare thisDate object
        SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/yy HH:mm:ss"); //declare date and time format
        stringStartTime = dateForm.format(thisDate);  //put date/time into myTime variable
        JLabel jLabelCurrentTime = new JLabel(stringStartTime);  //declare currentTimeJLabel object and set myTime as default
        
        //PRINT OUT CURRENT TIME
        jLabelTextCurrentTime.setForeground(Color.yellow);  //title color
        jLabelTextCurrentTime.setFont(new Font( "Arial", Font.BOLD, 24 )); //title font
        jLabelTextCurrentTime.setBounds(850, 620, 600, 80);  //title bounds        
        jLabelCurrentTime.setForeground(Color.red); //current time color
        jLabelCurrentTime.setFont(new Font( "Harrington", Font.BOLD + Font.ITALIC, 28 )); //current time font
        jLabelCurrentTime.setBounds(900, 670, 250, 50);  //current time bounds  
//        jLabelCurrentTime.setBorder(BorderFactory.createLineBorder(Color.black, 1, rootPaneCheckingEnabled));
        //END CURRENT TIME
        /////////////////////
        
        
                //DECLARE AND PLAY AUDIO
//        URL cd;
//        cd = Ray_Final_Escape.class.getResource("00-s-start.wav");  //import the song file
//        AudioClip cp = Applet.newAudioClip(cd);
//        cp.play();  //Play the music
        //END DECLARE AND PLAY AUDIO

        
        
        //EXIT BUTTON   
        jBRayIdInfoPg.setText("Exit");
        jBRayIdInfoPg.setForeground(Color.red);
        jBRayIdInfoPg.setBackground(Color.BLACK);
        jBRayIdInfoPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 50));
        jBRayIdInfoPg.setOpaque(false);
        jBRayIdInfoPg.setBounds(50, 500, 250, 80);
       
        //OVERVIEW BUTTON
        jBGoOverviewPg1.setText("Overview");
        jBGoOverviewPg1.setForeground(Color.white);
        jBGoOverviewPg1.setBackground(Color.BLACK);
        jBGoOverviewPg1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 50));
        jBGoOverviewPg1.setOpaque(false);
        jBGoOverviewPg1.setBounds(480, 500, 250, 80);

        //LOGIN BUTTON
        jBGoLoginPg.setText("Login Page");
        jBGoLoginPg.setForeground(Color.yellow);
        jBGoLoginPg.setBackground(Color.BLACK);
        jBGoLoginPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 50));
        jBGoLoginPg.setOpaque(false);
        jBGoLoginPg.setBounds(880, 500, 250, 80);

        
        ///////////// BUTTON LISTERNERS /////////////    
        //remove
        jBRayIdInfoPg.removeActionListener(objActionListener);
        jBGoOverviewPg1.removeActionListener(objActionListener);
        jBGoLoginPg.removeActionListener(objActionListener);
        //add
        jBRayIdInfoPg.addActionListener(objActionListener);
        jBGoOverviewPg1.addActionListener(objActionListener);
        jBGoLoginPg.addActionListener(objActionListener);
        
//        jBGoSummaryExitPg.addActionListener(new ListenForButtons());
//        jBGoOverviewPg1.addActionListener(new ListenForButtons());
//        jBGoLoginPg.addActionListener(new ListenForButtons());
//        
        
        ////////////////////////////////////////////////
        //////////// INSTALLATION ON JPANEL ////////////
        
        //RESET JPANEL
        jPanelMain.repaint();

        
        //Welcome message
        jPanelMain.add(jLabelTitle_1);
        jPanelMain.add(jLabelTitle_2);
        
        //Current time
        jPanelMain.add(jLabelCurrentTime);
        jPanelMain.add(jLabelTextCurrentTime);
        
        //Buttons
        jPanelMain.add(jBRayIdInfoPg);
        jPanelMain.add(jBGoOverviewPg1);
        jPanelMain.add(jBGoLoginPg);
        
        //Game theme image
        jPanelMain.add(jLabelPicWelcome);
        
        
    }
    
    
    //NAME:             displayOverviewDescriptionPg
    //DESCRIPTION:      info
    //PARAMETERS:       aUsername << username << displayWelcomeUserPg() << getUsername()
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        Ray_Final_Escape()
    public void displayOverviewDescriptionPg()
    {
                
        //GAME DESCRIPTION 
        String stringGameDescription = "<html> <font size=\"6\" face =\"Garamond\"> <strong> Game Description: </strong> <br> In this game you are a prisoner who is sentenced to death. Several minutes before your execution, you will be informed that you need to escape immediately. Two of the guards will help you with two maps and a lifevest. Of course they won't provide this assistance for free. That’s why I hid a gold coin and a bottle of beer for you to satisfy both the greedy and alchoholic guards. You need to find them and just RUN FOR YOUR LIFE… <br> You have to escape the island BEFORE YOU GET EXECUTED!!!</font> </html>";
        
        
        //GAME INSTRUCTIONS
        String stringGameInstruction = "<html><font size=\"5\" face =\"arial\"> <b>Game Instructions: <br> In order to start playing the game, you need to purchase some Treasures, Creatures and Extra Keys.<br> Click on the <strong/><u>Reg-Fees<u></strong>  button below to see the list and pricing.  </font></html>";
        
        
        
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Overveiw! Page 1");
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBackground(Color.black);
        
        
        //PAGE TITLE SETUP
        JLabel jLableTextTitlePage2 = new JLabel("<< OVERVIEW - Game Description >>");
                jLableTextTitlePage2.setFont(new Font("Courier New", Font.BOLD, 35));
                jLableTextTitlePage2.setForeground(Color.white);
                jLableTextTitlePage2.setBounds(250, 15, 700, 50);
        
                
        //GAME DESCRIPTION SETUP
        JLabel jLableTextDescription = new JLabel(stringGameDescription);
                jLableTextDescription.setForeground(Color.red);
                jLableTextDescription.setBounds(30, 70, 600, 420);
                //setup border to wordwrap the description
                jLableTextDescription.setBorder(BorderFactory.createLineBorder(Color.black, 1, rootPaneCheckingEnabled));
        
        //GAME INSTRUCTIONS SETUP
        JLabel textInstructionJLabel = new JLabel(stringGameInstruction);
                textInstructionJLabel.setForeground(Color.yellow);
                textInstructionJLabel.setBounds(30, 450, 600, 100);
                //setup border to wordwrap the instructions
                textInstructionJLabel.setBorder(BorderFactory.createLineBorder(Color.black, 1, rootPaneCheckingEnabled));
                
                
        //IMAGE SETUP        
        JLabel jLabelPicPunish3 = new JLabel();
                jLabelPicPunish3.setIcon(new ImageIcon(STRING_URL +"01-punish4.gif"));
                jLabelPicPunish3.setBounds(650, 100, 550, 381);
        
        
                

        //HOME BUTTON        
        jBGoHomePg.setForeground(new Color(255, 252, 0));
        jBGoHomePg.setBackground(Color.blue);
        jBGoHomePg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoHomePg.setOpaque(true);
        jBGoHomePg.setBounds(FINAL_BUTTON_LEFT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
        //regFeeButton BUTTON
        jBGoOverviewRegFeePg.setForeground(Color.white);
        jBGoOverviewRegFeePg.setBackground(Color.blue);
        jBGoOverviewRegFeePg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoOverviewRegFeePg.setOpaque(true);
        jBGoOverviewRegFeePg.setBounds(FINAL_BUTTON_RIGHT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        
        ///////////// BUTTON LISTERNERS /////////////   
        //remove
        jBGoOverviewRegFeePg.removeActionListener(objActionListener);
        jBGoHomePg.removeActionListener(objActionListener);
        //add
        jBGoOverviewRegFeePg.addActionListener(objActionListener);
        jBGoHomePg.addActionListener(objActionListener);
                        
        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();

        jPanelMain.add(jLableTextTitlePage2);
        jPanelMain.add(textInstructionJLabel);
        jPanelMain.add(jLableTextDescription);

        jPanelMain.add(jLabelPicPunish3);

        jPanelMain.add(jBGoHomePg);
        jPanelMain.add(jBGoOverviewRegFeePg);

    }
    
    //NAME:             displayOverviewDescriptionPg
    //DESCRIPTION:      info
    //PARAMETERS:       aUsername << username << displayWelcomeUserPg() << getUsername()
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        Ray_Final_Escape()
    public void displayOverviewRegFeesPg()
    {
        String stringAgePriceList = "<html><font size=\"6\" face =\"arial\"> <center> Here are the fees for Escape From Alcatraz   </center> <br> $2.50 for a Mini Player (age under 4) <br> $5.00 for a Junior Player (ages 4 - 12) <br> $7.50 for a Power Player (ages 13 – 17) <br> $9.75 for an Xtreme Player (ages 18 and above)  </font></html>";
        
        String stringFeatureCost = "<html><font size=\"5\" face =\"arial\"> <center> " + usdFormat.format(FINAL_EACH_FEATURE_COST) + " For Each Additional Feature </center> <br> 1- Treasures: Beer bottle, Gold Coin, Lifevest <br> 2- Creatures: Guards <br> 3- Extra Keys: Island's Map, Passcode first digit </font></html>";
        
        
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Overveiw! Page 2");
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBackground(Color.yellow);
        
        
        //PAGE TITLE SETUP
        JLabel jLabelTextTitlePage2 = new JLabel("<< OVERVIEW - Registration Fees >>");
                jLabelTextTitlePage2.setFont(new Font("Courier New", Font.BOLD, 35));
                jLabelTextTitlePage2.setForeground(Color.blue);
                jLabelTextTitlePage2.setBounds(230, 15, 750, 50);
        
                
        //FEES BASED ON AGE SETUP
        JLabel jLabelTextAgePrice = new JLabel(stringAgePriceList);
                jLabelTextAgePrice.setForeground(Color.black);
                jLabelTextAgePrice.setBounds(20, 180, 550, 200);
                //setup border to wordwrap the description
                jLabelTextAgePrice.setBorder(BorderFactory.createLineBorder(Color.yellow, 1, rootPaneCheckingEnabled));
        
        
        //FEATURE COSTS ON AGE SETUP
        JLabel jLabelTextFeature = new JLabel(stringFeatureCost);
                jLabelTextFeature.setForeground(Color.red);
                jLabelTextFeature.setBounds(20, 400, 550, 150);
                //setup border to wordwrap the description
                jLabelTextFeature.setBorder(BorderFactory.createLineBorder(Color.yellow, 1, rootPaneCheckingEnabled));
        
        
                
        //IMAGE FEE SETUP        
        JLabel jLabelPicFee = new JLabel();
                jLabelPicFee.setIcon(new ImageIcon(STRING_URL +"002-fee.jpg"));
                jLabelPicFee.setBounds(3, 3, 158, 158);
        
                
        //IMAGE BEER BOTTLE SETUP        
        JLabel jLabelPicBeer = new JLabel();
                jLabelPicBeer.setIcon(new ImageIcon(STRING_URL +"002-beer.jpg"));
                jLabelPicBeer.setBounds(950, 90, 173, 224);
        
                
        //IMAGE LIFEVEST SETUP        
        JLabel jLabelPicGuard = new JLabel();
                jLabelPicGuard.setIcon(new ImageIcon(STRING_URL +"002-guard-run.jpg"));
                jLabelPicGuard.setBounds(640, 100, 285, 200);
        
                
        //IMAGE GUARD SETUP        
        JLabel jLabelPicMap = new JLabel();
                jLabelPicMap.setIcon(new ImageIcon(STRING_URL +"002-map2.jpg"));
                jLabelPicMap.setBounds(690, 330, 360, 274);
        
                
                
        //BACK BUTTON TO OVERVIEW PAGE 1
        jBGoOverviewPg1.setText("back");
        jBGoOverviewPg1.setForeground(Color.white);
        jBGoOverviewPg1.setBackground(Color.blue);
        jBGoOverviewPg1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoOverviewPg1.setOpaque(true);
        jBGoOverviewPg1.setBounds(FINAL_BUTTON_LEFT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        //HOME BUTTON        
        jBGoHomePg.setForeground(Color.white);
        jBGoHomePg.setBackground(Color.blue);
        jBGoHomePg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoHomePg.setOpaque(true);
        jBGoHomePg.setBounds(FINAL_BUTTON_CENTER_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
        //LOGIN BUTTON
        jBGoLoginPg.setForeground(Color.yellow);
        jBGoLoginPg.setBackground(Color.blue);
        jBGoLoginPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoLoginPg.setOpaque(true);
        jBGoLoginPg.setBounds(FINAL_BUTTON_RIGHT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);


        ///////////// BUTTON LISTERNERS /////////////   
        //remove
        jBGoOverviewPg1.removeActionListener(objActionListener);
        jBGoHomePg.removeActionListener(objActionListener);
        jBGoLoginPg.removeActionListener(objActionListener);
        //add
        jBGoOverviewPg1.addActionListener(objActionListener);
        jBGoHomePg.addActionListener(objActionListener);
        jBGoLoginPg.addActionListener(objActionListener);
                
                
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();

        jPanelMain.add(jLabelTextTitlePage2);
        jPanelMain.add(jLabelTextAgePrice);
        jPanelMain.add(jLabelTextFeature);       
        
        jPanelMain.add(jLabelPicFee);
        jPanelMain.add(jLabelPicBeer);
        jPanelMain.add(jLabelPicGuard);
        jPanelMain.add(jLabelPicMap);
        
        jPanelMain.add(jBGoOverviewPg1);
        jPanelMain.add(jBGoHomePg);
        jPanelMain.add(jBGoLoginPg);
        

    }
    
    
    //NAME:             displayLoginUserPg
    //DESCRIPTION:      info
    //PARAMETERS:       aUsername << username << displayWelcomeUserPg() << getUsername()
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        Ray_Final_Escape()
    public void displayLoginUserPg()
    {
                      
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Login Page!");
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBackground(Color.black);
        
        
        //PAGE TITLE SETUP
        JLabel jLableTextTitle = new JLabel("<< Please Login >>");
                jLableTextTitle.setFont(new Font("Courier New", Font.BOLD, 35));
                jLableTextTitle.setForeground(Color.white);
                jLableTextTitle.setBounds(400, 15, 700, 50);
                
                
        //PROMPT USER TO ENTER USER ID
        String promptMessageString = "<html> Please enter one of the below ID numbers along with your password. <br> 1111, 2222, 3333, 4444, 5555</html>";
        JLabel jLTextMessage = new JLabel(promptMessageString);
                jLTextMessage.setForeground(Color.white);
                jLTextMessage.setFont(new Font("Times New Roman", Font.BOLD, 28));
                jLTextMessage.setBounds(300, 100, 650, 100);
                //setup border to wordwrap the description
//                jLableTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));
        
        //Error Message if user/password is incorrect
        jLTextLoginErrorMessage.setText(null);
        jLTextLoginErrorMessage.setForeground(Color.yellow);
        jLTextLoginErrorMessage.setFont(new Font("Times New Roman", Font.BOLD, 28));
        jLTextLoginErrorMessage.setBounds(450, 300, 650, 100);
        //setup border to wordwrap the description
//        jLTextLoginErrorMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));
        
                
        //PROMPT USER TO ENTER USER ID
        JLabel jLTextID = new JLabel("User ID #: ");
                jLTextID.setForeground(Color.yellow);
                jLTextID.setFont(new Font("Georgia", Font.BOLD, 30));
                jLTextID.setBounds(570, 450, 210, 50);
                //setup border to wordwrap the description
//                jLableTextID.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //ID JTextField DESIGN - declared globally
        jTextFieldID.setForeground(Color.blue);
        jTextFieldID.setFont(new Font("Arial", Font.BOLD, 20));
        jTextFieldID.setBounds(750, 450, 210, 50);
        
        
        //PROMPT USER TO ENTER PASSWORD
        JLabel jLTextPassword = new JLabel("Password: ");
                jLTextPassword.setForeground(Color.yellow);
                jLTextPassword.setFont(new Font("Georgia", Font.BOLD, 30));
                jLTextPassword.setBounds(570, 520, 210, 50);
                //setup border to wordwrap the description
//                jLableTextPassword.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));
                
        //PASSWORD JPasswordField DESIGN - declared globally
        jPasswordFieldID.setForeground(Color.blue);
        jPasswordFieldID.setFont(new Font("Arial", Font.BOLD, 35));
        jPasswordFieldID.setBounds(750, 520, 210, 50);
                
        
        
        //IMAGE SETUP        
        JLabel jLabelPicBackground = new JLabel();
                jLabelPicBackground.setIcon(new ImageIcon(STRING_URL +"003-bg-lines.jpg"));
                jLabelPicBackground.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        
        //IMAGE SETUP        
        JLabel jLabelPicID = new JLabel();
                jLabelPicID.setIcon(new ImageIcon(STRING_URL +"003-id.png"));
                jLabelPicID.setBounds(40, 40, 200, 200);
        
                
                
                
        //EXIT BUTTON
        jBGoSummaryExitPg.setForeground(Color.red);
        jBGoSummaryExitPg.setBackground(Color.blue);
        jBGoSummaryExitPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoSummaryExitPg.setOpaque(true);
        jBGoSummaryExitPg.setBounds(FINAL_BUTTON_LEFT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        //HOME BUTTON        
        jBGoHomePg.setForeground(Color.white);
        jBGoHomePg.setBackground(Color.blue);
        jBGoHomePg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoHomePg.setOpaque(true);
        jBGoHomePg.setBounds(FINAL_BUTTON_CENTER_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
        //LOGIN BUTTON
        jBGoRegPgIfIDValid.setForeground(Color.yellow);
        jBGoRegPgIfIDValid.setBackground(Color.blue);
        jBGoRegPgIfIDValid.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoRegPgIfIDValid.setOpaque(true);
        jBGoRegPgIfIDValid.setBounds(FINAL_BUTTON_RIGHT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoSummaryExitPg.removeActionListener(objActionListener);
        jBGoHomePg.removeActionListener(objActionListener);
        jBGoRegPgIfIDValid.removeActionListener(objActionListener);
        //add
        jBGoSummaryExitPg.addActionListener(objActionListener);
        jBGoHomePg.addActionListener(objActionListener);
        jBGoRegPgIfIDValid.addActionListener(objActionListener);
                
        //FocusListener: make the default text disapear when the field is clicked. 
        jPasswordFieldID.addFocusListener(objFocusGained);
        jTextFieldID.addFocusListener(objFocusGained);
        
        ///////////// END BUTTON LISTERNERS /////////////              
               
        
        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();

        jPanelMain.add(jLableTextTitle);
        jPanelMain.add(jLTextMessage);
        jPanelMain.add(jLTextLoginErrorMessage);
        
        jPanelMain.add(jLTextID);  
        jPanelMain.add(jTextFieldID);
        
        jPanelMain.add(jLTextPassword);
        jPanelMain.add(jPasswordFieldID);

        jPanelMain.add(jBGoSummaryExitPg);
        jPanelMain.add(jBGoHomePg);
        jPanelMain.add(jBGoRegPgIfIDValid);
        
        jPanelMain.add(jLabelPicID);
        jPanelMain.add(jLabelPicBackground);
        
    }
    
    
    
    public boolean methodValidateLoginUserPass ()
    {
        boolean userNameValid = true,
                userPasswordValid = true;
        
        
        stringLoginUsernameEntered = jTextFieldID.getText();
        stringLoginPasswordEntered = jPasswordFieldID.getText();
        
        if (stringLoginPasswordEntered.equals("master"))
            boolMasterPass = true;
        
        
        if (stringLoginPasswordEntered.equals("escape") || stringLoginPasswordEntered.equals("master"))
        {
            switch (stringLoginUsernameEntered)
            {
                case "1111": 
                    stringNameOfUser = "Albert Einstein";
                    break;

                case "2222":
                    stringNameOfUser = "Madame Curie";
                    break;

                case "3333":
                    stringNameOfUser = "Reza";
                    break;

                case "4444":
                    stringNameOfUser = "Behrouz";
                    break;

                case "5555":
                    stringNameOfUser = "Ali";
                    break;

                default:
                {
                    String loginErrorMessage = "<html> Your username/password is invalid.<br> Please try again!</html>";
                    jLTextLoginErrorMessage.setText(loginErrorMessage);

                    jTextFieldID.setText("Enter your ID");
                    jPasswordFieldID.setText("password");

                    userNameValid = false;
                }

            }

        }
        else
        {                
                String loginErrorMessage = "<html> Your username/password is invalid.<br> Please try again!</html>";
                jLTextLoginErrorMessage.setText(loginErrorMessage);

                jTextFieldID.setText("Enter your ID");
                jPasswordFieldID.setText("password");

                userPasswordValid = false;
        }

        //if both username and password are correct
        if(userNameValid && userPasswordValid)
        {
            boolUserPassValidity = true;
        }
            
        return boolUserPassValidity;
        
    }
    
    
    
    //NAME:             displayRegisterUserPersonalInfoPg
    //DESCRIPTION:      info
    //PARAMETERS:       aUsername << username << displayWelcomeUserPg() << getUsername()
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        Ray_Final_Escape()
    public void displayRegisterUserPersonalInfoPg()
    {
        jBGoToFeatureSelectPg.setEnabled(false);
                      
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Registration Page!");
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBackground(new Color(5, 80, 99));
        
        
        //IMAGE SETUP        
        JLabel jLabelPicBackground = new JLabel();
                jLabelPicBackground.setIcon(new ImageIcon(STRING_URL +"004-bg-lines-2.jpg"));
                jLabelPicBackground.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        

        //PAGE TITLE SETUP
        JLabel jLTextTitle = new JLabel("<< Registration Page >>");
                jLTextTitle.setFont(new Font("Courier New", Font.BOLD, 35));
                jLTextTitle.setForeground(Color.white);
                jLTextTitle.setBounds(350, 15, 700, 50);
                
                
        //PROMPT USER TO ENTER USER ID
        String burpBackLoginInfoString = "<html><Blockquote> Thank you " + stringNameOfUser + " for entering your account ID # " + stringLoginUsernameEntered +". Please fill out the form below.</Blockquote> </html>";
        JLabel jLTextLoginBurpBack = new JLabel(burpBackLoginInfoString);
                jLTextLoginBurpBack.setForeground(Color.white);
                jLTextLoginBurpBack.setFont(new Font("Times New Roman", Font.BOLD, 22));
                jLTextLoginBurpBack.setBounds(40, 100, 1100, 50);
                //setup border to wordwrap the description
//                jLTextLoginBurpBack.setBorder(BorderFactory.createLineBorder(Color.yellow, 4, rootPaneCheckingEnabled));
        
      
        //////////////////////////////////////
        ////////////// ALIAS /////////////////
        JLabel jLTextAlias = new JLabel("Alias: ");
                jLTextAlias.setForeground(Color.yellow);
                jLTextAlias.setFont(new Font("Georgia", Font.BOLD, 30));
                jLTextAlias.setBounds(100, 180, 210, 50);
                //setup border to wordwrap the description
//                jLableTextAlias.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //design jTextFiledAlias
        jTextFieldAlias.setForeground(Color.gray);
        jTextFieldAlias.setFont(new Font("Georgia", Font.BOLD, 18));
        jTextFieldAlias.setBounds(220, 180, 210, 50);
        ////////////// END ALIAS /////////////
        //////////////////////////////////////

        

        //////////////////////////////////////
        ////////////// GENDER /////////////////
        JLabel jLTextGender = new JLabel("Gender: ");
                jLTextGender.setForeground(Color.yellow);
                jLTextGender.setFont(new Font("Georgia", Font.BOLD, 30));
                jLTextGender.setBounds(100, 245, 210, 50);
                //setup border to wordwrap the description
//                jLableTextGender.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //design jTextFieldGender
        jTextFieldGender.setForeground(Color.gray);
        jTextFieldGender.setFont(new Font("Georgia", Font.BOLD, 18));
        jTextFieldGender.setBounds(280, 245, 210, 50);
        ////////////// END GENDER ////////////
        //////////////////////////////////////

        
        
        //////////////////////////////////////
        //////////// ASTRO SIGN //////////////
        JLabel jLTextAstroSign = new JLabel("Astrological Sign: ");
                jLTextAstroSign.setForeground(Color.yellow);
                jLTextAstroSign.setFont(new Font("Georgia", Font.BOLD, 22));
                jLTextAstroSign.setBounds(100, 310, 220, 50);
                //setup border to wordwrap the description
//                jLableTextAstroSign.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //design jTextFieldAstroSign
        jTextFieldAstroSign.setForeground(Color.gray);
        jTextFieldAstroSign.setFont(new Font("Georgia", Font.BOLD, 18));
        jTextFieldAstroSign.setBounds(330, 310, 210, 50);
        //////////// END ASTRO SIGN //////////
        //////////////////////////////////////

        
        
        //////////////////////////////////////
        //////////// BIRTH YEAR //////////////
        JLabel jLTextBirthYear = new JLabel("Birth Year: ");
                jLTextBirthYear.setForeground(Color.yellow);
                jLTextBirthYear.setFont(new Font("Georgia", Font.BOLD, 30));
                jLTextBirthYear.setBounds(600, 180, 210, 50);
                //setup border to wordwrap the description
//                jLableTextBirthYear.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //design jTextFieldBirthYear
        jTextFieldBirthYear.setForeground(Color.gray);
        jTextFieldBirthYear.setFont(new Font("Georgia", Font.BOLD, 18));
        jTextFieldBirthYear.setBounds(800, 180, 210, 50);
        //////////// END BIRTH YEAR //////////
        //////////////////////////////////////

        
        
        //////////////////////////////////////
        //////////// DEPOSIT /////////////////
        JLabel jLTextDeposit = new JLabel("Deposit Amount: ");
                jLTextDeposit.setForeground(Color.yellow);
                jLTextDeposit.setFont(new Font("Georgia", Font.BOLD, 30));
                jLTextDeposit.setBounds(600, 245, 280, 50);
                //setup border to wordwrap the description
//                jLableTextDeposit.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //design jTextFieldDeposit
        jTextFieldDeposit.setForeground(Color.gray);
        jTextFieldDeposit.setFont(new Font("Georgia", Font.BOLD, 18));
        jTextFieldDeposit.setBounds(880, 245, 210, 50);
        //////////// END DEPOSIT /////////////
        //////////////////////////////////////
        

        jLTextRegBurpBack.setForeground(Color.white);
        jLTextRegBurpBack.setFont(new Font("Times New Roman", Font.BOLD, 22));
        jLTextRegBurpBack.setBounds(40, 400, 1100, 200);
        //setup border to wordwrap the description
        jLTextRegBurpBack.setBorder(BorderFactory.createLineBorder(Color.yellow, 4, rootPaneCheckingEnabled));


        
        //REGISTER BUTTON
        jBRegisterData.setForeground(Color.black);
        jBRegisterData.setBackground(new Color(41, 196, 235));
        jBRegisterData.setFont(new Font("Arial", Font.ITALIC, 22));
        jBRegisterData.setOpaque(true);
        jBRegisterData.setBounds(830, 320, 160, 50);
                
        //RESET BUTTON        
        jBResetRegForm.setForeground(Color.black);
        jBResetRegForm.setBackground(new Color(41, 196, 235));
        jBResetRegForm.setFont(new Font("Arial", Font.ITALIC, 18));
        jBResetRegForm.setOpaque(true);
        jBResetRegForm.setBounds(640, 320, 160, 50);
                
                                
        //BACK BUTTON
        jBGoLoginPg.setText("Back");
        jBGoLoginPg.setForeground(Color.white);
        jBGoLoginPg.setBackground(Color.blue);
        jBGoLoginPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoLoginPg.setOpaque(true);
        jBGoLoginPg.setBounds(FINAL_BUTTON_LEFT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        //HOME BUTTON        
        jBGoHomePg.setForeground(Color.white);
        jBGoHomePg.setBackground(Color.blue);
        jBGoHomePg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoHomePg.setOpaque(true);
        jBGoHomePg.setBounds(FINAL_BUTTON_CENTER_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
        //CONTINUE FEATURE SELECTION BUTTON
        jBGoToFeatureSelectPg.setForeground(Color.yellow);
        jBGoToFeatureSelectPg.setBackground(Color.blue);
        jBGoToFeatureSelectPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoToFeatureSelectPg.setOpaque(true);
        jBGoToFeatureSelectPg.setBounds(FINAL_BUTTON_RIGHT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBRegisterData.removeActionListener(objActionListener);
        jBResetRegForm.removeActionListener(objActionListener);        
        jBGoLoginPg.removeActionListener(objActionListener);
        jBGoHomePg.removeActionListener(objActionListener);
        jBGoToFeatureSelectPg.removeActionListener(objActionListener);
        //add
        jBRegisterData.addActionListener(objActionListener);
        jBResetRegForm.addActionListener(objActionListener);        
        jBGoLoginPg.addActionListener(objActionListener);
        jBGoHomePg.addActionListener(objActionListener);
        jBGoToFeatureSelectPg.addActionListener(objActionListener);
                
        //FocusListener: make the default text disapear when the field is clicked. 
        jTextFieldAlias.addFocusListener(objFocusGained);
        jTextFieldGender.addFocusListener(objFocusGained);
        jTextFieldAstroSign.addFocusListener(objFocusGained);
        jTextFieldBirthYear.addFocusListener(objFocusGained);
        jTextFieldDeposit.addFocusListener(objFocusGained);
        
        ///////////// END LISTERNERS /////////////              
                
        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextTitle);
        jPanelMain.add(jLTextLoginBurpBack);
        jPanelMain.add(jLTextRegBurpBack);
        
        jPanelMain.add(jLTextAlias);
        jPanelMain.add(jTextFieldAlias);

        jPanelMain.add(jLTextGender);
        jPanelMain.add(jTextFieldGender);

        jPanelMain.add(jLTextAstroSign);
        jPanelMain.add(jTextFieldAstroSign);

        jPanelMain.add(jLTextBirthYear);
        jPanelMain.add(jTextFieldBirthYear);

        jPanelMain.add(jLTextDeposit);
        jPanelMain.add(jTextFieldDeposit);

        jPanelMain.add(jBResetRegForm);
        jPanelMain.add(jBRegisterData);
        
        jPanelMain.add(jBGoLoginPg);
        jPanelMain.add(jBGoHomePg);
        jPanelMain.add(jBGoToFeatureSelectPg);
        
        jPanelMain.add(jLabelPicBackground);

    }    


    public void methodRegisterUser()
    {        
        doubleAccountBalance = 0.0; //reset these two values in case user wants to change the registration values
        doubleDepositRegPg = 0.0;
        
        String burpBackRegInfoString = "";
        String errorAliasString = "";
        String errorAgeString = "";
        String errorDepositString = "";
        String errorUnderAgeString = "";
        
        boolean boolAliasError = true;
        boolean boolAgeError = true;
        boolean boolDepositError = true;
        boolean boolUnderOverAge = false;

        //GET ALIAS, GENDER, ASTRO
        stringRegAliasEntered = jTextFieldAlias.getText().trim();
        stringRegGenderEntered = jTextFieldGender.getText().trim();
        stringRegAstroEntered = jTextFieldAstroSign.getText().trim();
        
        if( !(stringRegAliasEntered.isEmpty() || stringRegAliasEntered.equals("Required") ))
        {
            boolAliasError = false;
            errorAliasString = "";
            jTextFieldAlias.setBorder(null);
        } //END OUTER If statement to check string variables
        
        else //if the String enteries are not valid.
        {
            boolAliasError = true;
            
            errorAliasString = " * Please choose an alias name. <br><br> ";
            
            jTextFieldAlias.setBorder(BorderFactory.createLineBorder(Color.red, 4, rootPaneCheckingEnabled));

            jBGoToFeatureSelectPg.setEnabled(false); //disable next page button
        }
        //END GET ALIAS, GENDER, ASTRO
        
        
        //AGE CHECK 
        try 
        {
            intRegBirthYEntered = Integer.parseInt(jTextFieldBirthYear.getText());
            jTextFieldBirthYear.setBackground(Color.white); //reset bg color after correcting under/over age

            if (intRegBirthYEntered > 1900 && intRegBirthYEntered < currentYear)
            {
                intUserAge = currentYear - intRegBirthYEntered;
                
                if (intUserAge >= 3 && intUserAge <= 103)
                {
                    jBGoToFeatureSelectPg.setEnabled(false); //disable next page button
                    boolAgeError = false; //if age entry is correct. So the error message doesn't show
                    jTextFieldBirthYear.setBorder(null);  //reset border after error border was made

                    intUserAge = currentYear - intRegBirthYEntered; 
                    if(intUserAge < 5)
                        userStatus = "Mini Player";
                    else if (intUserAge < 13)
                        userStatus = "Junior Player";
                    else if (intUserAge < 18)
                        userStatus = "Power Player";
                    else
                        userStatus = "Xtreme Player";
                }   
                else
                {
                    boolUnderOverAge = true; //if user is not under/over age
                    jTextFieldBirthYear.setBackground(Color.orange);
                    jTextFieldBirthYear.setBorder(BorderFactory.createLineBorder(Color.red, 4, rootPaneCheckingEnabled));
                    
                    errorUnderAgeString = "<html><Blockquote> Sorry!!! <br>You are " + intUserAge + " years old and are not allowed to play this game.<br> <br>Players have to be between 3 to 103 years old.</Blockquote> </html>";
                }


            }
            else
            {
                int crash = 1/0; //go to catch              
            }

        } 
        catch (Exception e) 
        {
            boolAgeError = true;
            
            errorAgeString = "* Birth Year entry is not valid. Only numbers between 1901 - 2016. <br> <br>";
            jTextFieldBirthYear.setBorder(BorderFactory.createLineBorder(Color.red, 4, rootPaneCheckingEnabled));
            
            jBGoToFeatureSelectPg.setEnabled(false); //disable next page button
        }
        //END AGE CHECK
        
        
        //DEPOSIT CHECK 
        try 
        {
            doubleDepositRegPg = Double.parseDouble(jTextFieldDeposit.getText()); //store user entry as double
            doubleDepositRegPg = methodRoundToPenny(doubleDepositRegPg); //round the number
            doubleAccountBalance = doubleDepositRegPg;
            doubleTotalDeposit = doubleDepositRegPg;
            
            if (doubleDepositRegPg >= FINAL_REQUIRED_BALANCE && doubleDepositRegPg <= FINAL_DEPOSIT_LIMIT)
            {
                boolDepositError = false;
                jTextFieldDeposit.setBorder(null);  //reset border after error border was made
            }
            else
            {
                int crash = 1/0;
            }
        } 
        catch (Exception e) 
        {
            boolDepositError = true;
            
            errorDepositString = "* Deposit Amount cannot be less than " + usdFormat.format(FINAL_REQUIRED_BALANCE) +" or greater than " + usdFormat.format(FINAL_DEPOSIT_LIMIT) + ". </html>";

            jTextFieldDeposit.setBorder(BorderFactory.createLineBorder(Color.red, 4, rootPaneCheckingEnabled));
            
            jBGoToFeatureSelectPg.setEnabled(false); //disable next page button
        }
        //END DEPOSIT CHECK 
        

        //PRINT THE FINAL MESSAGE IF ALL ENTRIES ARE CORRECT    
        if (!(boolAliasError || boolAgeError || boolDepositError)) //if all error bools are false
        {
            
            String messageGender = "";
            if(stringRegGenderEntered.equals("Optional"))
            {
                messageGender = "";
            }
            else
            {
                messageGender = " and you are " + stringRegGenderEntered;
            }

            String messageAstro = "";
            if(stringRegAstroEntered.equals("Optional"))
            {
                messageAstro = "";
            }
            else
            {
                messageAstro = " with the astrological sign of " + stringRegAstroEntered;
            }

            burpBackRegInfoString = "<html><Blockquote> Thanks, "+ stringNameOfUser + ", for informing us that your alias is " + stringRegAliasEntered + messageGender + messageAstro + ", you were born in " + intRegBirthYEntered + " and are depositing " + usdFormat.format(doubleDepositRegPg) + " into the Alcatraz Escape Game! <br> <br> You are " + intUserAge + " years old and will be considered as a " + userStatus +".</Blockquote> </html>";

            jBGoToFeatureSelectPg.setEnabled(true);
            
        }
        else //PRINT OUT ERRORS IF ANY ENTRY IS INCORRECT
        {
            burpBackRegInfoString = "<html> <Blockquote> " + errorAliasString + errorAgeString + errorDepositString + " </Blockquote><br> </html>"; //combine error messages
        }

        //PRINT OUT THE FINAL MESSAGE. EITHER ERRORS OR FINAL REPORT. CONSIDER UNDER/OVER AGE MESSAGE
        
        //under/over age error message
        if(boolUnderOverAge)
        {
            burpBackRegInfoString = ""; //reset variable
            burpBackRegInfoString = errorUnderAgeString;
        }
        
        //final report or errors
        jLTextRegBurpBack.setText(burpBackRegInfoString); 

        //SWITCH TEXT COLOR WITH EACH CLICK 
        if (boolSwitchColor)
        {
            jLTextRegBurpBack.setForeground(Color.white); 
            boolSwitchColor = false;
        }
        else
        {
            jLTextRegBurpBack.setForeground(Color.orange);
            boolSwitchColor = true;
        }
        //END SWITCH TEXT COLOR WITH EACH CLICK
        
    }
    

    
    public void methodRegisterReset()
    {
        jTextFieldAlias.setText("Required");
        jTextFieldAlias.setForeground(Color.gray);
        jTextFieldAlias.setBorder(null);
        
        jTextFieldGender.setText("Optional");
        jTextFieldGender.setForeground(Color.gray);
        
        jTextFieldAstroSign.setText("Optional");
        jTextFieldAstroSign.setForeground(Color.gray);

        jTextFieldBirthYear.setText("Between 1901 - 2016 ");
        jTextFieldBirthYear.setForeground(Color.gray);
        jTextFieldBirthYear.setBorder(null);

        jTextFieldDeposit.setText("Between $1 - $1000");  
        jTextFieldDeposit.setForeground(Color.gray);
        jTextFieldDeposit.setBorder(null);

        jLTextRegBurpBack.setText("<html><blockquote> Please fill out all fields and then click on the Register button. <br> Your confirmation will appear here.</blockquote> </html>");
        
        jBGoToFeatureSelectPg.setEnabled(false);
    }
  

    
    //NAME:             displaySelectFeaturesPg
    //DESCRIPTION:      info
    //PARAMETERS:       aUsername << username << displayWelcomeUserPg() << getUsername()
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        Ray_Final_Escape()
    public void displaySelectFeaturesPg()
    {       
        //DECLARATIONS FOR TREASURE
        final int CHECKBOX_TREASURE_X = 40 ;
        final int CHECKBOX_KEY_X = 370 ;
        final int CHECKBOX_GUARD_X = 700 ;
        final int CHECKBOX_Y_START = 130;
        final int CHECKBOX_WIDTH = 300;
        final int CHECKBOX_HEIGHT = 120;
                      
        
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Features Page!");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //IMAGE SETUP        
        JLabel jLabelPicBackground = new JLabel();
                jLabelPicBackground.setIcon(new ImageIcon(STRING_URL +"004-bg-lines-2.jpg"));
                jLabelPicBackground.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        

        //PAGE TITLE SETUP
        JLabel jLTextTitle = new JLabel("<< Select Your Desired Features and Game Difficulty >>");
                jLTextTitle.setFont(new Font("Courier New", Font.BOLD, 30));
                jLTextTitle.setForeground(Color.white);
                jLTextTitle.setBounds(100, 15, 1000, 50);

                
    //////////////////////////////////////////////////
    //////////////////////////////////////////////////
    ////////////// AGE FEE JRadioButton //////////////
    
        //DECLARATIONS
        final int JRB_JCB_FONT_SIZE = 19;

        //START CODE
        JLabel jLableTextAgeFee = new JLabel("Choose your Game Level");
                jLableTextAgeFee.setFont(new Font("Times New Roman", Font.BOLD, 28));
                jLableTextAgeFee.setForeground(Color.white);
                

        jrbMiniPlayer.setForeground(Color.yellow);
        jrbMiniPlayer.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jrbMiniPlayer.setOpaque(false);
                
        jrbJuniorPlayer.setForeground(Color.yellow);
        jrbJuniorPlayer.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jrbJuniorPlayer.setOpaque(false);

        jrbPowerPlayer.setForeground(Color.yellow);
        jrbPowerPlayer.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jrbPowerPlayer.setOpaque(false);

        jrbXtremePlayer.setForeground(Color.yellow);
        jrbXtremePlayer.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jrbXtremePlayer.setOpaque(false);

                
        ButtonGroup buttonGroupPlayer = new ButtonGroup();
                buttonGroupPlayer.add(jrbMiniPlayer);
                buttonGroupPlayer.add(jrbJuniorPlayer);
                buttonGroupPlayer.add(jrbPowerPlayer);
                buttonGroupPlayer.add(jrbXtremePlayer);
                
        Box boxJrbPlayer = Box.createVerticalBox();
                boxJrbPlayer.setBounds(700,290,420,170);
                boxJrbPlayer.setBackground(new Color(144, 4, 153));
                boxJrbPlayer.setOpaque(true);
                boxJrbPlayer.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, rootPaneCheckingEnabled));
                    boxJrbPlayer.add(jLableTextAgeFee);
                    boxJrbPlayer.add(jrbMiniPlayer);
                    boxJrbPlayer.add(jrbJuniorPlayer);
                    boxJrbPlayer.add(jrbPowerPlayer);
                    boxJrbPlayer.add(jrbXtremePlayer);
                    
                    
            
        //ERROR MESSAGE IF NO GAME LEVEL IS SELECTED - Or if birth year doesn't match the selected level
        jLTextWarnSelectLevelAndAgeChecker.setForeground(Color.yellow);
        jLTextWarnSelectLevelAndAgeChecker.setFont(new Font("Times New Roman", Font.BOLD, 28));
        jLTextWarnSelectLevelAndAgeChecker.setBounds(510, 470, 650, 150);
        //setup border to wordwrap the description
//        jLTextWarnSelectLevelAndAgeChecker.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));
       

        //////////// END AGE FEE JRadioButton ////////////               
    //////////////////////////////////////////////////
    //////////////////////////////////////////////////

    
    
    
    
    //////////////////////////////////////////////////
    //////////////////////////////////////////////////
    ////////////// TREASURE JCheckBox //////////////
    
        JLabel jLTextTreasure = new JLabel("Select your desired Treasures");
                jLTextTreasure.setFont(new Font("Times New Roman", Font.BOLD, 22));
                jLTextTreasure.setForeground(Color.CYAN);
                jLTextTreasure.setBounds(50, 50, 300, 100);
                
        ///////////// BEER /////////////////        
        jCheckBoxBeer.setForeground(Color.cyan);
        jCheckBoxBeer.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jCheckBoxBeer.setOpaque(false);

        
        jLPicBeer.setIcon(new ImageIcon(STRING_URL +"004-beer-checkbox.jpg"));
                
        Box boxJcBoxBeer = Box.createHorizontalBox();
            boxJcBoxBeer.setBackground(new Color(28, 99, 42));
            boxJcBoxBeer.setBounds(CHECKBOX_TREASURE_X, CHECKBOX_Y_START, CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
            boxJcBoxBeer.setOpaque(true);
            boxJcBoxBeer.setBorder(BorderFactory.createLineBorder(Color.white, 1, rootPaneCheckingEnabled));
                boxJcBoxBeer.add(jLPicBeer);
                boxJcBoxBeer.add(jCheckBoxBeer);
        ///////////// END BEER /////////////////
        
        
        ///////////// COIN /////////////////        
        jCheckBoxCoin.setForeground(Color.cyan);
        jCheckBoxCoin.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jCheckBoxCoin.setOpaque(false);
        
        jLPicCoin.setIcon(new ImageIcon(STRING_URL +"004-coin-checkbox.jpg"));
                
        Box boxJcBoxCoin = Box.createHorizontalBox();
            boxJcBoxCoin.setBackground(new Color(28, 99, 42));
            boxJcBoxCoin.setBounds(CHECKBOX_TREASURE_X, CHECKBOX_Y_START + 120, CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
            boxJcBoxCoin.setOpaque(true);
            boxJcBoxCoin.setBorder(BorderFactory.createLineBorder(Color.white, 1, rootPaneCheckingEnabled));
                boxJcBoxCoin.add(jLPicCoin);
                boxJcBoxCoin.add(jCheckBoxCoin);
        ///////////// END COIN /////////////////
        
        
        ///////////// LIFEVEST /////////////////        
        jCheckBoxLifevest.setForeground(Color.cyan);
        jCheckBoxLifevest.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jCheckBoxLifevest.setOpaque(false);
        
        JLabel jLPicLifevest = new JLabel();
                jLPicLifevest.setIcon(new ImageIcon(STRING_URL +"004-lifevest-checkbox.jpg"));
                
        Box boxJcBoxLifevest = Box.createHorizontalBox();
            boxJcBoxLifevest.setBackground(new Color(28, 99, 42));
            boxJcBoxLifevest.setBounds(CHECKBOX_TREASURE_X, CHECKBOX_Y_START + 240, CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
            boxJcBoxLifevest.setOpaque(true);
            boxJcBoxLifevest.setBorder(BorderFactory.createLineBorder(Color.white, 1, rootPaneCheckingEnabled));
                boxJcBoxLifevest.add(jLPicLifevest);
                boxJcBoxLifevest.add(jCheckBoxLifevest);
        ///////////// END LIFEVEST /////////////////
        
        
    ////////////// END TREASURE JCheckBox //////////////
    //////////////////////////////////////////////////
    //////////////////////////////////////////////////
    
        

    //////////////////////////////////////////////////
    //////////////////////////////////////////////////
    ////////////// KEYS JCheckBox //////////////
    

    JLabel jLTextKey = new JLabel("Select your desired extra Keys");
                jLTextKey.setFont(new Font("Times New Roman", Font.BOLD, 22));
                jLTextKey.setForeground(Color.green);
                jLTextKey.setBounds(380, 50, 300, 100);
                
        ///////////// MAP /////////////////        
        jCheckBoxMap.setForeground(Color.green);
        jCheckBoxMap.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jCheckBoxMap.setOpaque(false);

        
        JLabel jLPicMap = new JLabel();
                jLPicMap.setIcon(new ImageIcon(STRING_URL +"004-map2-checkbox.jpg"));
                
        Box boxJcBoxMap = Box.createHorizontalBox();
            boxJcBoxMap.setBackground(Color.gray);
            boxJcBoxMap.setBounds(CHECKBOX_KEY_X, CHECKBOX_Y_START, CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
            boxJcBoxMap.setOpaque(true);
            boxJcBoxMap.setBorder(BorderFactory.createLineBorder(Color.white, 1, rootPaneCheckingEnabled));
                boxJcBoxMap.add(jLPicMap);
                boxJcBoxMap.add(jCheckBoxMap);
        ///////////// END MAP /////////////////
        
        
        ///////////// PASSCODE /////////////////        
        jCheckBoxPasscode.setForeground(Color.green);
        jCheckBoxPasscode.setFont(new Font("Georgia", Font.BOLD, 17));
        jCheckBoxPasscode.setOpaque(false);
        
        JLabel jLPicPasscode = new JLabel();
                jLPicPasscode.setIcon(new ImageIcon(STRING_URL +"004-passcode-checkbox.jpg"));
                
        Box boxJcBoxPasscode = Box.createHorizontalBox();
            boxJcBoxPasscode.setBackground(Color.gray);
            boxJcBoxPasscode.setBounds(CHECKBOX_KEY_X, CHECKBOX_Y_START + 120, CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
            boxJcBoxPasscode.setOpaque(true);
            boxJcBoxPasscode.setBorder(BorderFactory.createLineBorder(Color.white, 1, rootPaneCheckingEnabled));
                boxJcBoxPasscode.add(jLPicPasscode);
                boxJcBoxPasscode.add(jCheckBoxPasscode);
        ///////////// END PASSCODE /////////////////
        
        
    ////////////// END KEYS JCheckBox //////////////
    //////////////////////////////////////////////////
    //////////////////////////////////////////////////
    
    
    
        
    //////////////////////////////////////////////////
    //////////////////////////////////////////////////
    ////////////// CREATURE JCheckBox //////////////
    

        JLabel jLTextGuard = new JLabel("Adding Extra Guards?");
                jLTextGuard.setFont(new Font("Times New Roman", Font.BOLD, 22));
                jLTextGuard.setForeground(Color.yellow);
                jLTextGuard.setBounds(740, 50, 300, 100);
                
        ///////////// GUARDS /////////////////        
        jCheckBoxGuard.setForeground(Color.yellow);
        jCheckBoxGuard.setFont(new Font("Georgia", Font.BOLD, JRB_JCB_FONT_SIZE));
        jCheckBoxGuard.setOpaque(false);

        
        JLabel jLPicGuard = new JLabel();
                jLPicGuard.setIcon(new ImageIcon(STRING_URL +"004-guard-run-checkbox.jpg"));
                
        Box boxJcBoxGuard = Box.createHorizontalBox();
            boxJcBoxGuard.setBackground(Color.red);
            boxJcBoxGuard.setBounds(CHECKBOX_GUARD_X, CHECKBOX_Y_START, CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
            boxJcBoxGuard.setOpaque(true);
            boxJcBoxGuard.setBorder(BorderFactory.createLineBorder(Color.white, 1, rootPaneCheckingEnabled));
                boxJcBoxGuard.add(jLPicGuard);
                boxJcBoxGuard.add(jCheckBoxGuard);
        ///////////// END MAP /////////////////
        
    ////////////// END CREATURE JCheckBox //////////////
    //////////////////////////////////////////////////
    //////////////////////////////////////////////////
    
        
        
                
        //EXIT BUTTON
        jBGoSummaryExitPg.setForeground(Color.red);
        jBGoSummaryExitPg.setBackground(Color.blue);
        jBGoSummaryExitPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoSummaryExitPg.setOpaque(true);
        jBGoSummaryExitPg.setBounds(FINAL_BUTTON_LEFT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        //BACK TO displayRegisterUserPersonalInfoPg BUTTON 
        jBBackToRegUserInfoPg.setText("Back");
        jBBackToRegUserInfoPg.setForeground(Color.white);
        jBBackToRegUserInfoPg.setBackground(Color.blue);
        jBBackToRegUserInfoPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBBackToRegUserInfoPg.setOpaque(true);
        jBBackToRegUserInfoPg.setBounds(FINAL_BUTTON_CENTER_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
        //SUBMIT ALL FEATURES AND GAME LEVEL BUTTON
        jBSubmitFeaturs.setForeground(Color.yellow);
        jBSubmitFeaturs.setBackground(Color.blue);
        jBSubmitFeaturs.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBSubmitFeaturs.setOpaque(true);
        jBSubmitFeaturs.setBounds(FINAL_BUTTON_RIGHT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

      
        //////////////////////////////////////
        ////////////// ALIAS /////////////////
        JLabel jLTextFeaturePricetag = new JLabel("<html><blockquote> Each extra feature costs " + usdFormat.format(FINAL_EACH_FEATURE_COST) + " </blockquote></html> ");
                jLTextFeaturePricetag.setForeground(Color.white);
                jLTextFeaturePricetag.setBackground(Color.black);
                jLTextFeaturePricetag.setFont(new Font("Georgia", Font.BOLD, 22));
                jLTextFeaturePricetag.setBounds(50, 540, 430, 50);
                jLTextFeaturePricetag.setOpaque(true);
                //setup border to wordwrap the description
                jLTextFeaturePricetag.setBorder(BorderFactory.createLineBorder(Color.orange, 3, rootPaneCheckingEnabled));

        ////////////// END ALIAS /////////////
        //////////////////////////////////////
       
  
        
        ///////////// BUTTON LISTERNERS ///////////// 
        //remove
        jBGoSummaryExitPg.removeActionListener(objActionListener);
        jBBackToRegUserInfoPg.removeActionListener(objActionListener);
        jBSubmitFeaturs.removeActionListener(objActionListener);
        //add
        jBGoSummaryExitPg.addActionListener(objActionListener);
        jBBackToRegUserInfoPg.addActionListener(objActionListener);
        jBSubmitFeaturs.addActionListener(objActionListener);
                

        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        

        jPanelMain.add(jLTextTitle);
        
        
        jPanelMain.add(boxJrbPlayer);
        jPanelMain.add(jLTextWarnSelectLevelAndAgeChecker);
        
        jPanelMain.add(jLTextTreasure);
        jPanelMain.add(boxJcBoxBeer);
        jPanelMain.add(boxJcBoxCoin);
        jPanelMain.add(boxJcBoxLifevest);
        
        jPanelMain.add(jLTextKey);
        jPanelMain.add(boxJcBoxPasscode);
        jPanelMain.add(boxJcBoxMap);
        
        jPanelMain.add(jLTextGuard);
        jPanelMain.add(boxJcBoxGuard);
        
        jPanelMain.add(jLTextFeaturePricetag);
        
        jPanelMain.add(jBGoSummaryExitPg);
        jPanelMain.add(jBBackToRegUserInfoPg);
        jPanelMain.add(jBSubmitFeaturs);
        
        jPanelMain.add(jLabelPicBackground);

        show();

    }
    
    
    public void methodCalcSelectedFeatures ()
    {
        boolean ageMatchesLevel = true;
        boolean levelIsSelected = false;
        intCountFeature = 0;
                
        String loginErrorMessage1 = "<html> Oops!!! Your selected level doesn't match your age of " + intUserAge + ". \nPlease either change your age in the previous page or select the appropriate game level based on your age.</html>";

                //SELECTED JRadioButton
        if (jrbMiniPlayer.isSelected())
        {
            stringJRbAgeLevelSelected = jrbMiniPlayer.getText();
            doubleAgeLevelCost = 2.50;
            
            if (intUserAge > 3)
            {
                jLTextWarnSelectLevelAndAgeChecker.setText(loginErrorMessage1);
                
                ageMatchesLevel = false;
                
            }
            
            levelIsSelected = true;
                
        }
        else if (jrbJuniorPlayer.isSelected())
        {
            stringJRbAgeLevelSelected = jrbJuniorPlayer.getText();
            doubleAgeLevelCost = 5.00;
            
            if (intUserAge < 4 || intUserAge > 12)
            {
                jLTextWarnSelectLevelAndAgeChecker.setText(loginErrorMessage1);
                
                ageMatchesLevel = false;
            }
                
            levelIsSelected = true;
            
        }
        else if (jrbPowerPlayer.isSelected())
        {
            stringJRbAgeLevelSelected = jrbPowerPlayer.getText();
            doubleAgeLevelCost = 7.50;
            
            if (intUserAge < 13 || intUserAge > 17)
            {
                jLTextWarnSelectLevelAndAgeChecker.setText(loginErrorMessage1);
                
                ageMatchesLevel = false;
            }
                
            levelIsSelected = true;

        }
        else if (jrbXtremePlayer.isSelected())
        {
            stringJRbAgeLevelSelected = jrbXtremePlayer.getText();
            doubleAgeLevelCost = 9.75;
            
            if (intUserAge < 18)
            {
                jLTextWarnSelectLevelAndAgeChecker.setText(loginErrorMessage1);

                ageMatchesLevel = false;
            }
                
            levelIsSelected = true;

        }
        
        //SELECTED JCheckBoxes
        if(jCheckBoxBeer.isSelected())
        {
            stringJChBTreasureSelected = "Treasure ";
            intCountFeature++;
        }
        if(jCheckBoxCoin.isSelected())
        {
            stringJChBTreasureSelected = "Treasure ";
            intCountFeature++;
        }
        if(jCheckBoxLifevest.isSelected())
        {
            stringJChBTreasureSelected = "Treasure ";
            intCountFeature++;
        }
        if(jCheckBoxMap.isSelected())
        {
            stringJChBKeysSelected = "Keys";
            intCountFeature++;
        }
        if(jCheckBoxPasscode.isSelected())
        {
            stringJChBKeysSelected = "Keys";
            intCountFeature++;
        }
        if(jCheckBoxGuard.isSelected())
        {
            stringJChBCreatureSelected = "Creature";
            intCountFeature++;
        }
        
        
        //CALCULATE THE COST OF FEATURES
        doubleCostFeature = intCountFeature * FINAL_EACH_FEATURE_COST;
        doubleCostBasicFeeAndFeature = doubleCostFeature + doubleAgeLevelCost;
        doubleCostBasicFeeAndFeature = methodRoundToPenny(doubleCostBasicFeeAndFeature);
        
        System.out.println(doubleCostBasicFeeAndFeature);
        
        
                //CALCULATE SERVICE FEE 10%
        double serviceFee;
        serviceFee = Math.round(doubleCostBasicFeeAndFeature * 10);
        serviceFee = serviceFee / 100;
        
        //TOTAL GAME COST
        doubleCostTotalGame = doubleCostBasicFeeAndFeature + serviceFee;
        

        String burpBackRegFeeString = "<html><Blockquote> So " + stringNameOfUser + ", aka " + stringRegAliasEntered + ", your registration fees are as follows: <br><br> " + usdFormat.format(doubleAgeLevelCost) + " -- Basic Registration fee as " + userStatus + "<br>" + usdFormat.format(doubleCostFeature) + " -- At " + usdFormat.format(FINAL_EACH_FEATURE_COST) + " per feature for " + intCountFeature + " Extra Game Features of <br>" + " &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp " + stringJChBTreasureSelected + " " + stringJChBKeysSelected + " " + stringJChBCreatureSelected + " <br>=====<br> " + usdFormat.format(doubleCostBasicFeeAndFeature) + " -- Subtotal <br> " + usdFormat.format(serviceFee) + "&nbsp -- Rounded ESCAPE Registration Fee of 10% <br>===== <br> " + usdFormat.format(doubleCostTotalGame) + " -- Total ESCAPE Registration Fee.</Blockquote> </html>";

        jLTextRegInfoBurpBack.setText(burpBackRegFeeString);
        
        
        //PRINT OUT SELECT LEVEL WARNING

        if (!levelIsSelected)
        {
            String loginErrorMessage2 = "<html> You have to select a Game Level to continue! </html>";
            jLTextWarnSelectLevelAndAgeChecker.setText(loginErrorMessage2);
        }
        //END PRINT OUT SELECLT LEVEL WARNING    

        //START SWITCH TEXT COLOR
        if (boolSwitchColor)
        {
            jLTextWarnSelectLevelAndAgeChecker.setForeground(Color.yellow);
            boolSwitchColor = false;
        }
        else
        {
            jLTextWarnSelectLevelAndAgeChecker.setForeground(new Color(255, 98, 249));
            boolSwitchColor = true;
        }
        //END SWITCH TEXT COLOR
                
        
        if (ageMatchesLevel && levelIsSelected)
        {
            displayRegInfoConfirmPg();
        }

        
    }
        


    
    public void displayRegInfoConfirmPg()
    {       
                      
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Registration Info Page!");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //PAGE TITLE SETUP
        JLabel jLTextTitle = new JLabel("<< Registration Information >>");
                jLTextTitle.setFont(new Font("Courier New", Font.BOLD, 30));
                jLTextTitle.setForeground(Color.white);
                jLTextTitle.setBounds(310, 15, 1000, 50);
                
                
        //Image BG       
        JLabel jLPicBG = new JLabel();
                jLPicBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"004-bg-lines-2.jpg"));

        //PROMPT USER TO ENTER USER ID
        jLTextRegInfoBurpBack.setForeground(Color.white);
        jLTextRegInfoBurpBack.setFont(new Font("Times New Roman", Font.BOLD, 22));
        jLTextRegInfoBurpBack.setBounds(100, 150, 900, 350);
        //setup border to wordwrap the description
//        jLTextRegInfoBurpBack.setBorder(BorderFactory.createLineBorder(Color.yellow, 4, rootPaneCheckingEnabled));



        //BACK TO displayRegisterUserPersonalInfoPg BUTTON   
        jBBackToRegUserInfoPg.setText("Change Registration");
        jBBackToRegUserInfoPg.setForeground(Color.white);
        jBBackToRegUserInfoPg.setBackground(Color.blue);
        jBBackToRegUserInfoPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 22));
        jBBackToRegUserInfoPg.setOpaque(true);
        jBBackToRegUserInfoPg.setBounds(FINAL_BUTTON_LEFT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        //EXIT BUTTON
        jBGoToGameOptionPgNoRecord.setText("I Agree");
        jBGoToGameOptionPgNoRecord.setForeground(Color.red);
        jBGoToGameOptionPgNoRecord.setBackground(Color.blue);
        jBGoToGameOptionPgNoRecord.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoToGameOptionPgNoRecord.setOpaque(true);
        jBGoToGameOptionPgNoRecord.setBounds(FINAL_BUTTON_RIGHT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        
        ///////////// BUTTON LISTERNERS ///////////// 
        //remove
        jBBackToRegUserInfoPg.removeActionListener(objActionListener);
        jBGoToGameOptionPgNoRecord.removeActionListener(objActionListener);
        //add
        jBBackToRegUserInfoPg.addActionListener(objActionListener);
        jBGoToGameOptionPgNoRecord.addActionListener(objActionListener);
                
        
        
        //RESET AND INSTALLATION ON JPANEL               
        jPanelMain.repaint();
        jPanelMain.add(jLTextTitle);
        jPanelMain.add(jLTextRegInfoBurpBack);
        
        jPanelMain.add(jBBackToRegUserInfoPg);
        jPanelMain.add(jBGoToGameOptionPgNoRecord);
        
        jPanelMain.add(jLPicBG);
    
    }    
    
    
    
    //////////////////////////////////////////////////////////////////////////
    //DESCRIPTION:      get's money variable and round it to nearest penny
    //PARAMETERS:       double aValue << main()
    //RETURNS:          double aValue       
    //CALLS:            none
    //CALLED BY:        main()
    public String displayCreatureMessage()
    {
        String message = "";
        if(boolFoundCoinTreasure)
        {
            message = "<html>You are caught " + stringRegAliasEntered + ", but this is so lucky of you to have the Gold Coin! <br>It's being used to rescue your life.</html>";
            
            boolFoundCoinTreasure = false;
        }
        else
        {
            message = "<html>You are caught " + stringRegAliasEntered + "! Now you'll be taken to the execution room. <br> Sorry!!!</html>";
        
            boolGameover = true;
        }


        return message;  
    }
    
    //////////////////////////////////////////////////////////////////////////
    //DESCRIPTION:      get's money variable and round it to nearest penny
    //PARAMETERS:       double aValue << main()
    //RETURNS:          double aValue       
    //CALLS:            none
    //CALLED BY:        main()
    public String displayWrongClickMessage()
    {
        Random randomMaker = new Random();
        int randomNumber = randomMaker.nextInt(5);
        
        String [] arrayMessage = {"<html><blockquote>I guess you are trying to find a Treasure! It's not here though.</html></blockquote>", 
                             "<html><blockquote>Hmmm, this spot doesn't take you anywhere!</html></blockquote>", 
                             "<html><blockquote>Sometimes you end up hittin a creature by wrong clicks. Be careful!</html></blockquote>", 
                             "<html><blockquote>Oops! You hit something wrong. No worries it's not a creature</html></blockquote>", 
                             "<html><blockquote>Tick Tack! You will either find a Creature or a Treasure by random clicks.</html></blockquote>"};
        
        String message = arrayMessage[randomNumber];
        
        int count = 0;
        count++;
        
        System.out.println("Counter: " + randomNumber);
        
        return message;  
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //NAME:             showGameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here at game options page. BUTTONS: History, Instructions, Play, Exit, Solution 
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showGameOptionsPg()
    {    
        boolSolutions = false; //reset solution to false. 
        jFrameFeatures.dispose();

        methodResetAudioEachGame();  //stop all playing sounds

        if (!boolSoundGameOption) //check to see if the sound is not already played to prevent double-playing
        {
            try
            {
                clipGameOptoin = AudioSystem.getClip();
                    clipGameOptoin.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"00-s-game-option.wav")));
                    clipGameOptoin.start();
                    clipGameOptoin.loop(Clip.LOOP_CONTINUOUSLY); 
                    
                boolSoundGameOption = true;
            }

            catch (Exception error)
            {
                JOptionPane.showMessageDialog( null, "Warning: 00-s-game-option.wav file is not available. \n Make sure all files are in the libraty folder"
                        + " Error Message - " + error);								
            }
            
        }
        
        jLPicFirstTonnelBG.removeMouseListener(objMouseGame);

        setTitle("Play Escape From Alcatraz!");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        jPanelScroll.removeAll();
        
        
        //WELCOME IMAGE - GAME THEME
        JLabel jLPicGameOptions = new JLabel();
                jLPicGameOptions.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLPicGameOptions.setIcon(new ImageIcon(STRING_URL +"011-game-options.gif"));
                

        jLTextAdminUserMode.setText("Your account balance is " + usdFormat.format(doubleAccountBalance));
        jLTextAdminUserMode.setForeground(Color.white);
        jLTextAdminUserMode.setFont(new Font("Arial", Font.BOLD, 20));
        jLTextAdminUserMode.setBounds(FINAL_BUTTON_RIGHT_X-40, FINAL_BUTTON_Y_LOWER, 350, 50);
        //setup border to wordwrap the description
//                jLTextAdminUserMode.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
        
        //EXIT BUTTON
        jBGoSummaryExitPg.setForeground(Color.red);
        jBGoSummaryExitPg.setBackground(Color.black);
        jBGoSummaryExitPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoSummaryExitPg.setOpaque(true);
        jBGoSummaryExitPg.setBounds(FINAL_BUTTON_LEFT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        //HISTORY BUTTON
        jBGoHistoryPg.setForeground(Color.white);
        jBGoHistoryPg.setBackground(Color.black);
        jBGoHistoryPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoHistoryPg.setOpaque(true);
        jBGoHistoryPg.setBounds(FINAL_BUTTON_RIGHT_X, 50, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
        //PLAY BUTTON
        jBGoPlayPg.setForeground(Color.yellow);
        jBGoPlayPg.setBackground(Color.black);
        jBGoPlayPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 60));
        jBGoPlayPg.setOpaque(false);
        jBGoPlayPg.setBounds(FINAL_BUTTON_CENTER_X, 250, FINAL_BUTTON_W, 100);
                
        //INSTRUCTIONS BUTTON
        jBGoInstructionPg.setForeground(Color.white);
        jBGoInstructionPg.setBackground(Color.black);
        jBGoInstructionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoInstructionPg.setOpaque(true);
        jBGoInstructionPg.setBounds(FINAL_BUTTON_LEFT_X, 50, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
        //SOLUTIONS BUTTON
        if(!boolMasterPass)           
            jBSolutionPath.setVisible(false);
        jBSolutionPath.setForeground(Color.white);
        jBSolutionPath.setBackground(Color.black);
        jBSolutionPath.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBSolutionPath.setOpaque(true);
        jBSolutionPath.setBounds(FINAL_BUTTON_CENTER_X, FINAL_BUTTON_Y_LOWER, FINAL_BUTTON_W, FINAL_BUTTON_H);
               
        //ADD MONEY BUTTON
        if(!boolMasterPass)           
            jBSecondDeposit.setVisible(true);
        if(doubleAccountBalance >= FINAL_REQUIRED_BALANCE)
            jBSecondDeposit.setEnabled(false);
        else
            jBSecondDeposit.setEnabled(true);
        jBSecondDeposit.setForeground(Color.white);
        jBSecondDeposit.setBackground(Color.black);
        jBSecondDeposit.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBSecondDeposit.setOpaque(true);
        jBSecondDeposit.setBounds(FINAL_BUTTON_RIGHT_X-60, FINAL_BUTTON_Y-30, FINAL_BUTTON_W, FINAL_BUTTON_H);
                
        //ADD MONEY JTextField DESIGN - declared globally
        if(doubleAccountBalance >= FINAL_REQUIRED_BALANCE)
            jTextFieldSecondDeposit.setEditable(false);
        else
            jTextFieldSecondDeposit.setEditable(true);
        jTextFieldSecondDeposit.setForeground(Color.gray);
        jTextFieldSecondDeposit.setFont(new Font("Arial", Font.BOLD, 20));
        jTextFieldSecondDeposit.setBounds(1030, FINAL_BUTTON_Y-25, 100, 50);
        
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoSummaryExitPg.removeActionListener(objActionListener);
        jBGoHistoryPg.removeActionListener(objActionListener);
        jBGoPlayPg.removeActionListener(objActionListener);
        jBGoInstructionPg.removeActionListener(objActionListener);
        jBSolutionPath.removeActionListener(objActionListener);
        jBSecondDeposit.removeActionListener(objActionListener);
        //add
        jBGoSummaryExitPg.addActionListener(objActionListener);
        jBGoHistoryPg.addActionListener(objActionListener);
        jBGoPlayPg.addActionListener(objActionListener);
        jBGoInstructionPg.addActionListener(objActionListener);
        jBSolutionPath.addActionListener(objActionListener);
        jBSecondDeposit.addActionListener(objActionListener);
        
        //FocusListener
        jTextFieldSecondDeposit.addFocusListener(objFocusGained);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextAdminUserMode);

        jPanelMain.add(jBGoSummaryExitPg);
        jPanelMain.add(jBGoHistoryPg);
        jPanelMain.add(jBGoPlayPg);
        jPanelMain.add(jBGoInstructionPg);
        jPanelMain.add(jBSolutionPath);
        jPanelMain.add(jBSecondDeposit);
        
        jPanelMain.add(jTextFieldSecondDeposit);
        
        jPanelMain.add(jLPicGameOptions);
        
    }


    //////////////////////////////////////////////////////////////////////////
    //DESCRIPTION:      get's money variable and round it to nearest penny
    //PARAMETERS:       double aValue << main()
    //RETURNS:          double aValue       
    //CALLS:            none
    //CALLED BY:        main()
    public void methodCheckBalanceAndDeposit()
    {
        double secondDeposit = 0.0;

        try 
        {
            secondDeposit = Double.parseDouble(jTextFieldSecondDeposit.getText());
            
            if (secondDeposit <= FINAL_DEPOSIT_LIMIT)
            {
                secondDeposit = methodRoundToPenny(secondDeposit);

                doubleAccountBalance += secondDeposit;

                doubleTotalDeposit += secondDeposit;  //calculate total of deposits

                jLTextAdminUserMode.setText("<html>You've added " + usdFormat.format(secondDeposit) 
                                            + " <br> Your new balance is " +usdFormat.format(doubleAccountBalance));

                if(doubleAccountBalance >= FINAL_REQUIRED_BALANCE)
                {
                    jLTextLowBalanceMessage.setVisible(false);
                    jBGoPlayPg.setEnabled(true);
                    jBSecondDeposit.setEnabled(false);
                    jTextFieldSecondDeposit.setEditable(false);
                }
            }

            else
                jLTextAdminUserMode.setText("<html>You cannot deposit more than " + usdFormat.format(FINAL_DEPOSIT_LIMIT) + "!</html>");

        } 
        catch (Exception e) 
        {
            jLTextAdminUserMode.setText("<html>Your entry is not valid. <br>Please enter a number only.</html>");

        }

    }
    

    public void showInstructionPg()
    {       
                      
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Game Instructions!");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //PAGE TITLE SETUP
        JLabel jLTextTitle = new JLabel("<< Game Instructions >>");
                jLTextTitle.setFont(new Font("Courier New", Font.BOLD, 30));
                jLTextTitle.setForeground(Color.white);
                jLTextTitle.setBounds(400, 15, 1000, 50);
                
        //Image BG       
        JLabel jLPicBG = new JLabel();
                jLPicBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"040-history-bg.jpg"));

                
        //INSTRUCTIONS DESCRIPTION
        String stringIntructions = "<html><font size=\"5\" face =\"arial\"> "
                + "After starting the game, your goal would be to escape from Alcatraz before your execution. Each game will cost you " + usdFormat.format(FINAL_EACH_GAME_COST) + ". If you don't have enough funds, you can deposit some money using the provided field in the main page. <br><br> "
                + "Except one page (Passcode Lock Room) the game is based on mouse clicks. You need to click on different spots in each room to find treasures, next room entrance, back to the previous room, etc. Avoid all random clicks because there are some spots that would call the Jail Guards as well. You need to double think before any click to not get caught! <br><br>"
                + "<span color='yellow'>Important Notes:</span><br>"
                + "&nbsp; &nbsp; &nbsp; 1- Try to find the gold coin treasure which is put in some of the rooms. If you escape the jail, it would add " + usdFormat.format(FINAL_WIN_TREASURE_PRISE) + " into your account balance. Also in case of getting caught, you can give it to the guard as a bribe to leave. <br><br>"
                + "&nbsp; &nbsp; &nbsp; 2- You have to escape in less than " + FINAL_CLICK_LIMIT + " clicks to not get caught. <br>Again, if you are cought at any point you'll be sent to the execution room! <br><br>"
                + "&nbsp; &nbsp; &nbsp; 3- Make sure your clicks are registered by hearing a sound feedback from your computer's speakers to make sure your clicks are registered properly and counted. <br> <br>"
                + "&nbsp; &nbsp; &nbsp; 4- If you escape successfully, " + usdFormat.format(FINAL_WIN_PRISE) + " will be added to your balance as a reward.<br><br>"
                + "<span color='yellow'>HISTORY: </span><br>"
                + "&nbsp; &nbsp; &nbsp; If you've played this game before, you can Retrieve your previous game record to continue your last game. Otherwise, you need to store your game record through the History page before closing the game completely. <br> <br>"
                + "&nbsp; &nbsp; &nbsp; You can also see a brief summary of your games, number of clicks, game start/end time, fails and winns records, balance, etc. in the History Page."
                + "</font></html>";
        
        JLabel jLTextInstruction = new JLabel();
                jLTextInstruction.setText(stringIntructions);
                jLTextInstruction.setForeground(Color.white);
                jLTextInstruction.setBounds(100, 80, 1000, 600);
                //setup border to wordwrap the description
//                jLTextInstruction.setBorder(BorderFactory.createLineBorder(Color.yellow, 4, rootPaneCheckingEnabled));


        //BACK BUTTON
        jBGoToGameOptionPgNoCalc.setText("Back");
        jBGoToGameOptionPgNoCalc.setForeground(Color.red);
        jBGoToGameOptionPgNoCalc.setBackground(Color.black);
        jBGoToGameOptionPgNoCalc.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoToGameOptionPgNoCalc.setOpaque(false);
        jBGoToGameOptionPgNoCalc.setBounds(FINAL_LEFT_CORNER_X-5, FINAL_BOTTOM_EDGE_Y+10, FINAL_BOTTON_Q_W_H+30, FINAL_BOTTON_Q_W_H);
        
        
        ///////////// BUTTON LISTERNERS ///////////// 
        //remove
        jBGoToGameOptionPgNoCalc.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPgNoCalc.addActionListener(objActionListener);
                
                
        
        
        //RESET AND INSTALLATION ON JPANEL               
        jPanelMain.repaint();
        jPanelMain.add(jLTextTitle);
        jPanelMain.add(jLTextInstruction);
        
        jPanelMain.add(jBGoToGameOptionPgNoCalc);
        
        jPanelMain.add(jLPicBG);
    
    }     
    
    

    //NAME:             showFirstHallwayPg
    //DESCRIPTION:      First hallway to enter the game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showFirstHallwayPg()
    {
        boolSoundGameOption = false; //to let sound in GameOptionPage play again
        
        setTitle("First Hallway");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        try {
            clipGameOptoin.stop();
        } catch (Exception e) {
            System.out.println("ClipGameOption didn't stop");
        }
        
        try
        {
            cliphHallway = AudioSystem.getClip();
            cliphHallway.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"s-jail.wav")));
            cliphHallway.start();
            cliphHallway.loop(1000);
        }

        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: s-jail.wav file is not available"
                    + " Error Message - " + error);								
        }

        //BG IMAGE
        jLPicHallwayBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        if (boolMasterPass && boolSolutions)
            jLPicHallwayBG.setIcon(new ImageIcon(STRING_URL +"012-enter-hall-master.jpg"));
        else
            jLPicHallwayBG.setIcon(new ImageIcon(STRING_URL +"012-enter-hall.jpg"));
            
        //TITLE        
        JLabel jLTextTitle = new JLabel("WELCOME TO ALCATRAZ " + stringNameOfUser + "!");
                jLTextTitle.setForeground(Color.red);
                jLTextTitle.setFont(new Font("Impact", Font.BOLD, 50));
                jLTextTitle.setBounds(100, 50, 1000, 100);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));
        
        //TITLE SHADOW
        JLabel jLTextTitleShadow = new JLabel("WELCOME TO ALCATRAZ " + stringNameOfUser + "!");
                jLTextTitleShadow.setForeground(Color.black);
                jLTextTitleShadow.setFont(new Font("Impact", Font.BOLD, 49));
                jLTextTitleShadow.setBounds(106, 56, 1000, 100);
                //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE
        String hallMessageString = "<html> <blockquote> You will be executed shortly after entering your room. "
                                    + "You have to escape before you're caught! The guards will apprehend you if you exceed 50 clicks! <br> (" + usdFormat.format(FINAL_REQUIRED_BALANCE) 
                                    + " will be deducted from your balance) </blockquote> </html>";
        jLTextHallwayMessage.setText(hallMessageString);
        jLTextHallwayMessage.setForeground(Color.white);
        jLTextHallwayMessage.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextHallwayMessage.setBounds(150, 150, 630, 200);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

//MESSAGE SHADOW
        jLTextHallwayMessageShadow.setText(hallMessageString);
        jLTextHallwayMessageShadow.setForeground(Color.black);
        jLTextHallwayMessageShadow.setBackground(Color.red);
        jLTextHallwayMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextHallwayMessageShadow.setBounds(145, 150, 630, 200);
        jLTextHallwayMessageShadow.setOpaque(true);
        //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));


        //COUNTER: Certain number of clicks left to gameover. 
        jLTextCounterShow.setText(FINAL_CLICK_LIMIT + " Clicks Left");
        jLTextCounterShow.setForeground(Color.white);
        jLTextCounterShow.setFont(new Font("Arial", Font.BOLD, 22));
        jLTextCounterShow.setBounds(FINAL_RIGHT_CORNER_COUNTER_X, FINAL_BOTTOM_EDGE_Y+20, 180, 50);
        jLTextCounterShow.setOpaque(false);
                
                
        //PLAY BUTTON        
        jBGoToGameOptionPgNoCalc.setText("Quit");
        jBGoToGameOptionPgNoCalc.setForeground(Color.red);
        jBGoToGameOptionPgNoCalc.setBackground(Color.black);
        jBGoToGameOptionPgNoCalc.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPgNoCalc.setOpaque(true);
        jBGoToGameOptionPgNoCalc.setBounds(FINAL_LEFT_CORNER_X, FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPgNoCalc.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPgNoCalc.addActionListener(objActionListener);

        //addMouseListener: Clicked
        jLPicHallwayBG.removeMouseListener(objMouseHallway);
        jLPicHallwayBG.addMouseListener(objMouseHallway);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextTitle);
        jPanelMain.add(jLTextTitleShadow);
        jPanelMain.add(jLTextHallwayMessage);
        jPanelMain.add(jLTextHallwayMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPgNoCalc);
        
        jPanelMain.add(jLPicHallwayBG);
        
    }

    

    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showYourRoomPg()
    {
        setTitle("Your Room");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
            jLPicYourRoomBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        if (boolMasterPass && boolSolutions)
            jLPicYourRoomBG.setIcon(new ImageIcon(STRING_URL +"013-room-master.jpg"));
        else
            jLPicYourRoomBG.setIcon(new ImageIcon(STRING_URL +"013-room.jpg"));
                
        
        String roomMessageString = "<html> Now you're in your room " + stringNameOfUser + ".<br> Find the indoor map in your room. It will show you the way to the Mess Hall.<br><br>"
                                + "Push one of the bricks between your toilet and the light. </html>";
        
        String roomMessageElse = "<html> Why are you back?! You already have the map. </html>";
        //MESSAGE
        if (!boolIndoorMap)
            jLTextYourRoomMessage.setText(roomMessageString);
        else
            jLTextYourRoomMessage.setText(roomMessageElse);            
        jLTextYourRoomMessage.setForeground(Color.white);
        jLTextYourRoomMessage.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextYourRoomMessage.setBounds(14, 10, 550, 200);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        if (!boolIndoorMap)
            jLTextYourRoomMessageShadow.setText(roomMessageString);
        else
            jLTextYourRoomMessageShadow.setText(roomMessageElse);
        jLTextYourRoomMessageShadow.setForeground(Color.black);
        jLTextYourRoomMessageShadow.setBackground(Color.red);
        jLTextYourRoomMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextYourRoomMessageShadow.setBounds(10, 10, 550, 200);
        jLTextYourRoomMessageShadow.setOpaque(false);
        //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        

        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(true);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);

        //MouseListener: Clicked 
        jLPicYourRoomBG.removeMouseListener(objMouseGame);
        jLPicYourRoomBG.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextYourRoomMessage);
        jPanelMain.add(jLTextYourRoomMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicYourRoomBG);
                
    }

    

    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showCoinRoomPg()
    {
        setTitle("Treasure - Gold Coin");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        jLPicCoinRoomBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        if (boolMasterPass && boolSolutions)
            jLPicCoinRoomBG.setIcon(new ImageIcon(STRING_URL +"014-coin-room-master.jpg"));
        else    
            jLPicCoinRoomBG.setIcon(new ImageIcon(STRING_URL +"014-coin-room.jpg"));
                
        

        //MESSAGE
        jLTextCoinRoomMessage.setText("");
        jLTextCoinRoomMessage.setForeground(Color.yellow);
        jLTextCoinRoomMessage.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextCoinRoomMessage.setBounds(300, 550, 800, 200);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        jLTextCoinRoomMessageShadow.setText("");
        jLTextCoinRoomMessageShadow.setForeground(Color.black);
        jLTextCoinRoomMessageShadow.setBackground(Color.gray);
        jLTextCoinRoomMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextCoinRoomMessageShadow.setBounds(300, 550, 800, 200);
        jLTextCoinRoomMessageShadow.setOpaque(false);
        //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                
        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(true);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);

        //MouseListener: clicked 
        jLPicCoinRoomBG.removeMouseListener(objMouseGame);
        jLPicCoinRoomBG.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextCoinRoomMessage);
        jPanelMain.add(jLTextCoinRoomMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicCoinRoomBG);
                
    }

    
    

    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showFirstTonnelPg()
    {
        setTitle("Tonnel");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        jLPicFirstTonnelBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        if (boolMasterPass && boolSolutions)
            jLPicFirstTonnelBG.setIcon(new ImageIcon(STRING_URL +"015-tonnel-master.jpg"));
        else
            jLPicFirstTonnelBG.setIcon(new ImageIcon(STRING_URL +"015-tonnel.jpg"));
                
        

        //MESSAGE
        String messageString = "<html> <blockquote>You are saving your life " + stringRegAliasEntered + "! Just RUUUNNNN… <br> The guard with a lifevest is waiting for you in the dark. You'll need this lifevest to escape from the island.</blockquote></html>";
        jLTextFirstTonnelMessage.setText(messageString);
        jLTextFirstTonnelMessage.setForeground(Color.white);
        jLTextFirstTonnelMessage.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextFirstTonnelMessage.setBounds(14, 10, 650, 160);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        jLTextFirstTonnelMessageShadow.setText(messageString);
        jLTextFirstTonnelMessageShadow.setForeground(Color.red);
        jLTextFirstTonnelMessageShadow.setBackground(Color.black);
        jLTextFirstTonnelMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextFirstTonnelMessageShadow.setBounds(10, 10, 650, 160);
        jLTextFirstTonnelMessageShadow.setOpaque(true);
        //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                
        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(true);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);

        //MouseListener: clicked 
        jLPicFirstTonnelBG.removeMouseListener(objMouseGame);
        jLPicFirstTonnelBG.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextFirstTonnelMessage);
        jPanelMain.add(jLTextFirstTonnelMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicFirstTonnelBG);
                
    }

    
    

    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showLifevistGuardPg()
    {
        setTitle("Lifevest Guard");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        jLPicLifevestBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        if (boolMasterPass && boolSolutions)
            jLPicLifevestBG.setIcon(new ImageIcon(STRING_URL +"016-lifevest-guard-master.jpg"));
        else
            jLPicLifevestBG.setIcon(new ImageIcon(STRING_URL +"016-lifevest-guard.jpg"));
                
        
        //GUARD TITLE
        JLabel jLTextGuardTitle = new JLabel("Guard:");
                jLTextGuardTitle.setForeground(Color.yellow);
                jLTextGuardTitle.setFont(new Font("Times New Roman", Font.BOLD, 26));
                jLTextGuardTitle.setBounds(590, 490, 550, 160);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));


        //MESSAGE
        String messageString = "<html> I can't believe you made it up to here " + stringRegAliasEntered + "! <br>Take this jacket and run away. </html>";
        JLabel jLTextMessage = new JLabel(messageString);
                jLTextMessage.setForeground(Color.white);
                jLTextMessage.setFont(new Font("Arial", Font.BOLD, 26));
                jLTextMessage.setBounds(600, 550, 550, 160);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        JLabel jLTextMessageShadow = new JLabel(messageString);
                jLTextMessageShadow.setForeground(Color.black);
                jLTextMessageShadow.setBackground(Color.red);
                jLTextMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
                jLTextMessageShadow.setBounds(595, 550, 550, 160);
                jLTextMessageShadow.setOpaque(false);
                //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                
        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.white);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(true);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);

        //MouseListener: clicked 
        jLPicLifevestBG.removeMouseListener(objMouseGame);
        jLPicLifevestBG.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextGuardTitle);
        jPanelMain.add(jLTextMessage);
        jPanelMain.add(jLTextMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicLifevestBG);
                
    }

    

    

    //NAME:             showBeerRoomPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showBeerRoomPg()
    {
        setTitle("Beer Bottle Room");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        jLPicBeerRoomBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
    if (boolMasterPass && boolSolutions)
        jLPicBeerRoomBG.setIcon(new ImageIcon(STRING_URL +"017-beer-room-master.jpg"));
    else
        jLPicBeerRoomBG.setIcon(new ImageIcon(STRING_URL +"017-beer-room.jpg"));
                
        

    //MESSAGE
    String messageString = "<html> Find a beer bottle in this room. You need to give it to that alcoholic guard. He will give you the outdoor island map. It’s helpful for escaping from the island.  </html>";
        jLTextBeerRoomMessage.setText(messageString);
        jLTextBeerRoomMessage.setForeground(Color.white);
        jLTextBeerRoomMessage.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextBeerRoomMessage.setBounds(14, 10, 550, 160);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

    //MESSAGE SHADOW
        jLTextBeerRoomMessageShadow.setText(messageString);
        jLTextBeerRoomMessageShadow.setForeground(Color.black);
        jLTextBeerRoomMessageShadow.setBackground(Color.red);
        jLTextBeerRoomMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextBeerRoomMessageShadow.setBounds(10, 10, 550, 160);
        jLTextBeerRoomMessageShadow.setOpaque(false);
        //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                
        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(true);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);

        //MouseListener: clicked 
        jLPicBeerRoomBG.removeMouseListener(objMouseGame);
        jLPicBeerRoomBG.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextBeerRoomMessage);
        jPanelMain.add(jLTextBeerRoomMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicBeerRoomBG);
                
    }

    


    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showTonnelOutdoorPg()
    {
        setTitle("Tonnel To Outside");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        jLPicTonnelOutdoorBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
    if (boolMasterPass && boolSolutions)
        jLPicTonnelOutdoorBG.setIcon(new ImageIcon(STRING_URL +"018-tonnel-out-master.jpg"));
    else
        jLPicTonnelOutdoorBG.setIcon(new ImageIcon(STRING_URL +"018-tonnel-out.jpg"));
                
        

        //MESSAGE
            String messageString = "<html><blockquote> RUN RUN RUN… <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; JUST RUNNNN… </blockquote></html>";
        jLTextTonnelOutdoorMessage.setText(messageString);
        jLTextTonnelOutdoorMessage.setForeground(Color.white);
        jLTextTonnelOutdoorMessage.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextTonnelOutdoorMessage.setBounds(14, 10, 450, 100);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        jLTextTonnelOutdoorMessageShadow.setText(messageString);
        jLTextTonnelOutdoorMessageShadow.setForeground(Color.red);
        jLTextTonnelOutdoorMessageShadow.setBackground(Color.black);
        jLTextTonnelOutdoorMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextTonnelOutdoorMessageShadow.setBounds(10, 10, 450, 100);
        jLTextTonnelOutdoorMessageShadow.setOpaque(true);
        //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                
        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(true);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);

        //MouseListener: clicked 
        jLPicTonnelOutdoorBG.removeMouseListener(objMouseGame);
        jLPicTonnelOutdoorBG.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextTonnelOutdoorMessage);
        jPanelMain.add(jLTextTonnelOutdoorMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicTonnelOutdoorBG);
                
    }

    


    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showOutdoorMapPg()
    {
        setTitle("Outdoor Map");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        jLPicOutdoorMapBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        if (boolBeerFound)
            jLPicOutdoorMapBG.setIcon(new ImageIcon(STRING_URL +"019-outdoor-map-guard.jpg"));
        else
            jLPicOutdoorMapBG.setIcon(new ImageIcon(STRING_URL +"019-outdoor-guard.jpg"));
                
                
        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(true);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        jBGoToGameOptionPg.addActionListener(objActionListener);

        //MouseListener: clicked 
        jLPicOutdoorMapBG.removeMouseListener(objMouseGame);
        jLPicOutdoorMapBG.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicOutdoorMapBG);
                
    }

    

    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showNumLockPg()
    {
        final int X_TITLE = 750,
                  X_FIELD = 940,
                  X_RESULT = 1050,
                  Y1 = 350,
                  Y2 = 410,
                  Y3 = 470;
        
        
        setTitle("Number Lock");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        JLabel jLPicBG = new JLabel();
                jLPicBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
            if (boolMasterPass && boolSolutions)
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"020-num-lock-master.jpg"));
            else
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"020-num-lock.jpg"));
                
        

        //MESSAGE
        String messageString1 = "<html> Hurry up! The only thing between you and freedom are three sets of Two-Digits numbers as a passcode. </html>";
        JLabel jLTextMessage = new JLabel(messageString1);
                jLTextMessage.setForeground(Color.white);
                jLTextMessage.setFont(new Font("Arial", Font.BOLD, 26));
                jLTextMessage.setBounds(400, 20, 700, 100);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        JLabel jLTextMessageShadow = new JLabel(messageString1);
                jLTextMessageShadow.setForeground(Color.red);
                jLTextMessageShadow.setBackground(Color.black);
                jLTextMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
                jLTextMessageShadow.setBounds(395, 20, 700, 100);
                jLTextMessageShadow.setOpaque(false);
                //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE
        String messageString2 = "<html> Hint: <br> As it’s shown on the lock, each two-digits number is among 00, 10, y,… up to 90. <br> It is possible to to trick the passlock using a formula. Think of it then put your two-digits guesses in each field and hit the Unlock button!</html>";
        JLabel jLTextInstructions = new JLabel(messageString2);
                jLTextInstructions.setForeground(Color.white);
                jLTextInstructions.setFont(new Font("Arial", Font.BOLD, 20));
                jLTextInstructions.setBounds(450, 120, 700, 150);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        JLabel jLTextInstructionsShadow = new JLabel(messageString2);
                jLTextInstructionsShadow.setForeground(Color.blue);
                jLTextInstructionsShadow.setBackground(Color.black);
                jLTextInstructionsShadow.setFont(new Font("Arial", Font.BOLD, 20));
                jLTextInstructionsShadow.setBounds(445, 120, 700, 150);
                jLTextInstructionsShadow.setOpaque(false);
                //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
        //1ST PASSCODES TITLE
        JLabel jLTextDigit1 = new JLabel("1st Two-Digits ");
                jLTextDigit1.setForeground(Color.yellow);
                jLTextDigit1.setFont(new Font("Georgia", Font.BOLD, 24));
                jLTextDigit1.setBounds(X_TITLE, Y1, 200, 50);
                //setup border to wordwrap the description
//                jLTextDigit1.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //1ST JTextField DESIGN - declared globally
        jTextFieldPassDigit1.setForeground(Color.gray);
        jTextFieldPassDigit1.setFont(new Font("Arial", Font.BOLD, 20));
        jTextFieldPassDigit1.setBounds(X_FIELD, Y1, 100, 50);
        
        
        //1ST PASSCODES TITLE
        JLabel jLTextDigit2 = new JLabel("2nd Two-Digits ");
            jLTextDigit2.setForeground(Color.yellow);
            jLTextDigit2.setFont(new Font("Georgia", Font.BOLD, 24));
            jLTextDigit2.setBounds(X_TITLE, Y2, 210, 50);
            //setup border to wordwrap the description
//                jLTextDigit2.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //2ND JTextField DESIGN - declared globally
        jTextFieldPassDigit2.setForeground(Color.gray);
        jTextFieldPassDigit2.setFont(new Font("Arial", Font.BOLD, 20));
        jTextFieldPassDigit2.setBounds(X_FIELD, Y2, 100, 50);
        
        
        //3RD PASSCODES TITLE
        JLabel jLTextDigit3 = new JLabel("3rd Two-Digits ");
                jLTextDigit3.setForeground(Color.yellow);
                jLTextDigit3.setFont(new Font("Georgia", Font.BOLD, 24));
                jLTextDigit3.setBounds(X_TITLE, Y3, 210, 50);
                //setup border to wordwrap the description
//                jLTextDigit3.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //3RD JTextField DESIGN - declared globally
        jTextFieldPassDigit3.setForeground(Color.gray);
        jTextFieldPassDigit3.setFont(new Font("Arial", Font.BOLD, 20));
        jTextFieldPassDigit3.setBounds(X_FIELD, Y3, 100, 50);
        
        
        
        //Show 1st result
        jLTextPassResult1.setText("<html>&nbsp;&nbsp;  X </html>");
        jLTextPassResult1.setForeground(Color.red);
        jLTextPassResult1.setFont(new Font("Georgia", Font.BOLD, 27));
        jLTextPassResult1.setBounds(X_RESULT, Y1, 60, 50);
        jLTextPassResult1.setOpaque(true);
        //setup border to wordwrap the description
//                jLTextDigit3.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));
        //Show 2nd result
        jLTextPassResult2.setText("<html>&nbsp;&nbsp;  X </html>");
        jLTextPassResult2.setForeground(Color.red);
        jLTextPassResult2.setFont(new Font("Georgia", Font.BOLD, 30));
        jLTextPassResult2.setBounds(X_RESULT, Y2, 60, 50);
        jLTextPassResult2.setOpaque(true);
        //setup border to wordwrap the description
//                jLTextDigit3.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));
        //Show 3rd result
        jLTextPassResult3.setText("<html>&nbsp;&nbsp; X </html>");
        jLTextPassResult3.setForeground(Color.red);
        jLTextPassResult3.setFont(new Font("Georgia", Font.BOLD, 30));
        jLTextPassResult3.setBounds(X_RESULT, Y3, 60, 50);
        jLTextPassResult3.setOpaque(true);
        //setup border to wordwrap the description
//                jLTextDigit3.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));


        //WARNING MESSAGE
        jLTextPasslockWarningMessage.setText("");        
        jLTextPasslockWarningMessage.setForeground(Color.white);
        jLTextPasslockWarningMessage.setBackground(Color.black);
        jLTextPasslockWarningMessage.setFont(new Font("Arial", Font.BOLD, 24));
        jLTextPasslockWarningMessage.setBounds(70, 460, 650, 150);
        jLTextPasslockWarningMessage.setOpaque(false);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        if(boolMasterPass) //if master password is entered:
            jLTextPasslockWarningMessage.setText("<html>You are here with Master password. "
                    + "<br>Click on Unlock button to see the passcodes. </html>");


        //COUNT NUMBER OF CHANCES TO UNLOCK AND GET TREASURE MESSAGE
        jLTextPasslockTreasureMessage.setText("<html><span style='font-size:22px' color='yellow'> You have only " + FINAL_LOCKPASS_LIMIT_TRY + " chance/s left to unlock the door!!!</span> <br><br>"
                + "Have not found any Treasure yet? No worries! <br>"
                + "If you open the lock with up to " + FINAL_LOCKPASS_TREASURE_TRY + " tries, you'll get a Gold Coin.</html> ");        
        jLTextPasslockTreasureMessage.setForeground(Color.green);
        jLTextPasslockTreasureMessage.setBackground(Color.black);
        jLTextPasslockTreasureMessage.setFont(new Font("Arial", Font.BOLD, 24));
        jLTextPasslockTreasureMessage.setBounds(150, 550, 1000, 200);
        jLTextPasslockTreasureMessage.setOpaque(false);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));




        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(true);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
        //UNLOCK BUTTON      
        jBUnlock.setForeground(Color.yellow);
        jBUnlock.setBackground(Color.gray);
        jBUnlock.setFont(new Font("Monotype Corsiva", Font.ITALIC, 35));
        jBUnlock.setOpaque(true);
        jBUnlock.setBounds(FINAL_BUTTON_RIGHT_X+30, 580, FINAL_BUTTON_W, FINAL_BUTTON_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        jBUnlock.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);
        jBUnlock.addActionListener(objActionListener);
        
        //FocusListener: textFields
        jTextFieldPassDigit1.addFocusListener(objFocusGained);
        jTextFieldPassDigit2.addFocusListener(objFocusGained);
        jTextFieldPassDigit3.addFocusListener(objFocusGained);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextMessage);
        jPanelMain.add(jLTextMessageShadow);
        jPanelMain.add(jLTextInstructions);
        jPanelMain.add(jLTextInstructionsShadow);
        jPanelMain.add(jLTextCounterShow);
        
        jPanelMain.add(jLTextDigit1);
        jPanelMain.add(jLTextDigit2);
        jPanelMain.add(jLTextDigit3);
        jPanelMain.add(jTextFieldPassDigit1);
        jPanelMain.add(jTextFieldPassDigit2);
        jPanelMain.add(jTextFieldPassDigit3);
        jPanelMain.add(jLTextPassResult1);
        jPanelMain.add(jLTextPassResult2);
        jPanelMain.add(jLTextPassResult3);
        jPanelMain.add(jLTextPasslockWarningMessage);
        jPanelMain.add(jLTextPasslockTreasureMessage);

        jPanelMain.add(jBGoToGameOptionPg);
        jPanelMain.add(jBUnlock);
        
        jPanelMain.add(jLPicBG);
                
    }


    public void methodValidatePasslock()
    {
        boolean boolErrorMessage = true;
        boolean boolPassUnlocked = false;
                               
        int userPassOne = 9999,
            userPassTwo = 9999,
            userPassThree = 9999;
        

        try 
        {
            //if this if-statement is not used, second time the TextField value will change to Unlocked and program will crash!
            if(!boolPassLockMatched1) 
                userPassOne = Integer.parseInt(jTextFieldPassDigit1.getText()); //This password was already generated in MouseEvent showFirstHallwayPg() 
            
            if(!boolPassLockMatched2)
                userPassTwo = Integer.parseInt(jTextFieldPassDigit2.getText()); //This password was already generated in MouseEvent showFirstHallwayPg() 
            
            if(!boolPassLockMatched3)
                userPassThree = Integer.parseInt(jTextFieldPassDigit3.getText()); //This password was already generated in MouseEvent showFirstHallwayPg() 
        } 
        catch (Exception e) //error message if a non-numeric value is entered
        {           
            jLTextPasslockWarningMessage.setText("<html><blockquote>Invalid entry!<br> - Only numbers are accepted. <br>- No non-numeric character in the fields. <br> - None of the fields should be empty.  <blockquote></html>");
            boolErrorMessage = false;
        }
        
        //if master password is entered, all passcodes will be shown.
        if(boolMasterPass)
        {
            jLTextPassResult1.setText("<html> &nbsp; " + (Integer.toString(intPassSet1)) + "</html>");
            jLTextPassResult2.setText("<html> &nbsp; " + (Integer.toString(intPassSet2)) + "</html>");
            jLTextPassResult3.setText("<html> &nbsp; " + (Integer.toString(intPassSet3)) + "</html>");
            jLTextPasslockWarningMessage.setText("<html><blockquote> Since you're logged in as a master, all passcodes are shown to you! Use them to unlock the lock. ");
        }
        
        
        //error message if the numbers don't match
        if(boolErrorMessage && !boolMasterPass)
            jLTextPasslockWarningMessage.setText("<html><blockquote> Nice Try! Also make sure all the entries are sets of TWO-Digit numbers "
                    + "with the following pattern. <br> Example: 0, 10, 20, 30, 40, ..., up to 90 <blockquote></html>");
        
        
        
        //check pass set 1. Don't do it again if it's already unlocked
        if (!boolPassLockMatched1 && intPassSet1 == userPassOne)
        {
            jTextFieldPassDigit1.setText("Unlocked");
            jTextFieldPassDigit1.setEditable(false);
            
            jLTextPassResult1.setText("<html> &nbsp; " + (Integer.toString(intPassSet1)) + "</html>");
            jLTextPassResult1.setForeground(Color.green);
            jLTextPassResult1.setBackground(Color.black);
            boolPassLockMatched1 = true;
        }
        
        //check pass set 2. Don't do it again if it's already unlocked
        if (!boolPassLockMatched2 && intPassSet2 == userPassTwo)
        {
            jTextFieldPassDigit2.setText("Unlocked");
            jTextFieldPassDigit2.setEditable(false);
            
            jLTextPassResult2.setText("<html> &nbsp; " + (Integer.toString(intPassSet2)) + "</html>");
            jLTextPassResult2.setForeground(Color.green);
            jLTextPassResult2.setBackground(Color.black);
            boolPassLockMatched2 = true;
        }
        
        //check pass set 3. Don't do it again if it's already unlocked
        if (!boolPassLockMatched3 && intPassSet3 == userPassThree)
        {
            jTextFieldPassDigit3.setText("Unlocked");
            jTextFieldPassDigit3.setEditable(false);
            
            jLTextPassResult3.setText("<html> &nbsp; " + (Integer.toString(intPassSet3)) + "</html>");
            jLTextPassResult3.setForeground(Color.green);
            jLTextPassResult3.setBackground(Color.black);
            boolPassLockMatched3 = true;
        }
        
        if (boolPassLockMatched1 && boolPassLockMatched2 && boolPassLockMatched3)  //if all 3 sets match, go to the next page. 
        {
            if (intCountPasscodeTries <= FINAL_LOCKPASS_TREASURE_TRY)
                boolFoundCoinTreasure = true;
            
            showOpenGatePg(); //if all passwords match goes to the next page. 
            
            boolPassUnlocked = true;  //passcode is unlocked. So don't go for the counters below anymore
        }


        //if passcodes are discoverd in less than 10 hits, treasure will be given.
        intCountPasscodeTries++;
        
        if(intCountPasscodeTries < FINAL_LOCKPASS_TREASURE_TRY)
        {
            jLTextPasslockTreasureMessage.setText("<html><span style='font-size:22px' color='yellow'> Chance/s left to unlock the door: " + (FINAL_LOCKPASS_LIMIT_TRY - intCountPasscodeTries) + "</span> <br><br>"
                + "Ramaning chances for a Gold Coin treasure: " + (FINAL_LOCKPASS_TREASURE_TRY - intCountPasscodeTries) + "</html>");  
        }   
        else if (intCountPasscodeTries < FINAL_LOCKPASS_LIMIT_TRY)
        {
            jLTextPasslockTreasureMessage.setText("<html><span style='font-size:22px' color='#ff0000'> Chance/s left to unlock the door: " + (FINAL_LOCKPASS_LIMIT_TRY - intCountPasscodeTries) + "</span> <br><br>"
                + "Sorry. You missed the Gold Coin. </html> ");
        }
        else if (boolFoundCoinTreasure && intCountPasscodeTries == FINAL_LOCKPASS_LIMIT_TRY)
        {
            intCountPasscodeTries -= 5;
            jLTextPasslockTreasureMessage.setText("<html><span style='font-size:18px' color='yellow'> <br> Lucky you for having the Gold Coin. It's being used to give <br>you 5 more chances.<br>Now you have only " + (FINAL_LOCKPASS_LIMIT_TRY - intCountPasscodeTries) + " chance/s left to unlock the door!!!</span> <br><br>"
                + "Sorry. You missed the Gold Coin. </html> ");
            boolFoundCoinTreasure = false;
        }
        else if (!boolGameover && !boolPassUnlocked)
        {
            featureGuardCreaturePg();
            boolGameover = true;
        }
        else if (boolGameover)
            showFailurePg();

    }
    
    

    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showOpenGatePg()
    {
        setTitle("Open Gate");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        jLPicOpenGateBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
    if (boolMasterPass && boolSolutions)
        jLPicOpenGateBG.setIcon(new ImageIcon(STRING_URL +"021-open-gate-master.jpg"));
    else
        jLPicOpenGateBG.setIcon(new ImageIcon(STRING_URL +"021-open-gate.jpg"));
                
        

        
        try
        {
            clipGate = AudioSystem.getClip();
            clipGate.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"s-gate.wav")));
            clipGate.start();        
        }

        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: s-gate.wav file is not available"
                    + " Error Message - " + error);								
        }

        //MESSAGE
        String messageString = "<html> Wear the lifevest and jump into the ocean. <br>  &nbsp; &nbsp; &nbsp; Swim Swim Swim…  </html>";
        jLTextOpenGateMessage.setText(messageString);
        jLTextOpenGateMessage.setForeground(Color.white);
        jLTextOpenGateMessage.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextOpenGateMessage.setBounds(30, 10, 550, 160);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        jLTextOpenGateMessageShadow.setText(messageString);
        jLTextOpenGateMessageShadow.setForeground(Color.black);
        jLTextOpenGateMessageShadow.setBackground(Color.red);
        jLTextOpenGateMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextOpenGateMessageShadow.setBounds(26, 10, 550, 160);
        jLTextOpenGateMessageShadow.setOpaque(false);
        //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                                
        ///////////// LISTERNERS ///////////// 
        
        //MouseListener: clicked 
        jLPicOpenGateBG.removeMouseListener(objMouseGame);
        jLPicOpenGateBG.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextOpenGateMessage);
        jPanelMain.add(jLTextOpenGateMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicOpenGateBG);
                
    }

    

    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showFreedomPg()
    {
        String freedomMessage = "";
        
        setTitle("Freedom!!!");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        try
        {
            cliphHallway.stop();
            clipGate.stop();
        }
        catch (Exception error)
        {
            //do nothing
        }
        
        try
        {
            clipFreedom = AudioSystem.getClip();
            clipFreedom.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"s-ocean.wav")));
            clipFreedom.start();        
        }

        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: s-ocean.wav file is not available"
                    + " Error Message - " + error);								
        }


        //BG IMAGE 
        JLabel jLPicBG = new JLabel();
                jLPicBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"022-freedom.jpg"));
                
        if(boolFoundCoinTreasure)
            freedomMessage = "<html> WOW… You were so close to death. <br>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; But You Escaped! <br> Also since you've got a treasure during the game and never used it, " + usdFormat.format(FINAL_WIN_TREASURE_PRISE) + " will be added to your account balance. <br>You Rock! </html>";
        
        else
            freedomMessage = "<html> WOW… You were so close to death. <br>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; But You Escaped!  </html>";
            
        //FREEDOM MESSAGE
        JLabel jLTextMessage = new JLabel(freedomMessage);
                jLTextMessage.setForeground(Color.blue);
                jLTextMessage.setFont(new Font("Arial", Font.BOLD, 40));
                jLTextMessage.setBounds(250, 10, 700, 500);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        JLabel jLTextMessageShadow = new JLabel(freedomMessage);
                jLTextMessageShadow.setForeground(Color.white);
                jLTextMessageShadow.setBackground(Color.red);
                jLTextMessageShadow.setFont(new Font("Arial", Font.BOLD, 40));
                jLTextMessageShadow.setBounds(245, 10, 700, 500);
                jLTextMessageShadow.setOpaque(false);
                //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                
        //PLAY BUTTON        
        jBGoToGameOptionPg.setText("Play Again");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(false);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H+100, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextMessage);
        jPanelMain.add(jLTextMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicBG);
                
    }

    
    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showFailurePg()
    {
        boolGameover = false;
        
        setTitle("Game Over!!!");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        

        try
        {
            clipFailure = AudioSystem.getClip();
            clipFailure.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"scream.wav")));
            clipFailure.start();
//            clipFailure.loop(Clip.LOOP_CONTINUOUSLY);
        }

        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: scream.wav file is not available"
                    + " Error Message - " + error);								
        }
        
        
        //BG IMAGE 
        JLabel jLPicBG = new JLabel();
                jLPicBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"023-gameover-execution.jpg"));
                
        
        //PUNISH IMAGE SETUP
        Random randomMaker = new Random();
        int punishPicRandom = randomMaker.nextInt(3);
        
        String[] punishPicArray = {STRING_URL + "01-punish1.gif",
                                   STRING_URL + "01-punish2.gif",
                                   STRING_URL + "01-punish3.gif"};

        JLabel jLPicPunishRandom = new JLabel();
                jLPicPunishRandom.setBounds(760, 480, 200, 200);
                jLPicPunishRandom.setIcon(new ImageIcon(punishPicArray[punishPicRandom]) );
        //END PUNISH IMAGE SETUP
                

        //MESSAGE
        String messageString = "<html> OHHH NOOOO! You couldn't make it. <br>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; See you in heaven!!! </html>";
        JLabel jLTextMessage = new JLabel(messageString);
                jLTextMessage.setForeground(Color.white);
                jLTextMessage.setFont(new Font("Arial", Font.BOLD, 40));
                jLTextMessage.setBounds(250, 10, 700, 200);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        JLabel jLTextMessageShadow = new JLabel(messageString);
                jLTextMessageShadow.setForeground(Color.blue);
                jLTextMessageShadow.setBackground(Color.red);
                jLTextMessageShadow.setFont(new Font("Arial", Font.BOLD, 40));
                jLTextMessageShadow.setBounds(245, 10, 700, 200);
                jLTextMessageShadow.setOpaque(false);
                //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                
        //PLAY BUTTON        
        jBGoToGameOptionPg.setEnabled(true); //Enable this button again. 
        jBGoToGameOptionPg.setText("Quit");
        jBGoToGameOptionPg.setForeground(Color.red);
        jBGoToGameOptionPg.setBackground(Color.black);
        jBGoToGameOptionPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 24));
        jBGoToGameOptionPg.setOpaque(false);
        jBGoToGameOptionPg.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H, FINAL_BOTTON_Q_W_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBGoToGameOptionPg.removeActionListener(objActionListener);
        //add
        jBGoToGameOptionPg.addActionListener(objActionListener);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextMessage);
        jPanelMain.add(jLTextMessageShadow);
        jPanelMain.add(jLTextCounterShow);

        jPanelMain.add(jBGoToGameOptionPg);
        
        jPanelMain.add(jLPicPunishRandom);
        jPanelMain.add(jLPicBG);
                
    }

    
    
    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void featureIndoorMapKeyPg()
    {
        final int FEATURE_W = 720,
                  FEATURE_H = 630;
        
        jFrameFeatures.setBounds(200, 100, FEATURE_W, FEATURE_H);
        jFrameFeatures.setTitle("Indoor Map - Key");
        jFrameFeatures.show();
        jFrameFeatures.setVisible(true);
        
        jPanelFeatures.removeAll();
        jPanelFeatures.setLayout(null);
        jPanelFeatures.setBounds(0, 0, FEATURE_W, FEATURE_H);
        jPanelFeatures.setBackground(Color.BLACK);
        
        
        try
        {
            Clip clipMap = AudioSystem.getClip();
            clipMap.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"s-map.wav")));
            clipMap.start();        
        }

        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: s-map.wav file is not available"
                    + " Error Message - " + error);								
        }


        //Map IMAGE 
        jLPicIndoorMap.setBounds(10, 0, FEATURE_W, FEATURE_H);
        jLPicIndoorMap.setIcon(new ImageIcon(STRING_URL +"030-indoor-map.jpg"));

        

        //MESSAGE
        JLabel jLTextMessage = new JLabel("<html> Click on the map to grab it. </html>");
                jLTextMessage.setForeground(Color.blue);
                jLTextMessage.setFont(new Font("Arial", Font.BOLD, 26));
                jLTextMessage.setBounds(10, 10, 300, 100);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

                                
        ///////////// LISTERNERS ///////////// 
        
        //MouseListener: clicked 
        jLPicIndoorMap.removeMouseListener(objMouseGame);
        jLPicIndoorMap.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelFeatures.repaint();
        
        jPanelFeatures.add(jLTextMessage);
        
        jPanelFeatures.add(jLPicIndoorMap);
                
    }

    
    
    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void featureCoinTreasurePg()
    {
        final int FEATURE_W = 520,
                  FEATURE_H = 520;
        
        jFrameFeatures.setBounds(200, 100, FEATURE_W, FEATURE_H);
        jFrameFeatures.setTitle("Coin - Treasure");        
        jFrameFeatures.show();
        jFrameFeatures.setVisible(true);
        
        jPanelFeatures.removeAll();
        jPanelFeatures.setLayout(null);
        jPanelFeatures.setBounds(0, 0, FEATURE_W, FEATURE_H);
        jPanelFeatures.setBackground(new Color(47, 49, 105));
        
        try
        {
            Clip clipCoin = AudioSystem.getClip();
            clipCoin.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"s-coin.wav")));
            clipCoin.start();        
        }

        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: s-coin.wav file is not available"
                    + " Error Message - " + error);								
        }


        
        //COIN IMAGE 
        jLPicCoin.setBounds(10, 0, FEATURE_W, FEATURE_H);
        jLPicCoin.setIcon(new ImageIcon(STRING_URL +"031-coin.jpg"));

        

        //MESSAGE
        JLabel jLTextMessage = new JLabel("<html> Click on the Coin to take it. </html>");
                jLTextMessage.setForeground(Color.blue);
                jLTextMessage.setFont(new Font("Arial", Font.BOLD, 26));
                jLTextMessage.setBounds(20, 10, 300, 100);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

                                
        ///////////// LISTERNERS ///////////// 
        
        //MouseListener: clicked 
        jLPicCoin.removeMouseListener(objMouseGame);
        jLPicCoin.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelFeatures.repaint();
        
        jPanelFeatures.add(jLTextMessage);
        
        jPanelFeatures.add(jLPicCoin);
                
    }

    
    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void featureBeerTreasurePg()
    {
        final int FEATURE_W = 720,
                  FEATURE_H = 595;
        
        jFrameFeatures.setBounds(200, 100, FEATURE_W, FEATURE_H);
        jFrameFeatures.setTitle("Beer - Treasure");        
        jFrameFeatures.show();
        jFrameFeatures.setVisible(true);
        
        jPanelFeatures.removeAll();
        jPanelFeatures.setLayout(null);
        jPanelFeatures.setBounds(0, 0, FEATURE_W, FEATURE_H);
        jPanelFeatures.setBackground(new Color(47, 49, 105));
        
        
        //COIN IMAGE 
        jLPicBeer.setBounds(10, -5, FEATURE_W, FEATURE_H);
        jLPicBeer.setIcon(new ImageIcon(STRING_URL +"033-beer-bottle.jpg"));

                                
        ///////////// LISTERNERS ///////////// 
        
        //MouseListener: clicked 
        jLPicBeer.removeMouseListener(objMouseGame);
        jLPicBeer.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelFeatures.repaint();
        
        jPanelFeatures.add(jLPicBeer);
                
    }


    
    //NAME:             gameOptionsPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void featureGuardCreaturePg()
    {
        final int FEATURE_W = 720,
                  FEATURE_H = 520;
        
        jFrameFeatures.setBounds(600, 300, FEATURE_W, FEATURE_H);
        jFrameFeatures.setTitle("You are caught!!! - Creature");        
        jFrameFeatures.show();
        jFrameFeatures.setVisible(true);
        
        jPanelFeatures.removeAll();
        jPanelFeatures.setLayout(null);
        jPanelFeatures.setBounds(0, 0, FEATURE_W, FEATURE_H);
        jPanelFeatures.setBackground(new Color(47, 49, 105));
        
        
        try
        {
            Clip clipRun = AudioSystem.getClip();
            clipRun.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"s-run.wav")));
            clipRun.start();        
        }

        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: s-run.wav file is not available"
                    + " Error Message - " + error);								
        }
        
        //COIN IMAGE 
        jLPicCreatureGuard.setBounds(10, 0, FEATURE_W, FEATURE_H);
        jLPicCreatureGuard.setIcon(new ImageIcon(STRING_URL +"032-guard-run.jpg"));

        

        //MESSAGE
        jLTextCreatureMessage.setText(displayCreatureMessage());
        jLTextCreatureMessage.setForeground(Color.white);
        jLTextCreatureMessage.setFont(new Font("Arial", Font.BOLD, 26));
        jLTextCreatureMessage.setBounds(20, 300, 600, 100);
        //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

                                
        ///////////// LISTERNERS ///////////// 
        
        //MouseListener: clicked 
        jLPicCreatureGuard.removeMouseListener(objMouseGame);
        jLPicCreatureGuard.addMouseListener(objMouseGame);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelFeatures.repaint();
        
        jPanelFeatures.add(jLTextCreatureMessage);
        
        jPanelFeatures.add(jLPicCreatureGuard);
                
    }

    
    //NAME:             showHistoryPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()        
    public void showHistoryPg()
    {       
                      
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Account History!");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        jPanelScroll.removeAll();
        jPanelScroll.setLayout(null);
        jPanelScroll.setBounds(450, 100, 720, 310);
        jPanelScroll.setVisible(false);

        
        //Image BG       
        JLabel jLPicBG = new JLabel();
                jLPicBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"040-history-bg.jpg"));

        
        //PAGE TITLE SETUP
        jLTextHistoryTitle.setText("<< Account History Options >>");
        jLTextHistoryTitle.setFont(new Font("Courier New", Font.BOLD, 30));
        jLTextHistoryTitle.setForeground(Color.white);
        jLTextHistoryTitle.setBounds(330, 15, 900, 50);
                
         
        String historyString = "<html> Game History:<br> Shows your account and game history briefly. <br> ( You have to play at least one game to activate this option. ) "
                                    + "<br><br> Save History:<br> It will store your game history data into a file disk. "
                                    + "<br><br> Retrieve History:<br> Reads your game history data from the disk file and displays it to you.</html> ";
        //HISTORY DETAILS LEFT
        jLTextHistoryLeft.setText(historyString);
        jLTextHistoryLeft.setForeground(Color.white);
        jLTextHistoryLeft.setFont(new Font("Times New Roman", Font.BOLD, 24));
        jLTextHistoryLeft.setBounds(30, 150, 1000, 350);
        //setup border to wordwrap the description
//        jLTextHistoryLeft.setBorder(BorderFactory.createLineBorder(Color.yellow, 4, rootPaneCheckingEnabled));


        //HISTORY DETAILS LEFT SHADOW
        jLTextHistoryLeftShadow.setText(historyString);
        jLTextHistoryLeftShadow.setForeground(Color.red);
        jLTextHistoryLeftShadow.setFont(new Font("Times New Roman", Font.BOLD, 24));
        jLTextHistoryLeftShadow.setBounds(32, 148, 1000, 350);
        //setup border to wordwrap the description
//        jLTextHistoryLeft.setBorder(BorderFactory.createLineBorder(Color.yellow, 4, rootPaneCheckingEnabled));


//HISTORY DETAILS RIGHT
        jLTextHistoryRight.setBackground(new Color(242, 220, 215));
        jLTextHistoryRight.setForeground(Color.black);
        jLTextHistoryRight.setFont(new Font("Times New Roman", Font.PLAIN, 22));
//        jLTextHistoryRight.setLineWrap(true);
//        jLTextHistoryRight.setWrapStyleWord(true);
        jLTextHistoryRight.setEditable(false);
//        jLTextHistoryRight.setBounds(500, 100, 300, 400);
        //setup border to wordwrap the description
        jLTextHistoryRight.setBorder(BorderFactory.createLineBorder(Color.black, 4, rootPaneCheckingEnabled));

        
        //SETUP JScrollPane
        scrollPaneHistory.getViewport().add(jLTextHistoryRight);
        scrollPaneHistory.setBounds(0, 0, 710, 300);
        scrollPaneHistory.setVisible(false);

        
        //HISTORY DETAILS LEFT
        jLTextSort.setForeground(Color.white);
        jLTextSort.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jLTextSort.setBounds(60, 450, 1100, 200);
        jLTextSort.setVisible(false);
        //setup border to wordwrap the description
//        jLTextSort.setBorder(BorderFactory.createLineBorder(Color.yellow, 4, rootPaneCheckingEnabled));


        

        //SHOW HISTORY BUTTON
        jBCalcHistoryShow.setForeground(Color.white);
        jBCalcHistoryShow.setBackground(Color.blue);
        jBCalcHistoryShow.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBCalcHistoryShow.setOpaque(true);
        jBCalcHistoryShow.setBounds(FINAL_BUTTON_LEFT_X+100, FINAL_BUTTON_Y_LOWER, FINAL_BUTTON_W, FINAL_BUTTON_H);

        //SAVE GAME HISTORY TO DISK BUTTON
        jBHisotyWriteToDisk.setForeground(Color.white);
        jBHisotyWriteToDisk.setBackground(Color.blue);
        jBHisotyWriteToDisk.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBHisotyWriteToDisk.setOpaque(true);
        jBHisotyWriteToDisk.setBounds(FINAL_BUTTON_CENTER_X+60, FINAL_BUTTON_Y_LOWER, FINAL_BUTTON_W, FINAL_BUTTON_H);
        jBHisotyWriteToDisk.setEnabled(false);

        //READ GAME HISTORY FROM DISK BUTTON   
        jBHisotyReadFromDisk.setForeground(Color.white);
        jBHisotyReadFromDisk.setBackground(Color.blue);
        jBHisotyReadFromDisk.setFont(new Font("Monotype Corsiva", Font.ITALIC, 26));
        jBHisotyReadFromDisk.setOpaque(true);
        jBHisotyReadFromDisk.setBounds(FINAL_BUTTON_RIGHT_X+15, FINAL_BUTTON_Y_LOWER, FINAL_BUTTON_W, FINAL_BUTTON_H);
        jBHisotyReadFromDisk.setEnabled(true);

        //BACK BUTTON
        jBGoToGameOptionPgNoCalc.setText("Back");
        jBGoToGameOptionPgNoCalc.setForeground(Color.red);
        jBGoToGameOptionPgNoCalc.setBackground(Color.black);
        jBGoToGameOptionPgNoCalc.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBGoToGameOptionPgNoCalc.setOpaque(false);
        jBGoToGameOptionPgNoCalc.setBounds(FINAL_LEFT_CORNER_X , FINAL_BOTTOM_EDGE_Y, FINAL_BOTTON_Q_W_H+30, FINAL_BOTTON_Q_W_H);
        
        
        ///////////// BUTTON LISTERNERS ///////////// 
        //remove
        jBCalcHistoryShow.removeActionListener(objActionListener);
        jBHisotyWriteToDisk.removeActionListener(objActionListener);
        jBHisotyReadFromDisk.removeActionListener(objActionListener);
        jBGoToGameOptionPgNoCalc.removeActionListener(objActionListener);
        //add
        jBCalcHistoryShow.addActionListener(objActionListener);
        jBHisotyWriteToDisk.addActionListener(objActionListener);
        jBHisotyReadFromDisk.addActionListener(objActionListener);
        jBGoToGameOptionPgNoCalc.addActionListener(objActionListener);
                
        
        //RESET AND INSTALLATION ON JPANEL  
        jPanelScroll.repaint();
        jPanelScroll.add(scrollPaneHistory);

        jPanelMain.repaint();
        jPanelMain.add(jLTextHistoryTitle);
        jPanelMain.add(jLTextHistoryLeft);
        jPanelMain.add(jLTextHistoryLeftShadow);
        jPanelMain.add(jLTextSort);
        
        jPanelMain.add(jBCalcHistoryShow);
        jPanelMain.add(jBHisotyWriteToDisk);
        jPanelMain.add(jBHisotyReadFromDisk);
        jPanelMain.add(jBGoToGameOptionPgNoCalc);
        
        
        jPanelMain.add(jLPicBG);
        
        setVisible(true);
    
    }     
    
    
    public void methodHistoryRecord()
    {
                
        if (boolSuccessFailEscape)
        {
            stringSuccessFail = "a SUCCESSFUL";
            intCountEscapedSuccess++; //if the user wins add one Success
        }
        else 
        {
            intCountEscapeFailed++;
            stringSuccessFail = "a failed";
        }
                
        historyResultString += "Game #" + intCountGameNum + " ended with " + stringSuccessFail + " escape after " + intCountMouseClickEachGame + " clicks" + " and balance of " + usdFormat.format(doubleAccountBalance) + "\n";
        
        
        unsortedClickString += Integer.toString(intCountMouseClickEachGame) + ", ";
        //NUMBER OF CLICKS NOT SORTED
        unsortedClickMessageString = "<html> So, in the " + intCountGameNum + " game/s, " + stringNameOfUser + " used the following number of clicks:<br>  &nbsp; &nbsp; &nbsp; " + unsortedClickString; //the </html> will be added from the next one. 
        
        //sort from fewest to most
        arrayLIntClicks.add(intCountMouseClickEachGame);

        Collections.sort(arrayLIntClicks);
        
        sortedClickString = "";
        for (int a : arrayLIntClicks)
        {
            sortedClickString += a + ", ";
        }
        sortedClickMessageString = "<br> <br> From fewest to most clicks we have: <br> "
                                            + " &nbsp; &nbsp; &nbsp; " + sortedClickString;
        
        //print the fewest and the most
        leastAndMostMessageString = "<br> <br> With the fewest = " + arrayLIntClicks.get(0) + " and the most = " + arrayLIntClicks.get((arrayLIntClicks.size())-1) + "</html>";
 
        
        
        //write history game details
        writeHistoryString += "Now writing game #" + intCountGameNum + " to game-history.dat:\n" 
                + "Game #" + intCountGameNum + " ended with " + stringSuccessFail + " escape after " + intCountMouseClickEachGame + " clicks" + " and balance of " + usdFormat.format(doubleAccountBalance) + "\n\n";

        
    }     
    




    
    public void methodHistoryShow()
    {
        jPanelScroll.setVisible(true);
        jPanelScroll.setOpaque(false);
        
        ////////////////////
        //CURRENT TIME
        Date thisDate = new Date(); //declare thisDate object
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yy HH:mm:ss"); //declare date and time format
        stringEndTime = dateForm.format(thisDate);  //put date/time into stringEndTime variable
//        JLabel jLabelCurrentTime = new JLabel(stringStartTime);  //declare currentTimeJLabel object and set myTime as default

        jLTextHistoryTitle.setText(stringNameOfUser + "'s ESCAPE FROM ALCATRAZ History");
        jLTextHistoryTitle.setBounds(50, 15, 1000, 50);
        
                //NAME, BALANCE, TOTAL GAME, WON/LOST, START TIME, END TIME
        String messageLeftString = "<html> " + stringNameOfUser + " started playing with " + usdFormat.format(doubleDepositRegPg) 
                                + " at<br> " + stringStartTime 
                                + "<br><br>" + stringNameOfUser + " currently has " + usdFormat.format(doubleAccountBalance) 
                                + " at<br> " + stringEndTime 
                                + "<br><br> In " + intCountGameNum + " games with total of " + intCountMouseClickTotal 
                                + " clicks, <br>  &nbsp; &nbsp; " 
                                + stringNameOfUser + " has " + intCountEscapedSuccess + " successful escape(s).<br>  &nbsp;  &nbsp; "
                                + stringNameOfUser + " has " + intCountEscapeFailed + " escape failure(s).</html>";
        

        scrollPaneHistory.setVisible(true);

        
        //ADD UNSORTED, SORTED, THE FEWEST AND THE MOST
        String completedClickString = unsortedClickMessageString + sortedClickMessageString + leastAndMostMessageString;
        
        //Left side message start/end time, start balance, total game number
        jLTextHistoryLeft.setText(messageLeftString);
        jLTextHistoryLeft.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jLTextHistoryLeft.setBounds(30, 70, 420, 350);
        jLTextHistoryLeftShadow.setText(messageLeftString);
        jLTextHistoryLeftShadow.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jLTextHistoryLeftShadow.setBounds(30, 68, 420, 350);
        
        //list of game details
        jLTextHistoryRight.setText("Game History: \n" + historyResultString);
        
        //buttom click report. sorted/unsorted/fewest and most
        jLTextSort.setVisible(true);
        jLTextSort.setText(completedClickString);
        
    }

    
    public void methodHistoryWriteToDisk()
    {
        jPanelMain.repaint();
        
        jPanelScroll.removeAll();
        jPanelScroll.setLayout(null);
        jPanelScroll.setBounds(450, 100, 720, 310);
        jPanelScroll.setVisible(true);

        jPanelScroll.repaint();
        jPanelScroll.add(scrollPaneHistory);
        scrollPaneHistory.setVisible(true);
        
        jLTextHistoryTitle.setText("<< Save Game History to Disk >>");
        jLTextHistoryTitle.setBounds(300, 15, 1000, 50);
        
        
        File myFile = new File(STRING_URL + "game-history.dat");
        

        try 
        {
            FileWriter f1 = new FileWriter(myFile, false);
            f1.write(historyResultString);
            f1.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        
        
        jLTextHistoryRight.setText("\tStarting writing to game-history.dat\n\n" + writeHistoryString 
                                + "\n\t Finished writing to game-history.dat");

        String leftMessage = "<html>The game history is being stored in a file so if you close the game, you can continue your game later. <br><br> You need to enter the game using the same username/password which you entered for this game. Then you will be able to recover your game data using the Retrieve History button.</html>";
        jLTextHistoryLeft.setText(leftMessage);
        jLTextHistoryLeftShadow.setText("");
        jLTextHistoryLeft.setBounds(30, 70, 400, 350);
//        jLTextHistoryLeftShadow.setBounds(30, 68, 400, 350);
        
    }
    
    public void methodHistoryReadFromDisk()
    {
        boolean boolFileNotFound = false; //if the history file is removed or does not exist
        
        jPanelMain.repaint();
        jPanelScroll.removeAll();
        jPanelScroll.setLayout(null);
        jPanelScroll.setBounds(450, 100, 720, 310);
        jPanelScroll.setVisible(true);

        jPanelScroll.repaint();
        jPanelScroll.add(scrollPaneHistory);
        scrollPaneHistory.setVisible(true);
        
        String leftMessage = "<html>The history is recovered successfully. <br><br> You can continue playing your game. </html>";

        jLTextHistoryTitle.setText("<< Read Game History From Disk >>");
        jLTextHistoryTitle.setBounds(300, 15, 1000, 50);

        
        String readHistoryString ="";
        
        try(BufferedReader br = new BufferedReader(new FileReader(STRING_URL + "game-history.dat"))) 
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) 
            {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            readHistoryString = sb.toString();
        
        }
        catch (Exception e)
        {
            leftMessage = "<html> Your game-history.dat file is not found. History recovery has failed! <br> <br>"
                    + "Either no history has been recorded yet or the history file is deleted from the library folder. </html>";
            
            boolFileNotFound = true; //the history file is not found
        }
        
        if (boolFileNotFound)
        {
            jLTextHistoryRight.setText("\n\n\n\tNo history file has been found! \n\n \tgame-history.dat file reading error.");            
        }
        else
        {
            jLTextHistoryRight.setText("\tStarting reading from game-history.dat\n\n" + readHistoryString 
                                + "\n\t Finished reading from game-history.dat");          
        }

        jLTextHistoryLeft.setText(leftMessage);
        jLTextHistoryLeftShadow.setText("");
        jLTextHistoryLeft.setBounds(30, 70, 400, 350);
//        jLTextHistoryLeftShadow.setBounds(30, 68, 400, 350);
        
    }


    public void methodResetAlcatraz()
    {     
        try 
        {
            cliphHallway.stop();
            clipFreedom.stop();
            clipFailure.stop();
            clipGate.stop();
        } 
        catch (Exception e) 
        {
            //do nothing
        }
        
        
        intCountGameNum = 0;
        intCountEscapeFailed = 0;
        intCountEscapedSuccess = 0;
        intCountMouseClickTotal = 0;
        intCountMouseClickEachGame = 0;
        intCountPasscodeTries = 0;
//        intHistoryArrayIndex = 0;

        boolMasterPass = false;
        boolBeerFound = false;
        boolFoundCoinTreasure = false;
        boolGameover = false;
        boolIndoorMap = false;
        boolPassLockMatched1 = false;
        boolPassLockMatched2 = false;
        boolPassLockMatched3 = false;
        boolSolutions = false;
        boolUserPassValidity = false;
        boolSuccessFailEscape = false;
        
        jTextFieldPassDigit1.setText("Required");
        jTextFieldPassDigit2.setText("Required");
        jTextFieldPassDigit3.setText("Required");
       
        jTextFieldPassDigit1.setEditable(true);
        jTextFieldPassDigit2.setEditable(true);
        jTextFieldPassDigit3.setEditable(true);

    }
    
    public void methodResetForEachGame()
    {
        intCountMouseClickEachGame = 0;
        boolBeerFound = false;
        boolFoundCoinTreasure = false;
        boolGameover = false;
        boolIndoorMap = false;
        boolSuccessFailEscape = false;

        //RESET BELOW ITEMS LOCATED IN showOpenGatePg();
        boolPassLockMatched1 = false;
        boolPassLockMatched2 = false;
        boolPassLockMatched3 = false;
        intCountPasscodeTries = 0;

        jTextFieldPassDigit1.setText("Required");
        jTextFieldPassDigit2.setText("Required");
        jTextFieldPassDigit3.setText("Required");

        jTextFieldPassDigit1.setEditable(true);
        jTextFieldPassDigit2.setEditable(true);
        jTextFieldPassDigit3.setEditable(true);
    }
    

    public void methodResetAudioEachGame()
    {
                
        try 
        {
            clipWelcome.stop();            
        } 
        catch (Exception e) 
        {
        }
        
        try 
        {
            cliphHallway.stop();
        } 
        catch (Exception e) 
        {
            System.out.println("hallway Didn't stop the sound");
        }
        
        try 
        {
            clipGate.stop();
        } 
        catch (Exception e) 
        {
            System.out.println(" gate Didn't stop the sound");
        }

        try 
        {
            clipFreedom.stop();
        } 
        catch (Exception e) 
        {
            System.out.println("freedom Didn't stop the sound");
        }
        
    }

    
    
    //////////////////////////////////////////////////////////////////////////
    //DESCRIPTION:      get's money variable and round it to nearest penny
    //PARAMETERS:       double aValue << main()
    //RETURNS:          double aValue       
    //CALLS:            none
    //CALLED BY:        main()
    public double methodRoundToPenny(double aValue) 
    {
        
        //CALCULATION
        aValue = Math.round(aValue * 100);
        aValue = aValue / 100;
        
        return aValue;
    }
    
 
   
    public void showSummaryExitPg()
    {       
                      
        //SET JFRAME TITLE, RESETUP JPANEL
        setTitle("Summary Page!");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //PAGE TITLE SETUP
        JLabel jLTextTitle = new JLabel("<< Game Status Summary >>");
                jLTextTitle.setFont(new Font("Courier New", Font.BOLD, 30));
                jLTextTitle.setForeground(Color.white);
                jLTextTitle.setBounds(370, 15, 1000, 50);
                
        //Image BG       
        JLabel jLPicBG = new JLabel();
                jLPicBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"040-history-bg.jpg"));

                
        //PROMPT USER TO ENTER USER ID
        jLTextAccountSummary.setForeground(Color.white);
        jLTextAccountSummary.setFont(new Font("Times New Roman", Font.BOLD, 22));
        jLTextAccountSummary.setBounds(100, 80, 1000, 530);
        //setup border to wordwrap the description
//        jLTextAccountSummary.setBorder(BorderFactory.createLineBorder(Color.yellow, 4, rootPaneCheckingEnabled));



        //SHOW RAY ID BUTTON
        jBRayIdInfoPg.setText("Reza ID Info");
        jBRayIdInfoPg.setForeground(Color.white);
        jBRayIdInfoPg.setBackground(Color.blue);
        jBRayIdInfoPg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 30));
        jBRayIdInfoPg.setOpaque(true);
        jBRayIdInfoPg.setBounds(FINAL_BUTTON_CENTER_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);

        //BACK TO HOME BUTTON - UNDER CONSTRUCTIONS
        jBGoHomePg.setForeground(Color.white);
        jBGoHomePg.setBackground(Color.blue);
        jBGoHomePg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 22));
        jBGoHomePg.setOpaque(true);
        jBGoHomePg.setBounds(FINAL_BUTTON_RIGHT_X, FINAL_BUTTON_Y, FINAL_BUTTON_W, FINAL_BUTTON_H);
        jBGoHomePg.setVisible(false);  //UNDER CONSTRUCTIONS

        
        ///////////// BUTTON LISTERNERS ///////////// 
        //remove
        jBGoHomePg.removeActionListener(objActionListener);
        jBRayIdInfoPg.removeActionListener(objActionListener);
        //add
        jBGoHomePg.addActionListener(objActionListener);
        jBRayIdInfoPg.addActionListener(objActionListener);
                
        
        
        //RESET AND INSTALLATION ON JPANEL               
        jPanelMain.repaint();
        jPanelMain.add(jLTextTitle);
        jPanelMain.add(jLTextAccountSummary);
        
        jPanelMain.add(jBGoHomePg);
        jPanelMain.add(jBRayIdInfoPg);
        
        jPanelMain.add(jLPicBG);
    
    }     
    
    
    
    //NAME:             showIdInfoPg
    //DESCRIPTION:      After I Agree button is clicked, comes here to play the escape game
    //PARAMETERS:       none
    //RETURNS:          none
    //CALLS:            none
    //CALLED BY:        BIGPROGRAM()    
    public void showIdInfoPg()
    {
        setTitle("ID Information");
        setLayout(null);
        show();
        jPanelMain.removeAll();
        jPanelMain.setLayout(null);
        jPanelMain.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
        jPanelMain.setBackground(new Color(47, 49, 105));
        
        
        //BG IMAGE 
        JLabel jLPicBG = new JLabel();
                jLPicBG.setBounds(0, 0, FINAL_MY_WIDTH, FINAL_MY_HEIGHT);
                jLPicBG.setIcon(new ImageIcon(STRING_URL +"001-escape-theme.jpg"));
                


        //MESSAGE
        String messageString = "<html> Programmer &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Reza Taba<br>" +
            " Assignment #&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp THE FINAL ESCAPE<br>" +
            " Assignment Name &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Escape Program Final<br>" +
            " Course # and Title &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp CISC 190 - Java<br>" +
            " Class Meeting Time &nbsp &nbsp &nbsp &nbsp &nbsp TTH 6:20, 9:50 pm<br>" +
            " Instructor &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Professor Larry Forman<br>" +
            " Hours &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp +160 + researches<br>" +
            " Difficulty &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 10 out of 10<br>" +
            " Completion Date &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 02/05/2017<br>" +
            " Program Name &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Reza_Final_Escape </html>";
        JLabel jLTextMessage = new JLabel(messageString);
                jLTextMessage.setForeground(Color.yellow);
                jLTextMessage.setFont(new Font("Arial", Font.BOLD, 26));
                jLTextMessage.setBounds(50, 350, 700, 400);
                //setup border to wordwrap the description
//                jLTextMessage.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        //MESSAGE SHADOW
        JLabel jLTextMessageShadow = new JLabel(messageString);
                jLTextMessageShadow.setForeground(Color.red);
                jLTextMessageShadow.setBackground(Color.red);
                jLTextMessageShadow.setFont(new Font("Arial", Font.BOLD, 26));
                jLTextMessageShadow.setBounds(47, 350, 700, 400);
                jLTextMessageShadow.setOpaque(false);
                //setup border to wordwrap the description
//                jLTextMessageShadow.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, rootPaneCheckingEnabled));

        
                
        //EXIT GAME BUTTON        
        jBExitProgram.setText("Exit Alcatraz Game");
        jBExitProgram.setForeground(Color.white);
        jBExitProgram.setBackground(Color.black);
        jBExitProgram.setFont(new Font("Monotype Corsiva", Font.ITALIC, 36));
        jBExitProgram.setOpaque(false);
        jBExitProgram.setBounds(FINAL_BUTTON_RIGHT_X-50, FINAL_BUTTON_Y, FINAL_BUTTON_W+100, FINAL_BUTTON_H);
        
                                
        ///////////// LISTERNERS ///////////// 
        
        //ActionListerners: Button 
        //remove
        jBExitProgram.removeActionListener(objActionListener);
        //add
        jBExitProgram.addActionListener(objActionListener);

        
        //RESET AND INSTALLATION ON JPANEL        
        jPanelMain.repaint();
        
        jPanelMain.add(jLTextMessage);
        jPanelMain.add(jLTextMessageShadow);

        jPanelMain.add(jBExitProgram);
        
        jPanelMain.add(jLPicBG);
                
    }



    public void methodSummaryExit ()
    {
        double winLossBalance = doubleWinningsBalance - doubleLossesBalance;
        
        String wonLossResultString = "";
        
        String wonString = "<font color=yellow>" + usdFormat.format(doubleWinningsBalance) + " -- You've Won " + intCountEscapedSuccess + " time/s and earned this amount.</font> <br>";
        
        String lossString = "<font color=orange>" + usdFormat.format(doubleLossesBalance) + " -- You've Lost " + intCountEscapeFailed + " time/s and lost this amount. </font> <br>";
        
        //wonLoss result color
        if (doubleWinningsBalance == doubleLossesBalance)
            wonLossResultString = "<font color=white>" + usdFormat.format(winLossBalance) + " -- Win/Loss Result. It seems you've won or lost equaly. <br>======= <br> </font>";
        else if (doubleWinningsBalance > doubleLossesBalance)
            wonLossResultString = "<font color=yellow>" + usdFormat.format(winLossBalance) + " -- Win/Loss Result. Good job! It seems you've won most of the time. <br>======= <br> </font>";
        else 
            wonLossResultString = "<font color=orange>_" + usdFormat.format(winLossBalance) + " -- Win/Loss Result. Oops! This negative result shows you've lost most of the time.<br>======= <br> </font>";
            

        
        
        String burpBackAcountSammuryString = "<html><Blockquote> THE ESCAPE FROM ALCATRAZ ACCOUNT BALANCE <br>============================================ <br><br>Summary of Account for " + stringNameOfUser + ", aka " + stringRegAliasEntered + ": <br><br>" 
                + usdFormat.format(doubleTotalDeposit) + " -- Amount deposited into your account<br> " 
                + usdFormat.format(doubleCostTotalGame) + " -- Total ESCAPE Registration Fee <br>======= <br> " 
                + usdFormat.format(doubleTotalDeposit - doubleCostTotalGame) + " -- Current Account Balance <br><br> " 
                + wonString 
                + lossString
                + wonLossResultString
                + usdFormat.format(doubleAccountBalance) + " -- FINAL BALANCE <br><br><br> "
                + " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Thank you for playing Escape From Alcatraz "+ stringRegAliasEntered + "!</Blockquote> </html>";

        jLTextAccountSummary.setText(burpBackAcountSammuryString);
    }
    
    
    
    
    
    
    
    
    
    public class My_ActionListener implements ActionListener
{
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == jBGoHomePg)
        {
            displayWelcomeUserPg();
        }
                
        else if (e.getSource() == jBGoOverviewPg1) 
        {
            displayOverviewDescriptionPg();
        }
        
        else if (e.getSource() == jBGoSummaryExitPg) 
        {
            methodSummaryExit();
            showSummaryExitPg();
        }
                 
        else if (e.getSource() == jBGoOverviewRegFeePg) 
        {
            displayOverviewRegFeesPg();
        }
                
        else if (e.getSource() == jBGoLoginPg) 
        {
            displayLoginUserPg();
        }
        
        else if (e.getSource() == jBGoRegPgIfIDValid) 
        {
            methodResetAlcatraz();  //reset all boolean, int, double, array, textFields
            
            if(methodValidateLoginUserPass())
                displayRegisterUserPersonalInfoPg();
        }
        
        else if (e.getSource() == jBRegisterData) 
        {
            methodRegisterUser();
        }
        
        else if (e.getSource() == jBResetRegForm) 
        {
            methodRegisterReset();
        }
        
        else if (e.getSource() == jBGoToFeatureSelectPg) 
        {
            displaySelectFeaturesPg();
        }
        
        else if (e.getSource() == jBBackToRegUserInfoPg) 
        {
            displayRegisterUserPersonalInfoPg();
        }
        
        else if (e.getSource() == jBSubmitFeaturs) 
        {
            methodCalcSelectedFeatures();
        }
        
        else if (e.getSource() == jBGoToGameOptionPgNoRecord) //coming from I Agree page - 1st time start
        {
            doubleAccountBalance -= doubleCostTotalGame; //deduct game basic fee + feature fee  + service fee
            showGameOptionsPg();  //Game option page
        }
        
        else if (e.getSource() == jBGoToGameOptionPgNoCalc) //coming from history page and 1st hallway page
        {
            showGameOptionsPg();  //Game option page
        }
        
        else if (e.getSource() == jBGoToGameOptionPg) //coming from inside the game
        {
            jTextFieldSecondDeposit.setText("Amount");
            methodHistoryRecord();
            
            boolSoundGameOption = false; //let the sound play again
            showGameOptionsPg();  //Game option page
        }
        
        else if (e.getSource() == jBGoPlayPg) 
        {
            showFirstHallwayPg();
        }
        
        else if (e.getSource() == jBSolutionPath) 
        {
            boolSolutions = true;
            showFirstHallwayPg();
        }
        
        else if (e.getSource() == jBRayIdInfoPg) 
        {
            showIdInfoPg();
        }
        
        else if (e.getSource() == jBGoToMedia) 
        {
            System.out.println("Here is the showMedia method");
//            showMedia();
        }
        else if (e.getSource() == jBGoToShowStars) 
        {
            System.out.println("Here is the showStars method");
//            showStars();
        }
        else if (e.getSource() == jBExitProgram) 
        {
            System.exit(0);
        }
        else if (e.getSource() == jBSecondDeposit) 
        {
            methodCheckBalanceAndDeposit();                        
        }
        else if (e.getSource() == jBUnlock) 
        {
            methodValidatePasslock();
        }
        else if (e.getSource() == jBGoHistoryPg) 
        {
            showHistoryPg();                        
        }
        else if (e.getSource() == jBGoInstructionPg) 
        {
            showInstructionPg();                     
        }
        else if (e.getSource() == jBCalcHistoryShow) 
        {
            jBCalcHistoryShow.setEnabled(false);
            jBHisotyWriteToDisk.setEnabled(true);
            jBHisotyReadFromDisk.setEnabled(false);
            
            methodHistoryShow(); //it will calculate games history record
        }
        else if (e.getSource() == jBHisotyWriteToDisk) 
        {
            jBHisotyWriteToDisk.setEnabled(false);

            methodHistoryWriteToDisk();
        }
        else if (e.getSource() == jBHisotyReadFromDisk) 
        {
            methodHistoryReadFromDisk();
            jBHisotyReadFromDisk.setEnabled(false);
        }
        
    }
    }

    
    
public class My_FocusGained implements FocusListener
{
    
    //HIDES JTextField DEFAULT VALUES WHEN IT'S CLICKED
    @Override
    public void focusGained(FocusEvent e) 
    {
        //LOGIN
        if (e.getSource() == jTextFieldID)
        {
            jTextFieldID.setText(null);
        }
        else if (e.getSource() == jPasswordFieldID)
        {
            jPasswordFieldID.setText(null);
        }
        //REGISTRATION
        else if (e.getSource() == jTextFieldAlias)
        {
            jTextFieldAlias.setText(null); 
            jTextFieldAlias.setForeground(Color.black);
        }
        else if (e.getSource() == jTextFieldGender)
        {
            jTextFieldGender.setText(null); 
            jTextFieldGender.setForeground(Color.black);
        }
        else if (e.getSource() == jTextFieldAstroSign)
        {
            jTextFieldAstroSign.setText(null); 
            jTextFieldAstroSign.setForeground(Color.black);
        }
        else if (e.getSource() == jTextFieldBirthYear)
        {
            jTextFieldBirthYear.setText(null); 
            jTextFieldBirthYear.setForeground(Color.black);
        }
        else if (e.getSource() == jTextFieldDeposit)
        {
            jTextFieldDeposit.setText(null); 
            jTextFieldDeposit.setForeground(Color.black);
        }
        //SECOND DEPOSIT   
        else if (e.getSource() == jTextFieldSecondDeposit)
        {
            jTextFieldSecondDeposit.setForeground(Color.black);
            
            if(doubleAccountBalance >= FINAL_REQUIRED_BALANCE)
                jTextFieldSecondDeposit.setText("Play!");
            else
                jTextFieldSecondDeposit.setText(null);
        }
        //LOCK ROOM PASS
        else if (e.getSource() == jTextFieldPassDigit1)
        {
            if(!boolPassLockMatched1)
            {
                jTextFieldPassDigit1.setText(null); 
                jTextFieldPassDigit1.setForeground(Color.black);
            }
        }
        else if (e.getSource() == jTextFieldPassDigit2)
        {
            if(!boolPassLockMatched2)
            {
                jTextFieldPassDigit2.setText(null); 
                jTextFieldPassDigit2.setForeground(Color.black);
            }
        }
        else if (e.getSource() == jTextFieldPassDigit3)
        {
            if(!boolPassLockMatched3)
            {
                jTextFieldPassDigit3.setText(null); 
                jTextFieldPassDigit3.setForeground(Color.black);
            }
        }

    }
//    @Override
    public void focusLost(FocusEvent e) 
    {
        if (jTextFieldID.getText().isEmpty())
            jTextFieldID.setText("Enter ID");

        if (jPasswordFieldID.getText().isEmpty())
            jPasswordFieldID.setText("Password");

        if (jTextFieldAlias.getText().isEmpty())
        {
            jTextFieldAlias.setText("Required");
            jTextFieldAlias.setForeground(Color.gray);
        }
        
        if (jTextFieldGender.getText().isEmpty())
        {
            jTextFieldGender.setText("Optional");
            jTextFieldGender.setForeground(Color.gray);
        }
        
        if (jTextFieldAstroSign.getText().isEmpty())
        {
            jTextFieldAstroSign.setText("Optional");
            jTextFieldAstroSign.setForeground(Color.gray);
        }
        
        if (jTextFieldBirthYear.getText().isEmpty())
        {
            jTextFieldBirthYear.setText("Required");
            jTextFieldBirthYear.setForeground(Color.gray);
        }

        if (jTextFieldDeposit.getText().isEmpty())
        {
            jTextFieldDeposit.setText("Required");
            jTextFieldDeposit.setForeground(Color.gray);
        }

        if (jTextFieldSecondDeposit.getText().isEmpty())
        {
            jTextFieldSecondDeposit.setText("ex. 123.45");
            jTextFieldSecondDeposit.setForeground(Color.gray);
        }

        if (jTextFieldPassDigit1.getText().isEmpty())
        {
            jTextFieldPassDigit1.setText("two-digits");
            jTextFieldPassDigit1.setForeground(Color.gray);
        }

        if (jTextFieldPassDigit2.getText().isEmpty())
        {
            jTextFieldPassDigit2.setText("two-digits");
            jTextFieldPassDigit2.setForeground(Color.gray);
        }

        if (jTextFieldPassDigit3.getText().isEmpty())
        {
            jTextFieldPassDigit3.setText("two-digits");
            jTextFieldPassDigit3.setForeground(Color.gray);
        }


    }

}


public void methodClickSoundFeedback()
{
    if (!boolGameover) //normal clicks in game. no game over
    {
            try
        {
            clipMouseClick = AudioSystem.getClip();
            clipMouseClick.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"00-s-mouse-click-regular.wav")));
            clipMouseClick.start();
//            clipMouseClick.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: 00-s-mouse-click.wav file is not available"
                    + " Error Message - " + error);								
        }
    }
    else //if the user hits creatures or game over
    {
            try
        {
            clipMouseClick = AudioSystem.getClip();
            clipMouseClick.open(AudioSystem.getAudioInputStream(new File(STRING_URL +"00-s-mouse-click-failed.wav")));
            clipMouseClick.start();
//            clipMouseClick.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception error)
        {
            JOptionPane.showMessageDialog( null, "Warning: 00-s-mouse-click.wav file is not available"
                    + " Error Message - " + error);								
        }
        
    }
}


public class Mouse_Hallway extends MouseAdapter
{

    @Override
    public void mousePressed(MouseEvent e) 
    {
        methodClickSoundFeedback(); //sound feedback both regular and failed sounds
        
        ///// showFirstHallwayPg() /////
        if (e.getSource() == jLPicHallwayBG) 
        {
            int mouseClickedX = e.getX(),
                mouseClickedY = e.getY();
            final int MIN_X = 253,
                      MAX_X = 290,
                      MIN_Y = 539,
                      MAX_Y = 606;

            if (doubleAccountBalance >= FINAL_REQUIRED_BALANCE && mouseClickedX > MIN_X && mouseClickedX < MAX_X && mouseClickedY > MIN_Y && mouseClickedY < MAX_Y)
            {
                jBCalcHistoryShow.setEnabled(true);
                intCountGameNum++;
                doubleAccountBalance -= FINAL_EACH_GAME_COST; //subtract the game cost when user hits the play button
                doubleLossesBalance += FINAL_EACH_GAME_COST; //If the user wins at the end, this game cost will be subtracted from doubleLossesBalance to not be counted as a loss.
                methodResetForEachGame();
                showYourRoomPg(); //enter the next room
                
                //GENERATE LOCK ROOM PASSCODES
                Random ranMaker = new Random(); //random maker object
                intPassSet1 = ranMaker.nextInt(10) * 10; //1st set will be generated between 00 - 90
                intPassSet2 = ranMaker.nextInt(10) * 10; //2nd set will be generated between 00 - 90 
                intPassSet3 = ranMaker.nextInt(10) * 10; //3rd set will be generated between 00 - 90
            }
            
            else if (doubleAccountBalance < FINAL_REQUIRED_BALANCE && mouseClickedX > MIN_X && mouseClickedX < MAX_X && mouseClickedY > MIN_Y && mouseClickedY < MAX_Y) 
            {
                String MessageString = "<html><blockquote>Your balance is lower than " + usdFormat.format(FINAL_REQUIRED_BALANCE) 
                                        + ". Please hit the Quit button and either doposit some money or exit the game.</blockquote></html";
                
                jLTextHallwayMessage.setText(MessageString);
                jLTextHallwayMessageShadow.setText(MessageString);                        
            }
            
            else
            {
                String message = "<html><blockquote> Hmmm... Are you trying to enter your room from there?! <br> Becareful where you click!!!</blockquote></html>";
                jLTextHallwayMessage.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                jLTextHallwayMessageShadow.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
            }
                        
        }
       
    }
    
}


    
public class Mouse_Game extends MouseAdapter
{

    @Override
//    public void mouseClicked(MouseEvent e) 
    public void mousePressed(MouseEvent e)
    {
       
        intCountMouseClickTotal += e.getClickCount();
            System.out.println("total: " + intCountMouseClickTotal);
            
        intCountMouseClickEachGame += e.getClickCount();
            System.out.println("each: " + intCountMouseClickEachGame);
            
        int intClicksLeft = FINAL_CLICK_LIMIT - intCountMouseClickEachGame;
        jLTextCounterShow.setText("<html>  &nbsp; " + intClicksLeft + " Clicks Left </html>");
        if(intClicksLeft < 15)
        {
            jLTextCounterShow.setForeground(Color.red);
            jLTextCounterShow.setBackground(Color.yellow);
            jLTextCounterShow.setOpaque(true);
        }
        
        if(intCountMouseClickEachGame >= FINAL_CLICK_LIMIT)
        {
            jLTextCounterShow.setText("<html>  &nbsp; OVER CLICKED! </html>");
            jLTextCounterShow.setFont(new Font("Arial", Font.BOLD, 20));
            jLTextCounterShow.setOpaque(true);
            showFailurePg();
        }
        

        //if the user loses bool game over is true and with any click it goes to execution room
        if (boolGameover && !boolFoundCoinTreasure)
        {
            showFailurePg();
            jFrameFeatures.dispose();
        }
        else
        {
            ///// showYourRoomPg() /////
            if (e.getSource() == jLPicYourRoomBG)
            {                
                int mouseClickedX = e.getX(),
                    mouseClickedY = e.getY();
                final int MIN_X1 = 637,
                          MAX_X1 = 681,
                          MIN_Y1 = 404,
                          MAX_Y1 = 420;
                final int MIN_X2 = 1007,
                          MAX_X2 = 1200,
                          MIN_Y2 = 398,
                          MAX_Y2 = 800;

                if (!boolIndoorMap && mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {                
                    boolIndoorMap = true;
                    featureIndoorMapKeyPg(); //show indoor map jframe

                    String messageString = "<html>Nice job! <br> Now find a hotspot on one of the walls to get out of here.</html>";
                    jLTextYourRoomMessage.setText(messageString);
                    jLTextYourRoomMessageShadow.setText(messageString);
                }

                else if (boolIndoorMap && mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                { 
                    String messageString = "<html>You already have the map. Plase move on!</html>";
                    jLTextYourRoomMessage.setText(messageString);
                    jLTextYourRoomMessageShadow.setText(messageString);
                }

                else if (boolIndoorMap && mouseClickedX > MIN_X2 && mouseClickedX < MAX_X2 && mouseClickedY > MIN_Y2 && mouseClickedY < MAX_Y2)
                {
                    jFrameFeatures.dispose();
                    showCoinRoomPg();
                }

                else if (boolIndoorMap == false)
                {
                    String messageString = "<html>Oops! " + stringRegAliasEntered + ", you should find the indoor map to be able to get out of this hell! <br> Keep pushing the logs between the toilet and the ceiling to find the right one. </html>";
                    jLTextYourRoomMessage.setText(messageString);
                    jLTextYourRoomMessageShadow.setText(messageString);
                }
            }
            //close indoor map page
            if (e.getSource() == jLPicIndoorMap)
            {
                jFrameFeatures.dispose();
            }


            ///// showCoinRoomPg() /////
            if (e.getSource() == jLPicCoinRoomBG)
            {
                int mouseClickedX = e.getX(),
                    mouseClickedY = e.getY();
                final int MIN_X1 = 60, //Coin area
                          MAX_X1 = 140,
                          MIN_Y1 = 85,
                          MAX_Y1 = 215;
                final int MIN_X2 = 205, //Next room area
                          MAX_X2 = 415,
                          MIN_Y2 = 285,
                          MAX_Y2 = 600;
                final int MIN_X3 = 754, //Back room area
                          MAX_X3 = 950,
                          MIN_Y3 = 200,
                          MAX_Y3 = 780;

                //GOLD COIN TREASURE IS CLICKED/FOUND
                if (!boolFoundCoinTreasure && mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {
                    boolFoundCoinTreasure = true; //activate Gold Coint treasure. Saves life once. If it's not used adds $200 to balance

                    String messageString = "<html> WOWW!!! You've found the Gold Coin! It will help you avoid execution one time if you are caught by a guard. <br> NOTE: If you escape without using your Gold Coin, you can sell it for $200 which will be deposited to your account balance. </html>";
                    jLTextCoinRoomMessage.setText(messageString);
                    jLTextCoinRoomMessageShadow.setText(messageString);
                    featureCoinTreasurePg();
                }

                else if (boolFoundCoinTreasure && mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {
                    String messageString = "<html> You already have the Gold Coin. Move On! </html>";
                    jLTextCoinRoomMessage.setText(messageString);
                    jLTextCoinRoomMessageShadow.setText(messageString);
                }

                //NEXT ROOM IS CLICKED
                else if (mouseClickedX > MIN_X2 && mouseClickedX < MAX_X2 && mouseClickedY > MIN_Y2 && mouseClickedY < MAX_Y2)
                {
                    showFirstTonnelPg();
                    jFrameFeatures.dispose();
                }

                //BACK ROOM IS CLICKED
                else if (mouseClickedX > MIN_X3 && mouseClickedX < MAX_X3 && mouseClickedY > MIN_Y3 && mouseClickedY < MAX_Y3)
                {
                    String messageString = "<html>You already have the map. Plase move on!</html>";
                    jLTextYourRoomMessage.setText(messageString);
                    jLTextYourRoomMessageShadow.setText(messageString);
                    showYourRoomPg();
                    jFrameFeatures.dispose();
                }

                else
                {
                    String message = displayWrongClickMessage();
                    jLTextCoinRoomMessage.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                    jLTextCoinRoomMessageShadow.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                }

            }
            //close Gold Coin page
            if (e.getSource() == jLPicCoin)
            {
                jFrameFeatures.setVisible(false);
            }


            ///// showFirstTonnelPg() /////
            if (e.getSource() == jLPicFirstTonnelBG) 
            {
                boolGameover = false;

                int mouseClickedX = e.getX(),
                    mouseClickedY = e.getY();
                final int MIN_X1 = 580,  //next room area
                          MAX_X1 = 680,
                          MIN_Y1 = 370,
                          MAX_Y1 = 520;
                final int MIN_X2 = 680,  //creature area
                          MAX_X2 = 790,
                          MIN_Y2 = 365,
                          MAX_Y2 = 530;


                if (mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {
                    jFrameFeatures.dispose();
                    showLifevistGuardPg();
                }

                else if (!boolGameover && mouseClickedX > MIN_X2 && mouseClickedX < MAX_X2 && mouseClickedY > MIN_Y2 && mouseClickedY < MAX_Y2)
                {
                    featureGuardCreaturePg();                
                    mouseClickedX = 0;
                    mouseClickedY = 0;
                }

                else
                {
                    String message = displayWrongClickMessage();
                    jLTextFirstTonnelMessage.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                    jLTextFirstTonnelMessageShadow.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                }

            }


            ///// showLifevistGuardPg() /////
            if (e.getSource() == jLPicLifevestBG) 
            {

                int mouseClickedX = e.getX(),
                    mouseClickedY = e.getY();
                final int MIN_X1 = 530,  //next room area
                          MAX_X1 = 1200,
                          MIN_Y1 = 75,
                          MAX_Y1 = 500;
                final int MIN_X2 = 0,  //creature area
                          MAX_X2 = 515,
                          MIN_Y2 = 75,
                          MAX_Y2 = 680;


                if (mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {
                    showBeerRoomPg();
                }

                else if (mouseClickedX > MIN_X2 && mouseClickedX < MAX_X2 && mouseClickedY > MIN_Y2 && mouseClickedY < MAX_Y2)
                {
                    featureGuardCreaturePg();
                    mouseClickedX = 0;
                    mouseClickedY = 0;                   
                }

                else
                {
                    String message = displayWrongClickMessage();
                    jLTextFirstTonnelMessage.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                    jLTextFirstTonnelMessageShadow.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                }


            }


            ///// showBeerRoomPg() /////
            if (e.getSource() == jLPicBeerRoomBG)
            {
                boolGameover = false;

                int mouseClickedX = e.getX(),
                    mouseClickedY = e.getY();
                final int MIN_X1 = 310, //beer bottle area
                          MAX_X1 = 390,
                          MIN_Y1 = 515,
                          MAX_Y1 = 670;
                final int MIN_X2 = 655, //creature area
                          MAX_X2 = 700,
                          MIN_Y2 = 175,
                          MAX_Y2 = 240;
                final int MIN_X3 = 740, //next room area
                          MAX_X3 = 870,
                          MIN_Y3 = 250,
                          MAX_Y3 = 550;

                if (!boolBeerFound && mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {
                    boolBeerFound = true; //beer is found and taken so user can pass the outdoor map level
                    featureBeerTreasurePg();
                }

                else if (boolBeerFound && mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {
                    String messageBeerFound = "You alreay have the beer bottle. Move on!";
                    jLTextBeerRoomMessage.setText(messageBeerFound); //Wrong spot is clicked. 5 random messages from an array. 
                    jLTextBeerRoomMessageShadow.setText(messageBeerFound); //Wrong spot is clicked. 5 random messages from an array. 
                }

                else if (mouseClickedX > MIN_X2 && mouseClickedX < MAX_X2 && mouseClickedY > MIN_Y2 && mouseClickedY < MAX_Y2)
                {
                    featureGuardCreaturePg();
                    mouseClickedX = 0;
                    mouseClickedY = 0;                   
                }

                else if (mouseClickedX > MIN_X3 && mouseClickedX < MAX_X3 && mouseClickedY > MIN_Y3 && mouseClickedY < MAX_Y3)
                {
                    jFrameFeatures.dispose();
                    showTonnelOutdoorPg(); //go to the next page 
                }

                else
                {
                    String message = displayWrongClickMessage();
                    jLTextBeerRoomMessage.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                    jLTextBeerRoomMessageShadow.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                }

            }
            //close beer bottle treasure page
            if (e.getSource() == jLPicBeer)
            {
                jFrameFeatures.dispose();
                String messageBeerFound = "You got it! Now find to the alcoholic guard and give him the bottle for the outdoor map.";
                jLTextBeerRoomMessage.setText(messageBeerFound);  
                jLTextBeerRoomMessageShadow.setText(messageBeerFound); 
            }

            ///// showTonnelOutdoorPg() /////
            if (e.getSource() == jLPicTonnelOutdoorBG)
            {
                boolGameover = false;

                int mouseClickedX = e.getX(),
                    mouseClickedY = e.getY();
                final int MIN_X1 = 815, //previous room area
                          MAX_X1 = 1070,
                          MIN_Y1 = 160,
                          MAX_Y1 = 555;
                final int MIN_X2 = 565, //next room area
                          MAX_X2 = 650,
                          MIN_Y2 = 220,
                          MAX_Y2 = 360;
                final int MIN_X3 = 415, //creature area
                          MAX_X3 = 525,
                          MIN_Y3 = 200,
                          MAX_Y3 = 320;
                final int MIN_X4 = 210, //Gold coin treasure
                          MAX_X4 = 335,
                          MIN_Y4 = 195,
                          MAX_Y4 = 340;


                if (mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {
                    jFrameFeatures.dispose();                
                    showBeerRoomPg(); //previous room
                }

                else if (mouseClickedX > MIN_X2 && mouseClickedX < MAX_X2 && mouseClickedY > MIN_Y2 && mouseClickedY < MAX_Y2)
                {
                    jFrameFeatures.dispose();
                    showOutdoorMapPg();
                }

                else if (!boolGameover && mouseClickedX > MIN_X3 && mouseClickedX < MAX_X3 && mouseClickedY > MIN_Y3 && mouseClickedY < MAX_Y3)
                {
                    mouseClickedX = 0;
                    mouseClickedY = 0;                   
                    featureGuardCreaturePg(); //next room
                }

                //GOLD COIN TREASURE IS CLICKED/FOUND
                else if (!boolFoundCoinTreasure && mouseClickedX > MIN_X4 && mouseClickedX < MAX_X4 && mouseClickedY > MIN_Y4 && mouseClickedY < MAX_Y4)
                {
                    boolFoundCoinTreasure = true; //activate Gold Coint treasure. Saves life once. If it's not used adds $200 to balance

                    String messageString = "<html> WOWW!!! You've found the Gold Coin! It will help you avoid execution one time if you are caught by a guard. <br> NOTE: If you escape without using your Gold Coin, you can sell it for $200 which will be deposited to your account balance. </html>";
                    jLTextCoinRoomMessage.setText(messageString);
                    jLTextCoinRoomMessageShadow.setText(messageString);
                    featureCoinTreasurePg();
                }
                //GOLD COIN IS ALREADY FOUND
                else if (boolFoundCoinTreasure && mouseClickedX > MIN_X4 && mouseClickedX < MAX_X4 && mouseClickedY > MIN_Y4 && mouseClickedY < MAX_Y4)
                {
                    String messageString = "<html> You already have the Gold Coin. Move On! </html>";
                    jLTextCoinRoomMessage.setText(messageString);
                    jLTextCoinRoomMessageShadow.setText(messageString);
                }

                else
                {
                    String message = displayWrongClickMessage();
                    jLTextTonnelOutdoorMessage.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                    jLTextTonnelOutdoorMessageShadow.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                }

            }


            //showOutdoorMapPg()
            if (e.getSource() == jLPicOutdoorMapBG)
            {
                if(boolBeerFound == true)  //if the user found the beer go to the next page
                    showNumLockPg();
                else
                    showTonnelOutdoorPg(); //if the beer is not found return the user to the previous place
            }



            ///// showOpenGatePg() /////
            if (e.getSource() == jLPicOpenGateBG)
            {
                boolGameover = false;

                int mouseClickedX = e.getX(),
                    mouseClickedY = e.getY();
                final int MIN_X1 = 180, //left creature area
                          MAX_X1 = 400,
                          MIN_Y1 = 245,
                          MAX_Y1 = 615;
                final int MIN_X2 = 680, //right creature area
                          MAX_X2 = 900,
                          MIN_Y2 = 250,
                          MAX_Y2 = 630;
                final int MIN_X3 = 510, //Exit Gate area
                          MAX_X3 = 580,
                          MIN_Y3 = 290,
                          MAX_Y3 = 475;

                if (!boolGameover && mouseClickedX > MIN_X1 && mouseClickedX < MAX_X1 && mouseClickedY > MIN_Y1 && mouseClickedY < MAX_Y1)
                {
                    featureGuardCreaturePg();
                    mouseClickedX = 0;
                    mouseClickedY = 0;                   
                }

                else if (!boolGameover && mouseClickedX > MIN_X2 && mouseClickedX < MAX_X2 && mouseClickedY > MIN_Y2 && mouseClickedY < MAX_Y2)
                {
                    featureGuardCreaturePg();
                    mouseClickedX = 0;
                    mouseClickedY = 0;                   
                }

                else if (mouseClickedX > MIN_X3 && mouseClickedX < MAX_X3 && mouseClickedY > MIN_Y3 && mouseClickedY < MAX_Y3)
                {
                    boolSuccessFailEscape = true;

                    if(boolFoundCoinTreasure)
                    {
                        doubleAccountBalance += FINAL_WIN_TREASURE_PRISE;  //if user escapes with a Gold Coin treasure which is not used. 
                        doubleWinningsBalance += FINAL_WIN_TREASURE_PRISE;  //add it to the total of user winning
                    }

                    doubleAccountBalance += FINAL_WIN_PRISE;  //successful escape. $100 gift.
                    doubleWinningsBalance += FINAL_WIN_PRISE - FINAL_EACH_GAME_COST;  //total of how much the user wins - the $25 game cost is deducted
                    doubleLossesBalance -= FINAL_EACH_GAME_COST; //it's returned to not be counted as a loss



                    showFreedomPg(); //go to the freedome page 
                }

                else
                {
                    String message = displayWrongClickMessage();
                    jLTextOpenGateMessage.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                    jLTextOpenGateMessageShadow.setText(message); //Wrong spot is clicked. 5 random messages from an array. 
                }

            }


            //close guard creature page
            if (e.getSource() == jLPicCreatureGuard)
            {
                if(!boolGameover)
                {
                    jFrameFeatures.dispose();
                }            
                else
                    showFailurePg();

                jFrameFeatures.setVisible(false);

            }
            
            methodClickSoundFeedback(); //sound feedback both regular and failed sounds
            
            //disable the Quit button to force execution page if gameover is true. 
            jBGoToGameOptionPg.setEnabled(!boolGameover);

        }


        
    }
    }

    
}
    
    

