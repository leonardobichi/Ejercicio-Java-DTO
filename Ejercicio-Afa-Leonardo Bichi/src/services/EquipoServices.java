package services;

import Dto.EquipoDto;
import java.util.List;

public interface EquipoServices {
    
    public EquipoDto listarPorCuit(int cuit);
    public List<EquipoDto> listar();
    public boolean insertar(EquipoDto edto);
    public boolean editar(EquipoDto edto);
    public boolean delete(int cuit);
    
}
