package com.sistemas.clases;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Evento  
 {
    private UUID id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaHora;
    private int capacidad;
    private Chef chef;
    private Map<Long,Participante> participantes = new TreeMap();
    private List<Resenia> resenias = new ArrayList<>();
   
    

    public Evento(UUID id, String nombre, String descripcion, LocalDateTime fechaHora, int capacidad, Chef chef,
        Map<Long, Participante> participantes, List<Resenia> resenias) {
      this.id = id;
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.fechaHora = fechaHora;
      this.capacidad = capacidad;
      this.chef = chef;
      this.participantes = participantes;
      this.resenias = resenias;
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


    public Map<Long, Participante> getParticipantes() {
      return participantes;
    }


    public void setParticipantes(Map<Long, Participante> participantes) {
      this.participantes = participantes;
    }


    public List<Resenia> getResenias() {
      return resenias;
    }


    public void setResenias(List<Resenia> resenias) {
      this.resenias = resenias;
    }


    public Evento() {};
     

    @Override
    public String toString() {
      return "Evento [id=" + id + 
             ", nombre=" + nombre + 
             ", descripcion=" + descripcion + 
             ", fechaHora=" + fechaHora +
             ", capacidad=" + capacidad + 
             ", chef=" + chef + 
             ", participantes=" + participantes.size() +
             ", reseñas=" + resenias.size() + "]";
    }
  
  }
