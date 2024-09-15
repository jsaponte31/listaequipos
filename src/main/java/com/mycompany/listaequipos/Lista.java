
package com.mycompany.listaequipos;

import static com.mycompany.listaequipos.Listaequipos.Esentero;
import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    private Nodo inicio;
    private int tamaño;
    
    public Lista() {
        inicio = null;
        tamaño = 0;
    }
    
    public int devolverTamaño(){
        return tamaño;
    }
    
    public boolean estaVacia() {
        if(inicio == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public Equipo crearNodo(){
        Scanner sc = new Scanner(System.in);
        String validador;
        int anio;
        int opcion2;
        boolean opcionValida2=false;
        boolean opcionValida3=false;
        System.out.println("Ingrese el codigo del equipo: ");
        String nuevoCodigo = sc.nextLine();
        System.out.println("Ingrese el nombre del equipo: ");
        String nuevoNombre = sc.nextLine();
        System.out.println("Ingrese la ciudad del equipo: ");
        String nuevaCiudad = sc.nextLine();
        ArrayList<Campeonato> listacampeonato = new ArrayList<>();
        do{
            System.out.println("1. Ingresar un campeonato al equipo. ");
            System.out.println("2. Terminar. ");
            do {
                System.out.print("Ingrese una opcion: ");
                validador = sc.nextLine();
                if (Esentero(validador)) {
                    opcion2 = Integer.parseInt(validador);
                    if (opcion2 >= 1 && opcion2 <= 2) { // Verifica si la opción ingresada está dentro del rango esperado
                        opcionValida2 = true; // Marca la opción como válida para salir del ciclo while
                    } else {
                        System.out.println("Por favor ingrese una opcion valida (entre 1 - 2).");
                    }
                }
            } while (!opcionValida2);
            opcion2 = Integer.parseInt(validador);
            opcionValida2 = false;
            switch(opcion2){
                case 1: 

                    do{
                        System.out.println("Ingrese el año del campeonato: ");
                        validador = sc.nextLine();
                        if(Esentero(validador)){
                            anio = Integer.parseInt(validador);
                            if (anio >= 1950 && anio <= 2023) { // Verifica el año
                                opcionValida3 = true; // Marca la opción como válida para salir del ciclo while
                            } else {
                                System.out.println("Por favor ingrese una año valido (entre 1950 - 2023).");
                            }
                        }
                    } while (!opcionValida3);
                    opcionValida3 = false;
                    int nuevoAño = Integer.parseInt(validador);
                    System.out.println("Ingrese el equipo visitante del campeonato: ");
                    String nuevoEquipoVisitante = sc.nextLine();
                    System.out.println("Ingrese el marcador del campeonato: ");
                    String nuevoMarcador = sc.nextLine();
                    Campeonato nuevoCampeonato = new Campeonato(nuevoAño,nuevoEquipoVisitante,nuevoMarcador);
                    listacampeonato.add(nuevoCampeonato);
                    break;
                case 2:
                    Equipo nuevoEquipo = new Equipo(nuevoCodigo,nuevoNombre,nuevaCiudad,listacampeonato);
                    return nuevoEquipo;
            }
        }while(opcion2 !=2);
        return null;
    }
    
    public void agregarNodo(Equipo nuevoEquipo) {
        Nodo nuevo = new Nodo(nuevoEquipo);
        if(estaVacia()){
            inicio = nuevo;
        } else {
            Nodo temporal = inicio;
            while(temporal.enlace != null ){
                temporal = temporal.enlace;
            }
            temporal.enlace = nuevo;
        }
        tamaño++;
    }
    
    public int consultarNodoEditar(String codigoEditar){
        int indiceID = buscarIndiceporCodigo(codigoEditar);
        if(estaVacia()){
            System.out.println("\n**La lista esta vacia no hay Equipos/Nodos para editar**\n ");
            return -2;
        }if(indiceID == -1){
            System.out.println("\n**El Equipo/Nodo ingresado no existe en la lista**\n ");
            return -1;
        }
        return indiceID;
    }
    
    public void actualizarNodo(Equipo equipoActualizar,int index){
        Nodo actual = inicio;
        int contador = 0;
        while (actual != null) {
            if (contador == index) {
                actual.nuevoEquipo = equipoActualizar;
                break;
            }
            actual = actual.enlace;
            contador++;
        }
    }
    
    public int buscarIndiceporCodigo(String codigo){
        Nodo temporal = inicio;
        int indice = 0;
        while(temporal != null){
            if(temporal.nuevoEquipo.getCodigo().equals(codigo)){
                return indice;
            }
            temporal = temporal.enlace;
            indice++;
        }
        return -1;
    }
    
    public void eliminarNodo(String codigoEliminar){
        int indiceID = buscarIndiceporCodigo(codigoEliminar);
        if(estaVacia()){
            System.out.println("\n**La lista esta vacia no hay Equipos/Nodos para eliminar**\n ");
            return;
        }if(indiceID == -1){
            System.out.println("\n**El Equipo/Nodo ingresado no existe en la lista**\n ");
            return;
        }if(inicio.nuevoEquipo.getCodigo().equals(codigoEliminar)){
            inicio = inicio.enlace;
            System.out.println("\n**Equipo/Nodo eliminado exitosamente**\n");
            tamaño--;
        }else{
            Nodo anterior = inicio;
            Nodo siguiente = inicio.enlace;
            while(siguiente != null){
                if(siguiente.nuevoEquipo.getCodigo().equals(codigoEliminar)){
                    anterior.enlace = siguiente.enlace;
                }
                anterior = siguiente;
                siguiente = siguiente.enlace;
            }
            System.out.println("\n**Equipo/Nodo eliminado exitosamente**\n");
            tamaño--;
        }
    }
    
    public void Visualizar() {
        if(estaVacia()){
            System.out.println("\n**La lista esta vacia no hay Equipos/Nodos para visualizar**\n");
            return;
        }
        Nodo temporal = inicio;
        int contador = 1;
        System.out.println("\n***Equipos de la lista***");
        while (temporal != null) {
            System.out.println(contador+"\n"+
                               "Codigo : "+temporal.nuevoEquipo.getCodigo()+"\n"+
                               "Nombre : "+temporal.nuevoEquipo.getNombre()+"\n"+
                               "Ciudad : "+temporal.nuevoEquipo.getCiudad()+"\n");
            
            String campeonatos = temporal.nuevoEquipo.getInfoCampeonatos();
            System.out.println(campeonatos);
            System.out.println("---------------------------------------");
            temporal = temporal.enlace;
            contador++;
        }
    }
    
    public void buscarNodoVisualizar(String codigoBuscarNodo){
        int indiceID = buscarIndiceporCodigo(codigoBuscarNodo);
        if(estaVacia()){
            System.out.println("\n**La lista esta vacia no hay Equipos/Nodos para eliminar**\n ");
            return;
        }if(indiceID == -1){
            System.out.println("\n**El Equipo/Nodo ingresado no existe en la lista**\n ");
            return;
        }
        Nodo temporal = inicio;
        while (temporal != null) {
            if(temporal.nuevoEquipo.getCodigo().equals(codigoBuscarNodo)){
                System.out.println("Equipo/nodo\n");
                System.out.println("Codigo : "+temporal.nuevoEquipo.getCodigo()+"\n"+
                                   "Nombre : "+temporal.nuevoEquipo.getNombre()+"\n"+
                                   "Ciudad : "+temporal.nuevoEquipo.getCiudad()+"\n");
                
                String campeonatos = temporal.nuevoEquipo.getInfoCampeonatos();
                System.out.println(campeonatos);
                System.out.println("---------------------------------------");
                return;
            }
            temporal = temporal.enlace;
        }
    }
}
