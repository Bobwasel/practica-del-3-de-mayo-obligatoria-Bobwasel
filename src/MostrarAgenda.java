import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MostrarAgenda {
	private static Agenda agenda;
	
	public static void anyadir() {
		String nombre = JOptionPane.showInputDialog(null,"Nombre?");
		int cantidadItems = Integer.parseInt(JOptionPane.showInputDialog(null,"Cuántos items desea añadir?"));
		Contacto c = new Contacto(nombre);
		agenda.anyadeContacto(c);
		for (int i=0; i<cantidadItems; i++ ) {
			String nombreItem = JOptionPane.showInputDialog(null,"Nombre?");
			String datoItem = JOptionPane.showInputDialog(null, "Dato");
			Item guardaItem = new Item(nombreItem, datoItem);
			agenda.anyadeItem(c, guardaItem);
		}
	}
	
	public static void leerFichero() {
		File fichero = new File("./tresDeMayo");
		if(fichero.exists()) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(fichero.getPath()));
			agenda = (Agenda) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		} else {
			JOptionPane.showMessageDialog(null, "Aún no ha creado el fichero.");
		}
		
	}
	
	public static void escribirFichero() {
		File fichero = new File("./tresDeMayo");
		if(!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichero.getPath()));
			oos.writeObject(agenda);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		HashMap<Contacto, List<Item>> listacontactos = new HashMap<>();
		
		Contacto c1 = new Contacto("Ana");
		ArrayList<Item> informacionAna = new ArrayList<>();
		informacionAna.add(new Item("Teléfono", "9999999"));
		informacionAna.add(new Item("Dirección", "C/ Mayor,8"));
		listacontactos.put(c1, informacionAna);
		
		agenda = new Agenda("Agenda", listacontactos);
		
		Contacto c2 = new Contacto("Bea");
		agenda.anyadeContacto(c2);
		agenda.anyadeItem(c2, new Item("Teléfono", "6666666"));
		agenda.anyadeItem(c2, new Item("Libro Favorito: ", "El Quijote"));
		
		Contacto c3 = new Contacto("Clara");
		ArrayList<Item> informacionClara = new ArrayList<>();
		informacionClara.add(new Item("Comida Favorita: ", "Sushi"));
		agenda.anyadeContacto(c3);
		agenda.anyadeItem(c3, informacionClara);
		
		System.out.println(agenda.listaCompleta());
		Ventana ventana = new Ventana();
		JPanel panel = new JPanel();
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(4,0,20,20));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		Map<JButton, ActionListener> botones=new HashMap<>();
        botones.put(new JButton("Mostrar"), e -> JOptionPane.showMessageDialog(null,agenda.listaCompleta()));
        botones.put(new JButton("Añadir"),e->anyadir());
        botones.put(new JButton("Leer de Fichero"),e->leerFichero());
        botones.put(new JButton("Escribir en Fichero"),e->escribirFichero());
        for(Map.Entry<JButton,ActionListener> boton:
            botones.entrySet()){
            boton.getKey().setMargin(new Insets(20, 20, 20, 20));
            boton.getKey().addActionListener(boton.getValue());
            panel.add(boton.getKey());
        } 
        ventana.add(panel);
	}
}
