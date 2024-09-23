package com.sistemas.service.Evento.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import com.sistemas.clases.Chef;
import com.sistemas.clases.Evento;
import com.sistemas.service.Chef.ChefService;
import com.sistemas.service.Evento.EventoService;
import com.sistemas.service.Organizador.OrganizadorService;

public class EventoServiceImpl implements EventoService {
    private ChefService chefService;
    private OrganizadorService organizadorService;
    private List<Evento> eventos = new ArrayList<>(); 

    public EventoServiceImpl(ChefService chefService, OrganizadorService organizadorService) {
        this.chefService = chefService;
        this.organizadorService = organizadorService;
    }

    @Override
    public Evento crearEvento() {
        try (Scanner sc = new Scanner(System.in)) {
            Evento nuevoEvento = new Evento();
            nuevoEvento.setId(UUID.randomUUID());

            System.out.println("Ingrese el nombre del evento:");
            String nombre = sc.nextLine();
            nuevoEvento.setNombre(nombre);

            System.out.println("Ingrese la descripcion del evento:");
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
                System.out.println("Ingrese un valor menor o igual a " + capacidadMaxima + ":");
                capacidad = sc.nextInt();
            }
            nuevoEvento.setCapacidad(capacidad);

            sc.nextLine(); 

         
            Chef chef = chefService.buscarChefByID();
            if (chef != null) {
                nuevoEvento.setChef(chef); 
                System.out.println("Chef asignado: " + chef.getNombre());
            } else {
                System.out.println("No se pudo asignar el chef al evento.");
            }

            eventos.add(nuevoEvento); 
            System.out.println("Evento creado exitosamente.");
            return nuevoEvento;
        }
    }

   
    public List<Evento> getEventos() {
        return eventos;
    }
    
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public void listarEventos(LocalDateTime fechaHora) {
        List<Evento> eventos = organizadorService.getEventos();

        List<Evento> eventosDisponibles = eventos.stream()
            .filter(evento -> evento.getFechaHora().isAfter(fechaHora))
            .collect(Collectors.toList());

        if (eventosDisponibles.isEmpty()) {
            System.out.println("No hay eventos disponibles.");
        } else {
            System.out.println("Eventos disponibles  " + fechaHora + ":");
            for (Evento evento : eventosDisponibles) {
                System.out.println(evento.toString()); 
            }
        }
    }

    
    

        
    
}
