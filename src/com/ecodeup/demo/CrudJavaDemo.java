package com.ecodeup.demo;
import com.ecodeup.controller.ControllerCliente;
import com.ecodeup.model.Cliente;


import java.util.Scanner;

public class CrudJavaDemo {
    public static void main(String[] args) {
        int cmd=0;
        Scanner scanner = new Scanner(System.in);
        ControllerCliente controller = new ControllerCliente();
        do{
            System.out.println("Ingrese un comando: \n 1. Dar de alta un cliente\n 2. Ver clientes\n 3. Eliminar Cliente por Id\n 4. Buscar cliente por Id\n 5. Salir");
            cmd=Integer.parseInt(scanner.nextLine());
            switch(cmd){
                case 1: System.out.println("Alta cliente\nIngrese el nombre:");
                        String name= scanner.nextLine();
                        System.out.println("Ingrese el apellido:");
                        String lastname=scanner.nextLine();
                        System.out.println("Ingrese el DNI:");
                        String dni=scanner.nextLine();
                        if(name.isBlank() || lastname.isBlank() || dni.isBlank()){
                            System.out.println("Datos invalidos");
                            break;
                        }
                        Cliente cliente = new Cliente(dni,name, lastname);
                        controller.registrar(cliente);//Se conecta
                        break;
                case 2: System.out.println("Clientes disponibles:");
                        controller.verClientes(); //Se conecta
                        break;

                case 3: System.out.println("Ingrese el id a borrar:");
                        int ide=Integer.parseInt(scanner.nextLine());
                        if(ide<1){
                            System.out.println("Id no valido");
                            break;
                        }
                        Cliente cliente2 =new Cliente();
                        cliente2.setId(ide);
                        controller.eliminar(cliente2);   // Se conecta
                        break;
                case 4:System.out.println("Ingrese el id a buscar:");
                        int idb=Integer.parseInt(scanner.nextLine());
                        if(idb<1){
                             System.out.println("Id no valido");
                             break;
                                }
                        break;
                default:
                        System.out.println("Adios");
            }
        }while(cmd!=5);







//        cliente.setId(2);
//        cliente.setNombre("Cristian");
//        controller.actualizar(cliente);  //Se conecta


    }
}
