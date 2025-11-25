public class TcentrService{

private TcentrDAO  tcentrDAO =  new TcentrDAO();
public void eliminarTcentr(Tcentr tcentr) {
        tcentrDAO.delete(tcentr.getId());
    }
 public List<Tcentr> selectAll(){
        return tcentrDAO.findAll();
    }
public void crearTcentr(Tcentr tcentr) throws IllegalArgumentException{
if (!tcentrDAO.filterByAll(null , tcentr.getNomce() , null ).isEmpty())throw new IllegalArgumentException("El nomce ya existe");
tcentrDAO.insert(tcentr);
}
public void updateTcentr(Tcentr tcentr) throws IllegalArgumentException{
if (!tcentrDAO.filterByAll(null , tcentr.getNomce() , null ).isEmpty())throw new IllegalArgumentException("El nomce ya existe");
tcentrDAO.update(tcentr);
}
}
