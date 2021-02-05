package services;

import Dao.HistorialJugDaoImpl;
import Dto.HistorialJugadorDto;
import java.util.ArrayList;
import java.util.List;
import entidades.HistorialJugador;

public class HistorialJugServicesImpl implements HistorialJugServices {
    
    HistorialJugDaoImpl hjdao = new HistorialJugDaoImpl();

    @Override
    public List<HistorialJugadorDto> listarPorDNI(int dni) {
        List<HistorialJugadorDto> listado_historiales = new ArrayList();
        
        hjdao.listarPorDNI(dni).forEach(h -> listado_historiales.add(convertirHistorialADTO(h)));
        
        return listado_historiales;
    }

    @Override
    public List<HistorialJugadorDto> listarPorCUIT(int cuit) {
        List<HistorialJugadorDto> listado_historiales = new ArrayList();
        
        hjdao.listarPorCUIT(cuit).forEach(h -> listado_historiales.add(convertirHistorialADTO(h)));
        
        return listado_historiales;
    }

    @Override
    public boolean insertar(HistorialJugadorDto hjdto) {
        return hjdao.insertar(convertirDTOAHistorial(hjdto));
    }

    @Override
    public boolean editar(HistorialJugadorDto hjdto) {
        return hjdao.editar(convertirDTOAHistorial(hjdto));
    }

    @Override
    public boolean delete(int dni) {
        return hjdao.delete(dni);
    }
    
    public HistorialJugadorDto convertirHistorialADTO(HistorialJugador hj) {
        HistorialJugadorDto hjdto = new HistorialJugadorDto();
        hjdto.setDni_jugador(hj.getDni_jugador());
        hjdto.setCuit_equipo(hj.getCuit_equipo());
        hjdto.setFecha_inicio(hj.getFecha_inicio());
        hjdto.setFecha_fin(hj.getFecha_fin());
        hjdto.setPosicion_jugador(hj.getPosicion_jugador());
        return hjdto;
    }
    
    public HistorialJugador convertirDTOAHistorial(HistorialJugadorDto hjdto) {
        HistorialJugador hj = new HistorialJugador();
        hj.setDni_jugador(hjdto.getDni_jugador());
        hj.setCuit_equipo(hjdto.getCuit_equipo());
        hj.setFecha_inicio(hjdto.getFecha_inicio());
        hj.setFecha_fin(hjdto.getFecha_fin());
        hj.setPosicion_jugador(hjdto.getPosicion_jugador());
        return hj;
    }
    
}
