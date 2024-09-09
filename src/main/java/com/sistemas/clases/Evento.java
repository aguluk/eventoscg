package com.sistemas.clases;

import java.time.LocalDateTime;
import java.util.*;

public class Evento 
 {
    private UUID id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaHora;
    private int capacidad;
    private Chef chef;
    private Map<UUID,Participante> participantes =  new HashMap<>();
    private Map<UUID, Resenia> resenias;
   
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



    public String getDescripcion() {
      return descripcion;
    }



    public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
    }



    public LocalDateTime getFechaHora() {
      return fechaHora;
    }



    public void setFechaHora(LocalDateTime fechaHora) {
      this.fechaHora = fechaHora;
    }



    public int getCapacidad() {
      return capacidad;
    }



    public void setCapacidad(int capacidad) {
      this.capacidad = capacidad;
    }



    public Chef getChef() {
      return chef;
    }



    public void setChef(Chef chef) {
      this.chef = chef;
    }



    public Map<UUID, Participante> getParticipantes() {
      return participantes;
    }



    public void setParticipantes(Map<UUID, Participante> participantes) {
      this.participantes = participantes;
    }



    public Map<UUID, Resenia> getResenias() {
      return resenias;
    }



    public void setReseñas(Map<UUID, Resenia> resenias) {
      this.resenias = resenias;
    }

    public Evento(UUID id, String nombre, String descripcion, LocalDateTime fechaHora, int capacidad, Chef chef,
        Map<UUID, Participante> participantes, Map<UUID, Resenia> resenias) {
      this.id = id;
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.fechaHora = fechaHora;
      this.capacidad = capacidad;
      this.chef = chef;
      this.participantes = participantes;
      this.resenias = resenias;
    }

    public Evento() {};
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evento{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", capacidad=").append(capacidad);
        sb.append(", chef=").append(chef);
        sb.append(", participantes=").append(participantes);
        sb.append(", resenias=").append(resenias);
        sb.append('}');
        return sb.toString();
    }  



    
  


    
  
  }
