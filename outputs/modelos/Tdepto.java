

public class Tdepto{
private int numde;
private int numce;
private int direc;
private String tidir;
private double presu;
private int depde;
private String nomde;

public Tdepto( int numde, int numce, int direc, String tidir, double presu, int depde, String nomde )  {
this.numde = numde;
this.numce = numce;
this.direc = direc;
this.tidir = tidir;
this.presu = presu;
this.depde = depde;
this.nomde = nomde;
}

public int getNumde() {
    return numde;
}
 
public void setNumde(int numde) {
    this.numde = numde;
}
 
public int getNumce() {
    return numce;
}
 
public void setNumce(int numce) {
    this.numce = numce;
}
 
public int getDirec() {
    return direc;
}
 
public void setDirec(int direc) {
    this.direc = direc;
}
 
public String getTidir() {
    return tidir;
}
 
public void setTidir(String tidir) {
    this.tidir = tidir;
}
 
public double getPresu() {
    return presu;
}
 
public void setPresu(double presu) {
    this.presu = presu;
}
 
public int getDepde() {
    return depde;
}
 
public void setDepde(int depde) {
    this.depde = depde;
}
 
public String getNomde() {
    return nomde;
}
 
public void setNomde(String nomde) {
    this.nomde = nomde;
}
 


}