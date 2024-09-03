package com.sistemas.service.Menu.Impl;


import java.util.Scanner;
import java.util.UUID;
import com.sistemas.clases.Evento;
import com.sistemas.service.Evento.EventoService;
import com.sistemas.service.Menu.MenuService;
import com.sistemas.service.Participante.ParticipanteService;

public class MenuServiceImpl implements MenuService{

    private EventoService eventoService ;
    private ParticipanteService participanteService;

    
   
    public MenuServiceImpl(EventoService eventoService, ParticipanteService participanteService) {
        this.eventoService = eventoService;
        this.participanteService = participanteService;
    }



    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Crear Evento");
            System.out.println("2. Registrar Participante");
            System.out.println("3. inscribir  al  Participante al evento");


          


            System.out.println("3. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                     eventoService.crearEvento();
                    break;
                case 2:
                     participanteService.registrarParticipante();

                case 3:
                   
                   
                        
                case 4:
                    System.out.println("\n Aplicacion finalizada");
                    break;
                default:
                    break;
            }

        }while (opcion != 4);
    }
}

    



