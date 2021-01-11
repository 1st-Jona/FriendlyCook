package codigo;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
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
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

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
    static int compilacion=0;
    //AUDIO
    static ArrayList <Integer> audio = new ArrayList();
    public Clip clip;
    public String ruta="/Audio/";
    int error=0;
    static boolean arduinoOn=false;
    //Manejo de peticiones de Marvin
    static boolean statusMarvin=false; //TRUE= OCUPADO | FALSE = DESOCUPADO
    static ArrayList <Integer> peticionesMarvin = new ArrayList();
    //ERRORES
    static ArrayList <String> genErrores = new ArrayList();
    static ArrayList <String> genErroresL = new ArrayList();
    //CUENTAS DE MESA
    static int mesaActual=5; //0=cocina
    static int mesaTemp=5;
    //Mesa 1 ->1
        static ArrayList <String> cuenta = new ArrayList<String>();
        static double totalPagar;
    //Mesa 2 ->2
        static ArrayList <String> cuenta2 = new ArrayList<String>();
        static double totalPagar2;
    //Mesa 1 ->3
        static ArrayList <String> cuenta3 = new ArrayList<String>();
        static double totalPagar3;
    //Mesa 1 ->3
        static ArrayList <String> cuenta4 = new ArrayList<String>();
        static double totalPagar4;

    static ArrayList <String> codObjPeticion = new ArrayList<String>();
    static ArrayList <String> codObjPeticionOptimizado = new ArrayList<String>();
    static ArrayList <String> cantidadesPlatillos = new ArrayList<String>();
    static String codObjeto;
     String acum="";
     String [] codeT;
     String codeArduino="";
    static ArrayList <String> rutaAutomata = new ArrayList<String>();
    static String codArduinoGenerado ="";
    static String codArduinoGenerado2 ="";
    static String codObjGenerado=""; 
    static boolean delete=false;
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
    static boolean hayError=false;
    /**
     * Creates new form Analizador
     */
    
    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private final SerialPortEventListener listener;
    
    public Ventana() {
        this.listener = new SerialPortEventListener(){
            
            @Override
            public void serialEvent(SerialPortEvent spe) {
                    try{
                        if(ino.isMessageAvailable()){        
                            codArduinoGenerado+=ino.printMessage();
                            codArduinoGenerado2=codArduinoGenerado.replaceAll(";", ";\n");
                            txtArduinoCode.setText(codArduinoGenerado2.replaceAll ("}", "}\n"));
                        }
                    }catch(SerialPortException|ArduinoException ex){
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            
        };

        initComponents();
        
        
       lblArduino.setText("[Desconectado]");
                
        //RESCALAR IMAGEN
        ImageIcon logo1= new ImageIcon(getClass().getResource("/imagenes/logo.png"));
        Icon logo=new ImageIcon(logo1.getImage().getScaledInstance(400, 100,Image.SCALE_DEFAULT));
        lbllogo.setIcon(logo);
        
        this.repaint();
        Color blues = new Color(127,160,252);
        this.setResizable(true);
        
        
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
                        if (text.substring(wordL, wordR).matches("(\\W)*(OYE|oye|Oye|listo|Listo|sanji|por|favor|Marvin|marvin|adios|Adios|adios|adiós)")) {
                            setCharacterAttributes(wordL, wordR - wordL, attg, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(un|uno|una|unas|unos|dos|tres|cuatro|cinco|seis|siete|ocho|nueve|diez|once|doce|trece|catorce|quince)")) {
                            setCharacterAttributes(wordL, wordR - wordL, atta, false);
                        } else if (text.substring(wordL, wordR).matches("(\\W)*(quiero|muestrame|traeme|ver|muéstrame|tráeme|leeme|léeme|dictame|díctame)")) { //VERBOS
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
        txtCodigo.setEditable(false);
        txtErrores.setFont(new java.awt.Font("Consolas", 0, 14));
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
            fileWriter.write(txtCodigoDictado.getText());
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
        lblArduino = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        lbllogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtCodObjGenerado = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtArduinoCode = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCliente = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        lblAutomata = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtCodigoDictado = new javax.swing.JTextPane();
        btnConectarArduino = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jScrollPane4.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblArduino, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 90, 20));

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 83, 90, 20));

        jButton2.setBackground(new java.awt.Color(102, 255, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/runFi.png"))); // NOI18N
        jButton2.setText("Compilar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, 60));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jScrollPane5KeyTyped(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 690, 220));
        jPanel1.add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 460, 50));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel1.setText("Elementos Generados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, -1, -1));

        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N
        jLabel2.setText("Cerrar");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, 60, 30));

        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimizar.png"))); // NOI18N
        jLabel3.setText("Miniminzar");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, -1, 30));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));
        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCodObjGenerado.setEditable(false);
        txtCodObjGenerado.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jScrollPane7.setViewportView(txtCodObjGenerado);

        jTabbedPane1.addTab("Código Intermedio", jScrollPane7);

        txtArduinoCode.setEditable(false);
        txtArduinoCode.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtArduinoCode.setForeground(new java.awt.Color(51, 51, 255));
        txtArduinoCode.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtArduinoCodeInputMethodTextChanged(evt);
            }
        });
        jScrollPane8.setViewportView(txtArduinoCode);

        jTabbedPane1.addTab("Código Generado Arduino", jScrollPane8);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Comp. Léxico", "Línea"
            }
        ));
        jScrollPane1.setViewportView(tblTokens);

        jTabbedPane1.addTab("Tokens", jScrollPane1);
        jScrollPane1.getAccessibleContext().setAccessibleName("Tabla");
        jScrollPane1.getAccessibleContext().setAccessibleDescription("");

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(txtCliente);

        jTabbedPane1.addTab("Pantalla Cliente", jScrollPane3);

        jScrollPane9.setViewportView(lblAutomata);

        jTabbedPane1.addTab("Automatas - Gramáticas", jScrollPane9);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 480, 330));
        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        txtCodigoDictado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCodigoDictado.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtCodigoDictado.setForeground(new java.awt.Color(102, 102, 102));
        txtCodigoDictado.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCodigoDictadoInputMethodTextChanged(evt);
            }
        });
        txtCodigoDictado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoDictadoKeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(txtCodigoDictado);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 580, 60));

        btnConectarArduino.setBackground(new java.awt.Color(102, 204, 255));
        btnConectarArduino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arduino.png"))); // NOI18N
        btnConectarArduino.setText("Conectar a Arduino");
        btnConectarArduino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConectarArduinoMouseClicked(evt);
            }
        });
        btnConectarArduino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarArduinoActionPerformed(evt);
            }
        });
        btnConectarArduino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConectarArduinoKeyPressed(evt);
            }
        });
        jPanel1.add(btnConectarArduino, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 170, 40));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 102, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new.png"))); // NOI18N
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/abrir.png"))); // NOI18N
        jButton6.setText("Abrir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtErrores.setEditable(false);
        txtErrores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtErrores.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtErrores.setForeground(new java.awt.Color(51, 204, 0));
        jScrollPane2.setViewportView(txtErrores);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 1190, 140));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel5.setText("Dictado por voz:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel6.setText("Consola");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel7.setText("Código Compilado: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       this.dispose();
       System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
     this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
       
       
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
       
    }//GEN-LAST:event_txtCodigoKeyTyped
            
    public void sonido(String archivo){
        try{
            clip=AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo)));
            clip.start();
        }catch(Exception e){ 
        }
    }
  public void reproduccionAudio(int a){
       if(error==0){ //analisis correcto
           
       }else{
           sonido(""+a+".wav");
       }
       audio.clear();
       error=0;
   }public void sintactico(){
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
            if(!hayError){
                txtErrores.setForeground(Color.GREEN);
            /*Optimizr*/
            if (!codObjPeticion.isEmpty()){
                 int nPlatillo=0;
                 int cant=0;
                 String[] paramsObj;
                 paramsObj=codObjPeticion.get(0).split(",");
                 if(paramsObj[0].equals("add")){
                     
                    while(nPlatillo<=27){
                        for(int l=0; l<codObjPeticion.size(); l++){
                            paramsObj=codObjPeticion.get(l).split(",");
                            if(paramsObj[2].equals(nPlatillo+"")){
                               cant+=Integer.parseInt(cantidadesPlatillos.get(l));
                           }
                        }
                     if(cant>0){
                           if(mesaActual==5){
                           codObjPeticionOptimizado.add("add,cuentaCocina"+","+nPlatillo+","+cant);
                           }else{
                        codObjPeticionOptimizado.add("add,cuenta"+mesaActual+","+nPlatillo+","+cant);}
                     }
                        nPlatillo++;
                        cant=0;

                    }
                    for(int p=0;p<codObjPeticionOptimizado.size();p++){
                    codObjGenerado+="["+codObjPeticionOptimizado.get(p)+"]\n";
                    }
                 }
                 if(paramsObj[0].equals("show")){
                    paramsObj=codObjPeticion.get(0).split(",");
                    for(int p=0;p<codObjPeticion.size();p++){
                        if(paramsObj[1].equals("cuenta")){
                             if(mesaActual==5){codObjGenerado+="[show,"+paramsObj[1]+",cocina"+", ]\n";}else{
                         codObjGenerado+="[show,"+paramsObj[1]+mesaActual+",mesa"+mesaActual+", ]\n";}}
                        else{
                            if(mesaActual==5){codObjGenerado+="[show,"+paramsObj[1]+",cocina"+", ]\n";}else{
                        codObjGenerado+="[show,"+paramsObj[1]+",mesa"+mesaActual+", ]\n";}}
                    }
                 }
                
            }
            
             /*Peticiones*/
             
             /*Asignar peticion*/
             if (!codObjPeticion.isEmpty()){
                
                 for(int i=0;i<codObjPeticion.size();i++){
                    codObjeto = codObjPeticion.get(i);
                    
                    if(cantidadesPlatillos.isEmpty()){cantidadesPlatillos.add("");}
                    
                    
                    //Liberar
                    if(codObjeto.equals("free,marvin,mesa, ")){
                        if (mesaActual==5) {
                            codObjGenerado="[free,marvin,cocina, ]";
                            
                        }else{
                        codObjGenerado="[free,marvin,"+mesaActual+", ]";}
                        statusMarvin=false;
                        if(delete){
                        if(mesaActual==5){
                            audio.clear();
                            codObjGenerado="[bye,marvin,cocina, ]";
                             txtErrores.setForeground(Color.ORANGE);
                            sonido("29.wav");resultado="Excepción de ejecución. No se puede usar esta petición desde la cocina.";
                            delete=false;
                        }else{
                            
                            
                         
                            
                            
                       
                        codObjGenerado="[bye,marvin,"+mesaActual+", ]";
                            if(mesaActual==1){
                                   cuenta.clear();
                                   totalPagar=0;
                            }
                            if(mesaActual==2){
                                cuenta2.clear();
                                totalPagar2=0;
                            }
                            if(mesaActual==3){
                                cuenta3.clear();
                                totalPagar3=0;
                            }
                            if(mesaActual==4){
                                cuenta4.clear();
                                totalPagar4=0;
                            }
                            delete=false;
                            try {
                                        ino.sendData("y");
                                        ino.sendData("w");
                                        
                                    } catch (ArduinoException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SerialPortException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                         
                        }}
                         if(!peticionesMarvin.isEmpty() && peticionesMarvin.size()>1 && statusMarvin==false){
                             statusMarvin=true;
                            String c= peticionesMarvin.get(1)+"";
                            mesaActual=peticionesMarvin.get(1);
                                    System.out.println(c);
                                     try {
                                        
                                        ino.sendData(c);
                                         if(mesaActual==5){ino.sendData("x");}
                                        ino.sendData("o");
                                    } catch (ArduinoException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SerialPortException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                println("Yendo a Mesa"+mesaActual);
                            }
                         if(!peticionesMarvin.isEmpty())  {
                             peticionesMarvin.remove(0);
                             if(peticionesMarvin.isEmpty()){
                              try {
                                  if(mesaActual==5){ino.sendData("y");}
                                        ino.sendData("l");//libre
                                        ino.sendData("5");
                                        
                                    } catch (ArduinoException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SerialPortException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                             }
                         }
                     }
                    
                    /*Peticion mostrar cuenta*/
                    if(codObjeto.equals("show,cuenta,mesa, ")){
                        if(mesaActual==5){
                            audio.clear();
                             txtErrores.setForeground(Color.ORANGE);
                            sonido("29.wav");resultado="Excepción de ejecución. No se puede usar esta petición desde la cocina.";
                            
                        }else{
                        JFlex.Out.println("se mostro cuenta");
                        String cuentaAcumulada="";
                        if(mesaActual==1){
                            for(int j=0;j<cuenta.size();j++){
                                cuentaAcumulada=cuentaAcumulada+cuenta.get(j)+"\n";
                            }
                            cuentaAcumulada+="\nTotal a pagar:             $"+totalPagar;
                        }
                        if(mesaActual==2){
                            for(int j=0;j<cuenta2.size();j++){
                                cuentaAcumulada=cuentaAcumulada+cuenta2.get(j)+"\n";
                            }
                             cuentaAcumulada+="\nTotal a pagar:             $"+totalPagar2;
                        }
                        if(mesaActual==3){
                            for(int j=0;j<cuenta3.size();j++){
                                cuentaAcumulada=cuentaAcumulada+cuenta3.get(j)+"\n";
                            }
                             cuentaAcumulada+="\nTotal a pagar:             $"+totalPagar3;
                        }
                        if(mesaActual==4){
                            for(int j=0;j<cuenta4.size();j++){
                                cuentaAcumulada=cuentaAcumulada+cuenta4.get(j)+"\n";
                            }                                                
                             cuentaAcumulada+="\n----------------------------------\nTotal a pagar:             $"+totalPagar4;
                        }
                    txtCliente.setText(cuentaAcumulada);
                    cuentaAcumulada="";
                     JFlex.Out.println("Cantidad de platillos"+cuenta.size());
                    }
                    }
                    //utencilios
                    String m="";
                    if(mesaActual==1){m="a";}
                    if(mesaActual==2){m="b";}
                    if(mesaActual==3){m="c";}
                    if(mesaActual==4){m="d";}
                  
                     if(codObjeto.equals("traer,mesa,vaso, ")){  
                         if(mesaActual==5){
                               codObjGenerado+="[traer,cocina"+",vaso, ]\n";
                        audio.clear();
                        txtErrores.setForeground(Color.ORANGE);
                            sonido("29.wav");resultado="Excepción de ejecución. No se puede usar esta petición desde la cocina.\n\n";
                             
                    }else{
                          codObjGenerado+="[traer,mesa"+mesaActual+",vaso, ]\n";
                         traer(m);
                     }
                     }
                     if(codObjeto.equals("traer,mesa,cuch, ")){
                         if(mesaActual==5){
                               codObjGenerado+="[traer,cocina"+",cuch, ]\n";
                        audio.clear();
                        txtErrores.setForeground(Color.ORANGE);
                            sonido("29.wav");resultado="Excepción de ejecución. No se puede usar esta petición desde la cocina.\n\n";
                    }else{
                         codObjGenerado+="[traer,mesa"+mesaActual+",cuch, ]\n";
                         traer(m);}
                     }
                     if(codObjeto.equals("traer,mesa,tene, ")){
                         if(mesaActual==5){
                             codObjGenerado+="[traer,cocina"+",tene, ]\n";
                        audio.clear();
                        txtErrores.setForeground(Color.ORANGE);
                            sonido("29.wav");resultado="Excepción de ejecución. No se puede usar esta petición desde la cocina.\n\n";
                    }else{
                         codObjGenerado+="[traer,mesa"+mesaActual+",tene, ]\n";
                         traer(m);
                     }}
                     if(codObjeto.equals("traer,mesa,serv, ")){
                         
                         if(mesaActual==5){
                             codObjGenerado+="[traer,cocina"+",serv, ]\n";
                        audio.clear();
                        txtErrores.setForeground(Color.ORANGE);
                            sonido("29.wav");resultado="Excepción de ejecución. No se puede usar esta petición desde la cocina.\n\n";
                    }else{
                         codObjGenerado+="[traer,mesa"+mesaActual+",serv, ]\n";
                         traer(m);
                     }}
                 
                     //ENTREGAR PEDIDOS
                     
                     
                     if(codObjeto.equals("entregar,mesaa, , ")){ 
                         if(mesaActual!=5){
                                 audio.clear();
                             sonido("11.wav");
                         txtErrores.setForeground(Color.ORANGE); 
                          resultado="Excepción de ejecución. No se puede usar esta petición fuera de la cocina.";
                         }else{
                             
                         sonido("7.wav");
                          codObjGenerado+="[entregar,mesa"+mesaActual+", , ]\n";
                          entregarPedido("h");
                          
                          
                         }
                     }
                     if(codObjeto.equals("entregar,mesab, , ")){  
                         if(mesaActual!=5){sonido("11.wav");}else{
                          sonido("8.wav");
                          codObjGenerado+="[entregar,mesa"+mesaActual+", , ]\n";
                           entregarPedido("j");
                         
                         }
                     }
                     if(codObjeto.equals("entregar,mesac, , ")){
                         if(mesaActual!=5){sonido("11.wav");}else{
                         
                          sonido("9.wav");
                          codObjGenerado+="[entregar,mesa"+mesaActual+", , ]\n";
                           entregarPedido("k");
                          
                         }
                     }
                     if(codObjeto.equals("entregar,mesad, , ")){  
                         if(mesaActual!=5){sonido("11.wav");}else{
                          sonido("10.wav");
                          codObjGenerado+="[entregar,mesa"+mesaActual+", , ]\n";
                           entregarPedido("m");
                           
                         }
                     }
                    //if(mesaActual!=5){
                    /*Agregar platillo*/
                    String[] params =  codObjeto.split(",");
                    /*for(int j=0;j<params.length;j++){
                    JFlex.Out.println("Pos "+ j +" = "+params[j]);
                    }*/
                    
                    if(params[0].equals("add")){
                        if(mesaActual==5){
                            txtErrores.setForeground(Color.ORANGE); 
                            audio.clear(); sonido("29.wav");
                            resultado="Excepción de ejecución. No se puede usar esta petición desde la cocina.";}
                        else{
                        numeroPlatillo=Integer.parseInt(params[2]);
                        cantPlatillos=Integer.parseInt(cantidadesPlatillos.get(i));
                        for(int j=0;j<cantPlatillos;j++){
                            //JFlex.Out.println("se agrego "+Platillos[numeroPlatillo]);
                            if(mesaActual==1){
                            cuenta.add(Platillos[numeroPlatillo]);
                            totalPagar+=precioPlatillos[numeroPlatillo];
                            
                                
                            }
                            if(mesaActual==2){
                            cuenta2.add(Platillos[numeroPlatillo]);
                            totalPagar2+=precioPlatillos[numeroPlatillo];
                            }
                            if(mesaActual==3){
                            cuenta3.add(Platillos[numeroPlatillo]);
                            totalPagar3+=precioPlatillos[numeroPlatillo];
                            }
                            if(mesaActual==4){
                            cuenta4.add(Platillos[numeroPlatillo]);
                            totalPagar4+=precioPlatillos[numeroPlatillo];
                            }
                            
                            
                        }
                        String temp="";
                            for(int q=0;q<cuenta.size();q++){
                                temp=cuenta.get(i)+"\n";                            
                            }
                            JFlex.Out.println(temp);
                        acum+="   [x"+cantPlatillos+"] - "+Platillos[numeroPlatillo]+"\n";
                        if(mesaActual==1){
                        txtCliente.setText("Se añadió a la cuenta:\n"+acum+"\n\n Total a pagar: $"+totalPagar+" MXN");}
                        if(mesaActual==2){
                        txtCliente.setText("Se añadió a la cuenta:\n"+acum+"\n\n Total a pagar: $"+totalPagar2+" MXN");}
                        if(mesaActual==3){
                        txtCliente.setText("Se añadió a la cuenta:\n"+acum+"\n\n Total a pagar: $"+totalPagar3+" MXN" );}
                        if(mesaActual==4){
                        txtCliente.setText("Se añadió a la cuenta:\n"+acum+"\n\n Total a pagar: $"+totalPagar4+" MXN");}
                    }}
                    
                    
                    /*Mostra menu*/
                    if(codObjeto.equals("show,menu, , ")){
                        JFlex.Out.println("Se mostro menú"+Platillos[0]);
                        mostrarMenu();
                    }//}else{ 
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
            codObjPeticionOptimizado.clear();
            acum="";
            
            if(!rutaAutomata.isEmpty()){
            ImageIcon logo1= new ImageIcon(getClass().getResource(rutaAutomata.get(rutaAutomata.size()-1)));
            Icon logo=new ImageIcon(logo1.getImage().getScaledInstance(logo1.getIconWidth()/2, logo1.getIconHeight()/2,Image.SCALE_DEFAULT));
            lblAutomata.setIcon(logo);
            println(rutaAutomata.get(0));
            }
            rutaAutomata.clear();
        }else{
            txtErrores.setForeground(Color.RED);
            
            txtErrores.setText(resultado+"Compilación completa.");
            genErrores.clear();
            codObjPeticion.clear();
            cantidadesPlatillos.clear();
            txtCodObjGenerado.setText(codObjGenerado);
            codObjGenerado="";
            codObjPeticionOptimizado.clear();
            acum="";
            if(!rutaAutomata.isEmpty()){
            ImageIcon logo1= new ImageIcon(getClass().getResource(rutaAutomata.get(rutaAutomata.size()-1)));
            Icon logo=new ImageIcon(logo1.getImage().getScaledInstance(logo1.getIconWidth()/2, logo1.getIconHeight()/2,Image.SCALE_DEFAULT));
            lblAutomata.setIcon(logo);
            println(rutaAutomata.get(0));
            }
            rutaAutomata.clear();
            }
            
             
        } catch (Exception ex) {
           Symbol sym = s.getS();
            txtErrores.setText("Error de sintaxis. Linea: "+ (sym.right +1)+ "Columna: "+ (sym.left + 1)+ ", \nTexto: \""+ sym.value+ "\n["+txtCodigo.getText()+"] No es una petición válida para el lenguaje. Marvin no puede entenderte :(");
            audio.clear();
            sonido("13.wav");
            txtErrores.setForeground(Color.RED);
            
             lblAutomata.setText("");
        }
        
        for(int i=0; i<audio.size();i++){
                 if(error==0){
                     error=audio.get(i);
                     System.out.println(audio.get(i));
                 }
            }
        reproduccionAudio(error);
        audio.clear();
}
   public void entregarPedido(String l){
       
       try {
                                       
                                        ino.sendData(l);
                                        
                                    } catch (ArduinoException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SerialPortException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    }
       
       
   }

public void traer(String c){
                                    try {
                                        ino.sendData(c);
                                    } catch (ArduinoException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SerialPortException ex) {
                                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                                    }
}
    private void jScrollPane5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane5KeyTyped
         System.out.println("Key Character: " + evt.getKeyChar() + "; Key Code: " + KeyEvent.getKeyText(evt.getKeyCode()));
    }//GEN-LAST:event_jScrollPane5KeyTyped
    private void peticionesMarvin(char c){
        int mesa=Integer.parseInt(c+"");
        if(peticionesMarvin.isEmpty()){
                 peticionesMarvin.add(mesa);
                 statusMarvin=true;
                System.out.println("Mesa"+mesa+"   Estado"+statusMarvin);
                   
             }else{
                 if(peticionesMarvin.get(peticionesMarvin.size()-1)!=mesa){
                statusMarvin=true;
                     peticionesMarvin.add(mesa);
                       System.out.println("Mesa"+mesa+"   Estado"+statusMarvin);
                 }
             }
    }
    private void txtCodigoDictadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoDictadoKeyTyped
    char c=evt.getKeyChar();
        if(c=='1'){
             
             //System.out.println("Mesa1");
             if (statusMarvin==false){
                 mesaActual=1;
            try {
                ino.sendData(c+"");
                ino.sendData("o");
            } catch (ArduinoException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SerialPortException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
             peticionesMarvin(c); 
        }
        if(c=='2'){
            
            //System.out.println(mesaActual+"");
            if (statusMarvin==false){
                mesaActual=2;
             try {
                ino.sendData(c+"");
                ino.sendData("o");
            } catch (ArduinoException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SerialPortException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            }
           peticionesMarvin(c);
        }
        if(c=='3'){
            
            //System.out.println(mesaActual+"");
            
            if (statusMarvin==false){
                mesaActual=3;
             try {
                ino.sendData(c+"");
                ino.sendData("o");
            } catch (ArduinoException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SerialPortException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            peticionesMarvin(c);
        }
        if(c=='4'){
            
            //System.out.println(mesaActual+"");  
            if (statusMarvin==false){
                mesaActual=4;
             try {
                ino.sendData(c+"");
                ino.sendData("o");
            } catch (ArduinoException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SerialPortException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
           peticionesMarvin(c);
        }
        if(c=='5'){
            
            //System.out.println(mesaActual+"");
            if (statusMarvin==false){
                mesaActual=5;
             try {
                ino.sendData(c+"");
                ino.sendData("o");
                ino.sendData("x");
            } catch (ArduinoException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SerialPortException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            peticionesMarvin(c);
             
        }
        
        if(Character.isDigit(c)){
		evt.consume();
        }
        
    }//GEN-LAST:event_txtCodigoDictadoKeyTyped

    private void btnConectarArduinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConectarArduinoKeyPressed
       
    }//GEN-LAST:event_btnConectarArduinoKeyPressed

    private void btnConectarArduinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConectarArduinoMouseClicked
        try {
            ino.arduinoRXTX("COM3", 9600,listener);
            arduinoOn=true;
            lblArduino.setText("[Conectado]");
        btnConectarArduino.setEnabled(false); 
        }catch(ArduinoException e){
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, e);
            lblArduino.setText("[Error]");
              btnConectarArduino.setEnabled(true);  
        }
        
             // TODO add your handling code here:
    }//GEN-LAST:event_btnConectarArduinoMouseClicked

    private void txtCodigoDictadoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCodigoDictadoInputMethodTextChanged
      compilacion+=1;
      if(compilacion==2){
          compilacion=0;
        if(arduinoOn==true){

        txtCodigo.setText(txtCodigoDictado.getText().toString());
        txtCliente.setText("");
        
        compilar();
       if(txtErrores.getText().equals("SIN ERRORES LÉXICOS - COMPILACIÓN EXITOSA")){
           sintactico();
       }
        txtArduinoCode.setText("");
        codArduinoGenerado="";

        hayError=false;
        }else{JOptionPane.showMessageDialog(this, "¡No se ha establecido conexión con Arduino!", "Alerta de conexión", JOptionPane.WARNING_MESSAGE); }
      }
    }//GEN-LAST:event_txtCodigoDictadoInputMethodTextChanged

    private void txtArduinoCodeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtArduinoCodeInputMethodTextChanged
       
    }//GEN-LAST:event_txtArduinoCodeInputMethodTextChanged

    private void btnConectarArduinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarArduinoActionPerformed
        arduinoOn=true;
    }//GEN-LAST:event_btnConectarArduinoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(arduinoOn==true){

        txtCodigo.setText(txtCodigoDictado.getText().toString());
        txtCliente.setText("");
        
        compilar();
       if(txtErrores.getText().equals("SIN ERRORES LÉXICOS - COMPILACIÓN EXITOSA")){
           sintactico();
       }
        txtArduinoCode.setText("");
        codArduinoGenerado="";

        hayError=false;
        }else{JOptionPane.showMessageDialog(this, "¡No se ha establecido conexión con Arduino!", "Alerta de conexión", JOptionPane.WARNING_MESSAGE); }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (filename == null || filename.equals("")) {

            int response = JOptionPane.showConfirmDialog(this, "¿Deseas guardar el archivo?", "Guardar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                //limpiar();

                txtCodigo.setText("");
                txtCodigoDictado.setText("");
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       saveAS();  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
       
         try {
           String ST = new String(Files.readAllBytes(archivo.toPath()));

           txtCodigoDictado.setText(ST);
         } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       txtCodigoDictado.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed
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

                    
                
                    
case SANJI:
fila[0] = lexer.lexeme;
    fila[1] = "SANJI";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case LEER:
fila[0] = lexer.lexeme;
    fila[1] = "LEER";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case QUIERO:
fila[0] = lexer.lexeme;
    fila[1] = "QUIERO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case OYE:
fila[0] = lexer.lexeme;
    fila[1] = "OYE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case PEPSI:
fila[0] = lexer.lexeme;
    fila[1] = "PEPSI";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case LA:
fila[0] = lexer.lexeme;
    fila[1] = "LA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case Y:
fila[0] = lexer.lexeme;
    fila[1] = "Y";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case HACER:
fila[0] = lexer.lexeme;
    fila[1] = "HACER";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case PEDIDO:
fila[0] = lexer.lexeme;
    fila[1] = "PEDIDO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case EL:
fila[0] = lexer.lexeme;
    fila[1] = "EL";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case LAS:
fila[0] = lexer.lexeme;
    fila[1] = "LAS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case LOS:
fila[0] = lexer.lexeme;
    fila[1] = "LOS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CANT_UN:
fila[0] = lexer.lexeme;
    fila[1] = "CANT_UN";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CANT_UNA:
fila[0] = lexer.lexeme;
    fila[1] = "CANT_UNA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CANT_PLURALES:
fila[0] = lexer.lexeme;
    fila[1] = "CANT_PLURALES";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
    case LISTO:
fila[0] = lexer.lexeme;
    fila[1] = "LISTO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case VASOS:
fila[0] = lexer.lexeme;
    fila[1] = "VASOS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case CUCHARAS:
fila[0] = lexer.lexeme;
    fila[1] = "CUCHARAS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case TENEDORES:
fila[0] = lexer.lexeme;
    fila[1] = "TENEDORES";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case SERVILLETAS:
fila[0] = lexer.lexeme;
    fila[1] = "SERVILLETAS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case MESAA:
fila[0] = lexer.lexeme;
    fila[1] = "MESAA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case MESAB:
fila[0] = lexer.lexeme;
    fila[1] = "MESAB";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case MESAC:
fila[0] = lexer.lexeme;
    fila[1] = "MESAC";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case MESAD:
fila[0] = lexer.lexeme;
    fila[1] = "MESAD";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;

case ADIOS:
fila[0] = lexer.lexeme;
    fila[1] = "ADIOS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case DE:
fila[0] = lexer.lexeme;
    fila[1] = "DE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case POR:
fila[0] = lexer.lexeme;
    fila[1] = "POR";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case FAVOR:
fila[0] = lexer.lexeme;
    fila[1] = "FAVOR";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case Coma:
fila[0] = lexer.lexeme;
    fila[1] = "Coma";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
    
break;
case ERROR:
   
     txtErrores.setForeground(Color.red);
     txtArduinoCode.setText("");
     txtCodObjGenerado.setText("");
     txtCliente.setText("");
     lblAutomata.setText("");
                        resultado = "Linea: " + cont + " ¡Error Léxico!: \n"
                                + "            Descripción: Palabra en petición no reconocida\n"
                                + "            Propuesta de solución: Utilice palabras válidas para el lenguaje de Marvin.\n" ;
                        
                        break;
//cuenta
case CUENTA:
fila[0] = lexer.lexeme;
    fila[1] = "CUENTA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case TRAER:
fila[0] = lexer.lexeme;
    fila[1] = "TRAER";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
 /*Menu*/
case MOSTRAR:
fila[0] = lexer.lexeme;
    fila[1] = "MOSTRAR";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case VER:
fila[0] = lexer.lexeme;
    fila[1] = "VER";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case MENU:
fila[0] = lexer.lexeme;
    fila[1] = "MENU";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CARTA:
fila[0] = lexer.lexeme;
    fila[1] = "CARTA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
//Cantidades plurales
case DOS:
fila[0] = lexer.lexeme;
    fila[1] = "DOS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case TRES:
fila[0] = lexer.lexeme;
    fila[1] = "TRES";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CUATRO:
fila[0] = lexer.lexeme;
    fila[1] = "CUATRO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CINCO:
fila[0] = lexer.lexeme;
    fila[1] = "CINCO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case SEIS:
fila[0] = lexer.lexeme;
    fila[1] = "SEIS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case SIETE:
fila[0] = lexer.lexeme;
    fila[1] = "SIETE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case OCHO:
fila[0] = lexer.lexeme;
    fila[1] = "OCHO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case NUEVE:
fila[0] = lexer.lexeme;
    fila[1] = "NUEVE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case DIEZ:
fila[0] = lexer.lexeme;
    fila[1] = "DIEZ";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case ONCE:
fila[0] = lexer.lexeme;
    fila[1] = "ONCE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case DOCE:
fila[0] = lexer.lexeme;
    fila[1] = "DOCE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case TRECE:
fila[0] = lexer.lexeme;
    fila[1] = "TRECE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CATORCE:
fila[0] = lexer.lexeme;
    fila[1] = "CATORCE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case QUINCE:
fila[0] = lexer.lexeme;
    fila[1] = "QUINCE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
/*Platillos*/
case SUSHI_CAMARON:
fila[0] = lexer.lexeme;
    fila[1] = "SUSHI_CAMARON";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case SUSHI_POLLO:
fila[0] = lexer.lexeme;
    fila[1] = "SUSHI_POLLO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case SUSHI_RES:
fila[0] = lexer.lexeme;
    fila[1] = "SUSHI_RES";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CAMARONITO:
fila[0] = lexer.lexeme;
    fila[1] = "CAMARONITO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case BOMBAZO:
fila[0] = lexer.lexeme;
    fila[1] = "BOMBAZO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case HAMBURGUESA_ARROZ:
fila[0] = lexer.lexeme;
    fila[1] = "HAMBURGUESA_ARROZ";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case TERIYAKI:
fila[0] = lexer.lexeme;
    fila[1] = "TERIYAKI";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case HELADO_VAINILLA:
fila[0] = lexer.lexeme;
    fila[1] = "HELADO_VAINILLA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case FRUTA_CARAMELO:
fila[0] = lexer.lexeme;
    fila[1] = "FRUTA_CARAMELO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case HELADO_CACAO:
fila[0] = lexer.lexeme;
    fila[1] = "HELADO_CACAO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case PIE_LIMON:
fila[0] = lexer.lexeme;
    fila[1] = "PIE_LIMON";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case PIE_FRESA:
fila[0] = lexer.lexeme;
    fila[1] = "PIE_FRESA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case PIE_MORA:
fila[0] = lexer.lexeme;
    fila[1] = "PIE_MORA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case PIE_QUESO:
fila[0] = lexer.lexeme;
    fila[1] = "PIE_QUESO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CHURROS:
fila[0] = lexer.lexeme;
    fila[1] = "CHURROS";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CAFE:
fila[0] = lexer.lexeme;
    fila[1] = "CAFE";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case EXPRESSO:
fila[0] = lexer.lexeme;
    fila[1] = "EXPRESSO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case MARTINI:
fila[0] = lexer.lexeme;
    fila[1] = "MARTINI";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case LIMONADA:
fila[0] = lexer.lexeme;
    fila[1] = "LIMONADA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case NARANJADA:
fila[0] = lexer.lexeme;
    fila[1] = "NARANJADA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case COCA_COLA:
fila[0] = lexer.lexeme;
    fila[1] = "COCA_COLA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case VICTORIA:
fila[0] = lexer.lexeme;
    fila[1] = "VICTORIA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case PIÑA_COLADA:
fila[0] = lexer.lexeme;
    fila[1] = "PIÑA_COLADA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case JUGO:
fila[0] = lexer.lexeme;
    fila[1] = "JUGO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case VAMPIRO:
fila[0] = lexer.lexeme;
    fila[1] = "VAMPIRO";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case CORONA:
fila[0] = lexer.lexeme;
    fila[1] = "CORONA";
    fila[2] = cont + "";
    model.addRow(fila);
    tblTokens.setModel(model);
break;
case FONDANT:
fila[0] = lexer.lexeme;
    fila[1] = "FONDAN";
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
    private javax.swing.JButton btnConectarArduino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblArduino;
    private javax.swing.JLabel lblAutomata;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JTable tblTokens;
    private javax.swing.JTextPane txtArduinoCode;
    private javax.swing.JTextPane txtCliente;
    private javax.swing.JTextPane txtCodObjGenerado;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtCodigoDictado;
    private javax.swing.JTextPane txtErrores;
    // End of variables declaration//GEN-END:variables
}
