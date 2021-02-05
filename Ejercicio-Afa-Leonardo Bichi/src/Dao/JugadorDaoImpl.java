package Dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Jugador;

public class JugadorDaoImpl implements JugadorDao {

    @Override
    public Jugador listarPorDNI(int dni) {
        ConexionBD conex = new ConexionBD();
        String sql = "SELECT * FROM jugadores WHERE dni = " + dni;
        Jugador j = new Jugador();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    j.setDni(rs.getInt(1));
                    j.setNombre(rs.getString(2));
                    j.setApellido(rs.getString(3));
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
        return j;
    }

    @Override
    public List<Jugador> listar() {
        ConexionBD conex = new ConexionBD();
        String sql = "SELECT * FROM jugadores";
        List<Jugador> listado_jugadores = new ArrayList();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Jugador j = new Jugador();
                    j.setDni(rs.getInt(1));
                    j.setNombre(rs.getString(2));
                    j.setApellido(rs.getString(3));
                    listado_jugadores.add(j);
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
        return listado_jugadores;
    }

    @Override
    public boolean insertar(Jugador j) {
        ConexionBD conex = new ConexionBD();
        String sql = "INSERT INTO jugadores VALUES (" + j.getDni() + ", '" + j.getNombre() + "', '" + j.getApellido() + "')";
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean editar(Jugador j) {
        ConexionBD conex = new ConexionBD();
        String sql = "UPDATE jugadores SET dni = " + j.getDni() + ", nombre = '" + j.getNombre() + "', apellido = '" + j.getApellido() + "' WHERE dni = " + j.getDni();
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int dni) {
        ConexionBD conex = new ConexionBD();
        String sql = "DELETE FROM jugadores WHERE dni = " + dni;
        
        try (Connection con = conex.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
        return true;
    }
    
}
