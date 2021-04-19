package com.ecodeup.dao;

import java.nio.channels.ScatteringByteChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.Conexion;
import com.ecodeup.idao.IClienteDao;
import com.ecodeup.model.Cliente;

public class ClienteDatoImpl implements IClienteDao {
    @Override
    public boolean registrar(Cliente cliente) {
        boolean registrar =false;

        Statement stm=null;
        Connection con=null;
        String sql="INSERT INTO cliente values (NULL,'" + cliente.getDni() + "','" + cliente.getNombre() + "','" + cliente.getApellido()+"')";

        try{
            con=Conexion.conectar();
            stm=con.createStatement();
            stm.execute(sql);
            registrar=true;
            stm.close();
            con.close();

        }
        catch (SQLException e){
            System.out.println("Error: Clase ClienteDaoImple, metodo registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Cliente> obtener() {
        Connection co=null;
        Statement stm=null;
        ResultSet rs=null;

        String sql="SELECT * FROM CLIENTE ORDER BY ID";

        List<Cliente> listaCliente = new ArrayList<Cliente>();

        try{
            co= Conexion.conectar();
            stm= co.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Cliente c= new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString (4));
                listaCliente.add(c);

            }
            stm.close();
            rs.close();
            co.close();
        }catch(SQLException e){
            System.out.println("Error: Clase ClienteDaoImple, metodo obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        Connection connect= null;
        Statement stm= null;
        boolean actualizar = false;

        String sql = "UPDATE CLIENTE SET dni='" + cliente.getDni()+ "',nombres='" + cliente.getNombre() + "',apellidos='" + cliente.getApellido() + "' WHERE ID=" + cliente.getId();
        try {connect=Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar=true;

        }catch (SQLException e){
            System.out.println("Error: Clase ClienteDoaImpl, metodo actualizar");
            e.printStackTrace();
        }
        return actualizar;


    }

    @Override
    public boolean eliminar(Cliente cliente) {
        Connection con= null;
        Statement stm = null;

        boolean eliminar=false;

        String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getId();
        try{
            con= Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            eliminar=true;
        }catch(SQLException e){
            System.out.println("Error: Clase ClienteDoaImpl, metodo eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
}
