public class TempleService{

private TempleDAO  templeDAO =  new TempleDAO();
public void eliminarTemple(Temple temple) {
        templeDAO.delete(temple.getId());
    }
 public List<Temple> selectAll(){
        return templeDAO.findAll();
    }
public void crearTemple(Temple temple) throws IllegalArgumentException{
templeDAO.insert(temple);
}
public void updateTemple(Temple temple) throws IllegalArgumentException{
templeDAO.update(temple);
}
}
