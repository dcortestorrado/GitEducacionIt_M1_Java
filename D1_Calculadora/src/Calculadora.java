import java.util.*;

public class Calculadora {

    public static double inputNumeros(Scanner input, String mensaje) {
        double numero = 0.0;
        System.out.print(mensaje);

        try {
            numero = input.hasNextInt() ? (double) input.nextInt() : input.nextDouble();
        } catch(InputMismatchException | NumberFormatException e){
            System.out.println("El dato ingresado no es un número válido.");
            input.nextLine();
            inputNumeros(input, mensaje);
        }

        return numero;
    }

    public static double calcular(double numero1, double numero2, String operacion) {
        double resultado = 0.0;
        switch (operacion) {
            case "SUM":
                resultado = numero1 + numero2;
                break;
            case "RES":
                resultado = numero1 - numero2;
                break;
            case "MUL":
                resultado = numero1 * numero2;
                break;
            case "DIV":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    throw new ArithmeticException("No se puede dividir por cero");
                }
                break;
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean opValida;
        boolean continuar;
        String opcion;
        double resultado = 0.0;
        final List<String> operaciones = new ArrayList<>(Arrays.asList("SUM", "RES", "MUL", "DIV"));
        final List<String> opciones = new ArrayList<>(Arrays.asList("S", "N"));
        double numero1 = 0.0;
        double numero2 = 0.0;

        do {
            numero1 = inputNumeros(input, "Ingresa el primer número:");
            numero2 = inputNumeros(input, "Ingresa el segundo número:");

            do {
                System.out.print("Ingresa una operación válida. SUM(suma), RES(resta), MUL(multiplicación), DIV(división):");
                String operacion = "";
                try {
                    operacion = input.next().toUpperCase();
                    if (operaciones.contains(operacion)) {
                        opValida = true;
                        resultado = calcular(numero1, numero2, operacion);
                    } else {
                        System.out.println(operacion + " no es una operación válida. Inténtalo de nuevo.");
                        opValida = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(operacion + " no es una operación válida. Inténtalo de nuevo.");
                    opValida = false;
                }
            } while (!opValida);

            System.out.println("El resultado es " + resultado);

            do {
                System.out.println("¿Quieres realizar otra operación? S(sí)/N(no):");
                opcion = "";

                try {
                    opcion = input.next().toUpperCase();
                } catch (InputMismatchException e){
                    System.out.println("Ingresa una opción válida. S(sí)/N(no):");
                }
            } while(!opciones.contains(opcion));

            continuar = opcion.equals("S");

        } while(continuar);

        System.out.println("Gracias por usar tu app de calculadora. ¡Hasta luego!");
        input.close();
    }
}