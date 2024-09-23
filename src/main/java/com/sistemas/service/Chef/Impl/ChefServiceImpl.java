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
        sc.close();
        return chefNuevo;
    }

    @Override
    public void mostrarDetallesChef(Chef chef) {
        System.out.println("\nDetalles del chef registrado:");
        System.out.println("ID: " + chef.getId());
        System.out.println("Nombre: " + chef.getNombre());
        System.out.println("Especialidad: " + chef.getEspecialidad());
    }

    @Override
    public Chef buscarChefByID() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del chef en formato UUID:");
        sc.close();
        try {
            UUID idChef = UUID.fromString(sc.nextLine());
    
            if (chefs.containsKey(idChef)) {
                Chef chef = chefs.get(idChef);
                System.out.println("Chef encontrado: " + chef.getNombre());
                return chef; 
            } else {
                System.out.println("Chef no encontrado con el ID proporcionado.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("El id no es valido.");
        }
        return null; 
    }
    

    public Map<UUID, Chef> getChefs() {
        return chefs;
    }
}
