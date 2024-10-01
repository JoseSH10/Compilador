import jflex.exceptions.SilentExit;  // Importa la clase SilentExit de JFlex para manejar errores específicos de JFlex.

/**
 * Clase principal para ejecutar JFlex y generar analizadores léxicos a partir de archivos .flex.
 */
public class ExecuteJFlex {

    public static void main(String omega[]) {
        // Obtiene el directorio de trabajo actual y construye las rutas absolutas para los archivos .flex.
        String lexerFile = System.getProperty("user.dir") + "/src/Lexer.flex",   // Ruta para el archivo Lexer.flex
               lexerFileColor = System.getProperty("user.dir") + "/src/LexerColor.flex";  // Ruta para el archivo LexerColor.flex
        
        try {
            // Llama al generador de JFlex con las rutas de los archivos .flex.
            // La función 'generate' toma un arreglo de strings (las rutas de los archivos).
            jflex.Main.generate(new String[]{lexerFile, lexerFileColor});
        } catch (SilentExit ex) {
            // Captura cualquier excepción lanzada por JFlex, en caso de fallar la generación.
            // Imprime un mensaje de error con el detalle de la excepción.
            System.out.println("Error al compilar/generar el archivo flex: " + ex);
        }
    }
}
