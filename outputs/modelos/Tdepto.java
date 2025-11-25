

public class Tdepto{
private Integer numde;
private Integer numce;
private Integer direc;
private String tidir;
private Double presu;
private Integer depde;
private String nomde;

public Tdepto( Integer numde, Integer numce, Integer direc, String tidir, Double presu, Integer depde, String nomde )  {
this.numde = numde;
this.numce = numce;
this.direc = direc;
this.tidir = tidir;
this.presu = presu;
this.depde = depde;
this.nomde = nomde;
}

public Integer getNumde() {
    return numde;
}
 
public void setNumde(Integer numde) {
    this.numde = numde;
}
 
public Integer getNumce() {
    return numce;
}
 
public void setNumce(Integer numce) {
    this.numce = numce;
}
 
public Integer getDirec() {
    return direc;
}
 
public void setDirec(Integer direc) {
    this.direc = direc;
}
 
public String getTidir() {
    return tidir;
}
 
public void setTidir(String tidir) {
    this.tidir = tidir;
}
 
public Double getPresu() {
    return presu;
}
 
public void setPresu(Double presu) {
    this.presu = presu;
}
 
public Integer getDepde() {
    return depde;
}
 
public void setDepde(Integer depde) {
    this.depde = depde;
}
 
public String getNomde() {
    return nomde;
}
 
public void setNomde(String nomde) {
    this.nomde = nomde;
}
 


}