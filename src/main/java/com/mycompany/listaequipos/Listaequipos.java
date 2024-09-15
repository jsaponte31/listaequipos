package com.mycompany.listaequipos;

import java.util.Scanner;
import java.util.ArrayList;

public class Listaequipos {
    
    // Funcion para validar si la opcion ingresada es un numero
    public static boolean Esentero(String cadena) {
        int num;
        try {
            num = Integer.parseInt(cadena);
            return true;
        }catch (NumberFormatException e) {
            System.out.println("Por favor ingrese una opcion valida (numero)");
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String validador;// validador
        int opcion;
        Lista lista = new Lista();// lista vacia
        boolean opcionValida = false;
        
        do{
            System.out.println("MENU DE OPCIONES");
            System.out.println("1 Agregar un Nodo/Equipo a la LISTA ");
            System.out.println("2 Modificar un Nodo/Equipo de la LISTA ");
            System.out.println("3 Eliminar un Nodo/Equipo de la LISTA ");
            System.out.println("4 Consultar todos los Nodos/Equipos de la LISTA ");
            System.out.println("5 Buscar un Nodo/Equipo de la LISTA ");
            System.out.println("6 SALIR");
            do {
                System.out.print("Ingrese una opcion: ");
                validador = sc.nextLine();

                if (Esentero(validador)) {
                    opcion = Integer.parseInt(validador);
                    if (opcion >= 1 && opcion <= 6) { // Verifica si la opción ingresada está dentro del rango esperado
                        opcionValida = true; // Marca la opción como válida para salir del ciclo while
                    } else {
                        System.out.println("Por favor ingrese una opcion valida (entre 1 - 6).");
                    }
                }
            } while (!opcionValida);
            opcion = Integer.parseInt(validador);
            opcionValida = false;
            switch(opcion){
                case 1 -> { 
                    Equipo nuevoEquipo = lista.crearNodo();
                    lista.agregarNodo(nuevoEquipo);
                    System.out.println("\n**Equipo/Nodo agregado exitosamente** \n\n");
                }
                    
                case 2 -> {
                    System.out.println("Ingrese el codigo del Equipo/Nodo que quiere editar: ");
                    String codigoEditar = sc.nextLine();
                    int index = lista.consultarNodoEditar(codigoEditar);
                    if(index != -1 && index != -2){
                        Equipo equipoActualizar = lista.crearNodo();
                        lista.actualizarNodo(equipoActualizar,index);
                        System.out.println("\n**Equipo/Nodo actualizado exitosamente** \n\n");
                    }
                }
                    
                case 3 -> {
                    System.out.print("Ingrese el codigo del Equipo/Nodo que quiere eliminar\n");
                    String codigoEliminar = sc.nextLine();
                    lista.eliminarNodo(codigoEliminar);
                }
                    
                case 4 -> lista.Visualizar();
                    
                case 5 -> {
                    System.out.print("Ingrese el codigo del Equipo/Nodo que quiere buscar\n");
                    String codigoBuscar = sc.nextLine();
                    lista.buscarNodoVisualizar(codigoBuscar);
                }
                    
                case 6 -> System.out.println("Hasta luego!!");
                default -> System.out.println("Opcion invalida");
            }
        }while(opcion!=6);
    }
}
