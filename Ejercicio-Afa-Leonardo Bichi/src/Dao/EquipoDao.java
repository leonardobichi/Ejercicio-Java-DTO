package Dao;

import entidades.Equipo;
import java.util.List;

public interface EquipoDao {
    
    public Equipo listarPorCuit(int cuit);
    public List<Equipo> listar();
    public boolean insertar(Equipo e);
    public boolean editar(Equipo e);
    public boolean delete(int cuit);
    
}
