/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pila;
import javax.swing.*;

/**
 *
 * @author Lalito
 */


public class Pila {

    private boolean PilaVacia(int TOPE) {
        if (TOPE == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean Pilallena(int TOPE, int MAX) {
        if (TOPE == MAX) {
            return true;
        } else {
            return false;
        }
    }

    public int Pone(int[] PILA, int TOPE, int MAX) {
        if (Pilallena(TOPE, MAX)) {
            JOptionPane.showMessageDialog(null,"La pila está llena\nPor favor elige otra opción");
        } else {
            String Dato = JOptionPane.showInputDialog("Ingrese el elemento que desea poner en la pila");
            int DATO = Integer.parseInt(Dato);
            PILA[TOPE] = DATO;
            TOPE++;
        }
        return TOPE;
    }

    public int Quita(int[] PILA, int TOPE) {
        if (PilaVacia(TOPE)) {
            JOptionPane.showMessageDialog(null,"Subdesbordamiento!\nLa pila está vacía");
        } else {
            TOPE--;
            int DATO = PILA[TOPE];
            JOptionPane.showMessageDialog(null, "Elemento quitado de la pila en la posicion " + (TOPE + 1) + " es: " + DATO);

        }
        return TOPE;
    }

    public void Mostrar(int[] PILA, int TOPE) {
        if (TOPE == 0) {
            JOptionPane.showMessageDialog(null, "----Elementos de la pila----\nLa pila está vacía");
        } else {
            StringBuilder mensaje = new StringBuilder("---ELEMENTOS DE LA PILA---\n");

            for (int i = 0; i < TOPE; i++) {
                mensaje.append("posicion ").append(i + 1).append(": ").append(PILA[i]).append("\n");
            }


            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
        }
    public boolean Exit() {
        int respuesta= JOptionPane.showConfirmDialog(null, "Desea salir del programa", "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION){
            return true;
        }else {
            return false;
        }
    }
}
