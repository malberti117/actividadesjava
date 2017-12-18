package temperatura;

import java.util.Scanner;

public class Temperatura {
    
    private static double celsiusfarenheit(){
        double farenheit=0;
	System.out.println("Introduce los grados que quieres pasar de Celsius a Farenheit: ");
        Scanner a = new Scanner(System.in);
        double celsius=a.nextInt();
        farenheit = (1.8 * celsius)+32;
        System.out.println("El resultado de la conversión es: "+farenheit);
        return celsius;
	}
    
    private static double farenheitcelsius(){
        double celsius=0;
	System.out.println("Introduce los grados que quieres pasar de Farenheit a celsius: ");
        Scanner b = new Scanner(System.in);
        double farenheit=b.nextInt();
        celsius = (farenheit-32)/1.8;
        System.out.println("El resultado de la conversion es: "+celsius);
	return farenheit;
	}
    
    public static void main(String[] args) {
        try {
        System.out.println("Elige que tipo de grados vas a introducir para posteriormente convertirlos: ");
        System.out.println("Introduce 0 si quieres pasar de celsius a farenheit");
        System.out.println("Introduce 1 si quieres pasar de farenheit a celsius");
        Scanner teclado = new Scanner(System.in);
        int respuesta = teclado.nextInt();
        double resultado=0;
        switch (respuesta){
            case 0:
                resultado = celsiusfarenheit();
                break;
            case 1:
                resultado = farenheitcelsius();
                break;
            default:
                System.out.println("Opción no válida");
        }
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("No se admiten caracteres");
        }

    }

}
