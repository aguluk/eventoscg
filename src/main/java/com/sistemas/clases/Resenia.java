package com.sistemas.clases;


import java.util.UUID;

import com.sistemas.enumeration.CalificacionEnum;

public class Resenia {
    private UUID id;
    private String descripcion;
    private Evento evento;
    private Participante participante;
    private CalificacionEnum calificacion;
    
    
    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Evento getEvento() {
        return evento;
    }


    public void setEvento(Evento evento) {
        this.evento = evento;
    }


    public Participante getParticipante() {
        return participante;
    }


    public void setParticipante(Participante participante) {
        this.participante = participante;
    }


    public CalificacionEnum getCalificacion() {
        return calificacion;
    }


    public void setCalificacion(CalificacionEnum calificacion) {
        this.calificacion = calificacion;
    }

      

    public Resenia(UUID id, String descripcion, Evento evento, Participante participante,
            CalificacionEnum calificacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.evento = evento;
        this.participante = participante;
        this.calificacion = calificacion;
    }
   

    @Override
    public String toString() {
        return "Resenia{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", evento=" + evento +
                ", participante=" + participante +
                ", calificacion=" + calificacion + '}';
    }



}