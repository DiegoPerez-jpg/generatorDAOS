package com.mycompany.generatorforbbdd;

import java.util.stream.Collectors;

public class DAOGenerator {
    private Table table;
    private StringBuilder sb;
    public DAOGenerator(Table table) {
        this.table = table;
        init();
    }


    public void init(){
        sb = new StringBuilder();
        sb.append("import java.sql.*;\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.List;\n\n")
                .append("public class "+table.objectName+"DAO {\n\n")
                .append(createInsert())
                .append("\n\n")
                .append(createUpdate())
                .append("\n\n")
                .append(createDelete())
                .append("\n\n")
                .append(createFindAll())
                .append("\n\n")
                .append(createFindById())
                .append("\n\n")
                .append("}");

    }

    public StringBuilder createInsert(){
        StringBuilder sb = new StringBuilder();
        sb.append("public void insert(")
                .append(table.getNameWithCase()).append(" ").append(table.objectName).append(") {\n")
                .append("    String sql = \"INSERT INTO ").append(table.objectName)
                .append(" (").append(valuesForInsert()[0]).append(") VALUES (")
                .append(valuesForInsert()[1]).append(")\";\n")
                .append("    try (Connection conn = Conexion.getConnection();\n")
                .append("         PreparedStatement ps = conn.prepareStatement(sql)) {\n")
                .append(setsForInsert())
                .append("        ps.executeUpdate();\n")
                .append("    } catch (SQLException e) {\n")
                .append("        e.printStackTrace();\n")
                .append("    }\n")
                .append("}\n");
        return sb;
    }

    public String setsForInsert(){
        return table.paramams.stream().map(param -> "ps.set"+Table.getNameWithCase(param.getJavaType())+"("+table.paramams.indexOf(param)+1+", entity.get"+Table.getNameWithCase(param.name)+"());").collect(Collectors.joining("\n"));
    }

    public String[] valuesForInsert(){
        String[] result = new String[2];
        result[0] = table.paramams.stream().map(param -> param.type).collect(Collectors.joining(", "));
        result[1] = table.paramams.stream().map(param -> "?").collect(Collectors.joining(", "));
        return result;


    }

    // ===============================
    // UPDATE
    // ===============================
    public StringBuilder createUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("public void update(")
                .append(table.getNameWithCase()).append(" ").append(table.objectName).append(") {\n")
                .append("    String sql = \"UPDATE ").append(table.objectName)
                .append(" SET ").append(valuesForUpdate())
                .append(" WHERE id = ?\";\n")
                .append("    try (Connection conn = Conexion.getConnection();\n")
                .append("         PreparedStatement ps = conn.prepareStatement(sql)) {\n")
                .append(setsForUpdate())
                .append("        ps.executeUpdate();\n")
                .append("    } catch (SQLException e) {\n")
                .append("        e.printStackTrace();\n")
                .append("    }\n")
                .append("}\n");
        return sb;
    }

    public String valuesForUpdate() {
        return table.paramams.stream()
                .filter(param -> !param.name.equalsIgnoreCase("id"))
                .map(param -> param.name + " = ?")
                .collect(Collectors.joining(", "));
    }

    public String setsForUpdate() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (var param : table.paramams) {
            if (!param.name.equalsIgnoreCase("id")) {
                sb.append("        ps.set").append(Table.getNameWithCase(param.getJavaType()))
                        .append("(").append(i++).append(", ").append(table.objectName)
                        .append(".get").append(Table.getNameWithCase(param.name)).append("());\n");
            }
        }
        sb.append("        ps.setInt(").append(i).append(", ").append(table.objectName)
                .append(".getId());\n");
        return sb.toString();
    }

    // ===============================
    // DELETE
    // ===============================
    public StringBuilder createDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("public void delete(int id) {\n")
                .append("    String sql = \"DELETE FROM ").append(table.objectName)
                .append(" WHERE id = ?\";\n")
                .append("    try (Connection conn = Conexion.getConnection();\n")
                .append("         PreparedStatement ps = conn.prepareStatement(sql)) {\n")
                .append("        ps.setInt(1, id);\n")
                .append("        ps.executeUpdate();\n")
                .append("    } catch (SQLException e) {\n")
                .append("        e.printStackTrace();\n")
                .append("    }\n")
                .append("}\n");
        return sb;
    }

    // ===============================
    // FIND BY ID
    // ===============================
    public StringBuilder createFindById() {
        StringBuilder sb = new StringBuilder();
        sb.append("public ").append(table.getNameWithCase())
                .append(" findById(int id) {\n")
                .append("    String sql = \"SELECT * FROM ").append(table.objectName)
                .append(" WHERE id = ?\";\n")
                .append("    try (Connection conn = Conexion.getConnection();\n")
                .append("         PreparedStatement ps = conn.prepareStatement(sql)) {\n")
                .append("        ps.setInt(1, id);\n")
                .append("        ResultSet rs = ps.executeQuery();\n")
                .append("        if (rs.next()) {\n")
                .append("            return new ").append(table.getNameWithCase()).append("(")
                .append(table.paramams.stream()
                        .map(p -> "rs.get" + Table.getNameWithCase(p.getJavaType()) + "(\"" + p.name + "\")")
                        .collect(Collectors.joining(", ")))
                .append(");\n")
                .append("        }\n")
                .append("    } catch (SQLException e) {\n")
                .append("        e.printStackTrace();\n")
                .append("    }\n")
                .append("    return null;\n")
                .append("}\n");
        return sb;
    }

    public void crearArchivo(){
        Table.crearArchivo("DAOS","DAO",sb,table.objectName);
    }

    // ===============================
    // FIND ALL
    // ===============================
    public StringBuilder createFindAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("public List<").append(table.getNameWithCase()).append("> findAll() {\n")
                .append("    List<").append(table.getNameWithCase()).append("> list = new ArrayList<>();\n")
                .append("    String sql = \"SELECT * FROM ").append(table.objectName).append("\";\n")
                .append("    try (Connection conn = Conexion.getConnection();\n")
                .append("         Statement st = conn.createStatement();\n")
                .append("         ResultSet rs = st.executeQuery(sql)) {\n")
                .append("        while (rs.next()) {\n")
                .append("            list.add(new ").append(table.getNameWithCase()).append("(")
                .append(table.paramams.stream()
                        .map(p -> "rs.get" + Table.getNameWithCase(p.getJavaType()) + "(\"" + p.name + "\")")
                        .collect(Collectors.joining(", ")))
                .append("));\n")
                .append("        }\n")
                .append("    } catch (SQLException e) {\n")
                .append("        e.printStackTrace();\n")
                .append("    }\n")
                .append("    return list;\n")
                .append("}\n");
        return sb;
    }
}
