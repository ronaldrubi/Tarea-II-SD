package servicio;

public class GrupoDTO {
  String id;
  String numero;
  String sigla;
  String nombre;
  String horario;
  String aula;
  String id_profesor;
  public void setId(String id) {this.id = id;}
  public void setNumero(String numero) {this.numero = numero;}
  public void setSigla(String sigla) {this.sigla = sigla;}
  public void setNombre(String nombre) {this.nombre = nombre;}
  public void setHorario(String horario) {this.horario = horario;}
  public void setAula(String aula) {this.aula = aula;}
  public void setId_profesor(String id_profesor) {this.id_profesor = id_profesor;}
  public String getId() { return id; }
  public String getNumero() { return numero; }
  public String getSigla() { return sigla; }
  public String getNombre() { return nombre; }
  public String getHorario() { return horario; }
  public String getAula() { return aula; }
  public String getId_profesor() { return id_profesor; }
}