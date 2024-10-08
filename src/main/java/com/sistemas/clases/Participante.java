package com.sistemas.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Participante {
    private UUID id;
    private String nombre;
    private String apellido;
    private String interes;
    private List<Evento> eventos = new ArrayList<>();
    private Resenia resenia;
    
   
   
    public Resenia getResenia() {
        return resenia;
    }


    public void setResenia(Resenia resenia) {
        this.resenia = resenia;
    }


    public List<Evento> getEvento() {
        return eventos;
    }


    public void setEvento(List<Evento> eventos) {
        this.eventos = eventos;
    }


    public String getInteres() {
        return interes;
    }


    public void setInteres(String interes) {
        this.interes = interes;
    }


    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    

    public List<Evento> getEventos() {
        return eventos;
    }


    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Participante{");
      sb.append("id=").append(id);
      sb.append(", nombre='").append(nombre).append('\'');
      sb.append(", apellido='").append(apellido).append('\'');
      sb.append(", interes='").append(interes).append('\'');
      sb.append(", eventos=").append(eventos);
      sb.append(", resenia=").append(resenia);
      sb.append('}');
      return sb.toString();
    }


  


    


}
  



