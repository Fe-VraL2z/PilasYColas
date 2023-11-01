/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cola;

/**
 *
 * @author Lalito
 */
import java.util.Scanner;

public class Menu {

    static int Size = 5;
    static String Cola[]=new String[Size];
    static int FRENTE = -1;
    static int MAX=Size-1;
    static int FINAL=-1;
    public void Insertar(String Dato){
        if(FINAL<MAX){
            FINAL++;
            Cola[FINAL]=Dato;
            if (FINAL==0){
                FRENTE=0;
            }
        }else{
            System.out.println("Desbordamiento - Cola llena");
        }
    }
    public void Quitar(){
        if(FRENTE != -1){
            String DATO = Cola[FRENTE];
            Cola[FRENTE]=null;
            System.out.println("El elemento eliminado es: " + DATO);
            if(FRENTE == FINAL){
                FRENTE = -1;
                FINAL = -1;
            } else {
                FRENTE++;
            }
        } else {
            System.out.println("Subdesbordamiento - Cola Vacia");
        }
    }
    public void mostrar(){
        System.out.println("----Elementos De La Cola----");
        if(FRENTE!=-1&&FINAL!=-1){
        for(int i=0; i<Size;i++){
            System.out.println("Cola posicion " + (i+1) + " es " + Cola[i]);
        }
        }else{
            System.out.println("No hay ningun elemento en la cola");
        }
        System.out.println("--------------------------");
    }
    public static void main(String[] args) {
        Menu re = new Menu();

        String DATO;
        Scanner sc = new Scanner(System.in);
        int choice = 0;


        do {
            System.out.println("----- MENU COLA -----");
            System.out.println("Elige una opcion");
            System.out.println("1.- Poner un elemento (push)");
            System.out.println("2.- Quitar un elemento");
            System.out.println("3.- Mostrar la COLA");
            System.out.println("4.- Salir");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    DATO = sc.next();
                    re.Insertar(DATO);
                    break;
                case 2:
                    re.Quitar();
                    break;
                case 3:
                    re.mostrar();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("La opcion elegida no exite");
                    System.out.println("Por favor elige una opcion dentro del menu");
                    break;
            }
        } while (choice != 4);
    }
}
