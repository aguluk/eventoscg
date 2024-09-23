package com.sistemas.service.Resenia.Impl;

import java.util.Scanner;
import java.util.UUID;
import com.sistemas.clases.Evento;
import com.sistemas.clases.Resenia;
import com.sistemas.enumeration.CalificacionEnum; 
import com.sistemas.service.Organizador.OrganizadorService;
import com.sistemas.service.Resenia.ReseniaService;

public class ReseniaServiceImpl implements ReseniaService {

    private OrganizadorService organizadorService;

    public ReseniaServiceImpl(OrganizadorService organizadorService) {
        this.organizadorService = organizadorService;
    }

    @Override
    public void dejarResenia(UUID idEvento, UUID idParticipante) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Ingrese el ID del evento:");
            idEvento = UUID.fromString(sc.nextLine());

            System.out.println("Ingrese el ID del participante:");
            idParticipante = UUID.fromString(sc.nextLine());

            boolean participantePresente = false;
            Evento evento = null;

            for (Evento e : organizadorService.getEventos()) {
                if (e.getId().equals(idEvento)) {
                    participantePresente = e.getParticipantes().containsKey(idParticipante);
                    if (participantePresente) {
                        evento = e;
                    }
                    break;
                }
            }

            if (participantePresente && evento != null) {
                Resenia reseniaExistente = evento.getParticipantes().get(idParticipante).getResenia();

                if (reseniaExistente != null) {
                    System.out.println("El participante ya ha dejado una reseña para este evento.");
                } else {
                    System.out.println("El participante asistio al evento.");
                    Resenia nuevaResenia = crearResenia();
                    evento.getParticipantes().get(idParticipante).setResenia(nuevaResenia);
                    evento.getResenias().put(idParticipante, nuevaResenia);

                    System.out.println("Reseña agregada .");
                }
            } else {
                System.out.println("El participante no asisti9 al evento o el evento no existe, no puede dejar una reseña.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("El formato del UUID no es valido.");
        } finally {
            sc.close();
        }
    }

    @Override
    public Resenia crearResenia() {
        Scanner sc = new Scanner(System.in);
        Resenia nuevaResenia = new Resenia();
        nuevaResenia.setId(UUID.randomUUID());

        System.out.println("Dejar descripcion:");
        String descripcion = sc.nextLine();
        nuevaResenia.setDescripcion(descripcion);

        CalificacionEnum calificacion = null;
        while (calificacion == null) {
            try {
                System.out.println("Ingrese una calificacion del 1 al 5:");
                int calificacionInput = Integer.parseInt(sc.nextLine());

                switch (calificacionInput) {
                    case 1:
                        calificacion = CalificacionEnum.UNO;
                        break;
                    case 2:
                        calificacion = CalificacionEnum.DOS;
                        break;
                    case 3:
                        calificacion = CalificacionEnum.TRES;
                        break;
                    case 4:
                        calificacion = CalificacionEnum.CUATRO;
                        break;
                    case 5:
                        calificacion = CalificacionEnum.CINCO;
                        break;
                    default:
                        System.out.println("Calificación no validas.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número del 1 al 5.");
            }
        }
        sc.close();
        nuevaResenia.setCalificacion(calificacion);
        return nuevaResenia;
       
    }
}
