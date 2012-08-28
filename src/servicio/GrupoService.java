/* id,numero,sigla,nombre,horario,aula,id_profesor */

package servicio;
import java.util.*;

public class GrupoService {

  private Map<String,GrupoDTO> grupos;

  private static String[][] data = {
    {"1","1","ADM-001","Elementos de Administración","K,J 7:00-9:00am","A01","101110111"},
	{"2","1","ECN-001","Principios de Economía","L,M 9:00-11:00am","B02","202220222"},
	{"3","2","MAT-001","Matematica I","K,J 1:00-3:00pm","A02","303330333"},
	{"4","1","ADM-101","Administración Avanzada","K,J 13:00-15:00am","A01","101110111"},
	{"5","2","ECN-101","Economía I","K,J 9:00-11:00am","B02","202220222"},
	{"6","2","MAT-102","Matematica II","K,J 14:00-16:00pm","A02","303330333"}};

  GrupoService() {
    grupos = new HashMap<String,GrupoDTO>();
    for (int i=0;i<data.length;i++) {
      GrupoDTO grupo = new GrupoDTO();
      grupo.setId(data[i][0]);
      grupo.setNumero(data[i][1]);
      grupo.setSigla(data[i][2]);
      grupo.setNombre(data[i][3]);
      grupo.setHorario(data[i][4]);
      grupo.setAula(data[i][5]);
	  grupo.setId_profesor(data[i][6]);
      grupos.put(grupo.getId(),grupo);	  
    }
  }
  
  protected void insert(String id, String numero, String sigla, String nombre, String horario, String aula, String id_profesor) {
	GrupoDTO grupo = new GrupoDTO();
	grupo.setId(id);
    grupo.setNumero(numero);
    grupo.setSigla(sigla);
    grupo.setNombre(nombre);
    grupo.setHorario(horario);
    grupo.setAula(aula);
	grupo.setId_profesor(id_profesor);
    grupos.put(grupo.getId(),grupo);
  }
  
  protected void eliminar(String id) {
	grupos.remove(id);
  }
  
  protected void update(String id, String numero, String sigla, String nombre, String horario, String aula, String id_profesor) {
	GrupoDTO grupo = new GrupoDTO();
	grupo.setId(id);
    grupo.setNumero(numero);
    grupo.setSigla(sigla);
    grupo.setNombre(nombre);
    grupo.setHorario(horario);
    grupo.setAula(aula);
	grupo.setId_profesor(id_profesor);
    grupos.put(grupo.getId(),grupo);
  }

  protected GrupoDTO find(String grupoID) {
    if (grupos.containsKey(grupoID))
      return (GrupoDTO)grupos.get(grupoID);
    else
      return null;
  }

  protected List<GrupoDTO> findAll() {
    List resultado = new ArrayList();
    for(Iterator<String> it = grupos.keySet().iterator();it.hasNext();) {
      String key = it.next();
      resultado.add(grupos.get(key));
    }
    return resultado;
  }
}