package com.sistemas.service.Chef.Impl;

import com.sistemas.clases.Chef;
import com.sistemas.service.Chef.ChefService;

import java.util.*;

public class ChefServiceImpl implements ChefService {

    private Map<UUID, Chef> chefs = new HashMap<>();

    @Override
    public Chef registrarChef() {
        Chef chefNuevo = new Chef();

        Scanner sc = new Scanner(System.in);

        chefNuevo.setId(UUID.randomUUID());
        System.out.println("Ingrese el nombre del chef:");
        chefNuevo.setNombre(sc.nextLine());
        System.out.println("Ingrese la especialidad del chef:");
        chefNuevo.setEspecialidad(sc.nextLine());

        chefs.put(chefNuevo.getId(), chefNuevo);

        mostrarDetallesChef(chefNuevo);

        return chefNuevo;
    }
    @Override
    public void mostrarDetallesChef(Chef chef) {
        System.out.println("\nDetalles del chef registrado:");
        System.out.println("ID: " + chef.getId());
        System.out.println("Nombre: " + chef.getNombre());
        System.out.println("Especialidad: " + chef.getEspecialidad());
    }
}