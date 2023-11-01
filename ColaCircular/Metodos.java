/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColaCircular;

/**
 *
 * @author Lalito
 */

import java.util.Scanner;

public class Metodos {
    String []COLACIR=new String[5];
    int FRENTE;
    int FINAL;
    int MAX;
    Metodos(){
        FRENTE=-1;
        FINAL=-1;
        MAX=4;
    }
    public void Inserta_circular(String DATO) {
        if (((FINAL == MAX) && (FRENTE == 0)) || ((FINAL + 1) == FRENTE)) {
            System.out.println("DESBORDAMIENTO! - Cola llena -");
        } else {
            if (FINAL == MAX) {
                FINAL = 0;
            } else {
                FINAL++;
            }
            COLACIR[FINAL] = DATO;
            if (FRENTE == -1) {
                FRENTE = 0;
            }
        }
    }
    public void Elimina_circular(){
     if(FRENTE!=-1){
         System.out.println("El dato que sale es "+COLACIR[FRENTE]);
         COLACIR[FRENTE]=null;
     }else{
         System.out.println("Subdesbordamiento! - Cola vacia -");
     }
     if(FRENTE==FINAL){
         FRENTE=-1;
         FINAL=-1;
     }else{
         if(FRENTE==MAX){
             FRENTE=0;
         }else{
             FRENTE++;
         }
     }
    }
    public void Muestra(){
        System.out.println("----Elementos De La Cola----");
        if(FRENTE==-1&&FINAL==-1){
            System.out.println("No hay ningun elemento en la cola");
        }else{

            for(int i=0; i<5;i++){
                System.out.println("Cola posicion " + (i+1) + " es " + COLACIR[i]);
            }
        }
        System.out.println("--------------------------");
    }
    public static void main(String[] args) {
        Metodos re = new Metodos();

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
                    re.Inserta_circular(DATO);
                    break;
                case 2:
                    re.Elimina_circular();
                    break;
                case 3:
                    re.Muestra();
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
