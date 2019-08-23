/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paqueteria;

import java.util.Random;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JLabel;
/**
 *
 * @author willians
 */
public class Controlador {
    Connection cn;
    String usuario = "";
    String puesto = "";
    
    public Controlador() {
        
        String user = "root";
        String password = "[Cristeptesico_65]";
        String url = "jdbc:mysql://localhost:3306/prueba1";
        try {
            cn = DriverManager.getConnection(url, user, password);
            //declaracion = cn.createStatement();
            //resultado = declaracion.executeQuery("SELECT * FROM Cliente");
        } catch (SQLException e) {
            System.out.println("Falló la conexión a la base de datos");
        }

    }

    public void agregarDatosPaquete(String idCreada, String peso1, String destinatario, String remitente, int ruta2) {
        try {
            PreparedStatement preparado = cn.prepareStatement("INSERT INTO paquete(Id_Paquete,Peso_Paquete,Destinatario,Remitente,PuntoControl,Priorizado,Ruta) VALUES(?,?,?,?,?,?,?)");
            preparado.setString(1, idCreada);
            preparado.setString(2, peso1);
            preparado.setString(3, destinatario);
            preparado.setString(4, remitente);
            preparado.setInt(5, 3);
            preparado.setBoolean(6, true);
            preparado.setInt(7, ruta2);
            preparado.executeUpdate();
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());

        }

    }

    public void crearIDPaquete(String destinatario, String remitente, String destino1, int peso) {
        String idPos = "ABCDEFGHIJKLMNOPQRSTUWXYZ1234567890";
        String idCreada = "";
        String peso1 = "" + peso;
        boolean paso = false;
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Random aleatorio = new Random(System.currentTimeMillis());
            int numeroElegido = aleatorio.nextInt(idPos.length());
            idCreada += idPos.charAt(numeroElegido);
        }
        int identidadRuta = 0;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT Destinatario FROM paquete WHERE Id_Paquete = ?");
            PreparedStatement preparada3 = cn.prepareStatement("SELECT Id_Ruta FROM Ruta WHERE Destino = '"+destino1+"'");
            preparada2.setString(1, idCreada);
            ResultSet resultado = preparada2.executeQuery();
            ResultSet resultado2 = preparada3.executeQuery();
            if (!resultado.next()) {
                paso = true;
            } else {
                System.out.print("Ya existe ese id");
            }
            while(resultado2.next())
            {
                identidadRuta = resultado2.getInt("Id_Ruta");
            }
        } catch (SQLException le) {
            System.out.print(le.getMessage());
        }

        if (paso) {
            agregarDatosPaquete(idCreada, peso1, destinatario, remitente,identidadRuta);
            String mensaje = "<html><body>Listo, el codigo de tu paquete es: <br>" + idCreada + "</body></html>";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            crearIDPaquete(destinatario, remitente, destino1, peso);
        }
    }
    public String crearIdPaquete(String destino1){
    String idPos = "ABCDEFGHIJKLMNOPQRSTUWXYZ1234567890";
        String idCreada = "";
        boolean paso = false;
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            Random aleatorio = new Random(System.currentTimeMillis());
            int numeroElegido = aleatorio.nextInt(idPos.length());
            idCreada += idPos.charAt(numeroElegido);
        }
        int identidadRuta = 0;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT Destinatario FROM paquete WHERE Id_Paquete = ?");
            PreparedStatement preparada3 = cn.prepareStatement("SELECT Id_Ruta FROM Ruta WHERE Destino = '"+destino1+"'");
            preparada2.setString(1, idCreada);
            ResultSet resultado = preparada2.executeQuery();
            ResultSet resultado2 = preparada3.executeQuery();
            if (!resultado.next()) {
                paso = true;
                return idCreada;
            } else {
                System.out.print("Ya existe ese id");
            }
            while(resultado2.next())
            {
                identidadRuta = resultado2.getInt("Id_Ruta");
            }
        } catch (SQLException le) {
            System.out.print(le.getMessage());
        }
        if (paso) {
            String mensaje = "<html><body>Listo, el codigo de tu paquete es: <br>" + idCreada + "</body></html>";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            crearIdPaquete(destino1);
        }
        return null;
    }
    public boolean identificar(String busqueda, String contra) {
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT pass, puesto FROM Usuarios WHERE user = ?");
            preparada2.setString(1, busqueda);
            ResultSet resultado = preparada2.executeQuery();
            System.out.print("entra acá");
            if (resultado.next()) {
                String contra_Hallada = resultado.getString("pass");
                if (contra_Hallada.equals(contra)) {
                    usuario = busqueda;
                    puesto = resultado.getString("puesto");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
                    return false;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    public void cambiando(NuevoPaquete nuevoPaquete1){
        String sql = "SELECT Destino FROM Ruta";
       
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                String destino1 = rs.getString(1);
                nuevoPaquete1.getCiudadesText().addItem(destino1);
            }
        }
        catch(SQLException e){
        
        }
    }

    public void buscandoPaquete(ControlarPaquete controlandoPaquete){
        String codigo = controlandoPaquete.getEntBusquedaPaquete().getText();
        String sql = "SELECT Ruta,PuntoControl FROM paquete WHERE Id_Paquete ='"+codigo+"'";
        int ruta1 = 0;
        Statement st;
        Statement st2;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                controlandoPaquete.setDondeEsta(rs.getInt("PuntoControl"));
                ruta1 = rs.getInt("Ruta");
            }
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT No_Punto FROM Ruta WHERE Id_Ruta = "+ruta1);
            while (rs2.next())
            {
                controlandoPaquete.setCuantosPuntos(rs2.getInt("No_Punto"));
            }
        }
        catch(SQLException e){
        
        }
        
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
}
