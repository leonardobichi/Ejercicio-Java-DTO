package services;

import Dao.EquipoDaoImpl;
import Dto.EquipoDto;
import Dto.JugadorDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entidades.Equipo;
import entidades.Posicion;

public class EquipoServicesImpl implements EquipoServices {
    
    EquipoDaoImpl eqdao = new EquipoDaoImpl();

    @Override
    public EquipoDto listarPorCuit(int cuit) {
        return convertirEquipoADTO(eqdao.listarPorCuit(cuit));
    }

    @Override
    public List<EquipoDto> listar() {
        List<EquipoDto> listado_equipos = new ArrayList();
        
        eqdao.listar().forEach(e -> listado_equipos.add(convertirEquipoADTO(e)));
        
        return listado_equipos;
    }

    @Override
    public boolean insertar(EquipoDto edto) {
        return eqdao.insertar(convertirDTOAEquipo(edto));
    }

    @Override
    public boolean editar(EquipoDto edto) {
        return eqdao.editar(convertirDTOAEquipo(edto));
    }

    @Override
    public boolean delete(int cuit) {
        return eqdao.delete(cuit);
    }
    
    public EquipoDto convertirEquipoADTO(Equipo e) {
        EquipoDto edto = new EquipoDto();
        edto.setCuit(e.getCuit());
        edto.setNombre(e.getNombre());
        edto.setCategoria_actual(e.getCategoria_actual());
        return edto;
    }
    
    public Equipo convertirDTOAEquipo(EquipoDto eqdto) {
        Equipo e = new Equipo();
        e.setCuit(eqdto.getCuit());
        e.setNombre(eqdto.getNombre());
        e.setCategoria_actual(eqdto.getCategoria_actual());
        return e;
    }
    
    public List<JugadorDto> contarJugadoresPorEquipo(EquipoDto e) {
        List<JugadorDto> lista_jugadores = new ArrayList();
        
        if (e.getListado_jugadores() != null && e.getListado_jugadores().size() > 0) {
            e.getListado_jugadores().forEach(j -> {
                j.getListado_historiales().forEach(h -> {
                    if (e.getCuit().equals(h.getCuit_equipo()) && (h.getFecha_fin() == null || h.getFecha_fin().isAfter(LocalDate.now()))) {
                        lista_jugadores.add(j);
                    }
                });
            });
        }
        return lista_jugadores;
    }
    
    public List<JugadorDto> contarJugadorPorPosicion(EquipoDto e, Posicion posicion) {
        List<JugadorDto> lista_filtrada = new ArrayList();
        
        if (e.getListado_jugadores().size() > 0) {
            e.getListado_jugadores().forEach(j -> {
                if (j.getListado_historiales() != null && j.getListado_historiales().size() > 0) {
                    j.getListado_historiales().forEach(h -> {
                        if (e.getCuit().equals(h.getCuit_equipo()) && h.getPosicion_jugador().getNombre_posicion().equals(posicion.getNombre_posicion()) && (h.getFecha_fin() == null || h.getFecha_fin().isAfter(LocalDate.now()))) {
                            lista_filtrada.add(j);
                        }
                    });
                }
            });
        }
        return lista_filtrada;
    }
    
    public List<JugadorDto> cuantosJugadoresJugabanDuranteUnaFecha(EquipoDto e, LocalDate fecha) {
        List<JugadorDto> lista_filtrada = new ArrayList();
        
        if (e.getListado_jugadores().size() > 0) {
            e.getListado_jugadores().forEach(j -> {
                if (j.getListado_historiales() != null && j.getListado_historiales().size() > 0) {
                    j.getListado_historiales().forEach(h -> {
                        if (e.getCuit().equals(h.getCuit_equipo()) && h.getFecha_inicio().isBefore(fecha) && (h.getFecha_fin() == null || h.getFecha_fin().isAfter(fecha))) {
                            lista_filtrada.add(j);
                        }
                    });
                }
            });
        } 
        return lista_filtrada;
    }
    
}