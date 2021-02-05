package entidades;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Integrante {
    
    private List<HistorialJugador> listado_historiales;
    
    public Jugador() {
        listado_historiales = new ArrayList();
    }

    public Jugador(List<HistorialJugador> listadoHistoriales) {
        this.listado_historiales = listadoHistoriales;
    }
    
    public Jugador(int dni, String nombre, String apellido, Direccion direccion, int telefono, String email) {
        super(dni, nombre, apellido, direccion, telefono, email);
        this.listado_historiales = new ArrayList();
    }

    public Jugador(List<HistorialJugador> listadoHistoriales, int dni, String nombre, String apellido, Direccion direccion, int telefono, String email) {
        super(dni, nombre, apellido, direccion, telefono, email);
        this.listado_historiales = listadoHistoriales;
    }

    public List<HistorialJugador> getListadoHistoriales() {
        return listado_historiales;
    }

    public void setListadoHistoriales(List<HistorialJugador> listadoHistoriales) {
        this.listado_historiales = listadoHistoriales;
    }
    
}
