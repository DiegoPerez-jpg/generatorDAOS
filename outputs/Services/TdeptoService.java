public class TdeptoService{

private TdeptoDAO  tdeptoDAO =  new TdeptoDAO();
public void eliminarTdepto(Tdepto tdepto) {
        tdeptoDAO.delete(tdepto.getId());
    }
 public List<Tdepto> selectAll(){
        return tdeptoDAO.findAll();
    }
public void crearTdepto(Tdepto tdepto) throws IllegalArgumentException{
tdeptoDAO.insert(tdepto);
}
public void updateTdepto(Tdepto tdepto) throws IllegalArgumentException{
tdeptoDAO.update(tdepto);
}
}
