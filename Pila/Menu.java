/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pila;

/**
 *
 * @author Lalito
 */
import javax.swing.*;

public class Menu {
    public static void main(String[] args) {
        Pila re = new Pila();

        boolean salida =false;
        int choice = 0;
        int MAX = 5;
        int[] PILA = new int[MAX];
        int TOPE = 0;
        int DATO = 0;

        do {

            String choice2 =JOptionPane.showInputDialog("------MENU PILA------\nElige una opción\n1.-Poner un Elemento"+
                    "\n2.-Quitar un elementon\n3.-Mostrar Pila\n4.-Salir");
            choice=Integer.parseInt(choice2);
            switch (choice) {
                case 1:
                    TOPE = re.Pone(PILA, TOPE, MAX);
                    break;
                case 2:
                    TOPE = re.Quita(PILA, TOPE);
                    break;
                case 3:
                    re.Mostrar(PILA, TOPE);
                    break;
                case 4:
                    salida=re.Exit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción elegida no existe\nPor favor elige una opcion dentro del menú");
                    break;
            }
        } while (!salida);
        System.exit(0);
    }
}
