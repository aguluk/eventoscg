package com.sistemas;
import java.util.*;
import com.sistemas.clases.Chef;
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
      Map<UUID, Chef> chefs = new HashMap<>();
      OrganizadorService organizadorService = new  OrganizadorServiceImpl(organizador);
      ParticipanteService participante = new ParticipanteServiceImpl(organizadorService);
      EventoService eventoService = new EventoServiceImpl(chefs,organizadorService);
      ReseniaService ReseniaService = new ReseniaServiceImpl(organizadorService);
      ChefService chefService = new ChefServiceImpl();
      MenuService menuService = new MenuServiceImpl(eventoService, participante,chefService, ReseniaService);
      
      Scanner scanner = new Scanner(System.in);

        menuService.mostrarMenu(scanner);

        scanner.close();
      };

          
    }