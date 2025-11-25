

public class Temple{
private Integer numem;
private Integer numde;
private Integer extel;
private LocalDate fecna;
private LocalDate fecin;
private Double salar;
private Double comis;
private Integer numhi;
private String nomem;

public Temple( Integer numem, Integer numde, Integer extel, LocalDate fecna, LocalDate fecin, Double salar, Double comis, Integer numhi, String nomem )  {
this.numem = numem;
this.numde = numde;
this.extel = extel;
this.fecna = fecna;
this.fecin = fecin;
this.salar = salar;
this.comis = comis;
this.numhi = numhi;
this.nomem = nomem;
}

public Integer getNumem() {
    return numem;
}
 
public void setNumem(Integer numem) {
    this.numem = numem;
}
 
public Integer getNumde() {
    return numde;
}
 
public void setNumde(Integer numde) {
    this.numde = numde;
}
 
public Integer getExtel() {
    return extel;
}
 
public void setExtel(Integer extel) {
    this.extel = extel;
}
 
public LocalDate getFecna() {
    return fecna;
}
 
public void setFecna(LocalDate fecna) {
    this.fecna = fecna;
}
 
public LocalDate getFecin() {
    return fecin;
}
 
public void setFecin(LocalDate fecin) {
    this.fecin = fecin;
}
 
public Double getSalar() {
    return salar;
}
 
public void setSalar(Double salar) {
    this.salar = salar;
}
 
public Double getComis() {
    return comis;
}
 
public void setComis(Double comis) {
    this.comis = comis;
}
 
public Integer getNumhi() {
    return numhi;
}
 
public void setNumhi(Integer numhi) {
    this.numhi = numhi;
}
 
public String getNomem() {
    return nomem;
}
 
public void setNomem(String nomem) {
    this.nomem = nomem;
}
 


}