/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDoble;
import java.util.Scanner;

/**
 *
 * @author Lalito
 */
public class ListaD {
    static class Nodo{
        String INFO;
        Nodo LIGAIZQ;
        Nodo LIGADER;
    }
    Scanner w=new Scanner(System.in);
    Nodo P=new Nodo();
    Nodo Q;
    Nodo F;
    Nodo T;
    Nodo R;
    static boolean ListStarted=false;
    ListaD(){
        P.LIGAIZQ=null;
        P.LIGADER=null;
    }
    public void CrearLista(){
        ListStarted=true;
        System.out.println("Dame el apellido");
        P.INFO=w.next();
        Q=P.LIGAIZQ;
        F=P;
    }
    //Algoritmo 5.16
    public void InsertarPrincipio(){
        int RES=0;
        do{
            Nodo Q=new Nodo();
            System.out.println("Dame el apellido");
            Q.INFO=w.next();
            Q.LIGADER=P;
            P.LIGAIZQ=Q;
            Q.LIGAIZQ=null;
            P=Q;
            System.out.println("Deseas agregar mas nodos?\n1)Si\n2)No");
            RES=w.nextInt();
        }while(RES==1);
    }
    //Algoritmo 5.17
    public void InsertaFinal(){
        int RES=0;
        do{
            Nodo Q=new Nodo();
            System.out.println("Dame el apellido");
            Q.INFO=w.next();
            F.LIGADER=Q;
            Q.LIGAIZQ=F;
            Q.LIGADER=null;
            F=Q;
            System.out.println("Desea agregar mas nodos?\n1)Si\n2)No");
            RES=w.nextInt();
        }while(RES==1);
    }
    //Algoritmo 5.18
    public void InsertaAntesDeX() {
        Q = P;
        System.out.println("Dame el elemento X para poder insertar un nodo:");
        String X = w.next();
        while ((Q.LIGADER != null) && (!Q.INFO.equals(X))) {
            Q = Q.LIGADER;
        }
        if (Q.INFO.equals(X)) {
            Nodo T = new Nodo();
            System.out.println("Dame el apellido");
            T.INFO = w.next();
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
        } else
            System.out.println("El elemento no se encuentra en la lista");
    }
    public void InsertaDespuesDeX(){
        Q = P;
        System.out.println("Dame el elemento X para poder insertar un nodo después:");
        String X = w.next();
        while ((Q.LIGADER != null) && (!Q.INFO.equals(X))) {
            Q = Q.LIGADER;
        }
        if (Q.INFO.equals(X)) {
            Nodo T = new Nodo();
            System.out.println("Dame el apellido");
            T.INFO = w.next();

            T.LIGADER = Q.LIGADER;  // Conectar el nuevo nodo al siguiente nodo
            Q.LIGADER = T;          // Conectar el nodo actual al nuevo nodo

        } else {
            System.out.println("El elemento no se encuentra en la lista");
        }
    }



    public void EliminaInicio(){
        Q=P;
        if (Q.LIGADER!=null) {
            P=Q.LIGADER;
            P.LIGAIZQ=null;
        }else{
            P=null;
            F=null;
            ListStarted=false;
        }
        System.out.println("Se elimino: "+Q.INFO);
        Q=null;
    }

    //Algoritmo 5.22
    public void EliminaAntesDeX(){
        Q=P;
        System.out.println("Dame el elemento X para poder eliminar el nodo que esta antes de el:");
        String X=w.next();
        while((Q.LIGADER!=null)&&(!Q.INFO.equals(X))){
            Q=Q.LIGADER;
        }
        if (Q.INFO.equals(X)) {
            if (P==Q) {
                System.out.println("No existe nodo anterior al primero");
            }else{
                T=Q.LIGAIZQ;
                if (P==T) {
                    P=Q;
                    P.LIGAIZQ=null;
                }else{
                    R=T.LIGAIZQ;
                    Q.LIGAIZQ=R;
                    R.LIGADER=Q;
                }
                System.out.println("Se elimino: "+T.INFO);
                T=null;
            }
        }else
            System.out.println("El elemento con la informacion X no se encuentra en la lista");//1er if
    }
    //Algoritmo 5.20
    public void EliminaUltimo(){
        Q=F;
        if (Q.LIGAIZQ!=null) { //Verifica si la lista solo tiene un nodo
            F=Q.LIGAIZQ;
            F.LIGADER=null;
        }else{
            F=null;
            //P=null;
            ListStarted=false;
        }
        System.out.println("Se elimino: "+Q.INFO);
        Q=null;
    }
    //Algoritmo 5.21
    public void EliminaX(){
        Q=P;
        System.out.println("Dame el elemento X a eliminar:");
        String X=w.next();
        while((Q.LIGADER!=null)&&(!Q.INFO.equals(X))){
            Q=Q.LIGADER;
        }
        if (Q.INFO.equals(X)) {
            if ((Q==P)&&(Q==F)) {
                //P=null;
                F=null;
                ListStarted=false;
            }else{          //Segundo IF
                if (Q==P) {
                    P=Q.LIGADER;
                    P.LIGAIZQ=null;
                }else{    //Tercer if
                    if (Q==F) {        //Cuarto if
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
            System.out.println("Se elimino: "+Q.INFO);
            Q=null;
        }else
            System.out.println("El elemento con la informacion X no se encuentra la lista");
    }
    public void BusquedaDeUnNodo(){
        Q=P;
        System.out.println("Dame el elemento a encontrar:");
        String X=w.next();
        while((Q!=null)&&(!Q.INFO.equals(X))){
            Q=Q.LIGADER;
        }
        if (Q==null) {
            System.out.println("El elemento no se encuetra en la lista");
        }else
            System.out.println("El elememnto si se encuentra en la lista");
    }
    public void EnlistarDePrincipioFin(){
        Q=P;
        while(Q!=null){
            System.out.println(Q.INFO);
            Q=Q.LIGADER;
        }
    }
    public void EnlistarDeFinPrincipio(){
        Q=F ;
        while(Q!=null){
            System.out.println(Q.INFO);
            Q=Q.LIGAIZQ;
        }
    }
    public static void main(String[] args) {
        Scanner w=new Scanner(System.in);
        ListaD sc=new ListaD();
        byte opc;
        do {
            System.out.println("\n--------------MENU--------------"
                    + "\nCREAR LISTA"
                    + "\n1) Crear lista"
                    + "\nINSERTA NODO"
                    + "\n2) Inserta principio"
                    + "\n3) Inserta final"
                    + "\n4) Inserta antes de X"
                    + "\n5) Inserta despues de X"
                    + "\nELIMINAR NODO"
                    + "\n6) Elimina inicio"
                    + "\n7) Eliminar ultimo"
                    + "\n8) Elimina antes X"
                    + "\n9) Eliminar X"
                    + "\nBUSQUEDA"
                    + "\n10)Busqueda de un nodo"
                    + "\nIMPRIMIR LISTA"
                    + "\n11)Enlistar de principio a fin"
                    + "\n12)Enlistar de fin a principio"
                    + "\n13) Salir\n"
                    + "¿Que deseas hacer?");
            opc=w.nextByte();
            switch(opc){
                case 1:
                    if (ListStarted) {
                        System.out.println("La lista ya fue creada");
                    }else
                        sc.CrearLista();
                    break;
                case 2:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar la accion debido a que no se ha creado una lista");
                    }else
                        sc.InsertarPrincipio();
                    break;
                case 3:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.InsertaFinal();
                    break;
                case 4:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.InsertaAntesDeX();
                    break;
                case 5:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.InsertaDespuesDeX();
                    break;
                case 6:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.EliminaInicio();
                    break;
                case 7:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.EliminaUltimo();
                    break;
                case 8:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.EliminaAntesDeX();
                    break;
                case 9:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.EliminaX();
                    break;
                case 10:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.BusquedaDeUnNodo();
                    break;
                case 11:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.EnlistarDePrincipioFin();
                    break;
                case 12:
                    if (!ListStarted) {
                        System.out.println("No se puede realizar, no se ha creado una lista");
                    }else
                        sc.EnlistarDeFinPrincipio();
                    break;
                case 13:
                    break;
                default:
                    System.out.println("Opcion invalida. Escoga una de las opciones que hay en el menu");
            }
        } while (opc!=13 );
    }
}
