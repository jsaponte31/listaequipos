
package com.mycompany.listaequipos;

public class Campeonato {
    private int año;
    private String equipoVisitante;
    private String marcador;
    
    public Campeonato(int año, String equipoVisitante,String marcador){
        this.año = año;
        this.equipoVisitante = equipoVisitante;
        this.marcador = marcador;
    }
    
    public int getAño(){
        return año;
    }
    
    public String getequipoVisitante(){
        return equipoVisitante;
    }
    
    public String getmarcador(){
        return marcador;
    }
    
    public String getInfo() {
        return "Año: " + this.año + ", Equipo visitante: " + this.equipoVisitante + ", Marcador: " + this.marcador;
    }
}
