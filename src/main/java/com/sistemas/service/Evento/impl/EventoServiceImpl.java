package com.sistemas.service.Evento.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;
import com.sistemas.clases.Chef;
import com.sistemas.clases.Evento;
import com.sistemas.service.Chef.ChefService;
import com.sistemas.service.Evento.EventoService;
import com.sistemas.service.Organizador.OrganizadorService;

public class EventoServiceImpl implements EventoService {
    private ChefService chefService;
    private OrganizadorService organizadorService;

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

            System.out.println("Ingrese la capacidad del evento (maximo 50 personas):");
            int capacidad = sc.nextInt();
            int capacidadMaxima = 50;
            while (capacidad > capacidadMaxima) {
                System.out.println("Ingrese un valor menor o igual a " + capacidadMaxima + ":");
                capacidad = sc.nextInt();
            }
            nuevoEvento.setCapacidad(capacidad);

            sc.nextLine(); 

            System.out.println("Ingrese el ID del chef en formato UUID:");
            try {
                UUID idChef = UUID.fromString(sc.nextLine());

                Map<UUID, Chef> chefs = chefService.getChefs();

                if (chefs.containsKey(idChef)) {
                    Chef chef = chefs.get(idChef);
                    nuevoEvento.setChef(chef);
                    System.out.println("Chef agregado correctamente: ");
                } else {
                    System.out.println("Chef no encontrado con el ID proporcionado.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("El ID ingresado no tiene un formato UUID válido.");
            }

            return nuevoEvento;
        }
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
            System.out.println("Eventos disponibles a partir de la fecha " + fechaHora + ":");
            for (Evento evento : eventosDisponibles) {
                System.out.println(evento.toString()); 
            }
        }
    }
}
