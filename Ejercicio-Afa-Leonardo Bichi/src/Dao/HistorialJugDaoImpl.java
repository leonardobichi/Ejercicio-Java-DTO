package Dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.HistorialJugador;
import entidades.Posicion;

public class HistorialJugDaoImpl implements HistorialJugDao {

    @Override
    public List<HistorialJugador> listarPorDNI(int dni) {
        ConexionBD conex = new ConexionBD();
        List<HistorialJugador> listado_historiales = new ArrayList();
        String sql = "SELECT * FROM historial_jugadores WHERE dni_jugador = " + dni;
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery() ) {
                while (rs.next()) {
                    HistorialJugador h = new HistorialJugador();
                    h.setDni_jugador(rs.getInt(2));
                    h.setCuit_equipo(rs.getInt(3));
                    if (rs.getDate(4) != null) h.setFecha_inicio(rs.getDate(4).toLocalDate());
                    if (rs.getDate(5) != null) h.setFecha_fin(rs.getDate(5).toLocalDate());
                    if (rs.getString(6).equals("DELANTERO")) h.setPosicion_jugador(Posicion.DELANTERO);
                    if (rs.getString(6).equals("DEFENSOR")) h.setPosicion_jugador(Posicion.DEFENSOR);
                    if (rs.getString(6).equals("MEDIOCAMPISTA")) h.setPosicion_jugador(Posicion.MEDIOCAMPISTA);
                    if (rs.getString(6).equals("ARQUERO")) h.setPosicion_jugador(Posicion.ARQUERO);
                    listado_historiales.add(h);
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return listado_historiales;
    }

    @Override
    public List<HistorialJugador> listarPorCUIT(int cuit) {
        ConexionBD conex = new ConexionBD();
        List<HistorialJugador> listado_historiales = new ArrayList();
        String sql = "SELECT * FROM historial_jugadores WHERE cuit_equipo = " + cuit;
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery() ) {
                while (rs.next()) {
                    HistorialJugador h = new HistorialJugador();
                    h.setDni_jugador(rs.getInt(2));
                    h.setCuit_equipo(rs.getInt(3));
                    if (rs.getDate(4) != null) h.setFecha_inicio(rs.getDate(4).toLocalDate());
                    if (rs.getDate(5) != null) h.setFecha_fin(rs.getDate(5).toLocalDate());
                    if (rs.getString(6).equals("DELANTERO")) h.setPosicion_jugador(Posicion.DELANTERO);
                    if (rs.getString(6).equals("DEFENSOR")) h.setPosicion_jugador(Posicion.DEFENSOR);
                    if (rs.getString(6).equals("MEDIOCAMPISTA")) h.setPosicion_jugador(Posicion.MEDIOCAMPISTA);
                    if (rs.getString(6).equals("ARQUERO")) h.setPosicion_jugador(Posicion.ARQUERO);
                    listado_historiales.add(h);
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return listado_historiales;
    }

    @Override
    public boolean insertar(HistorialJugador h) {
        ConexionBD conex = new ConexionBD();
        String sql = "INSERT INTO historial_jugadores (dni_jugador, cuit_equipo, fecha_inicio, fecha_fin, posicion) VALUES (" + h.getDni_jugador() + ", " + h.getCuit_equipo() + ", " + (h.getFecha_inicio() != null ? "'" + h.getFecha_inicio().toString() + "'" : "NULL") + ", " + (h.getFecha_fin() != null ? "'" + h.getFecha_fin().toString() + "'" : "NULL") + ", '" + h.getPosicion_jugador() + "')";
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(HistorialJugador h) {
        ConexionBD conex = new ConexionBD();
        String sql = "UPDATE historial_jugadores SET dni_jugador = " + h.getDni_jugador() + ", cuit_equipo = " + h.getCuit_equipo() + ", fecha_inicio = " + (h.getFecha_inicio() != null ? "'" + h.getFecha_inicio().toString() + "'" : "NULL") + ", fecha_fin = " + (h.getFecha_fin() != null ? "'" + h.getFecha_fin().toString() + "'" : "NULL") + ", posicion = '" + h.getPosicion_jugador() + "' WHERE dni = " + h.getDni_jugador();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        } 
        return true;
    }

    @Override
    public boolean delete(int dni) {
        ConexionBD conex = new ConexionBD();
        String sql = "DELETE FROM historial_jugadores WHERE dni = " + dni;
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return true;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }
    
}
