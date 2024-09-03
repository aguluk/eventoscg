package com.sistemas.service.Chef.ChefServiceImpl.Impl;

import com.sistemas.clases.Chef;
import com.sistemas.service.Chef.ChefService;
import java.util.Scanner;

public class ChefServiceImpl implements ChefService {

    @Override
    public Chef registrarChef() {

       Chef chefNuevo = new Chef();
       Scanner sc = new Scanner(System.in);


       System.out.println("ingrese nombre del Chef");
       String nombreChef = sc.nextLine();
       chefNuevo.setNombre(nombreChef);
       sc.nextLine();

       System.out.println("ingrese especialidad del Chef");
       String especialidadChef = sc.nextLine();
       chefNuevo.setEspecialidad(especialidadChef);
       sc.nextLine();

        
        return chefNuevo;
    }  

    



}
