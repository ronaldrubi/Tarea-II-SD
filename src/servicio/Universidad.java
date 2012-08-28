package servicio;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService (targetNamespace ="http://service", name="universidad")
public class Universidad {

  private static ProfesorService profesor;
  private static GrupoService grupo;

  @WebMethod (action="urn:insertProfesor", operationName="insertProfesor")
  public void insertProfesor(@WebParam (partName = "cedula") String cedula, @WebParam (partName = "area") String area, @WebParam (partName = "nombre") String nombre, @WebParam (partName = "titulo") String titulo, @WebParam (partName = "correo") String correo, @WebParam (partName = "telefono") String telefono) {
    checkProfesor();
    profesor.insert(cedula, area, nombre, titulo, correo, telefono);
  }
  
  @WebMethod (action="urn:insertGrupo", operationName="insertGrupo")
  public void insertGrupo(@WebParam (partName = "idGrupo") String idGrupo, @WebParam (partName = "numero") String numero, @WebParam (partName = "sigla") String sigla, @WebParam (partName = "nombre") String nombre, @WebParam (partName = "horario") String horario, @WebParam (partName = "aula") String aula, @WebParam (partName = "idProfesor") String idProfesor) {
    checkGrupo();
    grupo.insert(idGrupo, numero, sigla, nombre, horario, aula, idProfesor);
  }
  
  @WebMethod (action="urn:eliminarProfesor", operationName="eliminarProfesor")
  public void eliminarProfesor(@WebParam (partName = "id") String id) {
    checkProfesor();
    profesor.eliminar(id);
  }
  
  @WebMethod (action="urn:eliminarGrupo", operationName="eliminarGrupo")
  public void eliminarGrupo(@WebParam (partName = "id") String id) {
    checkGrupo();
    grupo.eliminar(id);
  }
  
  @WebMethod (action="urn:updateProfesor", operationName="updateProfesor")
  public void updateProfesor(@WebParam (partName = "cedula") String cedula, @WebParam (partName = "area") String area, @WebParam (partName = "nombre") String nombre, @WebParam (partName = "titulo") String titulo, @WebParam (partName = "correo") String correo, @WebParam (partName = "telefono") String telefono) {
    checkProfesor();
    profesor.update(cedula, area, nombre, titulo, correo, telefono);
  }
  
  @WebMethod (action="urn:updateGrupo", operationName="updateGrupo")
  public void updateGrupo(@WebParam (partName = "idGrupo") String idGrupo, @WebParam (partName = "numero") String numero, @WebParam (partName = "sigla") String sigla, @WebParam (partName = "nombre") String nombre, @WebParam (partName = "horario") String horario, @WebParam (partName = "aula") String aula, @WebParam (partName = "idProfesor") String idProfesor) {
    checkGrupo();
    grupo.update(idGrupo, numero, sigla, nombre, horario, aula, idProfesor);
  }
  
  @WebMethod (action="urn:findProfesor", operationName="findProfesor")
  public ProfesorDTO findProfesor(@WebParam (partName = "profesorId") String profesorId) {
    checkProfesor();
    return profesor.find(profesorId);
  }
  
  @WebMethod (action="urn:findGrupo", operationName="findGrupo")
  public GrupoDTO findGrupo(@WebParam (partName = "grupoId") String grupoId) {
    checkGrupo();
    return grupo.find(grupoId);
  }

  @WebMethod (action="urn:findAllProfesor", operationName="findAllProfesor")
  public List<ProfesorDTO> findAllProfesor() {
    checkProfesor();
    return profesor.findAll();
  }
  
  @WebMethod (action="urn:findAllGrupo", operationName="findAllGrupo")
  public List<GrupoDTO> findAllGrupo() {
    checkGrupo();
    return grupo.findAll();
  }

  private void checkProfesor() {
    if (profesor == null)
      profesor = new ProfesorService();
  }
  
  private void checkGrupo() {
    if (grupo == null)
      grupo = new GrupoService();
  }
}