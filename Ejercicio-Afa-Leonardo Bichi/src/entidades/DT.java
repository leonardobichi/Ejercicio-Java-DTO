package entidades;

import java.util.ArrayList;
import java.util.List;

public class DT extends Integrante {
    
    private List<HistorialJugador> listadoHistoriales;
    
    public DT() {
        listadoHistoriales = new ArrayList();
    }
    
    public DT(List<HistorialJugador> listadoHistoriales) {
        this.listadoHistoriales = listadoHistoriales;
    }

    public DT(Integer dni, String nombre, String apellido, Direccion direccion, int telefono, String email) {
        super(dni, nombre, apellido, direccion, telefono, email);
        this.listadoHistoriales = new ArrayList();
    }
    
    public DT(List<HistorialJugador> listadoHistoriales, Integer dni, String nombre, String apellido, Direccion direccion, int telefono, String email) {
        super(dni, nombre, apellido, direccion, telefono, email);
        this.listadoHistoriales = listadoHistoriales;
    }

    public List<HistorialJugador> getListadoHistoriales() {
        return listadoHistoriales;
    }

    public void setListadoHistoriales(List<HistorialJugador> listadoHistoriales) {
        this.listadoHistoriales = listadoHistoriales;
    }
    
}
