/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.project;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Shubh
 */
public class calculator extends javax.swing.JFrame {

    /**
     * Creates new form calculator
     */
    
    
    long num, ans, prevNum = 0;
    int calculation, mode, wordsize = 1;
    boolean equalPress = false;
    
    Stack<String> oprStack = new Stack<String>();
    Stack<Integer> numStack = new Stack<Integer>();
    
    public calculator() {
        initComponents();
        
        DecimalMode();      //this open the calculator in decimal mode by default. 
    }
    
    //checks if the number entered is within bounds.
    public boolean limitCheck(int num){
        
        long future = Long.parseLong(dec_Num.getText())*10 + num;
        
        if(wordsize == 2){
            //double Word
            if(future > 2147483647 || future < -2147483647){
                return false;
            }  
        }
        else if(wordsize == 3){
          //word
            if(future > 32767 || future < -23768){
                return false;
            }  
        }
        
        else if(wordsize == 4){
            //bytes
            if(future > 127 || future < -128){
                return false;
            }
        }
        
        return true;
        
    } 
    
    //function to take care of all operations in decimal mode
    public void decimalOperation(){
     switch(calculation){
                        //addition
                        case 1: ans = prevNum + Long.parseLong(MainDisplay.getText());
                                MainDisplay.setText(Long.toString(ans));
                                break;
                        //substraction    
                        case 2: ans = prevNum - Long.parseLong(MainDisplay.getText());
                                MainDisplay.setText(Long.toString(ans));
                                break;
                        // multiplication    
                        case 3: ans = prevNum * Long.parseLong(MainDisplay.getText());
                                MainDisplay.setText(Long.toString(ans));
                                break;
                        //division    
                        case 4: ans = prevNum / Long.parseLong(MainDisplay.getText());
                                MainDisplay.setText(Long.toString(ans));
                                break;
                        //modulous    
                        case 5: ans = prevNum % Long.parseLong(MainDisplay.getText());
                                MainDisplay.setText(Long.toString(ans));
                                break;    
            } 
}
    //function to take care of all operations in Hexadecimal mode
    public void HexOperation(){
        switch(calculation){
                        
                        //addition
                        case 1: ans = prevNum + Long.parseLong(MainDisplay.getText(),16);
                                MainDisplay.setText(Long.toHexString(ans));
                                break;
            
                        //subtraction    
                        case 2: ans = prevNum - Long.parseLong(MainDisplay.getText(),16);
                                MainDisplay.setText(Long.toHexString(ans));
                                break;
                        //multiplication    
                        case 3: ans = prevNum * Long.parseLong(MainDisplay.getText(),16);
                                MainDisplay.setText(Long.toHexString(ans));
                                break;
                        //division    
                        case 4: ans = prevNum / Long.parseLong(MainDisplay.getText(),16);
                                MainDisplay.setText(Long.toHexString(ans));
                                break;
                        //modulous    
                        case 5: ans = prevNum % Long.parseLong(MainDisplay.getText(),16);
                                MainDisplay.setText(Long.toHexString(ans));
                                break;    
            }
    }
    //function to take care of all operations in Binary mode
    public void BinaryOperation(){
                switch(calculation){
            
                        //addition
                        case 1: ans = prevNum + Long.parseLong(MainDisplay.getText(),2);
                                MainDisplay.setText(Long.toBinaryString(ans));
                                break;
                        //subtraction    
                        case 2: ans = prevNum - Long.parseLong(MainDisplay.getText(),2);
                                MainDisplay.setText(Long.toBinaryString(ans));
                                break;
                        //multiplication    
                        case 3: ans = prevNum * Long.parseLong(MainDisplay.getText(),2);
                                MainDisplay.setText(Long.toBinaryString(ans));
                                break;
                        //division    
                        case 4: ans = prevNum / Long.parseLong(MainDisplay.getText(),2);
                                MainDisplay.setText(Long.toBinaryString(ans));
                                break;
                         //modulous   
                        case 5: ans = prevNum % Long.parseLong(MainDisplay.getText(),2);
                                MainDisplay.setText(Long.toBinaryString(ans));
                                break;    
            }
    } 
    
    //function to take care of all operations in Hexadecimal mode
    public void OctOperation(){
           switch(calculation){
                        
                        //addition
                        case 1: ans = prevNum + Long.parseLong(MainDisplay.getText(),8);
                                MainDisplay.setText(Long.toOctalString(ans));
                                break;
                        //subtraction
                        case 2: ans = prevNum - Long.parseLong(MainDisplay.getText(),8);
                                MainDisplay.setText(Long.toOctalString(ans));
                                break;
                        //multiplication    
                        case 3: ans = prevNum * Long.parseLong(MainDisplay.getText(),8);
                                MainDisplay.setText(Long.toOctalString(ans));
                                break;
                        //division    
                        case 4: ans = prevNum / Long.parseLong(MainDisplay.getText(),8);
                                MainDisplay.setText(Long.toOctalString(ans));
                                break;
                        //modlous    
                        case 5: ans = prevNum % Long.parseLong(MainDisplay.getText(),8);
                                MainDisplay.setText(Long.toOctalString(ans));
                                break;    
            }
    }
   
    //driver function for all the operation function.
    public void operations(){
        
        switch(mode){
            
            case 1: HexOperation();
                     break;
            
            case 2: decimalOperation();
                     break;  
            
            case 3: OctOperation();
                     break;
            
            case 4: BinaryOperation();    
                     break;
        }
    }
    
    //set the calculator in binary mode
    public void binaryMode(){
        
      
        button_A.setEnabled(false);
        button_B.setEnabled(false);
        button_C.setEnabled(false);
        button_D.setEnabled(false);
        button_E.setEnabled(false);
        button_F.setEnabled(false);
        button_8.setEnabled(false);
        button_9.setEnabled(false);
        button_7.setEnabled(false);
        button_6.setEnabled(false);
        button_5.setEnabled(false);
        button_4.setEnabled(false);
        button_3.setEnabled(false);
        button_2.setEnabled(false);
       
        button_1.setEnabled(true);
        button_0.setEnabled(true);
        
        mode = 4;
    }
    
    //set the calculator in Octal mode
    public void OctalMode(){
        
        button_A.setEnabled(false);
        button_B.setEnabled(false);
        button_C.setEnabled(false);
        button_D.setEnabled(false);
        button_F.setEnabled(false);
        button_E.setEnabled(false);
        button_8.setEnabled(false);
        button_9.setEnabled(false);

        button_0.setEnabled(true);        
        button_1.setEnabled(true);
        button_2.setEnabled(true);
        button_3.setEnabled(true);
        button_4.setEnabled(true);
        button_5.setEnabled(true);
        button_6.setEnabled(true);
        button_7.setEnabled(true);
        
        mode = 3;
    }
    
    //set the calculator in decimal mode
    public void DecimalMode(){
        
        button_A.setEnabled(false);
        button_B.setEnabled(false);
        button_C.setEnabled(false);
        button_D.setEnabled(false);
        button_F.setEnabled(false);
        button_E.setEnabled(false);
        button_decimal.setEnabled(false);
        
        button_1.setEnabled(true);
        button_2.setEnabled(true);
        button_3.setEnabled(true);
        button_4.setEnabled(true);
        button_5.setEnabled(true);
        button_6.setEnabled(true);
        button_7.setEnabled(true);
        button_8.setEnabled(true);
        button_9.setEnabled(true);
        button_0.setEnabled(true);
        
        mode = 2;
    }
    
    //set the calculator in Hexadecimal mode
    public void HexMode(){
        
        button_1.setEnabled(true);
        button_2.setEnabled(true);
        button_3.setEnabled(true);
        button_4.setEnabled(true);
        button_5.setEnabled(true);
        button_6.setEnabled(true);
        button_7.setEnabled(true);
        button_8.setEnabled(true);
        button_9.setEnabled(true);
        button_0.setEnabled(true);
        button_A.setEnabled(true);
        button_B.setEnabled(true);
        button_C.setEnabled(true);
        button_D.setEnabled(true);
        button_E.setEnabled(true);
        button_F.setEnabled(true);
        
        mode = 1;
    }

    //Driver function for all mode display functions.
    public void secondaryDisplay(){
        toDecimal();
        toBinary();
        toHexa();
        toOctal();       
    }
    
    //converts the entered number to binary
    public void toBinary(){
       long entry = Long.parseLong(dec_Num.getText());
        bin_num.setText(Long.toBinaryString(entry));
  }
    //converts the entered number to Octal
    public void toOctal(){
       long entry = Long.parseLong(dec_Num.getText());
        oct_num.setText(Long.toOctalString(entry));
    }

    //converts the entered number to Hexadecimal
    public void toHexa(){
       long entry = Long.parseLong(dec_Num.getText());
       String upper =  Long.toHexString(entry);
       hex_Num.setText(upper.toUpperCase());
  }
    
    //converts the entered number to decimal
    public void toDecimal(){
       long entry;
       switch(mode){
           case 1:  entry = Long.parseLong(MainDisplay.getText(),16);   
                    dec_Num.setText(Long.toString(entry));
                    break;
           case 2: entry = Long.parseLong(MainDisplay.getText());   
                    dec_Num.setText(Long.toString(entry));
                    break;
           case 3: entry = Long.parseLong(MainDisplay.getText(),8);   
                    dec_Num.setText(Long.toString(entry));
                    break;
           case 4: entry = Long.parseLong(MainDisplay.getText(),2);   
                    dec_Num.setText(Long.toString(entry));
                    break;    
       }
       
       
    }
    
    //Checks if this is the first value
    public boolean nullVal(){
        
        if(MainDisplay.getText().equals("0")){
            return true;
        }
        return false;
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MainDisplay = new javax.swing.JTextField();
        button_Lsh = new javax.swing.JButton();
        button_Rsh = new javax.swing.JButton();
        button_or = new javax.swing.JButton();
        button_Xor = new javax.swing.JButton();
        button_Not = new javax.swing.JButton();
        button_And = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        button_divide = new javax.swing.JButton();
        button_mod = new javax.swing.JButton();
        button_ClrEqn = new javax.swing.JButton();
        button_Clear = new javax.swing.JButton();
        button_Del = new javax.swing.JButton();
        button_7 = new javax.swing.JButton();
        button_A = new javax.swing.JButton();
        button_B = new javax.swing.JButton();
        button_mult = new javax.swing.JButton();
        button_8 = new javax.swing.JButton();
        button_9 = new javax.swing.JButton();
        button_minus = new javax.swing.JButton();
        button_5 = new javax.swing.JButton();
        button_C = new javax.swing.JButton();
        button_6 = new javax.swing.JButton();
        button_4 = new javax.swing.JButton();
        button_D = new javax.swing.JButton();
        button_F = new javax.swing.JButton();
        button_2 = new javax.swing.JButton();
        button_1 = new javax.swing.JButton();
        button_Plus = new javax.swing.JButton();
        button_E = new javax.swing.JButton();
        button_3 = new javax.swing.JButton();
        button_Sign = new javax.swing.JButton();
        button_equals = new javax.swing.JButton();
        button_decimal = new javax.swing.JButton();
        button_0 = new javax.swing.JButton();
        button_openBracket = new javax.swing.JButton();
        button_closeBracket = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        WordSize = new javax.swing.JButton();
        oct_num = new javax.swing.JTextField();
        hex_Num = new javax.swing.JTextField();
        dec_Num = new javax.swing.JTextField();
        bin_num = new javax.swing.JTextField();
        button_Dec = new javax.swing.JToggleButton();
        button_Hex = new javax.swing.JToggleButton();
        button_Oct = new javax.swing.JToggleButton();
        button_Bin = new javax.swing.JToggleButton();
        stackDisplay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setResizable(false);
        setSize(new java.awt.Dimension(450, 680));
        setType(java.awt.Window.Type.UTILITY);

        MainDisplay.setEditable(false);
        MainDisplay.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        MainDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        MainDisplay.setText("0");
        MainDisplay.setBorder(null);
        MainDisplay.setOpaque(false);

        button_Lsh.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_Lsh.setText("Lsh");

        button_Rsh.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_Rsh.setText("Rsh");

        button_or.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_or.setText("Or");

        button_Xor.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_Xor.setText("Xor");

        button_Not.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_Not.setText("Not");

        button_And.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_And.setText("And");

        jButton7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shubh\\Pictures\\button3.PNG")); // NOI18N
        jButton7.setToolTipText("");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        button_divide.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_divide.setText("÷");
        button_divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_divideActionPerformed(evt);
            }
        });

        button_mod.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_mod.setText("Mod");
        button_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modActionPerformed(evt);
            }
        });

        button_ClrEqn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_ClrEqn.setText("CE");
        button_ClrEqn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ClrEqnActionPerformed(evt);
            }
        });

        button_Clear.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_Clear.setText("C");
        button_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ClearActionPerformed(evt);
            }
        });

        button_Del.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_Del.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shubh\\Pictures\\Capture (2).PNG")); // NOI18N
        button_Del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DelActionPerformed(evt);
            }
        });

        button_7.setBackground(new java.awt.Color(255, 255, 255));
        button_7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_7.setText("7");
        button_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_7ActionPerformed(evt);
            }
        });

        button_A.setBackground(new java.awt.Color(255, 255, 255));
        button_A.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_A.setText("A");
        button_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AActionPerformed(evt);
            }
        });

        button_B.setBackground(new java.awt.Color(255, 255, 255));
        button_B.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_B.setText("B");
        button_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_BActionPerformed(evt);
            }
        });

        button_mult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_mult.setText("×");
        button_mult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_multActionPerformed(evt);
            }
        });

        button_8.setBackground(new java.awt.Color(255, 255, 255));
        button_8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_8.setText("8");
        button_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_8ActionPerformed(evt);
            }
        });

        button_9.setBackground(new java.awt.Color(255, 255, 255));
        button_9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_9.setText("9");
        button_9.setBorder(null);
        button_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_9ActionPerformed(evt);
            }
        });

        button_minus.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_minus.setText("—");
        button_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_minusActionPerformed(evt);
            }
        });

        button_5.setBackground(new java.awt.Color(255, 255, 255));
        button_5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_5.setText("5");
        button_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_5ActionPerformed(evt);
            }
        });

        button_C.setBackground(new java.awt.Color(255, 255, 255));
        button_C.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_C.setText("C");
        button_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_CActionPerformed(evt);
            }
        });

        button_6.setBackground(new java.awt.Color(255, 255, 255));
        button_6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_6.setText("6");
        button_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_6ActionPerformed(evt);
            }
        });

        button_4.setBackground(new java.awt.Color(255, 255, 255));
        button_4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_4.setText("4");
        button_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_4ActionPerformed(evt);
            }
        });

        button_D.setBackground(new java.awt.Color(255, 255, 255));
        button_D.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_D.setText("D");
        button_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DActionPerformed(evt);
            }
        });

        button_F.setBackground(new java.awt.Color(255, 255, 255));
        button_F.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_F.setText("F");
        button_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_FActionPerformed(evt);
            }
        });

        button_2.setBackground(new java.awt.Color(255, 255, 255));
        button_2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_2.setText("2");
        button_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_2ActionPerformed(evt);
            }
        });

        button_1.setBackground(new java.awt.Color(255, 255, 255));
        button_1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_1.setText("1");
        button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_1ActionPerformed(evt);
            }
        });

        button_Plus.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_Plus.setText("+");
        button_Plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_PlusActionPerformed(evt);
            }
        });

        button_E.setBackground(new java.awt.Color(255, 255, 255));
        button_E.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_E.setText("E");
        button_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_EActionPerformed(evt);
            }
        });

        button_3.setBackground(new java.awt.Color(255, 255, 255));
        button_3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_3.setText("3");
        button_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_3ActionPerformed(evt);
            }
        });

        button_Sign.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_Sign.setText("+/-");
        button_Sign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SignActionPerformed(evt);
            }
        });

        button_equals.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_equals.setText("=");
        button_equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_equalsActionPerformed(evt);
            }
        });

        button_decimal.setText(".");
        button_decimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_decimalActionPerformed(evt);
            }
        });

        button_0.setBackground(new java.awt.Color(255, 255, 255));
        button_0.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        button_0.setText("0");
        button_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_0ActionPerformed(evt);
            }
        });

        button_openBracket.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_openBracket.setText("(");
        button_openBracket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_openBracketActionPerformed(evt);
            }
        });

        button_closeBracket.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        button_closeBracket.setText(")");
        button_closeBracket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_closeBracketActionPerformed(evt);
            }
        });

        jButton38.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButton38.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shubh\\Pictures\\button2.PNG")); // NOI18N
        jButton38.setBorder(null);

        jButton39.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButton39.setText("MS");
        jButton39.setBorder(null);

        jButton40.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButton40.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shubh\\Pictures\\button1 (2).PNG")); // NOI18N
        jButton40.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton40.setBorderPainted(false);

        jButton41.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButton41.setText("M");
        jButton41.setBorder(null);

        WordSize.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        WordSize.setText("QWord");
        WordSize.setBorder(null);
        WordSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WordSizeActionPerformed(evt);
            }
        });

        oct_num.setBackground(new java.awt.Color(240, 240, 240));
        oct_num.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        oct_num.setText("0");
        oct_num.setBorder(null);
        oct_num.setPreferredSize(new java.awt.Dimension(69, 25));

        hex_Num.setBackground(new java.awt.Color(240, 240, 240));
        hex_Num.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        hex_Num.setText("0");
        hex_Num.setBorder(null);
        hex_Num.setPreferredSize(new java.awt.Dimension(69, 25));

        dec_Num.setBackground(new java.awt.Color(240, 240, 240));
        dec_Num.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        dec_Num.setText("0");
        dec_Num.setBorder(null);
        dec_Num.setPreferredSize(new java.awt.Dimension(69, 25));

        bin_num.setBackground(new java.awt.Color(240, 240, 240));
        bin_num.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        bin_num.setText("0");
        bin_num.setBorder(null);
        bin_num.setPreferredSize(new java.awt.Dimension(69, 25));

        buttonGroup1.add(button_Dec);
        button_Dec.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        button_Dec.setSelected(true);
        button_Dec.setText("DEC");
        button_Dec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DecActionPerformed(evt);
            }
        });

        buttonGroup1.add(button_Hex);
        button_Hex.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        button_Hex.setText("HEX");
        button_Hex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_HexActionPerformed(evt);
            }
        });

        buttonGroup1.add(button_Oct);
        button_Oct.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        button_Oct.setText("OCT");
        button_Oct.setMaximumSize(new java.awt.Dimension(55, 25));
        button_Oct.setMinimumSize(new java.awt.Dimension(55, 25));
        button_Oct.setPreferredSize(new java.awt.Dimension(55, 25));
        button_Oct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_OctActionPerformed(evt);
            }
        });

        buttonGroup1.add(button_Bin);
        button_Bin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        button_Bin.setText("BIN");
        button_Bin.setBorder(null);
        button_Bin.setBorderPainted(false);
        button_Bin.setMaximumSize(new java.awt.Dimension(55, 25));
        button_Bin.setMinimumSize(new java.awt.Dimension(55, 25));
        button_Bin.setPreferredSize(new java.awt.Dimension(55, 25));
        button_Bin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_BinActionPerformed(evt);
            }
        });

        stackDisplay.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        stackDisplay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainDisplay)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(hex_Num, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_Dec, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dec_Num, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button_Hex, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button_Bin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bin_num, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button_Oct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(oct_num, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WordSize, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(button_Lsh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_Rsh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_or, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_Xor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_Not, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_And, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_ClrEqn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_Del, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_divide, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(button_A, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_B, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_mult, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(button_C, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_D, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_minus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(button_E, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_F, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_Plus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(button_openBracket, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_closeBracket, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_Sign, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button_equals, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(stackDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(stackDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hex_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Hex))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dec_Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Dec))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oct_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Oct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bin_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Bin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WordSize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Lsh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Rsh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_or, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Xor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Not, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_And, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_ClrEqn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Del, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_divide, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_A, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_B, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_mult, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_C, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_D, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_minus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_E, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_F, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Plus, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_openBracket, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_closeBracket, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_Sign, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_equals, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_8ActionPerformed
        if(limitCheck(8)){
        if(nullVal() || equalPress){
             MainDisplay.setText("8");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "8");
        }
        secondaryDisplay();
        }
    }//GEN-LAST:event_button_8ActionPerformed

    private void button_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_1ActionPerformed
        if(limitCheck(1)){
            if(nullVal() || equalPress){
             MainDisplay.setText("1");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "1");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_1ActionPerformed

    private void button_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_2ActionPerformed
        if(limitCheck(2)){ 
        if(nullVal() || equalPress){
             MainDisplay.setText("2");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "2");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_2ActionPerformed

    private void button_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_3ActionPerformed
        if(limitCheck(3)){
        if(nullVal() || equalPress){
             MainDisplay.setText("3");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "3");
        }
        secondaryDisplay();
        }
    }//GEN-LAST:event_button_3ActionPerformed

    private void button_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_4ActionPerformed
        if(limitCheck(4)){
        if(nullVal() || equalPress){
             MainDisplay.setText("4");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "4");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_4ActionPerformed

    private void button_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_5ActionPerformed
        if(limitCheck(5)){ 
        if(nullVal() || equalPress){
             MainDisplay.setText("5");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "5");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_5ActionPerformed

    private void button_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_6ActionPerformed
        if(limitCheck(6)){ 
        if(nullVal() || equalPress){
             MainDisplay.setText("6");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "6");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_6ActionPerformed

    private void button_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_7ActionPerformed
        if(limitCheck(7)){ 
        if(nullVal() || equalPress){
             MainDisplay.setText("7");
        }
        else{ 
        MainDisplay.setText(MainDisplay.getText() + "7");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_7ActionPerformed

    private void button_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_9ActionPerformed
        if(limitCheck(9)){ 
        if(nullVal() || equalPress){
             MainDisplay.setText("9");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "9");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_9ActionPerformed

    private void button_openBracketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_openBracketActionPerformed
         if(nullVal() || equalPress){
             MainDisplay.setText("(");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "(");
         }
    }//GEN-LAST:event_button_openBracketActionPerformed

    private void button_closeBracketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_closeBracketActionPerformed
         if(nullVal() || equalPress){
             MainDisplay.setText(")");
        }
        else{ 
        MainDisplay.setText(MainDisplay.getText() + ")");
         }
    }//GEN-LAST:event_button_closeBracketActionPerformed

    private void button_decimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_decimalActionPerformed
         if(nullVal()){
             MainDisplay.setText(".");
        }
        else{ 
        MainDisplay.setText(MainDisplay.getText() + ".");
         }
    }//GEN-LAST:event_button_decimalActionPerformed

    private void button_equalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_equalsActionPerformed
        equalPress = true;
        operations();
        secondaryDisplay();
        stackDisplay.setText("");
        prevNum = 0;
    }//GEN-LAST:event_button_equalsActionPerformed

    private void button_divideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_divideActionPerformed
        
        switch(mode){
        
            case 1: num = Long.parseLong(MainDisplay.getText(),16);
                    break;
            case 2: num = Long.parseLong(MainDisplay.getText());
                    break;    
            case 3: num = Long.parseLong(MainDisplay.getText(),8);
                    break;
            case 4: num = Long.parseLong(MainDisplay.getText(),2);
                    break;    
        } 
        calculation = 4;
        
         prevNum /= num;
         
        stackDisplay.setText(stackDisplay.getText()+ MainDisplay.getText() + "÷");
        MainDisplay.setText("");
                
    }//GEN-LAST:event_button_divideActionPerformed

    private void button_multActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_multActionPerformed
      
        switch(mode){
        
            case 1: num = Long.parseLong(MainDisplay.getText(),16);
                    break;
            case 2: num = Long.parseLong(MainDisplay.getText());
                    break;    
            case 3: num = Long.parseLong(MainDisplay.getText(),8);
                    break;
            case 4: num = Long.parseLong(MainDisplay.getText(),2);
                    break;    
        }
        calculation = 3;
        
    prevNum *= num;

        stackDisplay.setText(stackDisplay.getText()+ MainDisplay.getText() + "×");
        MainDisplay.setText("");
        
        
        
    }//GEN-LAST:event_button_multActionPerformed

    private void button_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_minusActionPerformed
         
        switch(mode){
        
            case 1: num = Long.parseLong(MainDisplay.getText(),16);
                    break;
            case 2: num = Long.parseLong(MainDisplay.getText());
                    break;    
            case 3: num = Long.parseLong(MainDisplay.getText(),8);
                    break;
            case 4: num = Long.parseLong(MainDisplay.getText(),2);
                    break;    
        }
        calculation = 2;
        
     prevNum -= num;
        
        stackDisplay.setText(stackDisplay.getText()+ MainDisplay.getText() + "-");
        MainDisplay.setText("");
        
        
    }//GEN-LAST:event_button_minusActionPerformed

    private void button_PlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_PlusActionPerformed

                calculation = 1;
                
         switch(mode){
        
            case 1: num = Long.parseLong(MainDisplay.getText(),16);
                    break;
            case 2: num = Long.parseLong(MainDisplay.getText());
                    break;    
            case 3: num = Long.parseLong(MainDisplay.getText(),8);
                    break;
            case 4: num = Long.parseLong(MainDisplay.getText(),2);
                    break;    
        } 
        
         prevNum += num;
         
        stackDisplay.setText(stackDisplay.getText()+ MainDisplay.getText() + "+");
        MainDisplay.setText("");
    }//GEN-LAST:event_button_PlusActionPerformed

    private void button_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ClearActionPerformed
       MainDisplay.setText("0");
       stackDisplay.setText("");
       prevNum = 0;
       secondaryDisplay();
    }//GEN-LAST:event_button_ClearActionPerformed

    private void button_BinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_BinActionPerformed
       binaryMode();
    }//GEN-LAST:event_button_BinActionPerformed

    private void button_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_0ActionPerformed
        if(limitCheck(0)){ 
        if(nullVal()){
             MainDisplay.setText("0");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "0");
        }
        secondaryDisplay();
        }
    }//GEN-LAST:event_button_0ActionPerformed

    private void button_OctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_OctActionPerformed
       OctalMode();
    }//GEN-LAST:event_button_OctActionPerformed

    private void button_DecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DecActionPerformed
        DecimalMode();
    }//GEN-LAST:event_button_DecActionPerformed

    private void button_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_EActionPerformed
        if(limitCheck(14)){
        if(nullVal() || equalPress){
             MainDisplay.setText("E");
        }
        else{ 
        MainDisplay.setText(MainDisplay.getText() + "E");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_EActionPerformed

    private void button_HexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_HexActionPerformed
     HexMode();
    }//GEN-LAST:event_button_HexActionPerformed

    private void button_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AActionPerformed
    if(limitCheck(10)){
        if(nullVal() || equalPress){
             MainDisplay.setText("A");
        }
        else{ 
        MainDisplay.setText(MainDisplay.getText() + "A");
         }
         secondaryDisplay();
    }
    }//GEN-LAST:event_button_AActionPerformed

    private void button_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_BActionPerformed
        if(limitCheck(11)){ 
        if(nullVal() || equalPress){
             MainDisplay.setText("B");
        }
        else{ 
        MainDisplay.setText(MainDisplay.getText() + "B");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_BActionPerformed

    private void button_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CActionPerformed
        if(limitCheck(12)){ 
        if(nullVal() || equalPress){
             MainDisplay.setText("C");
        }
        else{ 
        MainDisplay.setText(MainDisplay.getText() + "C");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_CActionPerformed

    private void button_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DActionPerformed
        if(limitCheck(13)){
        if(nullVal() || equalPress){
             MainDisplay.setText("D");
        }
        else{ 
        MainDisplay.setText(MainDisplay.getText() + "D");
         }
         secondaryDisplay();
        }
    }//GEN-LAST:event_button_DActionPerformed

    private void button_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_FActionPerformed
        if(limitCheck(15)){
        if(nullVal() || equalPress){
             MainDisplay.setText("F");
        }
        else{
        MainDisplay.setText(MainDisplay.getText() + "F");
        }
        secondaryDisplay();
        }
    }//GEN-LAST:event_button_FActionPerformed

    private void button_DelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DelActionPerformed
        int length = MainDisplay.getText().length();
        int index = (MainDisplay.getText().length() - 1);     //get the index of the character that need to be removed. 
        
        String store;
        
        if(length > 1){
            
            StringBuilder back = new StringBuilder(MainDisplay.getText());
            back.deleteCharAt(index);
            store = back.toString();
            MainDisplay.setText(store);
        }
        
        else if(length == 1){
            MainDisplay.setText("0");
        }
    }//GEN-LAST:event_button_DelActionPerformed

    private void button_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modActionPerformed
       
        switch(mode){
        
            case 1: num = Long.parseLong(MainDisplay.getText(),16);
                    break;
            case 2: num = Long.parseLong(MainDisplay.getText());
                    break;    
            case 3: num = Long.parseLong(MainDisplay.getText(),8);
                    break;
            case 4: num = Long.parseLong(MainDisplay.getText(),2);
                    break;    
        }
        
        prevNum %= num;
        
        calculation = 5;
        
        stackDisplay.setText(stackDisplay.getText()+ MainDisplay.getText() + " Mod");
        
        MainDisplay.setText("");
        
    }//GEN-LAST:event_button_modActionPerformed

    private void button_ClrEqnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ClrEqnActionPerformed
       MainDisplay.setText("0");
    }//GEN-LAST:event_button_ClrEqnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(button_Lsh.getText().equals("Lsh")){
            button_Lsh.setText("RoL");
            button_Rsh.setText("RoR");
        }
        else{
            button_Lsh.setText("Lsh");
            button_Rsh.setText("Rsh");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void WordSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WordSizeActionPerformed
        
        wordsize++;
        
        if(wordsize == 5){
            wordsize = 1;
        }
        
        switch(wordsize){
            
            case 1: WordSize.setText("QWord");
                    break;
            case 2: WordSize.setText("DWord");
                    break;
            case 3: WordSize.setText("Word");
                    break;
            case 4: WordSize.setText("Byte");
                    break;
        }
    }//GEN-LAST:event_WordSizeActionPerformed

    private void button_SignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SignActionPerformed
     
        long original = 0;
        
        switch(mode){     
            case 1: original = Long.parseLong(MainDisplay.getText(),16);
                break;
            case 2: original = Long.parseLong(MainDisplay.getText());
                break;
            case 3: original = Long.parseLong(MainDisplay.getText(),8);
                break;
            case 4: original = Long.parseLong(MainDisplay.getText(),2);
                break;
        }
        
        original *= -1;
        
        MainDisplay.setText(Long.toString(original));
        secondaryDisplay();
    }//GEN-LAST:event_button_SignActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
                      
            // Windows LF
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MainDisplay;
    private javax.swing.JButton WordSize;
    private javax.swing.JTextField bin_num;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_0;
    private javax.swing.JButton button_1;
    private javax.swing.JButton button_2;
    private javax.swing.JButton button_3;
    private javax.swing.JButton button_4;
    private javax.swing.JButton button_5;
    private javax.swing.JButton button_6;
    private javax.swing.JButton button_7;
    private javax.swing.JButton button_8;
    private javax.swing.JButton button_9;
    private javax.swing.JButton button_A;
    private javax.swing.JButton button_And;
    private javax.swing.JButton button_B;
    private javax.swing.JToggleButton button_Bin;
    private javax.swing.JButton button_C;
    private javax.swing.JButton button_Clear;
    private javax.swing.JButton button_ClrEqn;
    private javax.swing.JButton button_D;
    private javax.swing.JToggleButton button_Dec;
    private javax.swing.JButton button_Del;
    private javax.swing.JButton button_E;
    private javax.swing.JButton button_F;
    private javax.swing.JToggleButton button_Hex;
    private javax.swing.JButton button_Lsh;
    private javax.swing.JButton button_Not;
    private javax.swing.JToggleButton button_Oct;
    private javax.swing.JButton button_Plus;
    private javax.swing.JButton button_Rsh;
    private javax.swing.JButton button_Sign;
    private javax.swing.JButton button_Xor;
    private javax.swing.JButton button_closeBracket;
    private javax.swing.JButton button_decimal;
    private javax.swing.JButton button_divide;
    private javax.swing.JButton button_equals;
    private javax.swing.JButton button_minus;
    private javax.swing.JButton button_mod;
    private javax.swing.JButton button_mult;
    private javax.swing.JButton button_openBracket;
    private javax.swing.JButton button_or;
    private javax.swing.JTextField dec_Num;
    private javax.swing.JTextField hex_Num;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton7;
    private javax.swing.JTextField oct_num;
    private javax.swing.JLabel stackDisplay;
    // End of variables declaration//GEN-END:variables
}
