/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlo
 */
public class persona {
    
    private String nit,nombres,apellidos,direccion,telefono,fehca_nacimiento;
    //constructores
    public persona(){}
        public persona(String nit, String nombre, String apellidos, String direccion, String telefono, String fehca_nacimiento) {
        this.nit = nit;
        this.nombres = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fehca_nacimiento = fehca_nacimiento;
            }

    //metodos
        
        
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFehca_nacimiento() {
        return fehca_nacimiento;
    }

    public void setFehca_nacimiento(String fehca_nacimiento) {
        this.fehca_nacimiento = fehca_nacimiento;
    }

//merodos Crud
 protected void crear(){}
  protected DefaultTableModel leer(){return null;}
   protected void modificar(){}
   protected void eliminar(){}
}
    

