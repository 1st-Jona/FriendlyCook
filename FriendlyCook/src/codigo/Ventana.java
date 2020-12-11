package codigo;

import compilador.TextLineNumber;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class Ventana extends javax.swing.JFrame {

    int contador = 0;
    TextLineNumber lineas;
    DefaultTableModel model;
    
    static ArrayList <String> genErrores = new ArrayList();
    static ArrayList <String> genErroresL = new ArrayList();
    String resultado;
    
    /**
     * Creates new form Analizador
     */
    public Ventana() {

        initComponents();
        //RESCALAR IMAGEN
        ImageIcon logo1= new ImageIcon(getClass().getResource("/imagenes/logo.png"));
        Icon logo=new ImageIcon(logo1.getImage().getScaledInstance(400, 100,Image.SCALE_DEFAULT));
        lbllogo.setIcon(logo);
        
        this.repaint();
        Color blues = new Color(127,160,252);
        this.setResizable(false);
        
        
        final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
        final AttributeSet attg = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
        final AttributeSet atta = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.ORANGE);
        final AttributeSet attx = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
        final AttributeSet atty = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, blues);

        final AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        DefaultStyledDocument doc = new DefaultStyledDocument() {
            public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;

                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(OYE|oye|Oye|sanji|por|favor)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attg, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(un|una|unas|unos|dos|tres|cuatro|cinco|seis|siete|ocho|nueve|diez)")) {
                            setCharacterAttributes(wordL, wordR - wordL, atta, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(quiero)")) { //VERBOS
                            setCharacterAttributes(wordL, wordR - wordL, attx, false);
                        /*} else if (text.substring(wordL, wordR).matches("(\\W)*()")) { //VERBOS
                            setCharacterAttributes(wordL, wordR - wordL, attx, false);*/
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(y)")) { //VERBOS
                            setCharacterAttributes(wordL, wordR - wordL, atty, false);
                        } else {
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                        }
                        wordL = wordR;
                    }
                    wordR++;
                }
            }

            public void remove(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offs);
                if (before < 0) {
                    before = 0;
                }
                int after = findFirstNonWordChar(text, offs);

                if (text.substring(before, after).matches("(\\W)*()")) {
                    setCharacterAttributes(before, after - before, attr, false);
                } else {
                    setCharacterAttributes(before, after - before, attrBlack, false);
                }

                if (text.substring(before, after).matches("(\\W)*()")) {
                    setCharacterAttributes(before, after - before, attg, false);
                } else {
                    setCharacterAttributes(before, after - before, attrBlack, false);
                }

            }
        };
        txtCodigo = new JTextPane(doc);
        txtCodigo.setFont(new java.awt.Font("Consolas", 0, 18));

        this.setLocationRelativeTo(null);

        lineas = new TextLineNumber(txtCodigo);
        lineas.setCurrentLineForeground(new Color(255, 0, 0));//current line
        lineas.setForeground(new Color(0, 0, 0));//color linea
        lineas.setBackground(new Color(240, 240, 240));
        jScrollPane5.setRowHeaderView(lineas);
        jScrollPane5.setViewportView(txtCodigo);
        txtErrores.setEditable(false);

        //COLOR DE FUENTE DE ERRORES
        Font fuente = new Font("Console", Font.PLAIN, 20);
        txtErrores.setFont(fuente); 
        txtErrores.setForeground(Color.RED);
        
         txtCodigo.setBackground(Color.GREEN);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextPane();
        lbllogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAbrir = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();
        lblCompilar = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jScrollPane4.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        txtCodigo.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(txtCodigo);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 820, 360));

        jScrollPane6.setViewportView(txtErrores);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 1050, 160));
        jPanel1.add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 460, 50));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel1.setText("Tabla de tokens");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, -1, -1));

        tblTokens.setBackground(new java.awt.Color(204, 204, 204));
        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Componente lexico", "No.lLinea"
            }
        ));
        jScrollPane3.setViewportView(tblTokens);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 310, 330));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N
        jLabel2.setText("Cerrar");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 60, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar.png"))); // NOI18N
        jLabel3.setText("Miniminzar");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, 30));

        lblAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrir.png"))); // NOI18N
        lblAbrir.setText("Abrir");
        lblAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAbrirMouseClicked(evt);
            }
        });
        jPanel1.add(lblAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        lblGuardar.setText("Guardar");
        jPanel1.add(lblGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        lblCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/runFi.png"))); // NOI18N
        lblCompilar.setText("Compilar");
        lblCompilar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCompilarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, -1, -1));

        lblNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new.png"))); // NOI18N
        lblNuevo.setText("Nuevo");
        lblNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNuevoMouseClicked(evt);
            }
        });
        jPanel1.add(lblNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jButton1.setText("SINTÁCTICO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 520, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 630));

        jMenu4.setText("Ver");

        jMenuItem5.setText("Ver Alfabeto");
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("Ver familias de cadenas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
     this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
       
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
      
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void lblNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoMouseClicked
    
    }//GEN-LAST:event_lblNuevoMouseClicked

    private void lblCompilarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCompilarMouseClicked
        compilar();
        //SEPARACIÓN POR LETRAS 
        String CodigoTXT = txtCodigo.getText().toLowerCase().replaceAll("oye sanji", "oye sanji");
        CodigoTXT=CodigoTXT.replaceAll("quiero", "\n\tquiero\n\t\t");
        CodigoTXT=CodigoTXT.replaceAll(",", ",\n\t\t");
        CodigoTXT=CodigoTXT.replaceAll(" y", " y\n\t\t");
        CodigoTXT=CodigoTXT.replaceAll("por favor", "\npor favor");
        txtCodigo.setText(CodigoTXT);
        
    }//GEN-LAST:event_lblCompilarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ST=txtCodigo.getText();
        Sintax s= new Sintax(new codigo.LexerCup(new StringReader(ST)));
        try {
            s.parse();
            resultado="";
            txtErrores.setText("Analisi sintáctico realizado con exito");
            txtErrores.setForeground(new Color(25,111,61));
             for(int i=0;i<genErrores.size();i++){
                    resultado=resultado+genErrores.get(i)+"\n";
            }
             txtErrores.setText(resultado+"Compilación completa.");
             genErrores.clear();

        } catch (Exception ex) {
           Symbol sym = s.getS();
            txtErrores.setText("Erro de sintaxis. Linea: "+ (sym.right +1)+ "Columna: "+ (sym.left + 1)+ ", Texto: \""+ sym.value+ "\"");
            txtErrores.setForeground(Color.RED);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAbrirMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
       
         try {
           String ST = new String(Files.readAllBytes(archivo.toPath()));
           txtCodigo.setText(ST);
         } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblAbrirMouseClicked
    public void compilar(){
         String[] titulos = {"Nombre", "Componente léxico", "NoLinea"};
        model = new DefaultTableModel(null, titulos);
        File archivo = new File("archivo.txt");
        PrintWriter escribir;

        try {
            escribir = new PrintWriter(archivo);
            escribir.print(/*Aqui se pone lo que se va a analizar*/txtCodigo.getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            int cont = 1;

            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            Object[] fila = new Object[3];
            int contador = 0;
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    return;
                }
                switch (tokens) {

                    case LINEA:
                    cont++;
                    break;
                   
                    case Numero:
                    fila[0] = lexer.lexeme;
                    fila[1] = "Constante Numérica";
                    fila[2] = cont + "";
                    model.addRow(fila);
                    tblTokens.setModel(model);
                    break;
                   
                    //ERRORES LÉXICOS
                   /* case ErrorLEX00:
                    resultado += "Linea: " + cont + "   Error Léxico: LEX00  Descripción: Símbolo no definido. "
                             + "\n          Propuesta de solución: Utilice símbolos válidos para el lenguaje (Consulte el manual técnico)."
                             + "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                 */

                }
                txtErrores.setText(resultado);
                if(txtErrores.getText().equals("")){
                    txtErrores.setText("SIN ERRORES LÉXICOS - COMPILACIÓN EXITOSA");
                };

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    private int findLastNonWordChar(String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int findFirstNonWordChar(String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblAbrir;
    private javax.swing.JLabel lblCompilar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JTable tblTokens;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtErrores;
    // End of variables declaration//GEN-END:variables
}
