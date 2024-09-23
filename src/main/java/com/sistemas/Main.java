package com.sistemas;



import com.sistemas.clases.Organizador;
import com.sistemas.service.Chef.ChefService;
import com.sistemas.service.Chef.Impl.ChefServiceImpl;
import com.sistemas.service.Evento.EventoService;
import com.sistemas.service.Evento.impl.EventoServiceImpl;
import com.sistemas.service.Menu.MenuService;
import com.sistemas.service.Menu.Impl.MenuServiceImpl;
import com.sistemas.service.Organizador.OrganizadorService;
import com.sistemas.service.Organizador.Impl.OrganizadorServiceImpl;
import com.sistemas.service.Participante.ParticipanteService;
import com.sistemas.service.Participante.Impl.ParticipanteServiceImpl;
import com.sistemas.service.Resenia.ReseniaService;
import com.sistemas.service.Resenia.Impl.ReseniaServiceImpl;

import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
      
      Organizador organizador  = new Organizador();
      OrganizadorService organizadorService = new OrganizadorServiceImpl(organizador);
      ParticipanteService participanteService = new ParticipanteServiceImpl(organizadorService);
      ReseniaService reseniaService = new ReseniaServiceImpl(organizadorService);
      ChefService chefService = new ChefServiceImpl();
      EventoService eventoService = new EventoServiceImpl(chefService, organizadorService);
      MenuService menuService = new MenuServiceImpl(eventoService, participanteService, chefService, reseniaService);
      
      Scanner scanner = new Scanner(System.in);


      menuService.mostrarMenu(scanner);  
      scanner.close();

       
  }
}
