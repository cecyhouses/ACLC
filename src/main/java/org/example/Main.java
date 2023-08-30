import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java ExpresionRegONo <cadena>");
            return;
        }

        String cadena = args[0];

        // Expresiones regulares (ER)
        //1
        String ERHolaMundoExacto = "\\bHola mundo\\b";
        //2
        String ERHolaMundoLibre = "(?i)\\bHola mundo\\b";
        //3
        String ERNomasEstos = "\\b(?:Java|Python|Go|Pascal|Perl)\\b";
        //4
        String ERCorreoUni = "^[a-zA-Z0-9._%+-]+@(?:unison\\.mx|uson\\.mx)$";
        //5
        String ERPreISI = "^ISI\\d{4}[12]\\.(?:txt|csv)$";

        System.out.println("recibiendo argumento" + cadena);

        boolean esValida = validaER(cadena, ERHolaMundoExacto) ||
                validaER(cadena, ERHolaMundoLibre) ||
                validaER(cadena, ERNomasEstos) ||
                validaER(cadena, ERCorreoUni) ||
                validaER(cadena, ERPreISI);

        if (esValida) {
            System.out.println("valida");
        } else {
            System.out.println("no valida");
        }
    }

    public static boolean validaER(String cadena, String ER) {
        Pattern pattern = Pattern.compile(ER);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }
}
