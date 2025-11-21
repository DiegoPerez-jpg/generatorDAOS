

public class Tipoiva{
private Integer id;
private String concepto;
private Double porcentaje;

public Tipoiva( Integer id, String concepto, Double porcentaje )  {
this.id = id;
this.concepto = concepto;
this.porcentaje = porcentaje;
}

public Integer getId() {
    return id;
}
 
public void setId(Integer id) {
    this.id = id;
}
 
public String getConcepto() {
    return concepto;
}
 
public void setConcepto(String concepto) {
    this.concepto = concepto;
}
 
public Double getPorcentaje() {
    return porcentaje;
}
 
public void setPorcentaje(Double porcentaje) {
    this.porcentaje = porcentaje;
}
 


}