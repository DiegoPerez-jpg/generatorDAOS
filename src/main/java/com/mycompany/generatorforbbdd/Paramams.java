package com.mycompany.generatorforbbdd;

public class Paramams {
    String type;
    String name;
    public Paramams(String type, String name){
        this.type = type;
        this.name = name.toLowerCase();
    }



    public String getDeclarator(){
        return getJavaType() + " " + name + ";";
    }

    public String getConstructorParam() {
        String result = getDeclarator();
        return result.substring(0, result.length()-1);
    }
    public String getPrivateDeclarator(){
        return "private " + getDeclarator();
    }

    public String getConstructor(){
        return "this." + name + " = " + name + ";";
    }

    public StringBuilder getGetter(){
        StringBuilder sb = new StringBuilder();

        sb.append("public ")
        .append(getJavaType())
        .append(" get")
        .append(name.substring(0, 1).toUpperCase())
        .append(name.substring(1))
        .append("() {\n")
        .append("    return ")
        .append(name)
        .append(";\n")
        .append("}");
        return sb;
    }

    public StringBuilder getSetter(){
        StringBuilder sb = new StringBuilder();

        sb.append("public void set")
        .append(name.substring(0, 1).toUpperCase())
        .append(name.substring(1))
        .append("(")
        .append(getJavaType())
        .append(" ")
        .append(name)
        .append(") {\n")
        .append("    this.")
        .append(name)
        .append(" = ")
        .append(name)
        .append(";\n")
        .append("}");
        return sb;
    }

    public String getJavaType(){
        
        return getJavaType(type);

    }
    public static String getJavaType(String type){
        type = type.toUpperCase();
        if (type.contains("BOOLEAN") || type.contains("BOOL")) {
            return "boolean";
        }else if (type.contains("TINYINT") || type.contains("SMALLINT") ||
                type.contains("MEDIUMINT") || type.contains("INT") ||
                type.contains("INTEGER") || type.contains("BIGINT")) {
            return "int";
        }else if (type.contains("DECIMAL") || type.contains("NUMERIC") ||
                type.contains("REAL")) {
            return "double";
        } else if ( type.contains("FLOAT") ){
            return "float";
        } else if ( type.contains("DOUBLE") ){
            return "double";
        } else if (type.contains("CHAR") || type.contains("VARCHAR") ||
                type.contains("TEXT") || type.contains("TINYTEXT") ||
                type.contains("MEDIUMTEXT") || type.contains("LONGTEXT") ||
                type.contains("ENUM") || type.contains("SET")) {
            return "String";
        }else if (type.contains("DATE") || type.contains("TIME") ||
                type.contains("YEAR") || type.contains("DATETIME") ||
                type.contains("TIMESTAMP")) {
            return "LocalDate";
        }

        // Si no coincide con ninguno de los anteriores:
        return "otro";

    }

}
