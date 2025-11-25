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
        return "private "+daoGenerator.getClassNameCase()+"  "+daoGenerator.getClassName()+" =  new "+daoGenerator.getClassNameCase()+"();";
    }


    private StringBuilder createDelete(){
        return new StringBuilder("public void eliminar"+table.getNameWithCase()+"("+table.getNameWithCase()+" "+table.objectName+") {\n"
                +
                "        "+daoGenerator.getClassName()+".delete("+table.objectName+".getId());\n" +
                "    }");
    }

    private StringBuilder createSelectAll(){
        return new StringBuilder(" public List<"+table.getNameWithCase()+"> selectAll(){\n" +
                "        return "+daoGenerator.getClassNameCase()+".findAll();\n" +
                "    }");
    }

    private StringBuilder createCrear(){
        StringBuilder sb = new StringBuilder();

        sb.append("public void update").append(table.getNameWithCase()).append("(").append(table.getNameWithCase()).append(" ").append(table.objectName).append(") throws ").append("IllegalArgumentException{\n");
        sb.append(table.paramams.stream()
                .filter(p->p.getIs_unique().equals(true))
                .map(p->"if (!direccionDAO.filterByAll("+table.getReplacedCastingFunctionParams(table.paramams.indexOf(p))+").isEmpty())throw new IllegalArgumentException(\"El "+p.name+" no existe\");\n").collect(Collectors.joining()));
        sb.append(daoGenerator.getClassName()).append(".insert(").append(table.getNameWithCase()).append(");\n");
        sb.append("}\n");
        return sb;
    }

    private StringBuilder createUpdate(){
        StringBuilder sb = new StringBuilder();
        sb.append("public void eliminar").append(table.getNameWithCase()).append("(").append(table.getNameWithCase()).append(" ").append(table.objectName).append(") throws ").append("IllegalArgumentException{\n");
        sb.append(table.paramams.stream().filter(p->p.getIs_unique().equals(true)).map(p->"if (!direccionDAO.filterByAll("+table.getReplacedCastingFunctionParams(table.paramams.indexOf(p))+").isEmpty())throw new IllegalArgumentException(\"El "+p.name+" no existe\");\n").collect(Collectors.joining()));
        sb.append(daoGenerator.getClassName()).append(".update(").append(table.getNameWithCase()).append(");\n");
        sb.append("}\n");
        return sb;

    }


}