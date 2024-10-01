
// Importa la biblioteca FlatLaf para aplicar temas y estilos visuales modernos a las aplicaciones Java Swing.
// FlatIntelliJLaf proporciona un tema similar a IntelliJ IDEA.
import com.formdev.flatlaf.FlatIntelliJLaf;

// Importa la clase CodeBlock que probablemente representa un bloque de código o estructura de código.
// Esta clase podría estar relacionada con la manipulación de fragmentos de código dentro del compilador.
import compilerTools.CodeBlock;

// Importa clases de Swing para manejar y personalizar la interfaz gráfica de usuario.
import javax.swing.UIManager;  // UIManager permite configurar el estilo visual (look and feel) de la aplicación.
import javax.swing.UnsupportedLookAndFeelException;  // Excepción que ocurre si el look and feel no es compatible.

// Herramientas adicionales relacionadas con el compilador:
import compilerTools.Directory;  // Directory podría estar relacionada con la gestión de archivos y directorios.
import compilerTools.ErrorLSSL;  // Manejo de errores específicos del compilador o lenguaje definido en LSSL.
import compilerTools.Functions;  // Contiene funciones utilitarias relacionadas con el compilador o procesamiento de código.
import compilerTools.Grammar;  // Representa la gramática del lenguaje que maneja el compilador.
import compilerTools.Production;  // Representa una producción de la gramática, útil para definir reglas gramaticales.
import compilerTools.TextColor;  // Maneja el color del texto, posiblemente en un editor de código para resaltar sintaxis.
import compilerTools.Token;  // Representa un token léxico, fundamental en el análisis léxico del compilador.

// Importa clases de AWT para manejar aspectos de la interfaz gráfica no cubiertos por Swing.
import java.awt.Color;  // Clase para manejar colores en la interfaz gráfica.
import java.awt.event.ActionEvent;  // Acción realizada al ejecutar algún evento (como un clic de botón).
import java.awt.event.WindowAdapter;  // Adaptador para manejar eventos de ventana.
import java.awt.event.WindowEvent;  // Evento de ventana, como apertura, cierre o minimizar.

// Importa clases de Java IO para manejar archivos y flujo de datos.
import java.io.BufferedReader;  // Para leer texto de una secuencia de entrada (como archivos) de manera eficiente.
import java.io.File;  // Clase que representa archivos o directorios.
import java.io.FileInputStream;  // Para leer bytes de un archivo.
import java.io.FileNotFoundException;  // Excepción lanzada cuando no se encuentra un archivo.
import java.io.FileOutputStream;  // Para escribir bytes en un archivo.
import java.io.IOException;  // Excepción general de entrada/salida, manejada cuando ocurren errores de I/O.
import java.io.InputStreamReader;  // Convierte un InputStream en un lector de texto.

// Importa estructuras de datos de Java:
import java.util.ArrayList;  // Lista dinámica que puede cambiar de tamaño.
import java.util.HashMap;  // Estructura de datos de mapa para asociar claves y valores.

// Importa componentes adicionales de Swing:
import javax.swing.JOptionPane;  // Para mostrar cuadros de diálogo (mensajes emergentes) en la interfaz.
import javax.swing.Timer;  // Temporizador para realizar tareas repetitivas con un intervalo de tiempo definido.

/**
 *
 * @author yisus
 */
public class Compilador extends javax.swing.JFrame {

    private String title;// Título de la ventana
    private Directory directorio;// Objeto para manejar los archivos del proyecto
    private ArrayList<Token> tokens;// Lista que almacena los tokens generados del código
    private ArrayList<ErrorLSSL> errors;// Lista que almacena los errores encontrados durante la compilación
    private ArrayList<TextColor> textsColor;// Lista que maneja el color del texto para la sintaxis del código
    private Timer timerKeyReleased;// Temporizador que se activa al soltar una tecla para realizar acciones como el análisis de color
    private ArrayList<Production> identProd;// Lista que maneja las producciones identificadas en la gramática del compilador
    private HashMap<String, String> identificadores;// Mapa para almacenar identificadores y sus valores
    private boolean codeHasBeenCompiled = false;// Variable booleana para saber si el código ha sido compilado con éxito
    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();// Inicializa los componentes gráficos (botones, paneles, etc.)
        init();// Llama a un método personalizado para más configuraciones.
    }

     private void init() {// Metodo de inicialización
        title = "Compiler";// titulo de la ventana
        setLocationRelativeTo(null);// Coloca la ventana en el centro de la pantalla
        setTitle(title);// Aplica el título definido a la ventana
        directorio = new Directory(this, jtpCode, title, ".comp");// Inicializa el objeto directorio
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();// Llama al método 'Exit' para cerrar archivos y liberar recursos
                System.exit(0);// Cierra la aplicación
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode); // Configura el número de líneas en el editor de código
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();// Detiene el temporizador
            colorAnalysis();// Realiza el análisis del color del texto (resaltar la sintaxis)
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {// Inserta un asterisco (*) en el título de la ventana si hay cambios en el código
            timerKeyReleased.restart();// Reinicia el temporizador para analizar el color después de cambios.
        });
        // Inicializa las listas y mapas para los tokens, errores, colores de texto, etc.
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jtpCode);

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rootPanelLayout.createSequentialGroup()
                        .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(rootPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);
                executeCode(blocksOfCode, 1);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed
    
    private void executeCode(ArrayList<String> blocksOfCode, int repeats){
        for(int j=1; j<=repeats; j++){
            int repeatCode = -1;// Variable para almacenar la cantidad de repeticiones dentro de un bloque
            for (int i = 0; i < blocksOfCode.size(); i++){// Ciclo para recorrer cada bloque de código
                String blockOfCode = blocksOfCode.get(i);// Extrae el bloque de código en la posición i
                // Si repeatCode es diferente de -1, significa que estamos dentro de un bloque repetir
                if(repeatCode!= -1){
                    // Obtiene las posiciones de inicio y fin de los marcadores de bloque para repetir
                    int[] posicionMarcador = CodeBlock.getPositionOfBothMarkers(blocksOfCode, blockOfCode);
                    // Llama a executeCode recursivamente para ejecutar el sub-bloque repetido
                    executeCode(new ArrayList<>(blocksOfCode.subList(posicionMarcador[0], posicionMarcador[1])), repeatCode);
                    // Resetea repeatCode y actualiza i para saltar al final del bloque repetir
                    repeatCode = -1;
                    i = posicionMarcador[1];
                }
                else{
                    // Divide el bloque de código actual en sentencias individuales separadas por punto y coma
                    String[] sentences= blockOfCode.split(";");
                    for(String sentence : sentences ){// Itera sobre cada sentencia en el bloque de código
                        sentence = sentence.trim();// Elimina espacios en blanco antes y después de la sentencia
                        if(sentence.startsWith("pintar")){// Si la sentencia es "pintar", identifica el color a usar
                            String parametro;
                            // Si el color es una variable identificada por $, busca el valor en el mapa de identificadores
                            if(sentence.contains("$")){
                                parametro = identificadores.get(sentence.substring(9, sentence.length()-2));
                            }else{
                                 // Si no, toma el color directamente de la sentencia.
                                parametro = sentence.substring(9, sentence.length()-2);
                            }
                            System.out.println("Pintando de color " +parametro+"...");// Imprime el color que se está "pintando"
                            
                        }
                        // Si la sentencia es "derecha", imprime que se está moviendo a la derecha
                        else if(sentence.startsWith("derecha")){
                            System.out.println("Moviendose a la derecha");
                        }
                        // Si la sentencia es "izquierda", imprime que se está moviendo a la izquierda
                        else if(sentence.startsWith("izquierda")){
                            System.out.println("Moviendose a la izquierda");
                        }
                        // Si la sentencia es "adelante", imprime que se está moviendo hacia adelante
                        else if(sentence.startsWith("adelante")){
                            System.out.println("Moviendose hacia adelante");
                        }
                        // Si la sentencia es "-->", se está declarando un identificador
                        else if(sentence.startsWith("-->")){
                            System.out.println("Meclarando identificador...");
                        }
                        // Si la sentencia es "atrás", imprime que se está moviendo hacia atrás
                        else if(sentence.startsWith("atrás")){
                            System.out.println("Moviendose hacia atrás");
                        }
                        // Si la sentencia es "repetir", se prepara para ejecutar un ciclo
                        else if(sentence.startsWith("repetir")){
                            String parametro;
                            // Si el número de repeticiones está representado por una variable, busca su valor en el mapa
                            if(sentence.contains("$")){
                                parametro = identificadores.get(sentence.substring(10, sentence.length()-2));
                            }else{
                                // Si no, toma el número directamente de la sentencia
                                parametro = sentence.substring(10,sentence.length()-2);
                            }
                            repeatCode = Integer.parseInt(parametro);// Almacena el número de repeticiones para el siguiente bloque
                        }
                    }
                }
            }
        }
    }
    // Método que inicia el proceso de compilación del código ingresado
    private void compile() {
        clearFields();// Limpia los campos de la interfaz
        lexicalAnalysis();// Realiza el análisis léxico del código
        fillTableTokens();// Llena la tabla de tokens con los resultados del análisis léxico
        syntacticAnalysis();// Realiza el análisis sintáctico
        semanticAnalysis();// Realiza el análisis semántico
        printConsole();// Imprime los resultados en la consola
        codeHasBeenCompiled = true;// Marca que el código ha sido compilado correctamente
    }
    // Método que realiza el análisis léxico, transformando el código fuente en una serie de tokens
    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;// Declara un objeto Lexer para procesar el código
        try {
            // Crea un archivo temporal para almacenar el código ingresado
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText); // Escribe el contenido del código en el archivo
            //Abre el archivo para leerlo y procesarlo en el lexer
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);//Inicializamos el lexer
            while (true) {// Lee tokens asta que haya mas que procesar
                Token token = lexer.yylex();
                if (token == null) {
                    break;//Termina cuando no quedan tokens 
                }
                tokens.add(token);// Agrega el token a la lista de tokens
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }
    // Método que realiza el análisis sintáctico del código fuente
    private void syntacticAnalysis() {
        // Se crea una nueva instancia de la clase Grammar, que toma los tokens y los errores como parámetros
        Grammar gramatica = new Grammar(tokens, errors);
        
        /*Eliminacion de errores*/
        gramatica.delete(new String[]{"ERROR", "ERROR_1", "ERROR_2"},1);
        
        /* Agrupacion de valores */
        gramatica.group("VALOR", "(NUMERO | COLOR)", true);
        
        /* Declaracion de variables */
        gramatica.group("VARIABLE" , "TIPO_DATO IDENTIFICADOR OP_ASIG VALOR", true, identProd);
        gramatica.group("VARIABLE" , "TIPO_DATO OP_ASIG VALOR", true,
                2, "error sintactico: falta el identificador en la variable [#, %]");
        
        gramatica.finalLineColumn();
        
        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OP_ASIG",
                3,"error sintactico {}: falta el identificador en la variable [#, %]");
        
        gramatica.initialLineColumn();
        
        /*Eliminacion de tipos de dato y operadores de asignacion*/
        gramatica.delete("TIPO_DATO",4,
                "error sintactico{}: falta el identificador en la variable [#, %]");
        gramatica.delete("OP_ASIG",4,
                "error sintactico{}: falta el identificador en la variable [#, %]");
        
        /*Agrupar identificadores y definicion de parametros*/
        gramatica.group("VALOR", "IDENTIFICADOR", true);
        gramatica.group("PARAMETROS", "VALOR(COMA VALOR)+", true);
        
        /* Agrupacion de Funciones */
        gramatica.group("FUNCION", "(MOVIMIENTO | PINTAR | DETENER_PINTAR | TOMAR |"
                + " LANZAR_MONEDA | VER | DETENER_REPETIR)", true);
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)? PARENTESIS_C", true);
        gramatica.group("FUNCION_COMP", "FUNCION (VALOR | PARAMETROS)? PARENTESIS_C", true,
                6,"error_sintactico {}: falta el parentesis que abre la funcion[#,%]");
        gramatica.finalLineColumn();
        
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)", true,
                7, "error_sintactico {}: falta el parentesis que abre la funcion[#,%]");
        
        gramatica.initialLineColumn();
        
        /* Eliminiacion de funciones incompletas */
        gramatica.delete("FUNCION",8,"error sintactico {}: la funcion no esta declarada correctamente");
        
        gramatica.loopForFunExecUntilChangeNotDetected(()->{
        gramatica.group("EXP_LOGICA", "(FUNCION_COMP | EXP_LOGICA) (OP_LOGICO (FUNCION_COMP | EXP_LOGICA))+");
        gramatica.group("EXP_LOGICA", "PARENTESIS_A (EXP_LOGICA | FUNCION_COMP) PARENTESIS_C");
        });

        /* ELiminacion de operadores logicos*/
        gramatica.delete("OP_LOGICO",10,
                "error sintactico{}: el operador logico no esta contenido en una expresion");
        
        /* Agrupacion de exp. logicas como valor y parametros */
        gramatica.group("VALOR", "EXP_LOGICA");
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");
        
        /* Agrupacion de estructuras de control */
        gramatica.group("EST_CONTROL", "(REPETIR | ESTRUCTURA_SI)");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A PARENTESIS_C");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL (VALOR | PARAMETROS)");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A (VALOR | PARAMETROS) PARENTESIS_C");
        
        /* ELIMINACION DE ESTRUCTURAS DE CONTROL INCOMPLETAS */
        gramatica.delete("EST_CONTROL",11,
                "error sintactico {}: La estructura de control no esta declarada correctamente [#,%]");
        
        /* Eliminacion de parentesis */
        gramatica.delete(new String []{"PARENTESIS_A","PARENTESIS_C"},12,
            "error sintactico {}: el parentesis [] no esta contenido en una agrupacion [#, %]");
        
        gramatica.finalLineColumn();
        
        /* Verificacion de punto y coma al final de una sentencia */
        //Identificadores o variables
        gramatica.group("VARIABLE_PC", "VARIABLE PUNTO_COMA",true);
        gramatica.group("VARIABLE_PC", "VARIABLE",true,
                13, "error sintactico {}: Falta el punto y coma final de la variable [#, %]");
        
        //Funciones
        gramatica.group("FUNCION_COMP_PC", "FUNCION_COMP PUNTO_COMA");
        gramatica.group("FUNCION_COMP_PC", "FUNCION_COMP", 14,
                "error sintactico {}: falta el punto y coma al final de la declaracion de la funcion");
        
        gramatica.initialLineColumn();
        
        /* Eliminacion del punto y coma */
        gramatica.delete("PUNTO_COMA",15,
                "error sintactico {}: el punto y coma no esta al final de una sentencia");
        
        /* Sentencias */
        gramatica.group("SENTENCIAS", "(VARIABLE_PC | FUNCION_COMP_PC)+");
        
        /*  */
        gramatica.loopForFunExecUntilChangeNotDetected(()->{
            gramatica.group("EST_CONTROL_COMP_LASLC","EST_CONTROL_COMP LLAVE_A (SENTENCIAS)? LLAVE_C",true);
            gramatica.group("SENTENCIAS","(SENTENCIAS | EST_CONTROL_COMP_LASLC)+");
        });
        
        /* Estructuras de funcion incompletas */
        gramatica.loopForFunExecUntilChangeNotDetected(()->{
            gramatica.initialLineColumn();
            
            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP (SENTENCIAS)? LLAVE_C",true,
                    15, "error sintactico {}: falta la llave que abre en la estructura de control");
            
            gramatica.finalLineColumn();
            
            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP LLAVE_A SENTENCIAS",true,
                    15, "error sintactico {}: falta la llave que cierra en la estructura de control");
            
            gramatica.group("SENTENCIAS","(SENTENCIAS | EST_CONTROL_COMP_LASLC)");
        });
        
        gramatica.delete(new String[]{"LLAVE_A","LLAVE_C"},16,
                "error sintactico {}: la llave {} no esta contenida en una agrupacion [#, %]");
        
        
        /* Mostrar gramáticas */
        gramatica.show();
    }
    // Método que realiza el análisis semántico del código, verificando la compatibilidad entre tipos de datos y valores asignados
    private void semanticAnalysis() {
        HashMap<String, String> identDataType = new HashMap<>();// Mapa que almacena los tipos de datos permitidos
        identDataType.put("color", "COLOR");// Asocia "color" con el tipo "COLOR"
        identDataType.put("número", "NUMERO");// Asocia "número" con el tipo "NUMERO"

        for(Production id: identProd){// Recorre todas las producciones que contienen identificadores
            // Verifica si el tipo de dato asociado al identificador no coincide con el valor asignado
            if (!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))){
                // Si no coinciden, agrega un error semántico de tipo de dato incompatible
                errors.add(new ErrorLSSL(1 , "error semantico {}: valor no compatible con el tipo de dato", id, true));
            }
             // Si el tipo de dato es "COLOR", verifica que el valor sea un código hexadecimal válido
            else if (id.lexicalCompRank(-1).equals("COLOR") && !id.lexemeRank(-1).matches("#[0-9a-fA-F]+")){
                // Si no es un código hexadecimal válido, agrega un error semántico
                errors.add(new ErrorLSSL(2 , "error semantico {}: el color no es un numero hexadecimal", id, false));
            }
            else{// Si el tipo de dato es válido y compatible, agrega el identificador y su valor al mapa de identificadores
                identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
            }
        }
    }
    // Método que realiza el análisis de colores en el código
    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {// Crea un archivo temporal para procesar el texto de colores encriptados
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();// Convierte el código a bytes
            output.write(bytesText);// Escribe los bytes en el archivo temporal
            // Crea un lector que permitirá leer el archivo para el análisis de colores
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);// Inicializa el lexer con el archivo de entrada
            // Extrae y analiza cada color hasta que no queden más en el código
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;// Si no hay más colores, se detiene el análisis
                }
                textsColor.add(textColor);// Añade el color al arreglo
            }
        } catch (FileNotFoundException ex) {// Manejo de excepciones si el archivo no se encuentra
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {// Manejo de excepciones si ocurre un error de escritura en el archivo
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }
    // Manejo de excepciones si el archivo no se encuentra
    private void fillTableTokens() {
        tokens.forEach(token -> {// Manejo de excepciones si el archivo no se encuentra
            // Manejo de excepciones si el archivo no se encuentra
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            // Manejo de excepciones si el archivo no se encuentra
            Functions.addRowDataInTable(tblTokens, data);
        });
    }
    // Manejo de excepciones si el archivo no se encuentra
    private void printConsole() {
        int sizeErrors = errors.size();// Manejo de excepciones si el archivo no se encuentra
        if (sizeErrors > 0) {// Manejo de excepciones si el archivo no se encuentra
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {// Manejo de excepciones si el archivo no se encuentra
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            // Manejo de excepciones si el archivo no se encuentra
            jtaOutputConsole.setText("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            // Manejo de excepciones si el archivo no se encuentra
            jtaOutputConsole.setText("Compilación terminada...");
        }
        // Manejo de excepciones si el archivo no se encuentra
        jtaOutputConsole.setCaretPosition(0);
    }
    // Manejo de excepciones si el archivo no se encuentra
    private void clearFields() {
        Functions.clearDataInTable(tblTokens);// Manejo de excepciones si el archivo no se encuentra
        jtaOutputConsole.setText("");// Manejo de excepciones si el archivo no se encuentra
        // Manejo de excepciones si el archivo no se encuentra
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;// Manejo de excepciones si el archivo no se encuentra
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
