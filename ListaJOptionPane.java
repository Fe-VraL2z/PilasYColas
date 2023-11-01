/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lalito
 */
import javax.swing.JOptionPane;
import java.util.Scanner;
public class ListaJOptionPane {
    Scanner w=new Scanner(System.in);
    Nodo P=new Nodo();
    Nodo Q;
    Nodo T;
    Nodo R;
    static boolean lis=false;
    static class Nodo{
        String INFO;
        Nodo LIGA;
    }
    //Algoritmo 5.1 
    public void CrearLista(){
        lis=true;
        P.INFO=JOptionPane.showInputDialog("Escribe el nombre(INFO)");
        P.LIGA=null;
    }
    //Algoritmo 5.5
    public void InsertaInicio(){
        int RES;
        do{
            Nodo Q=new Nodo();
            Q.INFO=JOptionPane.showInputDialog("Introduce el nombre(INFO)");
            Q.LIGA=P;
            P=Q;
            RES=Integer.parseInt(JOptionPane.showInputDialog("Deseas agregar mas nodos a la lista? 1.Si  2.No"));
        }while(RES==1);
    }
        //Algoritmo 5.3
    public void ImprimirLista(){
        String mostrar="";
        Nodo Q=P;
        while(Q!=null){
            mostrar=mostrar+Q.INFO;
            mostrar+="\n";
            Q=Q.LIGA;
        }
        JOptionPane.showMessageDialog(null,mostrar);
    }
    //Algoritmo 5.6 Inserta Final
    public void InsertaFinal(){
        T=P;
        while(T.LIGA!=null){
            T=T.LIGA;
        }
        int RES;
        do{
        Nodo Q=new Nodo();
        Q.INFO=JOptionPane.showInputDialog("Dame el nombre(INFO)");
        Q.LIGA=null;
        T.LIGA=Q;
        T=Q; //Agregue esta linea de codigo
        RES=Integer.parseInt(JOptionPane.showInputDialog("Deseas agregar mas nodos a la lista? 1.Si  2.No"));
        }while(RES==1); 
    
    }
    //Algoritmo 5.7
    public void InsertaAntesDeX(){
        Q=P;
        T=P;//Agregue
        String X;
        X=JOptionPane.showInputDialog("Dame el nombre del contenido para insertar un nodo antes de nombre dado");
        byte BAND=1;
        while((!Q.INFO.equals(X)) && (BAND==1)){
            if (Q.LIGA!=null) {
                T=Q;
                Q=Q.LIGA;
            }else
            BAND=0;
        } 
        if (BAND==1) {
            Nodo Z=new Nodo();
            Z.INFO=JOptionPane.showInputDialog("Dame el nombre(INFO)");
            if (P==Q) {
                Z.LIGA=P;
                P=Z;
            }else
                T.LIGA=Z;
                Z.LIGA=Q;
        }else
            JOptionPane.showMessageDialog(null,"El nodo dado como referencia no se encuentra en la lista");
    }
    //Algoritmo 5.8
    public void InsertaDespuesDeX(){  
        Q=P;
        byte BAND=1;
        String X;
        X=JOptionPane.showInputDialog("Dame el nombre del contenido para insertar un nodo despues del nombre dado");
        while((!Q.INFO.equals(X))&&(BAND==1)){
            if (Q.LIGA!=null) {
                Q=Q.LIGA;
            }else
                BAND=0;
        }
        if (BAND==1) {
            Nodo T=new Nodo();
            T.INFO=JOptionPane.showInputDialog("Dame el nombre(INFO)");
            T.LIGA=Q.LIGA;
            Q.LIGA=T;
        }else
            JOptionPane.showMessageDialog(null,"El nodo dado como referencia no se encuentra en la lista");  
    }
    
    //Algoritmo 5.9
    public void EliminaInicio(){  
        Q=P;
        if(Q.LIGA==null){//Si la lista estuviera un solo elemento entonces a P se le asignaria NULL
            Q=null;      //
            lis=false;    //
        }else 
        P=Q.LIGA;
        JOptionPane.showMessageDialog(null,"Se ha eliminado el elemento: "+Q.INFO);
        Q=null;
    }
    //Algoritmo 5.10
    public void EliminaUltimo(){
        Q=P;
        if (Q.LIGA==null) {
            Q=null;
            lis=false; //En caso que solo haya un elemento y asi nos permita crear las lista P
        }else{
            while(Q.LIGA!=null){
                T=Q;
                Q=Q.LIGA;
            }
            JOptionPane.showMessageDialog(null,"Se ha eliminado el elemento: "+Q.INFO);
            T.LIGA=null;
        }
        Q=null;
    }
    //Algoritmo 5.11
    public void EliminaX(){
        Q=P;
        byte BAND=1;
        String X;
        X=JOptionPane.showInputDialog("Dame el nombre para quitarlo de la lista");
        while((!Q.INFO.equals(X))&&(BAND==1)){
            if (Q.LIGA!=null) {
                T=Q;
                Q=Q.LIGA;
            }else{
                BAND=0;
            }
        }
        if (BAND==0) {
            JOptionPane.showMessageDialog(null,"El elemento con la informacion X no se encuentra la lista");
        }else{
            if (P==Q) {
                if (Q.LIGA==null) { //Si es que el elemento a eliminar es solo un nodo
                    Q=null;   //Cuando solo hay un elemennto en la lista
                    lis=false; //Para poder crear una lista porque hay solo un elemento
                }else
                P=Q.LIGA;
            }else{
                T.LIGA=Q.LIGA;
            }
            JOptionPane.showMessageDialog(null,"Se ha eliminado el elemento: "+Q.INFO);
            Q=null;
        }
 
    }
    //Algoritmo 5.12
    public void EliminaAntesX(){    
        byte BAND;
        String X;
        X=JOptionPane.showInputDialog("Para eliminar un nodo antes de X, deme el nombre del contenido para hacer la eliminacion");
        if (P.INFO.equals(X)) {
            System.out.println("No existe un nodo que proceda al que contiene a X");
        }else{
            Q=P;
            T=P;
            BAND=1;
            while((!Q.INFO.equals(X))&&(BAND==1)){
                if (Q.LIGA!=null) {
                    R=T;
                    T=Q;
                    Q=Q.LIGA;
                }else{
                    BAND=0;
                }
        }
            
            if (BAND==0) {
                JOptionPane.showMessageDialog(null,"El elemento no se encuentra en la lista");
            }else{
                if (P.LIGA==Q) {
                    P=Q;
                }else{
                    R.LIGA=Q;
                }
                JOptionPane.showMessageDialog(null,"Se ha eliminado el elemento:"+T.INFO);
                T=null;
            }
        }
    }
    public void BusquedaDesordenada(){
        Q=P;
        String X;
        X=JOptionPane.showInputDialog("Dame el elemento a encontrar:");
        while((Q!=null)&&(!Q.INFO.equals(X))){
            Q=Q.LIGA;
        }
        if (Q==null) {
            JOptionPane.showMessageDialog(null,"El elemento no se encuetra en la lista");
        }else
            JOptionPane.showMessageDialog(null,"El elememnto si se encuentra en la lista");
    }
    public static void main(String[] args) {
        Scanner w=new Scanner(System.in);
        ListaJOptionPane sc=new ListaJOptionPane();
        String menu="\n------MENU------"
                + "\nQue desea hacer?"
                + "\n1) Crear lista"
                + "\n2) Inserta inicio"
                + "\n3) Imprimir lista"
                + "\n4) Inserta final"
                + "\n5) Inserta antes de X"
                + "\n6) Inserta despues de X"
                + "\n7) Eliminar inicio"
                + "\n8) Eliminar ultimo"
                + "\n9) Elimina X"
                + "\n10) Elimina antes de X"
                + "\n11) Busque desordenada"
                + "\n12) Salir\n";
        int opc;
        do {
            opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opc){
        case 1:
            if (lis==true) {
                JOptionPane.showMessageDialog(null,"Lista ya creada");
            }else
            sc.CrearLista();
            break;
        case 2:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.InsertaInicio();
            break;
        case 3:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.ImprimirLista();
            break;
        case 4:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.InsertaFinal();
            break;
        case 5:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.InsertaAntesDeX();
            break;
        case 6:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.InsertaDespuesDeX();
            break;
        case 7:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.EliminaInicio();
            break;
        case 8:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.EliminaUltimo();
            break;
        case 9:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.EliminaX();
            break;
        case 10:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.EliminaAntesX();
            break;
        case 11:
            if (lis==false) {
                JOptionPane.showMessageDialog(null,"No se puede realizar, no se ha creado una lista"); 
            }else
            sc.BusquedaDesordenada();
            break;
        case 12:
            break;   
        default:
            JOptionPane.showMessageDialog(null,"Opcion invalida. Escoga una de las opciones que hay en el menu");
            }
        }while(opc!=12);
    }
}
