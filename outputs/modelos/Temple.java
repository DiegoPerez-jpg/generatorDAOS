

public class Temple{
private int numem;
private int numde;
private int extel;
private LocalDate fecna;
private LocalDate fecin;
private double salar;
private double comis;
private int numhi;
private String nomem;

public Temple( int numem, int numde, int extel, LocalDate fecna, LocalDate fecin, double salar, double comis, int numhi, String nomem )  {
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

public int getNumem() {
    return numem;
}
 
public void setNumem(int numem) {
    this.numem = numem;
}
 
public int getNumde() {
    return numde;
}
 
public void setNumde(int numde) {
    this.numde = numde;
}
 
public int getExtel() {
    return extel;
}
 
public void setExtel(int extel) {
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
 
public double getSalar() {
    return salar;
}
 
public void setSalar(double salar) {
    this.salar = salar;
}
 
public double getComis() {
    return comis;
}
 
public void setComis(double comis) {
    this.comis = comis;
}
 
public int getNumhi() {
    return numhi;
}
 
public void setNumhi(int numhi) {
    this.numhi = numhi;
}
 
public String getNomem() {
    return nomem;
}
 
public void setNomem(String nomem) {
    this.nomem = nomem;
}
 


}