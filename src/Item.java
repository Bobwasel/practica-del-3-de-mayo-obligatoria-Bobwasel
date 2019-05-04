
public class Item {
	private String nombre;
	private String dato;
	
	public Item(String nombre, String dato) {
		this.nombre = nombre;
		this.dato = dato;
	}
	public String getDato() {
		return dato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dato == null) ? 0 : dato.hashCode());
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
		Item other = (Item) obj;
		if (dato == null) {
			if (other.dato != null)
				return false;
		} else if (!dato.equals(other.dato))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Item [nombre=" + nombre + ", dato=" + dato + "]";
	}
}
