package com.sistemas.service.Menu.Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.UUID;
import java.util.InputMismatchException;



import com.sistemas.service.Evento.EventoService;
import com.sistemas.service.Menu.MenuService;
import com.sistemas.service.Participante.ParticipanteService;
import com.sistemas.service.Resenia.ReseniaService;
import com.sistemas.clases.Chef;
import com.sistemas.service.Chef.ChefService;

public class MenuServiceImpl implements MenuService {

    private EventoService eventoService;
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
    int opcion = 0;

    while (opcion != 6) {
        System.out.println("Ingrese opcion: \n");
        System.out.println("1. Registrar chef");
        System.out.println("2. Crear Evento");
        System.out.println("3. Registrar Participante");
        System.out.println("4. Dejar reseña");
        System.out.println("5. Listar eventos");
        System.out.println("6. Salir");

   
        try {
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                Chef chef = chefService.registrarChef(); 
                System.out.println("Chef registrado exitosamente: " + chef);
                break;
            case 2:
                eventoService.crearEvento();
                break;
            case 3:
                participanteService.registrarParticipante();
                break;
            case 4:
                try {
                    System.out.println("Ingrese el ID del evento:");
                    if (scanner.hasNextLine()) {
                        UUID idEvento = UUID.fromString(scanner.nextLine());

                        System.out.println("Ingrese el ID del participante:");
                        if (scanner.hasNextLine()) {
                            UUID idParticipante = UUID.fromString(scanner.nextLine());
                            reseniaService.dejarResenia(idEvento, idParticipante);
                        } else {
                            System.out.println("No se encontró la entrada del participante.");
                        }
                    } else {
                        System.out.println("No se encontró la entrada del evento.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Formato de ID invalido.");
                }
                break;
            case 5:
                System.out.println("Ingrese la fecha y hora desde la cual desea listar los eventos (yyyy-MM-ddTHH:mm): ");
                if (scanner.hasNextLine()) {
                    String inputFecha = scanner.nextLine();
                    LocalDateTime fechaHora;
                    try {
                        fechaHora = LocalDateTime.parse(inputFecha); 
                        eventoService.listarEventos(fechaHora);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha/hora incorrecto.");
                    }
                } else {
                    System.out.println("No se encontró la entrada de fecha/hora.");
                }
                break;
            case 6:
                System.out.println("\nAplicacian finalizada.");
                break;
            default:
                System.out.println("Opción no valida. Inténtelo de nuevo.");
                break;
        }
        } catch (InputMismatchException e) {
            System.out.println(" ingrese un número valido.");
            scanner.next();
        }
    }
}
    
}
