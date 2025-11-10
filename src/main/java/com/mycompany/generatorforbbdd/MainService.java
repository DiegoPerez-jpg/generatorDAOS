package com.mycompany.generatorforbbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainService {
    ArrayList<String> objectsNames;
    Connection conexion;
    ArrayList<Table> tables;
    ArrayList<DAOGenerator> daoGenerators;
    ConexionGenerator cg;
    public MainService(String url, String user, String password){
        conexion = Conexion.getConnection(url,user,password);
        cg = new ConexionGenerator(url,user,password);

        init();
    }

    public void init() {
        objectsNames = new ArrayList<>();
        try{
            PreparedStatement ps = conexion.prepareStatement("SHOW TABLES;");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                objectsNames.add(rs.getString(1));
            }
        } catch (SQLException e){
            System.out.println("Error buscando las tablas: " + e.getMessage());
        }

        setupModelosGenerators();
        setupDAOSGenerators();
        crearModelos();
        crearDAOS();
        cg.init();
    }

    private void crearDAOS(){
        Table.setupModelosRepository("DAOS");
        daoGenerators.forEach(DAOGenerator::crearArchivo);
    }

    private void crearModelos(){
        Table.setupModelosRepository();
        tables.forEach(Table::crearArchivo);

    }

    private void setupDAOSGenerators(){
        daoGenerators =  tables.stream().map(DAOGenerator::new).collect(Collectors.toCollection(ArrayList::new));
    }

    private void setupModelosGenerators() {
        try{
            tables = new ArrayList<>();
            for(String objectName : objectsNames){
                PreparedStatement ps = conexion.prepareStatement("DESC " + objectName);
                ResultSet rs = ps.executeQuery();
                tables.add(new Table(rs,objectName));
            }
        } catch (SQLException e){
            System.out.println("Error investigando las tablas: " + e.getMessage());
        }


    }
}
