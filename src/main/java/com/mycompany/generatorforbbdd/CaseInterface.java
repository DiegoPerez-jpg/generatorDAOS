package com.mycompany.generatorforbbdd;

public interface CaseInterface {

    String getClassName();

    default String getClassNameCase(){
        return Table.getNameWithCase(getClassName());
    }

}
