package services;

import Dao.JugadorDaoImpl;
import Dto.JugadorDto;
import java.util.ArrayList;
import java.util.List;
import entidades.Jugador;

public class JugadorServicesImpl implements JugadorServices {
    
    JugadorDaoImpl jugdao = new JugadorDaoImpl();
    HistorialJugServicesImpl hservice = new HistorialJugServicesImpl();

    @Override
    public JugadorDto listarPorDNI(int dni) {
        JugadorDto jugdto = convertirJugadorADTO(jugdao.listarPorDNI(dni)); 
        if (hservice.listarPorDNI(jugdto.getDni()) != null) { 
            jugdto.setListado_historiales(hservice.listarPorDNI(jugdto.getDni()));
        }
        return jugdto;
    }

    @Override
    public List<JugadorDto> listar() {
        List<JugadorDto> listado_jugadores = new ArrayList();
        
        jugdao.listar().forEach(jug -> listado_jugadores.add(convertirJugadorADTO(jug)));
        listado_jugadores.forEach(jug -> {
            if (hservice.listarPorDNI(jug.getDni()) != null) { 
                jug.setListado_historiales(hservice.listarPorDNI(jug.getDni()));
            }
        });
        
        return listado_jugadores;
    }

    @Override
    public boolean insertar(JugadorDto jugdto) {
        return jugdao.insertar(convertirDTOAJugador(jugdto));
    }

    @Override
    public boolean editar(JugadorDto jugdto) {
        return jugdao.editar(convertirDTOAJugador(jugdto));
    }

    @Override
    public boolean delete(int dni) {
        return jugdao.delete(dni);
    }
    
    public JugadorDto convertirJugadorADTO(Jugador j) {
        JugadorDto jugdto = new JugadorDto();
        jugdto.setDni(j.getDni());
        jugdto.setNombre(j.getNombre());
        jugdto.setApellido(j.getApellido());
        return jugdto;
    }
    
    public Jugador convertirDTOAJugador(JugadorDto jdto) {
        Jugador jug = new Jugador();
        jug.setDni(jdto.getDni());
        jug.setNombre(jdto.getNombre());
        jug.setApellido(jdto.getApellido());
        return jug;
    }
    
}
