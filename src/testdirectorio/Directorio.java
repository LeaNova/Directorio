package testdirectorio;

import java.util.*;

/**
 * @author Leandro Heredia
 */
public class Directorio {
    
    public TreeMap<String, Cliente> registros = new TreeMap<>();

    public Directorio() {
        registros = new TreeMap<>();
    }
    
    public boolean agregarCliente(String tel, Cliente cli) {
        if (registros.containsKey(tel)) {
            return false;
        } else {
            registros.put(tel, cli);
            return true;
        }
    }
    
    public Cliente buscarCliente(String tel) {
        return registros.get(tel);
    }
    
    //Buscar con Apellido --> Lista con numeros de telefono;
    public List<String> buscarTelefono(String ape) {
        ArrayList<String> telefonos = new ArrayList<>();
        
        Set<String> claves = registros.keySet();
        
            for (String key: claves) {
                if (registros.get(key).getApellido().equals(ape)) {
                    telefonos.add(key);
                }
            }
        return telefonos;    
    }
    
    //Buscar con Ciudad --> Lista con los clientes;
    public List<Cliente> buscarClientes(String ciu) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        Collection valores = registros.values();
        Iterator it = valores.iterator();

        while (it.hasNext()){
            Cliente valor = (Cliente)it.next();
            if (valor.getCiudad().equals(ciu)) {
                clientes.add(valor);
            }
        }
        return clientes;
    }
    
    public Object borrarCliente(long dni) {
        String telefono = null;
        
        Set<String> claves = registros.keySet();
        
        for (String key: claves) {
            if (registros.get(key).getDni() == dni) {
                telefono = key;
                break;
            }
        }
        return registros.remove(telefono);
    }
}