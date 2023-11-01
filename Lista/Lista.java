/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista;
import javax.swing.*;

/**
 *
 * @author Lalito
 */


public class Lista {
    static boolean ListStarted=false;

    public static class Node {
        String INFO;
        Node LIGA;
    }

    Node P = new Node();
    Node Q;
    Node F;

    byte BAND;
    String Dato;
    String RES2;

    /*
    public void Crea_Inicio() {
        ListStarted = true;
        int RES = 0;
        System.out.println("Escribe la Información del nodo");
        P = new Node(); // Inicializa P como un nuevo nodo
        P.INFO = sc.next();
        P.LIGA = null;
        System.out.println("Deseas mas datos? \nSi:1\nNo:2");
        RES = sc.nextInt();
        Node Q = null;
        while (RES == 1) {
            Q = new Node();
            System.out.println("Escribe la Información del nodo");
            Q.INFO = sc.next();
            Q.LIGA = P;
            P = Q;
            System.out.println("Deseas mas datos? \nSi:1\nNo:2");
            RES = sc.nextInt();
        }
        Mostrar_lista();
    }

     */

    public void Crea_Final() {
        ListStarted=true;
        int RES = 0;

        Node T = new Node();

        P = new Node();
        P.INFO = JOptionPane.showInputDialog("Ingrese el elemento que desea poner en la lista");
        P.LIGA = null;
        T = P;
        RES2 = JOptionPane.showInputDialog("Deseas mas datos? \nSi:1\nNo:2");
        RES = Integer.parseInt(RES2);
        while (RES == 1) {
            Q = new Node();
            Q.INFO = JOptionPane.showInputDialog("Ingrese el elemento que desea poner en la pila");;
            Q.LIGA = null;
            T.LIGA = Q;
            T = Q;
            String RES2 = JOptionPane.showInputDialog("Deseas mas datos? \nSi:1\nNo:2");
            RES = Integer.parseInt(RES2);
        }

    }

    public void Mostrar_lista() {
        Node Q = new Node();
        String mCola="";

        Q = P;
        while (Q != null) {
            mCola=mCola+(Q.INFO+"-");
            Q = Q.LIGA;

        }
        JOptionPane.showMessageDialog(null, "----Elementos de la Lista----\n-"+mCola+"\n--------------------------");
    }

    public void Inserta_Inicio() {
        Node Q = new Node();
        Dato = JOptionPane.showInputDialog(null,"Dame el dato a insertar al principio");
        Q.INFO = Dato;
        Q.LIGA = P;
        P = Q;
    }

    public void Inserta_Final() {
        Node T  = new Node();
        T = P;
        while (T.LIGA != null) {
            T = T.LIGA;
        }
        Node Q = new Node();
        Dato = JOptionPane.showInputDialog(null,"Dame el dato a insertar al final");
        Q.INFO = Dato;
        Q.LIGA = null;
        T.LIGA = Q;
    }

    public void Inserta_Antes_X() {
        Node T = new Node();
        Node Q = new Node();
        Q = P;
        BAND = 1;
        String x = JOptionPane.showInputDialog("Dame la referencia del nodo (El contenido de este)");
        while (!Q.INFO.equals(x) && BAND == 1) {
            if (Q.LIGA != null) {
                T = Q;
                Q = Q.LIGA;
            } else {
                BAND = 0;
            }
        }
        if (BAND == 1) {
            Node Z = new Node();
            Dato = JOptionPane.showInputDialog("Dame el dato a ingresar");
            Z.INFO = Dato;
            if (P == Q) {
                Z.LIGA = P;
                P = Z;
            } else {
                T.LIGA = Z;
                Z.LIGA = Q;
            }
        } else {

            JOptionPane.showMessageDialog(null,"El nodo dado como referencia no se encuentra en la lista");
        }
    }
    public void Inserta_Despues_X(){
        Node Q = new Node();
        String x = JOptionPane.showInputDialog("Dame la referencia del nodo (El contenido de este)");
        Q=P;
        BAND=1;
        while(!Q.INFO.equals(x) && BAND==1){
            if(Q.LIGA!=null){
                Q=Q.LIGA;
            }else {
                BAND=0;
            }
        }
        if(BAND==1){
            Node T=new Node();
            Dato = JOptionPane.showInputDialog("Dame el dato a ingresar");
            T.INFO=Dato;
            T.LIGA = Q.LIGA;
            Q.LIGA = T;
        }else{
            JOptionPane.showMessageDialog(null,"El nodo dado como referencia no se encuentra");
        }
    }
    public void elimina_inicio(){
            P = P.LIGA; // Avanza P al siguiente nodo
            if (P == null) {
                ListStarted = false;
        }
    }
    public void elimina_ultimo(){
        Node Q = new Node();
        Node T = new Node();
        Q = P;
        if (P.LIGA == null) {
            P = null; // Establece P en null, ya que la lista estará vacía
            ListStarted = false; // Actualiza ListStarted a false
        } else {
            while (Q.LIGA != null) {
                T = Q;
                Q = Q.LIGA;
            }
            T.LIGA = null;
        }
    }
    public void Elimina_X(){
        Node Q = new Node();
        Node T = new Node();
        Q=P;
        BAND=1;

        String x = JOptionPane.showInputDialog(null,"Dame una referencia del nodo a eliminar");
        while(!Q.INFO.equals(x) && BAND==1){
            if(Q.LIGA!=null){
                T=Q;
                Q=Q.LIGA;
            }else{
                BAND=0;
            }
        }
        if(BAND==0){
            JOptionPane.showMessageDialog(null,"El elemento con la referencia dada no se encuentra en la lista");
        }else {
            if(P==Q){
                P=Q.LIGA;
                if(Q.LIGA==null){
                    ListStarted=false;
                }
            }else{
                T.LIGA=Q.LIGA;
            }
        }
    }
    public void elimina_antesX() {
        Node Q = new Node();
        Node T = new Node();
        Node R = new Node();

        byte BAND;
        String X = JOptionPane.showInputDialog(null,"Dame una referencia del nodo a eliminar");

        if (P.INFO.equals(X)) {
            JOptionPane.showMessageDialog(null, "No existe un nodo que preceda al que contiene X");
        } else {
            Q = P;
            T = P;
            BAND = 1;
            while (!Q.INFO.equals(X) && BAND == 1) {
                if (Q.LIGA != null) {
                    R = T;
                    T = Q;
                    Q = Q.LIGA;
                } else {
                    BAND = 0;
                }
            }

            if (BAND == 0) {
                JOptionPane.showMessageDialog(null,"El elemento no se encuentra en la lista");
            } else {
                if (P.LIGA == Q) {
                    P = Q;
                } else {
                    R.LIGA = Q;
                }
            }
        }
    }
    public void busqueda_desordenada(){
        String X = JOptionPane.showInputDialog(null,"Dime el dato que quieres saber si está dentro de la lista");
        Node Q = new Node();
        Q=P;
        while(Q!=null && !Q.INFO.equals(X)){
            Q=Q.LIGA;
        }
        if(Q==null){

            JOptionPane.showMessageDialog(null, "El elemento no se encuentra dentro de la lista");
        }else{

            JOptionPane.showMessageDialog(null, "El elemento si se encuentra dentro de la lista");
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
        Lista re = new Lista();


        String DATO;

        int choice = 0;
        boolean salida=false;


        do {
            String choice2=JOptionPane.showInputDialog(null,"----- MENU LISTA -----\nElige una opcion\n1.- Crear Lista\n2.- Insertar al inicio\n3.- Insertar al final" +
                    "\n4.- Insertar antes de nodo dado\n5.- Insertar despues de nodo dado\n6.- Eliminar primer nodo\n7.- Eliminar ultimo nodo" +
                    "\n8.- Elimina un nodo anterior a X\n9.- Elimina un nodo con informacion X\n10.- Busqueda de un nodo\n11.- Mostrar lista\n12.- Salir");
            choice = Integer.parseInt(choice2);
            switch (choice) {
                case 1:
                    if(ListStarted){
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que ya se ha creado una lista");
                    }else {
                        re.Crea_Final();
                    }
                    break;
                case 2:
                    if(!ListStarted){
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else {
                        re.Inserta_Inicio();
                    }
                    break;
                case 3:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.Inserta_Final();
                    }
                    break;
                case 4:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.Inserta_Antes_X();
                    }
                    break;
                case 5:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.Inserta_Despues_X();
                    }
                    break;
                case 6:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.elimina_inicio();
                    }
                    break;
                case 7:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.elimina_ultimo();
                    }
                    break;
                case 8:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.elimina_antesX();
                    }
                    break;
                case 9:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.Elimina_X();
                    }
                    break;
                case 10:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.busqueda_desordenada();
                    }
                    break;
                case 11:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    } else {
                        re.Mostrar_lista();
                    }
                    break;
                case 12:
                    salida=re.Exit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción elegida no existe\nPor favor elige una opcion dentro del menú");
                    break;

            }
        } while (!salida);
    }
}