/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDoble;

/**
 *
 * @author Lalito
 */

import javax.swing.*;


public class ListaDoble {
    String Mos = "";
    static class Nodo{
        String INFO;
        Nodo LIGAIZQ;
        Nodo LIGADER;
    }
    Nodo P=new Nodo();
    Nodo Q;
    Nodo F;
    Nodo T;
    Nodo R;
    static boolean ListStarted=false;
    ListaDoble(){
        P.LIGAIZQ=null;
        P.LIGADER=null;
    }
    public void CrearLista(){
        ListStarted=true;

        P.INFO= JOptionPane.showInputDialog(null,"Dame el dato");
        Q=P.LIGAIZQ;
        F=P;
    }
    public void InsertarPrincipio(){
        int RES=0;
        do{
            Nodo Q=new Nodo();

            Q.INFO=JOptionPane.showInputDialog(null, "Dame el datos");
            Q.LIGADER=P;
            P.LIGAIZQ=Q;
            Q.LIGAIZQ=null;
            P=Q;

            String RES1=JOptionPane.showInputDialog(null,"Deseas agregar mas nodos?\n1)Si\n2)No");
            RES=Integer.parseInt(RES1);
        }while(RES==1);
    }
    //Algoritmo 5.17
    public void InsertaFinal(){
        int RES=0;
        do{
            Nodo Q=new Nodo();
            Q.INFO=JOptionPane.showInputDialog("Dame el dato");
            F.LIGADER=Q;
            Q.LIGAIZQ=F;
            Q.LIGADER=null;
            F=Q;
            String RES1=JOptionPane.showInputDialog(null,"Deseas agregar mas nodos?\n1)Si\n2)No");
            RES=Integer.parseInt(RES1);
        }while(RES==1);
    }
    //Algoritmo 5.18
    public void InsertaAntesDeX() {
        Q = P;
        String X = JOptionPane.showInputDialog(null,"Dame el elemento de X para poder insertar un nodo antes");
        while ((Q.LIGADER != null) && (!Q.INFO.equals(X))) {
            Q = Q.LIGADER;
        }
        if (Q.INFO.equals(X)) {
            Nodo T = new Nodo();
            T.INFO = JOptionPane.showInputDialog(null,"Dame la informacion");
            T.LIGADER = Q;
            R = Q.LIGAIZQ;
            Q.LIGAIZQ = T;
            if (P == Q) {
                P = T;
                T.LIGAIZQ = null;
            } else {
                R.LIGADER = T;
                T.LIGAIZQ = R;
            }
        } else {
            JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la lista");
        }
    }
    public void InsertaDespuesDeX() {
        Q = P;
        String X = JOptionPane.showInputDialog(null,"Dame el elemento X para poder insertar un nodo después");
        while ((Q.LIGADER != null) && (!Q.INFO.equals(X))) {
            Q = Q.LIGADER;
        }
        if (Q.INFO.equals(X)) {
            Nodo T = new Nodo();
            T.INFO = JOptionPane.showInputDialog(null,"Dame el apellido");

            T.LIGADER = Q.LIGADER;  // Conectar el nuevo nodo al siguiente nodo
            Q.LIGADER = T;          // Conectar el nodo actual al nuevo nodo

        } else {
            JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la lista");
        }
    }
    //Algoritmo 5.19
    public void EliminaInicio(){
        Q=P;
        if (Q.LIGADER!=null) { //Verifica si la lista tiene un solo elemento
            P=Q.LIGADER;
            P.LIGAIZQ=null;
        }else{
            P=null;
            F=null;
            ListStarted=false;
        }
        JOptionPane.showMessageDialog(null,"Se elimino: "+Q.INFO);
        Q=null;
    }

    //Algoritmo 5.22
    public void EliminaAntesDeX(){
        Q=P;
        String X=JOptionPane.showInputDialog(null,"Dame el elemento X para poder eliminar el nodo que esta antes de el");
        while((Q.LIGADER!=null)&&(!Q.INFO.equals(X))){
            Q=Q.LIGADER;
        }
        if (Q.INFO.equals(X)) {
            if (P==Q) {
                JOptionPane.showMessageDialog(null,"No existe nodo anterior al primero");
            }else{  //2if
                T=Q.LIGAIZQ;
                if (P==T) {  //Es el primer nodo de la lista
                    P=Q;
                    P.LIGAIZQ=null;
                }else{            //3er if
                    R=T.LIGAIZQ;
                    Q.LIGAIZQ=R;
                    R.LIGADER=Q;
                }
                JOptionPane.showMessageDialog(null,"Se elimino"+T.INFO);
                T=null;
            }
        }else
        JOptionPane.showMessageDialog(null,"El elemento con la informacion X no se encuentra en la lista");
    }
    public void EliminaUltimo(){
        Q=F;
        if (Q.LIGAIZQ!=null) {
            F=Q.LIGAIZQ;
            F.LIGADER=null;
        }else{
            F=null;
            P=null;
            ListStarted=false;
        }
        JOptionPane.showMessageDialog(null,"Se elimino: " + Q.INFO);
        Q=null;
    }
    public void EliminaX(){
        Q=P;
        String X=JOptionPane.showInputDialog(null,"Dame el elemento X a eliminar");
        while((Q.LIGADER!=null)&&(!Q.INFO.equals(X))){
            Q=Q.LIGADER;
        }
        if (Q.INFO.equals(X)) {
            if ((Q==P)&&(Q==F)) {
                P=null;
                F=null;
                ListStarted=false;
            }else{
                if (Q==P) {
                    P=Q.LIGADER;
                    P.LIGAIZQ=null;
                }else{
                    if (Q==F) {
                        F=Q.LIGAIZQ;
                        F.LIGADER=null;
                    }else{
                        T=Q.LIGAIZQ;
                        R=Q.LIGADER;
                        T.LIGADER=R;
                        R.LIGAIZQ=T;
                    }
                }
            }
            JOptionPane.showMessageDialog(null,"Se elimino: "+Q.INFO);
            Q=null;
        }else
        JOptionPane.showMessageDialog(null,"El elemento con la informacion X no se encuentra la lista");
    }
    public void BusquedaDeUnNodo(){
        Q=P;
        String X=JOptionPane.showInputDialog(null,"Dame el elemento a encontrar");
        while((Q!=null)&&(!Q.INFO.equals(X))){
            Q=Q.LIGADER;
        }
        if (Q==null) {
            JOptionPane.showMessageDialog(null,"El elemento no se encuetra en la lista");
        }else
            JOptionPane.showMessageDialog(null,"El elememnto si se encuentra en la lista");

    }
    public void EnlistarDePrincipioFin(){
        Q=P;
        String Mos="";
        while(Q!=null){
            Mos = Mos+Q.INFO+"<->";
            Q=Q.LIGADER;
        }
        JOptionPane.showMessageDialog(null,Mos);
    }

    public void EnlistarDeFinPrincipio(){
        String Mos="";
        Q=F ;
        while(Q!=null){
            Mos = Mos+Q.INFO+"<->";
            Q=Q.LIGAIZQ;
        }
        JOptionPane.showMessageDialog(null,Mos);
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
        boolean salida=false;
        ListaDoble sc=new ListaDoble();
        int opc;
        do {
            String choice2=JOptionPane.showInputDialog(null,"--------------MENU--------------" +
                            "\nCREAR LISTA" +
                            "\n1) Crear lista" +
                            "\nINSERTA NODO" +
                            "\n2) Inserta principio" +
                            "\n3) Inserta final" +
                            "\n4) Inserta antes de X" +
                            "\n5) Inserta despues de X" +
                            "\nELIMINAR NODO" +
                            "\n6) Elimina inicio" +
                            "\n7) Eliminar ultimo" +
                            "\n8) Elimina antes X" +
                            "\n9) Eliminar X" +
                            "\nBUSQUEDA" +
                            "\n10)Busqueda de un nodo" +
                            "\nIMPRIMIR LISTA" +
                            "\n11)Enlistar de principio a fin" +
                            "\n12)Enlistar de fin a principio" +
                            "\n13) Salir");

            opc=Integer.parseInt(choice2);
            switch(opc){
                case 1:
                    if (ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que ya se ha creado una lista");
                    }else
                        sc.CrearLista();
                    break;
                case 2:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.InsertarPrincipio();
                    break;
                case 3:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.InsertaFinal();
                    break;
                case 4:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.InsertaAntesDeX();
                    break;
                case 5:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.InsertaDespuesDeX();
                    break;
                case 6:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.EliminaInicio();
                    break;
                case 7:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.EliminaUltimo();
                    break;
                case 8:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.EliminaAntesDeX();
                    break;
                case 9:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.EliminaX();
                    break;
                case 10:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.BusquedaDeUnNodo();
                    break;
                case 11:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.EnlistarDePrincipioFin();
                    break;
                case 12:
                    if (!ListStarted) {
                        JOptionPane.showMessageDialog(null,"No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.EnlistarDeFinPrincipio();
                    break;
                case 13:
                    salida=sc.Exit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción elegida no existe\nPor favor elige una opcion dentro del menú");
            }
        } while (!salida);
    }
}