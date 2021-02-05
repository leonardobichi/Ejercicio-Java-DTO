package services;

import Dto.JugadorDto;
import java.util.List;

public interface JugadorServices {
    
    public JugadorDto listarPorDNI(int dni);
    public List<JugadorDto> listar();
    public boolean insertar(JugadorDto jdto);
    public boolean editar(JugadorDto jdto);
    public boolean delete(int dni);
    
}
