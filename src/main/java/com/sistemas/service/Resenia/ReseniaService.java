package com.sistemas.service.Resenia;

import java.util.UUID;

import com.sistemas.clases.Resenia;

public interface ReseniaService {


      

   public Resenia crearResenia();

   public void dejarResenia(UUID idEvento, UUID idParticipante);



}
