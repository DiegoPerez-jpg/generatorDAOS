package com.mycompany.generatorforbbdd;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
public class DAOGenerator {
    ArrayList<DAOParamams> daoParamams;
    String objectName;
    
    public DAOGenerator(ResultSet tabla, String objectName) throws SQLException{
        this.objectName = objectName;
        daoParamams = new ArrayList<>(); 
        while(tabla.next()){
            daoParamams.add(new DAOParamams(tabla.getString("Type"), (tabla.getString("Field")));
        }
    }

    public void init(){
        StringBuilder sb = new StringBuilder();
        sb.append(createConstructor())
        .append("\n")
        .append("\n")
        .append(createGetterAndSetters())
        .append("\n")
        .append("\n")
        .append("}");   
    }

    public void crearArchivo(StringBuilder contenido){
        try (FileWriter writer = new FileWriter(objectName+".java")) {
            writer.write(contenido.toString());
            System.out.println("Archivo creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder createConstructor(){
        StringBuilder sb = new StringBuilder();
        sb.append("public class ")
        .append(objectName)
        .append("( ")
        .append(getVariableConstructors())
        .append(" ) ")
        .append(" {\n")
        .append(getConstructors())
        .append("}");
        return sb;
    }


    public StringBuilder createGetterAndSetters(){
        StringBuilder result = new StringBuilder();
        for (DAOParamams param : daoParamams) {
            result.append(param.getGetter()+"\n \n");
            result.append(param.getSetter()+"\n \n");
        }
        return result;
    }
    public String getVariableConstructors(){
        String result = "";
        for (DAOParamams param : daoParamams) {
            result += param.getConstructorParam()+", ";
        }
        result = result.substring(0, result.length()-2);
        return result;
    }

    public StringBuilder getConstructors(){
        StringBuilder result = new StringBuilder();
        for (DAOParamams param : daoParamams) {
            result.append(param.getConstructor()+"\n");
        }
        return result;
    }
}
