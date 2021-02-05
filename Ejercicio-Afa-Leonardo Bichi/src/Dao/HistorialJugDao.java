package Dao;

import java.util.List;
import entidades.HistorialJugador;

public interface HistorialJugDao {
    
    public List<HistorialJugador> listarPorDNI(int dni);
    public List<HistorialJugador> listarPorCUIT(int cuit);
    public boolean insertar(HistorialJugador h);
    public boolean editar(HistorialJugador h);
    public boolean delete(int dni);
    
}
