package com.sistemas.service.Evento.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;


import com.sistemas.clases.Evento;

import com.sistemas.service.Evento.EventoService;
import com.sistemas.service.Organizador.OrganizadorService;
import com.sistemas.service.Participante.ParticipanteService;

public class EventoServiceImpl implements EventoService {
    
   

    private OrganizadorService organizadorService;
    private ParticipanteService participanteService; 
   



    public EventoServiceImpl(OrganizadorService organizadorService, ParticipanteService participanteService) {
        this.organizadorService = organizadorService;
        this.participanteService = participanteService;
    }

    @Override

        public Evento crearEvento() {
    Scanner sc = new Scanner(System.in);
    Evento nuevoEvento = new Evento();

    nuevoEvento.setId(UUID.randomUUID());


    System.out.println("Ingrese el nombre del evento:");
    String nombre = sc.nextLine();
    nuevoEvento.setNombre(nombre);

    System.out.println("Ingrese la descripción del evento:");
    String descripcion = sc.nextLine();
    nuevoEvento.setDescripcion(descripcion);

    System.out.println("Ingrese la fecha y hora del evento (AAAA-MM-dd HH:mm):");
    String fechaHoraStr = sc.nextLine();
    LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    nuevoEvento.setFechaHora(fechaHora);

    System.out.println("Ingrese la capacidad del evento (máximo 50 personas):");
    int capacidad = sc.nextInt();
    
    int capacidadMaxima = 50;
    while (capacidad > capacidadMaxima) {
        System.out.println(" Ingrese un valor menor o igual a " + capacidadMaxima + ":");
        capacidad = sc.nextInt();
    }
    nuevoEvento.setCapacidad(capacidad);



    return nuevoEvento;
        
          
    }

    @Override
    public void inscribirParticipanteAlEvento(UUID idEvento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inscribirParticipanteAlEvento'");
    }

    
} 

        
    



