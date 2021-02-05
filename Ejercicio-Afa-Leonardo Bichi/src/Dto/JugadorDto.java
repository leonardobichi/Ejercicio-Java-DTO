package Dto;

import java.util.List;

public class JugadorDto {
    
    private Integer dni;
    private String nombre;
    private String apellido;
    private List<HistorialJugadorDto> listado_historiales;

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<HistorialJugadorDto> getListado_historiales() {
        return listado_historiales;
    }

    public void setListado_historiales(List<HistorialJugadorDto> listado_historiales) {
        this.listado_historiales = listado_historiales;
    }
    
    @Override
    public String toString() {
        String resultado = "Jugador{ dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido;      
        if (listado_historiales != null) {
            resultado += ", historial";
            resultado = listado_historiales.stream().map((h) -> h.toString()).reduce(resultado, String::concat);
        }
        return resultado += " }";
    }
    
}
