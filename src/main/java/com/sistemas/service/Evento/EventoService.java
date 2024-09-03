package com.sistemas.service.Evento;

import java.util.UUID;

import com.sistemas.clases.Evento;

public interface EventoService {
    Evento crearEvento();

     void inscribirParticipanteAlEvento(UUID idEvento);

   
}

