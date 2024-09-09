package com.sistemas.service.Menu.Impl;


import java.util.Scanner;

import com.sistemas.service.Evento.EventoService;
import com.sistemas.service.Menu.MenuService;
import com.sistemas.service.Participante.ParticipanteService;
import com.sistemas.service.Resenia.ReseniaService;
import com.sistemas.service.Chef.ChefService;



public class MenuServiceImpl implements MenuService{

    private EventoService eventoService ;
    private ParticipanteService participanteService;
    private ChefService chefService;
    private ReseniaService reseniaService;

    public MenuServiceImpl(EventoService eventoService, ParticipanteService participanteService,
            ChefService chefService, ReseniaService reseniaService) {
        this.eventoService = eventoService;
        this.participanteService = participanteService;
        this.chefService = chefService;
        this.reseniaService = reseniaService;
    }

    @Override
    public void mostrarMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("Ingrese opcion : \n");
            System.out.println("1. Registrar chef ");
            System.out.println("2. Crear Evento");
            System.out.println("3. Registrar Participante");
            System.out.println("4. Dejar reseña");
            System.out.println("5. listar eventos");
            System.out.println("6. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                      chefService.registrarChef();
                      break;
                case 2:
                      eventoService.crearEvento();
                      break;
                case 3:
                      participanteService.registrarParticipante();  
                      break;  
                case 4:
                      reseniaService.dejarResenia(null, null);
                      break;
                case 5:
                      eventoService.listarEventos(null);
                      break;
                case 6:
                    System.out.println("\n Aplicacion finalizada");
                    break;

                default:
                    break;
            }

        }while (opcion != 6);
    }
}

    



