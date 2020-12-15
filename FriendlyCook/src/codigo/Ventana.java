package codigo;

import static JFlex.Out.println;
import compilador.TextLineNumber;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextPane;
import javax.swing.UIDefaults;
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
    static ArrayList <String> cuenta = new ArrayList<String>();
    
    static ArrayList <String> codObjPeticion = new ArrayList<String>();
    static ArrayList <String> cantidadesPlatillos = new ArrayList<String>();
    static String codObjeto;
    static double totalPagar;
    
    static String codObjGenerado=""; 
    
    static int cantPlatillos;
    static int numeroPlatillo;
    
    static String [] Platillos={
    "Sushi de camaron           $80.00 ",
    "Sushi de pollo             $80.00 ",
    "Sushi de res               $80.00 ",
    "Camaronito                 $100.00",
    "Bombazo                    $100.00",
    "Hamburguesa de arroz       $90.00 ",
    "Teriyaki                   $120.00",
    "Helado de vainilla         $30.00 ",
    "Fruta en caramelo          $28.00 ",
    "Fondant                    $40.00 ",
    "Helado de cacao            $30.00 ",
    "Pie de limón               $26.00 ",
    "Pie de fresa               $26.00 ",
    "Pie de mora                $26.00 ",
    "Pie de queso               $28.00 ",
    "Churros                    $06.00 ",
    "Dulce de leche             $12.00 ",
    "Café                       $20.00 ",
    "Expresso                   $35.00 ",
    "Martini                    $45.00 ",
    "Limonada                   $22.00 ",
    "Naranjada                  $22.00 ",
    "Coca-cola                  $18.00 ",
    "Corona                     $39.00 ",
    "Victoria                   $39.00 ",
    "Piña colada                $45.00 ",
    "Jugo                       $25.00 ",
    "Vampiro                    $55.00 "
    };
    
    static double [] precioPlatillos={
    80.00,
    80.00,
    80.00,
    100.0,
    100.0,
    90.00,
    120.0,
    30.00,
    28.00,
    40.00,
    30.00,
    26.00,
    26.00,
    26.00,
    28.00,
    06.00,
    12.00,
    20.00,
    35.00,
    45.00,
    22.00,
    22.00,
    18.00,
    39.00,
    39.00,
    45.00,
    25.00,
    55.00
    };
    
    String resultado;
    String filename;
    boolean formatFlag=false;
    
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
        final AttributeSet attr = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
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
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(un|una|unas|unos|dos|tres|cuatro|cinco|seis|siete|ocho|nueve|diez|once|doce|trece|catorce|quince)")) {
                            setCharacterAttributes(wordL, wordR - wordL, atta, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(quiero|muestrame|traeme|ver)")) { //VERBOS
                            setCharacterAttributes(wordL, wordR - wordL, attx, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(la|el)")) { //VERBOS
                            setCharacterAttributes(wordL, wordR - wordL, attr, false);
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

    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void saveAS() {
        FileDialog fileDialog = new FileDialog(this, "Guardar archivo", FileDialog.SAVE);
        fileDialog.setVisible(true);
 
        if (fileDialog.getFile() != null) {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(filename);
             filename=filename+".snj";

        }
        try {
            
            
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(txtCodigo.getText());
            setTitle(filename);
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("Error al guardar.");
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                txtCodigo.setText(sb.toString());
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Archivo no encontrado");
        }
    }
    
    public void mostrarMenu(){
        println("se mostró menu");
        txtCliente.setText(
"________________[MENÚ]_______________\n"+
"| Sushi de camaron           $80.00  |\n" +
"| Sushi de pollo             $80.00  |\n" +
"| Sushi de res               $80.00  |\n" +
"| Camaronito                 $100.00 |\n" +
"| Bombazo                    $100.00 |\n" +
"| Hamburguesa de arroz       $90.00  |\n" +
"| Teriyaki                   $120.00 |\n" +
"| Helado de vainilla         $30.00  |\n" +
"| Fruta en caramelo          $28.00  |\n" +
"| Fondant                    $40.00  |\n" +
"| Helado de cacao            $30.00  |\n" +
"| Pie de limón               $26.00  |\n" +
"| Pie de fresa               $26.00  |\n" +
"| Pie de mora                $26.00  |\n" +
"| Pie de queso               $28.00  |\n" +
"| Churros                    $06.00  |\n" +
"| Dulce de leche             $12.00  |\n" +
"| Café                       $20.00  |\n" +
"| Expresso                   $35.00  |\n" +
"| Martini                    $45.00  |\n" +
"| Limonada                   $22.00  |\n" +
"| Naranjada                  $22.00  |\n" +
"| Coca-cola                  $18.00  |\n" +
"| Corona                     $39.00  |\n" +
"| Victoria                   $39.00  |\n" +
"| Piña colada                $45.00  |\n" +
"| Jugo                       $25.00  |\n" +
"| Vampiro                    $55.00  |\n" + 
"|____________________________________|");
    }
    

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        lbllogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAbrir = new javax.swing.JLabel();
        lblGuardar = new javax.swing.JLabel();
        lblCompilar = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        btnFormato = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtCodObjGenerado = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCliente = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
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

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 690, 540));
        jPanel1.add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 460, 50));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel1.setText("Elementos Generados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, -1));

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
        lblGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuardarMouseClicked(evt);
            }
        });
        jPanel1.add(lblGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        lblCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/runFi.png"))); // NOI18N
        lblCompilar.setText("Compilar");
        lblCompilar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCompilarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCompilar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        lblNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new.png"))); // NOI18N
        lblNuevo.setText("Nuevo");
        lblNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNuevoMouseClicked(evt);
            }
        });
        jPanel1.add(lblNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        btnFormato.setText("Dar formato   ");
        btnFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormatoActionPerformed(evt);
            }
        });
        jPanel1.add(btnFormato, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        txtErrores.setEditable(false);
        txtErrores.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtErrores.setForeground(new java.awt.Color(51, 204, 0));
        jScrollPane2.setViewportView(txtErrores);

        jTabbedPane1.addTab("Consola", jScrollPane2);

        jScrollPane7.setViewportView(txtCodObjGenerado);

        jTabbedPane1.addTab("Código Intermedio", jScrollPane7);
        jTabbedPane1.addTab("Código Generado Arduino", jScrollPane8);
        jTabbedPane1.addTab("Gramáticas Generadas", jScrollPane9);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Comp. Léxico", "Línea"
            }
        ));
        jScrollPane1.setViewportView(tblTokens);

        jTabbedPane1.addTab("Tab. Simb.", jScrollPane1);
        jScrollPane1.getAccessibleContext().setAccessibleName("Tabla");
        jScrollPane1.getAccessibleContext().setAccessibleDescription("");

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(txtCliente);

        jTabbedPane1.addTab("Pantalla Cliente", jScrollPane3);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 480, 510));
        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        jLabel4.setText("Formato");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

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
    if (filename == null || filename.equals("")) {

            int response = JOptionPane.showConfirmDialog(this, "¿Deseas guardar el archivo?", "Guardar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                //limpiar();

                txtCodigo.setText("");
                txtErrores.setText("");
                filename = null;
                setTitle(filename);
                model.setRowCount(0);
            } else if (response == JOptionPane.YES_OPTION) {
                if (filename == null || filename.equals("")) {
                    saveAS();
                }
            }
        } else {

            //limpiar();
            txtCodigo.setText("");
            txtErrores.setText("");
            filename = null;
            setTitle(filename);
            model.setRowCount(0);
        }
    }//GEN-LAST:event_lblNuevoMouseClicked

    private void lblCompilarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCompilarMouseClicked
       
        compilar();
        sintactico();
        //mostrarMenu();

        //SEPARACIÓN POR LETRAS 
        
    }//GEN-LAST:event_lblCompilarMouseClicked
  
    private void btnFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormatoActionPerformed
    if (formatFlag){
        String CodigoTXT = txtCodigo.getText().toLowerCase()
                .replaceAll("oye sanji", "oye sanji")
                .replaceAll(",\n\t\t","," )
                .replaceAll("\n\tquiero\n\t\t", "quiero" )
                .replaceAll(" y\n\t\t"," y" )
                .replaceAll("\npor favor", "por favor");
        
        txtCodigo.setText(CodigoTXT);
        btnFormato.setText("Dar formato    ");
        formatFlag=false;
    }        else{
        String CodigoTXT = txtCodigo.getText().toLowerCase()
                .replaceAll("oye sanji", "oye sanji")
                .replaceAll(",", ",\n\t\t")
                .replaceAll("quiero", "\n\tquiero\n\t\t")
                .replaceAll(" y", " y\n\t\t")
                .replaceAll("por favor", "\npor favor");
        
        txtCodigo.setText(CodigoTXT);
         btnFormato.setText("Quitar formato");
        formatFlag=true;
    }
        
    }//GEN-LAST:event_btnFormatoActionPerformed
public void sintactico(){
       String ST=txtCodigo.getText();
        Sintax s= new Sintax(new codigo.LexerCup(new StringReader(ST)));
        try {
            s.parse();
            resultado="";
            txtErrores.setText("Analisis sintáctico realizado con exito");
            txtErrores.setForeground(new Color(255,204,0));
             for(int i=0;i<genErrores.size();i++){
                    resultado=resultado+genErrores.get(i)+"\n";
            }
             
            
             /*Peticiones*/
             
             /*Asignar peticion*/
             if (!codObjPeticion.isEmpty()){
                
                 for(int i=0;i<codObjPeticion.size();i++){
                    codObjeto = codObjPeticion.get(i);
                    
                    if(cantidadesPlatillos.isEmpty()){cantidadesPlatillos.add("");}
                    
                    
                    
                    codObjGenerado+="["+codObjPeticion.get(i)+","+cantidadesPlatillos.get(i)+"]\n";
                    /*Peticion mostrar cuenta*/
                    if(codObjeto.equals("oye,quiero,cuenta")){
                        JFlex.Out.println("se mostro cuenta");
                        String cuentaAcumulada="";
                        for(int j=0;j<cuenta.size();j++){
                            cuentaAcumulada=cuentaAcumulada+cuenta.get(i)+"\n";
                        }
           
                    txtCliente.setText(cuentaAcumulada+"\nTotal a pagar:             $"+ totalPagar);
                     JFlex.Out.println("Cantidad de platillos"+cuenta.size());
                    }
                    /*Agregar platillo*/
                    String[] params =  codObjeto.split(",");
                    /*for(int j=0;j<params.length;j++){
                    JFlex.Out.println("Pos "+ j +" = "+params[j]);
                    }*/
                    
                    if(params[0].equals("add")){
                        numeroPlatillo=Integer.parseInt(params[2]);
                        cantPlatillos=Integer.parseInt(cantidadesPlatillos.get(i));
                        for(int j=0;j<cantPlatillos;j++){
                            JFlex.Out.println("se agrego "+Platillos[numeroPlatillo]);
                            cuenta.add(Platillos[numeroPlatillo]);
                            
                            totalPagar+=precioPlatillos[numeroPlatillo];
                            
                        }
                        txtCliente.setText("Se agregaron :"+cantPlatillos+" de "+Platillos[numeroPlatillo]+"\nTotal actual: "+totalPagar );
                    }
                       
                    
                    /*Mostra menu*/
                    if(codObjeto.equals("oye,quiero,menu")){
                        JFlex.Out.println("Se mostro menú"+Platillos[0]);
                        mostrarMenu();
                    } 
                }
             } else{
                 codObjeto="[ , , ]";
             }
            
            txtErrores.setText(resultado+"Compilación completa.");
            genErrores.clear();
            codObjPeticion.clear();
            cantidadesPlatillos.clear();
            txtCodObjGenerado.setText(codObjGenerado);
            codObjGenerado="";
             
             
        } catch (Exception ex) {
           Symbol sym = s.getS();
            txtErrores.setText("Error de sintaxis. Linea: "+ (sym.right +1)+ "Columna: "+ (sym.left + 1)+ ", Texto: \""+ sym.value+ "\"");
            txtErrores.setForeground(Color.RED);
        }
}
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

    private void lblGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuardarMouseClicked
        saveAS();        // TODO add your handling code here:
    }//GEN-LAST:event_lblGuardarMouseClicked
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
    private javax.swing.JButton btnFormato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblAbrir;
    private javax.swing.JLabel lblCompilar;
    private javax.swing.JLabel lblGuardar;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JTable tblTokens;
    private javax.swing.JTextPane txtCliente;
    private javax.swing.JTextPane txtCodObjGenerado;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtErrores;
    // End of variables declaration//GEN-END:variables
}
