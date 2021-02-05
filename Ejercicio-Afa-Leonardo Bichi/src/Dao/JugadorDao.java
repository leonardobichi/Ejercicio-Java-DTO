package Dao;

import java.util.List;
import entidades.Jugador;

public interface JugadorDao {
    
    public Jugador listarPorDNI(int dni);
    public List<Jugador> listar();
    public boolean insertar(Jugador j);
    public boolean editar(Jugador j);
    public boolean delete(int dni);
    
}
