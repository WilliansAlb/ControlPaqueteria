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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
/**
 *
 * @author willians
 */
public class Controlador {
    Connection cn;
    String usuario = "";
    String puesto = "";
    int repeticion = 0;
    int referencia1 = 0;
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

    public void agregarDatosPaquete(
            String idCreada, int ruta, String punto, 
            String destinatario, String remitente, String tiempo, 
            int tarifa, boolean priori, String nit, int peso) {
        try {
            PreparedStatement preparado = cn.prepareStatement(
                    "INSERT INTO Paquetes("
                            + "id_paquete,"
                            + "ruta,"
                            + "punto,"
                            + "destinatario,"
                            + "remitente,"
                            + "tiempo,"
                            + "tarifa_global,"
                            + "estado,"
                            + "priorizado,"
                            + "nit,"
                            + "peso) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            preparado.setString(1, idCreada);
            preparado.setInt(2, ruta);
            preparado.setString(3, punto);
            preparado.setString(4, destinatario);
            preparado.setString(5, remitente);
            preparado.setString(6, tiempo);
            preparado.setInt(7, tarifa);
            preparado.setBoolean(8, true);
            preparado.setBoolean(9, priori);
            preparado.setString(10, nit);
            preparado.setInt(11, peso);
            preparado.executeUpdate();
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());

        }
    }
   
    public int[] costos(int ruta){
        int[] costosHallados = new int[4];
        
        String sql = "SELECT cuota_destino,cuota_priori,tarifa_peso,tarifa_global FROM Ruta WHERE codigo_ruta = "+ruta;
       
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                costosHallados[0] = rs.getInt("cuota_destino");
                costosHallados[1] = rs.getInt("cuota_priori");
                costosHallados[2] = rs.getInt("tarifa_peso");
                costosHallados[3] = rs.getInt("tarifa_global");
            }
            return costosHallados;
        }
        catch(SQLException e){
        
        }
        return null;
    }
    public void agregarUsuario(String user, String pass, String nombre, String puesto){
        try {
            PreparedStatement preparado = cn.prepareStatement("INSERT INTO Usuarios(user,pass,puesto,nombre) VALUES(?,?,?,?)");
            preparado.setString(1, user);
            preparado.setString(2, pass);
            preparado.setString(3, puesto);
            preparado.setString(4, nombre);
            preparado.executeUpdate();
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());
        }
    }
    
    public void agregarCliente(String nit, String nombre, String ciudad){
        try {
            PreparedStatement preparado = cn.prepareStatement("INSERT INTO Clientes(nit_1,nombre,ciudad) VALUES(?,?,?)");
            preparado.setString(1, nit);
            preparado.setString(2, nombre);
            preparado.setString(3, ciudad);
            preparado.executeUpdate();
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());
        }
    }
    
    public void agregarRuta(int no_puntos, String destino, int cuota_destino, int cuota_priori, int tarifa_peso,boolean estado_ruta, int tarifa_global){
        try {
            PreparedStatement preparado = cn.prepareStatement("INSERT INTO Ruta(no_puntos,destino,cuota_destino,cuota_priori,tarifa_peso,estado_ruta,tarifa_global) VALUES(?,?,?,?,?,?,?)");
            preparado.setInt(1, no_puntos);
            preparado.setString(2, destino);
            preparado.setInt(3,cuota_destino);
            preparado.setInt(4,cuota_priori);
            preparado.setInt(5,tarifa_peso);
            preparado.setBoolean(6, true);
            preparado.setInt(7, tarifa_global);
            preparado.executeUpdate();
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());
        }
    }
    
    public void agregarPunto(int id_ruta, String lugar, int no_paquetes, int no_punto, int tarifa,String encargado){
        if (encargado.isBlank()) {
            try {
                PreparedStatement preparado = cn.prepareStatement("INSERT INTO Puntos(id_ruta,id_punto,no_paquetes,no_punto,tarifa,encargado) VALUES(?,?,?,?,?,?)");
                preparado.setInt(1, id_ruta);
                preparado.setString(2, lugar);
                preparado.setInt(3, no_paquetes);
                preparado.setInt(4, no_punto);
                preparado.setInt(5, tarifa);
                preparado.setString(6, null);
                preparado.executeUpdate();
            } catch (SQLException el) {
                System.out.println("Falló la inserción a la base de datos" + el.getMessage());
            }
        } else {
            try {
                PreparedStatement preparado = cn.prepareStatement("INSERT INTO Puntos(id_ruta,id_punto,no_paquetes,no_punto,tarifa,encargado) VALUES(?,?,?,?,?,?)");
                preparado.setInt(1, id_ruta);
                preparado.setString(2, lugar);
                preparado.setInt(3, no_paquetes);
                preparado.setInt(4, no_punto);
                preparado.setInt(5, tarifa);
                preparado.setString(6, encargado);
                preparado.executeUpdate();
            } catch (SQLException el) {
                System.out.println("Falló la inserción a la base de datos" + el.getMessage());
            }
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
            //agregarDatosPaquete(idCreada, peso1, destinatario, remitente,identidadRuta);
            String mensaje = "<html><body>Listo, el codigo de tu paquete es: <br>" + idCreada + "</body></html>";
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            crearIDPaquete(destinatario, remitente, destino1, peso);
        }
    }
    public String[] clienteNit(String nit){
        String[] datosHallados = new String[2];
        int hay = 0;
        try {
            Statement st2;
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT COUNT(*) AS TOTAL FROM Clientes WHERE nit_1 = '"+nit+"'");
            while (rs2.next())
            {
                hay = Integer.parseInt(rs2.getString("TOTAL"));
            }
        } catch (SQLException sqe){
        
        }
        if (hay == 1) {
            String sql = "SELECT nombre,ciudad FROM Clientes WHERE nit_1 = '" + nit + "'";

            Statement st;
            try {
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datosHallados[0] = rs.getString("nombre");
                    datosHallados[1] = rs.getString("ciudad");
                }
                return datosHallados;
            } catch (SQLException e) {

            }
        } else {
            datosHallados[0] = "nuevo";
            return datosHallados;
        }
        
        return datosHallados;
    }
    public void agregarABodega(int ruta, int referencia) {

        int hay = 0;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT COUNT(*) AS TOTAL FROM "
                    + "Bodega WHERE Numero = " + referencia);
            ResultSet resultado = preparada2.executeQuery();
            while (resultado.next()) {
                hay = Integer.parseInt(resultado.getString("TOTAL"));
            }

            if (hay > 0) {
                if (repeticion == 0) {
                    repeticion++;
                    agregarABodega(ruta,(referencia + 1));
                    PreparedStatement preparada1 = cn.prepareStatement("SELECT Codigo_Paquete "
                            + "FROM Bodega WHERE Numero = " + referencia1);
                    ResultSet resultado1 = preparada1.executeQuery();
                    String lugar1 = "";
                    while (resultado1.next()) {
                        lugar1 = resultado1.getString("Codigo_Paquete");
                    }
                    eliminando("UPDATE Bodega SET Numero =" + (referencia) + ", Priorizado = true WHERE Codigo_Paquete = '" + lugar1 + "'");
                } else {
                    agregarABodega(ruta,(referencia + 1));
                    PreparedStatement preparada1 = cn.prepareStatement("SELECT Codigo_Paquete "
                            + "FROM Bodega WHERE Numero = " + referencia);
                    ResultSet resultado1 = preparada1.executeQuery();
                    String lugar1 = "";
                    while (resultado1.next()) {
                        lugar1 = resultado1.getString("Codigo_Paquete");
                    }
                    eliminando("UPDATE Bodega SET Numero =" + (referencia + 1) + " WHERE Codigo_Paquete = '" + lugar1 + "'");
                }

            } else {
                System.out.print("nada");
            }
        } catch (SQLException le) {
            System.out.print(le.getMessage());
        }
    }
    public void agregarABodega1(String codigo, int ruta, boolean priori){
        System.out.print(regresandoUltimo()+"");
        if (regresandoCuantosTiene() == 0) {
            try {
                PreparedStatement preparado = cn.prepareStatement("INSERT INTO Bodega(Codigo_Paquete,Ruta,Priorizado,Numero) VALUES(?,?,?,?)");
                preparado.setString(1, codigo);
                preparado.setInt(2, ruta);
                preparado.setBoolean(3, priori);
                preparado.setInt(4, 1);
                preparado.executeUpdate();
            } catch (SQLException el) {
                System.out.println(el.getMessage());
            }
        } else {
            try {
                PreparedStatement preparado = cn.prepareStatement("INSERT INTO Bodega(Codigo_Paquete,Ruta,Priorizado,Numero) VALUES(?,?,?,?)");
                preparado.setString(1, codigo);
                preparado.setInt(2, ruta);
                preparado.setBoolean(3, false);
                preparado.setInt(4, regresandoUltimo());
                preparado.executeUpdate();
            } catch (SQLException el) {
                System.out.println(el.getMessage());
            }
        }
        int inicio = 0;
        try {
            PreparedStatement preparado = cn.prepareStatement("SELECT Numero FROM Bodega WHERE Codigo_Paquete = '"+codigo+"'");
            ResultSet rs = preparado.executeQuery();
            while (rs.next()){
                inicio = rs.getInt("Numero");
            }
        } catch (SQLException el) {
            System.out.println("Falló la inserción a la base de datos" + el.getMessage());
        }
        this.referencia1 = inicio;
        int referencia = regresandoUltimoPriorizado();
        System.out.println("inicio = "+referencia1 +" y donde quiero meterlo ="+(referencia+1)+codigo);
        if (priori){
            agregarABodega(ruta,referencia+1);
        }
    }
    public int regresandoUltimoPriorizado(){
        int final1 = 0;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT Numero FROM Bodega WHERE Priorizado = true");
            ResultSet resultado = preparada2.executeQuery();
            while (resultado.next()) {
                final1 = resultado.getInt("Numero");
            }
            return (final1);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return final1;
    }
    public int regresandoUltimo(){
        int final1 = 0;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT Numero FROM Bodega ORDER BY Numero DESC LIMIT 1");
            ResultSet resultado = preparada2.executeQuery();
            while (resultado.next()) {
                final1 = resultado.getInt("Numero");
            }
            return (final1+1);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return final1;
    }
    public int regresandoCuantosTiene() {
        int hay = 0;
        try {
            Statement st2;
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT COUNT(*) AS TOTAL FROM Bodega");
            while (rs2.next()) {
                hay = Integer.parseInt(rs2.getString("TOTAL"));
            }
            return hay;
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hay;
    }
    public void agregarAGanancias(String codigo, int ruta, int costoInicio, String fecha){
    
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
            PreparedStatement preparada2 = cn.prepareStatement("SELECT destinatario FROM Paquetes WHERE id_paquete = ?");
            PreparedStatement preparada3 = cn.prepareStatement("SELECT codigo_ruta FROM Ruta WHERE destino = '"+destino1+"'");
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
                identidadRuta = resultado2.getInt("codigo_ruta");
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
    
    public void eliminando(String sql){
        try {
            PreparedStatement preparado = cn.prepareStatement(sql);
            preparado.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean estaVacio(int ruta){
        int hay = 0;
        try {
            Statement st2;
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT COUNT(*) AS TOTAL FROM Paquetes WHERE ruta = "+ ruta);
            while (rs2.next())
            {
                hay = Integer.parseInt(rs2.getString("TOTAL"));
            }
            return hay>0;
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void cambiandoDestino(ControlAdmin admin){
        String sql = "SELECT Destino FROM Ruta";
       
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                String destino1 = rs.getString(1);
                admin.getCombo_Destinos().addItem(destino1);
            }
        }
        catch(SQLException e){
        
        }
    }
    
    public void cambiandoEncargados(ControlAdmin admin2){
        String ope = "OPERADOR";
        String sql = "SELECT user FROM Usuarios WHERE puesto = '"+ope+"'";
       
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                String destino1 = rs.getString(1);
                admin2.getCombo_Encargados().addItem(destino1);
                admin2.getCombo_Encargados2().addItem(destino1);
            }
        }
        catch(SQLException e){
        
        }
    }
    
    public int ruta(String destino){
        String sql = "SELECT codigo_ruta FROM Ruta WHERE destino = '"+destino+"'";
        int numero = 0; 
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                numero = rs.getInt("codigo_ruta");
            }
        }
        catch(SQLException e){
        
        }
        return numero;
    }
    
    public boolean verificarLimite(int i, ControlAdmin adm){
        String sql = "SELECT no_puntos FROM Ruta WHERE codigo_ruta = "+i;
        Statement st;
        Statement st2;
        int limite = 0;
        int existen = 0;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                limite = rs.getInt("no_puntos");
                
            }
            st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT COUNT(*) AS TOTAL FROM Puntos WHERE id_ruta = "+i);
            while (rs2.next())
            {
                existen = Integer.parseInt(rs2.getString("TOTAL"));
            }
            adm.setLimiteRuta(limite);
            return existen<=limite;
        }
        catch(SQLException e){
            System.out.print(e.getMessage());
        }
        return false;
    }
    
    public String lugarPunto(String punto) {
        char guion = '-';
        String numeros = "0123456789";
        int hay = 0;
        boolean sigue = false;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT COUNT(*) AS TOTAL FROM Puntos WHERE id_punto = '" + punto + "'");
            ResultSet resultado = preparada2.executeQuery();
            while (resultado.next()) {
                hay = Integer.parseInt(resultado.getString("TOTAL"));
            }
            if (hay > 0) {
                int posicionGuion = 0;
                for (int i = 0; i < punto.length(); i++) {
                    if (punto.charAt(i) == guion) {
                        posicionGuion = i;
                        sigue = true;
                        break;
                    }
                }
                if (sigue) {
                    String numeroObtenido = "";
                    for (int u = (posicionGuion + 1); u < punto.length(); u++) {
                        numeroObtenido += punto.charAt(u);
                    }
                    int numero = Integer.parseInt(numeroObtenido);
                    String nuevoPunto = "";
                    for (int u = 0; u < posicionGuion; u++) {
                        nuevoPunto += punto.charAt(u);
                    }
                    numero += 1;
                    return nuevoPunto + "-" + numero;
                } else {
                    punto += "-2";
                    return punto;
                }
            } else {
                return punto;
            }
        } catch (SQLException le) {
            System.out.print(le.getMessage());
        }
        return punto;
    }
    
    public void acomodando(int referencia, int ruta){
        int hay = 0;
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT COUNT(*) AS TOTAL FROM Puntos WHERE id_ruta = " + ruta + " AND no_punto ="+referencia);
            ResultSet resultado = preparada2.executeQuery();
            while (resultado.next()) {
                hay = Integer.parseInt(resultado.getString("TOTAL"));
            }
            
            if (hay > 0) {
                acomodando((referencia+1),ruta);
                PreparedStatement preparada1 = cn.prepareStatement("SELECT id_punto FROM Puntos WHERE id_ruta = " + ruta + " AND no_punto =" + referencia);
                ResultSet resultado1 = preparada1.executeQuery();
                String lugar1 = "";
                while (resultado1.next()) {
                    lugar1 = resultado1.getString("id_punto");
                }
                eliminando("UPDATE Puntos SET no_punto ="+(referencia+1)+" WHERE id_punto = '"+lugar1+"'");
            } else{
                System.out.print("nada");
            }
        } catch (SQLException le) {
            System.out.print(le.getMessage());
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
    
    public boolean existe_Usuario(String user){
        try {
            PreparedStatement preparada2 = cn.prepareStatement("SELECT nombre FROM Usuarios WHERE user = ?");
            preparada2.setString(1, user);
            ResultSet resultado = preparada2.executeQuery();
            if (!resultado.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Ese user le pertenece a "+ resultado.getString("nombre"));
                return false;
            }
        }catch (SQLException es){
            return false;
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
