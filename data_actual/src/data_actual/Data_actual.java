package data_actual;

/* Importamos las dos utilidades de java que necesitaremos:
el scanner para introducir por teclado y el calendario para conocer la fecha actual. */
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Data_actual {
    
/* Creamos el método bisiesto, que nos calculará si un año es bisiesto o no, y devolverá 
el valor integer 'c', siendo 1 cuando es bisiesto y 0 cuando no lo es. */
    public static int bisiesto (int x){
        int c=0;
        if ((x%4==0)&&(x%100!=0)||(x%400==0)){
            c+=1;
        }
            else{
            c=0;
        }
        
        return c;
    }
    
/* Creamos el método suma, que nos calculará mediante un bucle switch,
los días que hay entre la fecha actual y la solicitada por el usuario. */
    public static int suma (int y1,int y2, int y3){
        int resul=0;
        int dias_mes=0;
        double dias_ano=0;

        dias_ano = y1*365.25;
        int dias_y1=(int)dias_ano;
        
/* Creamos el bucle switch que nos permitirá calcular la acumulación de dias de los distintos 
meses del año con cases, y nos devolverá el resultado de la suma en la variable integer 'resul'. */          
          switch (y2){
          case 1: dias_mes = 0;
          break;
          case 2: dias_mes = 31;
          break;
          case 3: dias_mes = 59;
          break;
          case 4: dias_mes = 90;
          break;
          case 5: dias_mes = 120;
          break;
          case 6: dias_mes = 151;
          break;
          case 7: dias_mes = 181;
          break;
          case 8: dias_mes = 212;
          break;
          case 9: dias_mes = 243;
          break;
          case 10: dias_mes = 273;
          break;
          case 11: dias_mes = 304;
          break;
          case 12: dias_mes = 334;
          break;
          case 13: dias_mes = 365;
          break;
      }    
            resul = dias_y1 + dias_mes + y3;
            return resul;
    }
    
    public static void main (String[] args) {
        
/* Invocamos el útil de java del calendario gregoriano para saber la fecha actual y mostrarla por pantalla. */
        GregorianCalendar data = new GregorianCalendar();
        int dia = (data.get(GregorianCalendar.DATE));
        int mes = (data.get(GregorianCalendar.MONTH))+1;
        int ano = (data.get(GregorianCalendar.YEAR));
        System.out.println("La fecha actual es: "+dia+"/"+mes+"/"+ano);
        System.out.println(data.getTime());
        
/* Introducimos un try catch (totalmente opcional) para garantizar que el usuario
no introduzca letras por pantalla sino únicamente números. */
        try{
            
/* Solicitamos al usuario que introduzca por pantalla (en formato numérico) el día, el mes y el año actual
para poder realizar después los cálculos declarados en el resto de métodos. */
        System.out.println("Escribe el día en formato numérico (XX): ");
        Scanner d=new Scanner(System.in);
        int dia1= d.nextInt();
        System.out.println("Escribe el mes en formato numérico (XX): ");
        Scanner m=new Scanner(System.in);
        int mes1=m.nextInt();System.out.println("Escribe el año en formato numérico (XXXX): ");
        Scanner a=new Scanner(System.in);
        int ano1=a.nextInt();
        
/* Creamos un bucle switch para mostrar por pantalla si el año es o no bisiesto. */
        switch (bisiesto(ano1)){
            
            case 1 : System.out.println("Es un año bisiesto");
            break;
        
            case 0 : System.out.println("No es un año bisiesto");
            break;
        }

/* Invocamos los métodos ya creados para calcular la diferencia de días entre 
la fecha actual y la fecha introducida por el usuario. */
        int dias_actual = suma (ano, mes, dia);
        int dias_usuario = suma (ano1, mes1, dia1);
        
/* Creamos un bucle de condiciones, para mostrar por pantalla las diferentes casuísticas, es decir: 
si la fecha introducida y la actual son iguales, si la introducida es anterior, o bien si es posterior.  */
        if (dias_actual==dias_usuario){
            System.out.println("La fecha introducida ("+dia1+"/"+mes1+"/"+ano1+") y la fecha actual ("+dia+"/"+mes+"/"+ano+") son iguales");
        } else if (dias_actual>dias_usuario){
        int dias = (dias_actual) - dias_usuario;
            System.out.println("Han pasado " +dias+ " días desde la fecha introducida ("+dia1+"/"+mes1+"/"+ano1+").");
        } else {
            int dias = (dias_usuario) - dias_actual;
            System.out.println("Faltan " +dias+ " días para la fecha introducida ("+dia1+"/"+mes1+"/"+ano1+").");
        }
        }
        catch (Exception e) {
		System.out.println();
		System.out.println("No se permiten caracteres");
        }
    }
}
