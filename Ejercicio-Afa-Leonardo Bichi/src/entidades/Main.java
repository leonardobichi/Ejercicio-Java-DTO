package entidades;

import Dto.EquipoDto;
import Dto.JugadorDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import services.EquipoServicesImpl;
import services.JugadorServicesImpl;

public class Main {
    
    public static void main(String[] args) {
        
//Services

        EquipoServicesImpl eservice = new EquipoServicesImpl();
        JugadorServicesImpl jservice = new JugadorServicesImpl();
        
//Lista Equipos

        List<EquipoDto> listado_equipos = eservice.listar();
        
//Lista Jugadores

        List<JugadorDto> listado_jugadores = jservice.listar();

//Asignar jugadores a cada equipo

        listado_equipos.forEach(e -> {
            e.setListado_jugadores(new ArrayList());
            listado_jugadores.forEach(j -> {
                if (j.getListado_historiales() != null) {
                    j.getListado_historiales().forEach(h -> {
                        if (h.getCuit_equipo().equals(e.getCuit())) {
                            e.agregarJugador(j);
                        }
                    });
                }
            });
        });
        
//Cantidad de jugadores de cada equipo ordenado alfabeticamente

        Collections.sort(listado_equipos, (EquipoDto e1, EquipoDto e2) -> e1.getNombre().compareTo(e2.getNombre()));
        listado_equipos.forEach(e -> {
            List<JugadorDto> listado = eservice.contarJugadoresPorEquipo(e);
            if (listado != null && listado.size() > 0) {
                System.out.println("\n" + e.getNombre() + " tiene " + listado.size() + " jugadores:");
                listado.forEach(System.out::println);
            }
        });
        
//Defensores de cada equipo    

        listado_equipos.forEach(e -> {
            List<JugadorDto> listado = eservice.contarJugadorPorPosicion(e, Posicion.DEFENSOR);
            if (listado != null && listado.size() > 0) {
                System.out.println("\n" + e.getNombre() + " tiene " + listado.size() + " defensores:");
                listado.forEach(System.out::println);
            }
        });
        
//Jugadores que jugaron durante cierta fecha 

        listado_equipos.forEach(e -> {
            LocalDate fecha = LocalDate.of(2018, 9, 7);
            List<JugadorDto> listado = eservice.cuantosJugadoresJugabanDuranteUnaFecha(e, fecha);
            if (listado != null && listado.size() > 0) {
                System.out.println("\nEn la " + fecha + " jugaron " + listado.size() + " jugadores en " + e.getNombre() + ":");
                listado.forEach(System.out::println);
            }
        });
    }
}