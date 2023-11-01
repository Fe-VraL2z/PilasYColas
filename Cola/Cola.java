/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cola;

/**
 *
 * @author Lalito
 */
import javax.swing.*;


public class Cola {
    static int Size = 5;
    static String Cola[]=new String[Size];
    static int FRENTE = -1;
    static int MAX=Size-1;
    static int FINAL=-1;
    boolean salida=false;

    public void Insertar(String Dato){
        if(FINAL<MAX){
            FINAL++;
            Cola[FINAL]=Dato;
            if (FINAL==0){
                FRENTE=0;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Desbordamiento - Cola llena");
        }
    }
    public void Quitar(){
        if(FRENTE != -1){
            String DATO = Cola[FRENTE];
            Cola[FRENTE]=null;
            JOptionPane.showMessageDialog(null,"El elemento eliminado es: " + DATO);
            if(FRENTE == FINAL){
                FRENTE = -1;
                FINAL = -1;
            } else {
                FRENTE++;
            }
        } else {
            JOptionPane.showMessageDialog(null,"Subdesbordamiento - Cola Vacia");
        }
    }
    public void mostrar(){
        if(FRENTE!=-1&&FINAL!=-1){
            String mCola="";
            for(int i=0; i<Size;i++){
                mCola=mCola+("Cola posicion " + (i+1) + " es " + Cola[i]+"\n");

            }
            JOptionPane.showMessageDialog(null, "----Elementos de la pila----\n"+mCola);
        }else{
            JOptionPane.showMessageDialog(null, "----Elementos de la pila----\nLa pila está vacía");
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
    public static void main(String[] args) {
        Cola re = new Cola();

        String DATO;

        int choice = 0;
        boolean salida=false;


        do {
            String choice2 =JOptionPane.showInputDialog(null,"----- MENU COLA -----\nElige una opcion\n1.- Poner un elemento (push)\n2.- Quitar un elemento\n3.- Mostrar la COLA\n4.- Salir");
            choice=Integer.parseInt(choice2);
            switch (choice) {
                case 1:

                    DATO = JOptionPane.showInputDialog("Ingrese el elemento que desea poner en la pila");
                    re.Insertar(DATO);
                    break;
                case 2:
                    re.Quitar();
                    break;
                case 3:
                    re.mostrar();
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
