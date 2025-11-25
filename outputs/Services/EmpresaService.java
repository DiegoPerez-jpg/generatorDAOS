public class EmpresaService{

private Empresa  empresa =  new Empresa();public void eliminarEmpresa(Empresa empresa) {
        empresa.delete(empresa.getId());
    } public List<Empresa> selectAll(){
        return Empresa.findAll();
    }public void updateEmpresa(Empresa empresa) throws IllegalArgumentException{
empresa.insert(Empresa);
}
public void eliminarEmpresa(Empresa empresa) throws IllegalArgumentException{
empresa.update(Empresa);
}
}
