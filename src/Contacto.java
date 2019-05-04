
public class Contacto {
	private String nombre;
	
	public Contacto(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Contacto other = (Contacto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + "]";
	}
	
	public static void main(String[] args) {
		Contacto c1 = new Contacto("Pepe");
		
		String nombre = c1.getNombre();
		System.out.println(nombre);
	}
}
