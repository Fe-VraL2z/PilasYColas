/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColaCircular;
import javax.swing.*;
/**
 *
 * @author Lalito
 */
public class ColaCircularMenu {
    String mCola="";
    int SIZE = 5;
    String []COLACIR=new String[SIZE];
    int FRENTE;
    int FINAL;
    int MAX;
    ColaCircularMenu(){
        FRENTE=-1;
        FINAL=-1;
        MAX=4;
    }
    public void Inserta_circular() {
        if (((FINAL == MAX) && (FRENTE == 0)) || ((FINAL + 1) == FRENTE)) {
            JOptionPane.showMessageDialog(null,"Desbordamiento - Cola llena");
        } else {
            String DATO = JOptionPane.showInputDialog("Ingrese el elemento que desea poner en la pila");;
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
            JOptionPane.showMessageDialog(null,"El elemento eliminado es: " + COLACIR[FRENTE]);
            COLACIR[FRENTE]=null;
        }else{
            JOptionPane.showMessageDialog(null,"Subdesbordamiento - Cola Vacia");
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

        if(FRENTE==-1&&FINAL==-1){
            JOptionPane.showMessageDialog(null, "----Elementos de la pila----\nLa pila está vacía\n--------------------------");
        }else{

            if(FRENTE!=-1&&FINAL!=-1){
                String mCola="";
                for(int i=0; i<SIZE;i++){
                    mCola=mCola+("Cola posicion " + (i+1) + " es " + COLACIR[i]+"\n");
                }
                JOptionPane.showMessageDialog(null, "----Elementos de la pila----\n"+mCola+"--------------------------");
            }
        }

    }
    public boolean Exit() {
        int respuesta = JOptionPane.showConfirmDialog(null, "Desea salir del programa", "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        ColaCircularMenu re = new ColaCircularMenu();

        String DATO;
        int choice = 0;
        boolean salida=false;


        do {
            String choice2 =JOptionPane.showInputDialog(null,"----- MENU COLA CIRCULAR -----\nElige una opcion\n1.- Poner un elemento (push)\n2.- Quitar un elemento\n3.- Mostrar la COLA\n4.- Salir");
            choice=Integer.parseInt(choice2);
            switch (choice) {
                case 1:
                    re.Inserta_circular();
                    break;
                case 2:
                    re.Elimina_circular();
                    break;
                case 3:
                    re.Muestra();
                    break;
                case 4:
                    salida=re.Exit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Esa opción elegida no existe\nPor favor elige una opcion dentro del menú");
                    break;
            }
        } while (!salida);
        System.exit(0);
    }
}
