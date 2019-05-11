import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Agenda implements Serializable {
	private String nombre;
	private Map<Contacto,List<Item>> listaContacto;
	
	public Agenda(String nombre, Map<Contacto, List<Item>> listaContacto) {
		this.nombre = nombre;
		this.listaContacto = listaContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaContacto == null) ? 0 : listaContacto.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (listaContacto == null) {
			if (other.listaContacto != null)
				return false;
		} else if (!listaContacto.equals(other.listaContacto))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public Map<Contacto, List<Item>> getListaContacto() {
		return listaContacto;
	}

	public void setListaContacto(Map<Contacto, List<Item>> listaContacto) {
		this.listaContacto = listaContacto;
	}

	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + ", listaContacto=" + listaContacto + "]";
	}
	
	public void anyadeContacto(Contacto c) {
		listaContacto.put(c, new ArrayList <Item>());
	}
	
	public void anyadeItem(Contacto c, Item i) {
		
		List<Item> guarda = listaContacto.get(c);
		guarda.add(i);
		listaContacto.replace(c, guarda);
	}
	
	public void anyadeItem(Contacto c, List<Item> lista) {
		List<Item> guarda = listaContacto.get(c);
		guarda.addAll(lista);
		listaContacto.replace(c, guarda);
	}
	
	public String listaCompleta() {
		Set<Contacto> contactos = listaContacto.keySet();
		String cadena = "";
		for(Contacto c : contactos) {
			List<Item> guarda = listaContacto.get(c);
			cadena += c + "\n";
			for(Item i : guarda) {
				cadena += i + "\n";
				cadena += "-----------\n";
			}
		}
		return cadena;
	}
	
	public List<Contacto> listadoContacto(){
		Set<Contacto> contactos = listaContacto.keySet();
		List<Contacto> muestraContacto = new ArrayList<Contacto>();
		for(Contacto c : contactos) {
			muestraContacto.add(c);
		}
		return muestraContacto;
	}
	
	public List<Item> listaItem(Contacto c){
		return listaContacto.get(c);
	}
	
	public static void main (String[] args) {
		HashMap<Contacto, List<Item>> agenda = new HashMap<>();
		Contacto c1 = new Contacto("Antonio");
		Agenda a1 = new Agenda("Agenda", agenda);
		
		a1.anyadeContacto(c1);
		a1.anyadeItem(c1, new Item("Dirreción: ", "C/Falsa 123"));
		
		System.out.println(a1.listaCompleta());
	}

}
