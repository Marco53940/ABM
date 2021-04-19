package com.ecodeup.controller;

import com.ecodeup.dao.ClienteDatoImpl;
import com.ecodeup.idao.IClienteDao;
import com.ecodeup.model.Cliente;
import com.ecodeup.vista.ViewCliente;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

public class ControllerCliente {

    private ViewCliente vista = new ViewCliente();
    public ControllerCliente(){

    }
    public void registrar(Cliente cliente){
        IClienteDao dao= new ClienteDatoImpl();
        dao.registrar(cliente);

    }

    public void actualizar(Cliente cliente) {
        IClienteDao dao = new ClienteDatoImpl();
        dao.actualizar(cliente);

    }
    public void eliminar(Cliente cliente){
        IClienteDao dao = new ClienteDatoImpl();
        dao.eliminar(cliente);

    }

    public void verClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        IClienteDao dao = new ClienteDatoImpl();
        clientes = dao.obtener();
        vista.verClientes(clientes);

    }
}
