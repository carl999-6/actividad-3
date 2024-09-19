/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Carlo
 */
public class docente extends persona {
    private int id;
    private String cod,ingreso, registro,salario;
    
    conexion cn;
    
    public docente(){}
    public docente(int id,String nit, String nombre, String apellidos, String direcciones, String telefono, String fehca_nacimiento, String cod, String salario, String ingreso, String registro) {
        super(nit,nombre, apellidos, direcciones, telefono, fehca_nacimiento);
        this.id = id;
        this.cod = cod;
        this.ingreso = ingreso;
        this.registro = registro;
        this.salario = salario;

    }

    public void crear (){
        try {
            PreparedStatement parametros;
            cn = new conexion();
            cn.abrir_conexion();
            String qery = "INSERT INTO persona(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento,codigo_docente,salario,fecha_ingreso_laborar, fecha_ingreso_registro)VALUES(?,?,?,?,?,?,?,?,?,?);";
            parametros = (PreparedStatement) cn.conexionBD.prepareStatement(qery);
parametros.setString(1, getNit());
parametros.setString(2, getNombre());
parametros.setString(3, getApellidos());
parametros.setString(4, getDireccion());
parametros.setString(5, getTelefono());
parametros.setString(6, getFehca_nacimiento());
parametros.setString(7, getCod());
parametros.setString(8, getSalario());
parametros.setString(9, getIngreso());
parametros.setString(10, getRegistro());


int ejecutar = parametros.executeUpdate();
System.out.println("ingreso exitoso");

            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println("error en crear" + ex.getMessage());
        }
    }
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new conexion();
            cn.abrir_conexion();
            
            String qery = "SELECT * FROM persona;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(qery);
            String encabezado[] = {"id_docente", "nit", "nombres", "apellidos", "direccion", "telefono"," fecha_nacimiento","codigo_docente","salario","fecha_ingreso_laborar","fecha_ingreso_registro"};
            tabla.setColumnIdentifiers(encabezado);
            String datos [] = new String [11];
            while(consulta.next()){
            datos [0] = consulta.getString("id_docente");
            datos [1] = consulta.getString("nit");
            datos [2] = consulta.getString("nombres");
            datos [3] = consulta.getString("apellidos");
            datos [4] = consulta.getString("direccion");
            datos [5] = consulta.getString("telefono");
            datos [6] = consulta.getString("fecha_nacimiento");
            datos [7] = consulta.getString("codigo_docente");
            datos [8] = consulta.getString("salario");
            datos [9] = consulta.getString("fecha_ingreso_laborar");
            datos [10] = consulta.getString("fecha_ingreso_registro");
            tabla.addRow(datos);
            }
            cn.cerrar_conexion();
        } catch (SQLException ex) {
            cn.cerrar_conexion();
            System.out.println("error en leer" + ex.getMessage());
        }
    return tabla;
    }
    
    public void actualizar (){
     try {
            PreparedStatement parametros;
            cn = new conexion();
            cn.abrir_conexion();
            String qery = "UPDATE persona SET nit=?, nombres=?, apellidos=?, direccion=?, telefono=?, fecha_nacimiento=?, codigo_docente=?, salario=?, fecha_ingreso_laborar=?, fecha_ingreso_registro=? WHERE id_docente = ?;";
            parametros = (PreparedStatement) cn.conexionBD.prepareStatement(qery);
            parametros.setString(1, getNit());
            parametros.setString(2, getNombre());
            parametros.setString(3, getApellidos());
            parametros.setString(4, getDireccion());
            parametros.setString(5, getTelefono());
            parametros.setString(6, getFehca_nacimiento());
            parametros.setString(7, getCod());
            parametros.setString(8, getSalario());
            parametros.setString(9, getIngreso());
            parametros.setString(10, getRegistro());
            parametros.setInt(11, getId());




int ejecutar = parametros.executeUpdate();
System.out.println("modificacion exitosa");

            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println("error al modificar" + ex.getMessage());
        }
    }
    
    public void borrar (){
     try {
            PreparedStatement parametros;
            cn = new conexion();
            cn.abrir_conexion();
            String qery = "DELETE FROM persona WHERE id_docente = ?;";
            parametros = (PreparedStatement) cn.conexionBD.prepareStatement(qery);
            parametros.setInt(1, getId());
            
int ejecutar = parametros.executeUpdate();
System.out.println("eliminacion exitosa");

            cn.cerrar_conexion();
        } catch (SQLException ex) {
            System.out.println("error al eliminar" + ex.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
     public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

   
}
