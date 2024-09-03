package com.sistemas.service.Participante.Impl;

import com.sistemas.clases.Participante;
import com.sistemas.service.Participante.ParticipanteService;
import java.util.Scanner;

public class ParticipanteServiceImpl  implements ParticipanteService{

    @Override
    public Participante registrarParticipante() {
        
        Participante participanteNuevo = new Participante();
        Scanner sc = new Scanner(System.in);

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

        return participanteNuevo;
      
    }

    


}
