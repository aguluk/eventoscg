package com.sistemas.service.Participante.Impl;

import com.sistemas.clases.Evento;
import com.sistemas.clases.Participante;
import com.sistemas.service.Organizador.OrganizadorService;
import com.sistemas.service.Participante.ParticipanteService;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

public class ParticipanteServiceImpl  implements ParticipanteService{
     
    private OrganizadorService organizadorService;
    
    public ParticipanteServiceImpl(OrganizadorService organizadorService) {
        this.organizadorService = organizadorService;
    }


    @Override
    public Participante registrarParticipante() {
        
        Participante participanteNuevo = new Participante();
        Scanner sc = new Scanner(System.in);

        participanteNuevo.setId( UUID.randomUUID() );

        System.out.println("Ingrese el nombre del Participante: ");
        String nombreParticipante = sc.nextLine();
        sc.nextLine();
        participanteNuevo.setNombre(nombreParticipante);

        System.out.println("ingrese el apellido del Participante");
        String apellidoParticipante = sc.nextLine();
        sc.nextLine();
        participanteNuevo.setApellido(apellidoParticipante);

        System.out.println("ingrese intereses culinarios");
        String nuevointereses = sc.nextLine();
        sc.nextLine();
        participanteNuevo.setInteres(nuevointereses);
        sc.close();
        return participanteNuevo;
      
    }
  

    @Override
    public void inscribirParticipanteAEvento(UUID idEvento, UUID idParticipante) {
        Participante participante = null;
        boolean existeParticipante = false;
        boolean eventoEncontrado = false;
        
        for (Evento evento : organizadorService.getEventos()) {
            if (evento.getParticipantes().containsKey(idParticipante)) {
                participante = evento.getParticipantes().get(idParticipante);
                existeParticipante = true;
                break;
            }
        }
    
        if (!existeParticipante) {
            throw new NoSuchElementException("No existe el participante");
        }
        
        for (Evento evento : organizadorService.getEventos()) {
            if (evento.getId().equals(idEvento)) {
        
                if (evento.getParticipantes().size() >= evento.getCapacidad()) {
                    throw new IllegalStateException("El evento ha alcanzado su capacidad maxima");
                }
                participante.getEventos().add(evento);
                evento.getParticipantes().put(participante.getId(), participante);
                eventoEncontrado = true;
                break;
            }
        }   
        
        if (!eventoEncontrado) {
            throw new NoSuchElementException("No existe el evento");
        } else {
            System.out.println("Estudiante asignado al evento");
        }
    }
    
       




        }








     
     








