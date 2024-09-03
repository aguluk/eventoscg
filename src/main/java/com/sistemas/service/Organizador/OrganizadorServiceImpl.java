package com.sistemas.service.Organizador;

import java.util.List;

import com.sistemas.clases.Evento;
import com.sistemas.clases.Organizador;

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
