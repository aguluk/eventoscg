package com.sistemas.service.Chef;


import java.util.Map;
import java.util.UUID;

import com.sistemas.clases.Chef;

public interface ChefService {

    Chef registrarChef();

    public void mostrarDetallesChef(Chef chef);

    Map<UUID, Chef> getChefs();

    public Chef buscarChefByID();
}
