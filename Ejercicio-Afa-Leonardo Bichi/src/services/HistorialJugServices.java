package services;

import Dto.HistorialJugadorDto;
import java.util.List;

public interface HistorialJugServices {
    
    public List<HistorialJugadorDto> listarPorDNI(int dni);
    public List<HistorialJugadorDto> listarPorCUIT(int cuit);
    public boolean insertar(HistorialJugadorDto hdto);
    public boolean editar(HistorialJugadorDto hdto);
    public boolean delete(int dni);
    
}
