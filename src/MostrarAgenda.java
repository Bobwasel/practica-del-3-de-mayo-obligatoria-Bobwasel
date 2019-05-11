import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MostrarAgenda {
	public static void main(String[] args) {
		HashMap<Contacto, List<Item>> agenda = new HashMap<>();
		
		Contacto c1 = new Contacto("Ana");
		ArrayList<Item> informacionAna = new ArrayList<>();
		informacionAna.add(new Item("Teléfono", "9999999"));
		informacionAna.add(new Item("Dirección", "C/ Mayor,8"));
		agenda.put(c1, informacionAna);
		
		Agenda a1 = new Agenda("Agenda", agenda);
		
		Contacto c2 = new Contacto("Bea");
		a1.anyadeContacto(c2);
		a1.anyadeItem(c2, new Item("Teléfono", "6666666"));
		a1.anyadeItem(c2, new Item("Libro Favorito: ", "El Quijote"));
		
		Contacto c3 = new Contacto("Clara");
		ArrayList<Item> informacionClara = new ArrayList<>();
		informacionClara.add(new Item("Comida Favorita: ", "Sushi"));
		a1.anyadeContacto(c3);
		a1.anyadeItem(c3, informacionClara);
		
		System.out.println(a1.listaCompleta());
	}
}
