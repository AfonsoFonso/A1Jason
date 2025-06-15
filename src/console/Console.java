package console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);

    public static String lerString() {
        return leitor.nextLine();
    }

    public static int lerInt() {
        
        int valor = 0;
        
        while(true){
            try{
                valor = leitor.nextInt();
                break; 

        } catch (InputMismatchException e){
            System.out.println("Valor informado precisa ser um inteiro");
            System.out.print("Digite novamente: ");
        }finally{
            leitor.nextLine();
        }
    }
    return valor;
}

    public static float lerFloat() {

        float valor = 0;

        while (true) { 
            try {
                valor = leitor.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor informado precisa ser um real");
                System.out.print("Digite novamente: ");
            }finally{
                leitor.nextLine();
            }
        }
        return valor;
    }
}