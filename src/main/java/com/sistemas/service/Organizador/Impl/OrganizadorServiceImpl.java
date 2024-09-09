package com.sistemas.service.Organizador.Impl;

import java.util.List;


import com.sistemas.clases.Evento;
import com.sistemas.clases.Organizador;
import com.sistemas.service.Organizador.OrganizadorService;

public class OrganizadorServiceImpl implements OrganizadorService{

    Organizador organizador;
     

    public OrganizadorServiceImpl(Organizador organizador) {
        this.organizador = organizador;
    }

    @Override
    public List<Evento> getEventos() {
    
        return this.organizador.getEventos();
    }



    



}
