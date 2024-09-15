package com.mycompany.listaequipos;

import java.util.ArrayList;

public class Equipo{
    private String codigo;
    private String nombre;
    private String ciudad;
    private Campeonato arraycampeonato[];
    
    public Equipo(String codigo, String nombre, String ciudad, ArrayList<Campeonato> arraycampeonato){
        this.ciudad=ciudad;
        this.codigo=codigo;
        this.nombre=nombre;
        this.arraycampeonato = arraycampeonato.toArray(new Campeonato[arraycampeonato.size()]);
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public String getInfoCampeonatos() {
        StringBuilder sb = new StringBuilder();
        if (arraycampeonato.length == 0) {
            sb.append( "El equipo no tiene campeonatos\n");
        } else {
            sb.append("Campeonatos del equipo " + this.nombre + ":\n");
            for (Campeonato c : this.arraycampeonato) {
                sb.append(c.getInfo() + "\n");
            }
        }
        return sb.toString();
    }
    
    
}