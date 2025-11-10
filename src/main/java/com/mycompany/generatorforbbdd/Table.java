package com.mycompany.generatorforbbdd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
public class Table {
    public StringBuilder sb;
    ArrayList<Paramams> paramams;
    String objectName;
    
    public Table(ResultSet tabla, String objectName) throws SQLException{
        this.objectName = objectName;
        paramams = new ArrayList<>();
        while(tabla.next()){
            paramams.add(new Paramams(tabla.getString("Type"), tabla.getString("Field")));
        }
        init();
    }

    public void init(){
        sb = new StringBuilder();
        sb.append(getImports()+"\n\n")
                .append(createClass())
                .append(createDeclarators())
                .append("\n")
        .append(createConstructor())
        .append("\n")
        .append("\n")
        .append(createGetterAndSetters())
        .append("\n")
        .append("\n")
        .append("}");

    }
    public String getImports(){
        for(Paramams paramams : this.paramams){
            if(paramams.type.equals("LocalDAte")){
                return "import java.time.LocalDate;";
            }
        }
        return "";
    }

    public String createClass(){
        return "public class "+ getNameWithCase()+"{\n";
    }


    public static void setupModelosRepository(){
        setupModelosRepository("modelos");
    }

    public static void setupModelosRepository(String repositoryName){
        File carpeta = new File("./outputs/"+repositoryName);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        File[] files = carpeta.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
    }

    public void crearArchivo(){
        crearArchivo("modelos","",sb,objectName);
    }

    public static void crearArchivo(String repositoryName,String prefijoName,StringBuilder contenido,String nombreArchivo){
        nombreArchivo = getNameWithCase(nombreArchivo);
        try (FileWriter writer = new FileWriter("./outputs/"+repositoryName+"/"+prefijoName+nombreArchivo+".java")) {
            writer.write(contenido.toString());
            System.out.println("Archivo creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder createConstructor(){
        StringBuilder sb = new StringBuilder();
        sb.append("public ")
        .append(getNameWithCase())
        .append("( ")
        .append(getVariableConstructors())
        .append(" ) ")
        .append(" {\n")
        .append(getConstructors())
        .append("}");
        return sb;
    }


    public String getNameWithCase(){
        return getNameWithCase(objectName);
    }
    public static String getNameWithCase(String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public StringBuilder createDeclarators(){
        StringBuilder sb = new StringBuilder();
        for(Paramams modeloParamam : paramams){
            sb.append(modeloParamam.getPrivateDeclarator()+"\n");
        }
        return sb;
    }

    public StringBuilder createGetterAndSetters(){
        StringBuilder result = new StringBuilder();
        for (Paramams param : paramams) {
            result.append(param.getGetter()+"\n \n");
            result.append(param.getSetter()+"\n \n");
        }
        return result;
    }
    public String getVariableConstructors(){
        String result = "";
        for (Paramams param : paramams) {
            result += param.getConstructorParam()+", ";
        }
        result = result.substring(0, result.length()-2);
        return result;
    }

    public StringBuilder getConstructors(){
        StringBuilder result = new StringBuilder();
        for (Paramams param : paramams) {
            result.append(param.getConstructor()+"\n");
        }
        return result;
    }
}
