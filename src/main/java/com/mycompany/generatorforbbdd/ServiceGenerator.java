package com.mycompany.generatorforbbdd;
import com.mycompany.generatorforbbdd.Table;

import java.util.stream.Collectors;

public class ServiceGenerator implements CaseInterface {
    private final Table table;
    public StringBuilder sb;
    private final String className;
    private final DAOGenerator  daoGenerator;
    public ServiceGenerator(Table table,DAOGenerator daoGenerator){
        this.table = table;
        this.className = table.objectName+"Service";
        this.daoGenerator = daoGenerator;
        init();
    }

    public Table getTable() {
        return table;
    }

    public String getClassName() {
        return className;
    }

    public void crearArchivo(){
        Table.crearArchivo("Services","","Service",sb,table.getNameWithCase());
    }

    private void init(){
        this.sb = new StringBuilder();
        this.sb.append(createClass()).append(createDAOObject()).append(createDelete()).append(createSelectAll()).append(createCrear()).append(createUpdate()).append("}\n");

    }

    private String createClass(){
        return "public class "+ getClassNameCase()+"{\n\n";
    }

    private String createDAOObject(){
        return "private "+daoGenerator.getClassNameCase()+"  "+daoGenerator.getClassName()+" =  new "+daoGenerator.getClassNameCase()+"();\n";
    }


    private StringBuilder createDelete(){
        return new StringBuilder("public void eliminar"+table.getNameWithCase()+"("+table.getNameWithCase()+" "+table.objectName+") {\n"
                +
                "        "+daoGenerator.getClassName()+".delete("+table.objectName+".getId());\n" +
                "    }\n");
    }

    private StringBuilder createSelectAll(){
        return new StringBuilder(" public List<"+table.getNameWithCase()+"> selectAll(){\n" +
                "        return "+daoGenerator.getClassName()+".findAll();\n" +
                "    }\n");
    }

    private StringBuilder createCrear(){
        StringBuilder sb = new StringBuilder();

        sb.append("public void crear").append(table.getNameWithCase()).append("(").append(table.getNameWithCase()).append(" ").append(table.objectName).append(") throws ").append("IllegalArgumentException{\n");
        sb.append(table.paramams.stream()
                .filter(p->p.getIs_unique().equals(true))
                .map(p->"if (!"+daoGenerator.getClassName()+".filterByAll"+table.getReplacedCastingFunctionParams(table.paramams.indexOf(p))+".isEmpty())throw new IllegalArgumentException(\"El "+p.name+" ya existe\");\n").collect(Collectors.joining()));
        sb.append(daoGenerator.getClassName()).append(".insert(").append(table.objectName).append(");\n");
        sb.append("}\n");
        return sb;
    }

    private StringBuilder createUpdate(){
        StringBuilder sb = new StringBuilder();
        sb.append("public void update").append(table.getNameWithCase()).append("(").append(table.getNameWithCase()).append(" ").append(table.objectName).append(") throws ").append("IllegalArgumentException{\n");
        sb.append(table.paramams.stream().filter(p->p.getIs_unique().equals(true)).map(p->"if (!"+daoGenerator.getClassName()+".filterByAll"+table.getReplacedCastingFunctionParams(table.paramams.indexOf(p))+".isEmpty())throw new IllegalArgumentException(\"El "+p.name+" ya existe\");\n").collect(Collectors.joining()));
        sb.append(daoGenerator.getClassName()).append(".update(").append(table.objectName).append(");\n");
        sb.append("}\n");
        return sb;

    }


}