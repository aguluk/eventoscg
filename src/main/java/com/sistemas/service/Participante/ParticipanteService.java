package com.sistemas.service.Participante;

import java.util.UUID;

import com.sistemas.clases.Participante;

public interface ParticipanteService {

    Participante registrarParticipante();

    public void inscribirParticipanteAEvento(UUID idEvento,UUID idParticipante);



}
