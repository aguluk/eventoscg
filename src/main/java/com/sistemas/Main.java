package com.sistemas;

import com.sistemas.clases.Organizador;
import com.sistemas.service.Evento.EventoService;
import com.sistemas.service.Evento.impl.EventoServiceImpl;
import com.sistemas.service.Menu.MenuService;
import com.sistemas.service.Menu.Impl.MenuServiceImpl;
import com.sistemas.service.Organizador.OrganizadorService;
import com.sistemas.service.Organizador.OrganizadorServiceImpl;
import com.sistemas.service.Participante.ParticipanteService;
import com.sistemas.service.Participante.Impl.ParticipanteServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
      Organizador organizador = new Organizador();
      ParticipanteService participanteService = new ParticipanteServiceImpl();
      OrganizadorService organizadorService = new OrganizadorServiceImpl(organizador);

      EventoService eventoService = new EventoServiceImpl(organizadorService,participanteService);
      MenuService menuService = new MenuServiceImpl(eventoService,participanteService);
      Scanner scanner = new Scanner(System.in);

        menuService.mostrarMenu(scanner);

        scanner.close();
      };

          
    }