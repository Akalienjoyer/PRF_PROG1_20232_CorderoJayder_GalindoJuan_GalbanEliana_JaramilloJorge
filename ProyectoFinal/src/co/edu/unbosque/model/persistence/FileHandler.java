package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase que controla la apertura, lectura, y guardado de archivos.
 * 
 * @author JorgeJ
 *
 */
public class FileHandler {
	// lectura serializados
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	// escritura serializados
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;
	private static String url = "src/co/edu/unbosque/model/persistence/";

	/**
	 * Constructor vacio del FileHandler.
	 */
	public FileHandler() {
	}

	/**
	 * Abre y lee el archivo (serializado) para extraer todo su contenido, guardarlo
	 * en un String, y devolver este mismo.
	 * 
	 * @param fileName - Nombre del archivo CSV serializado a buscar.
	 * @return
	 */
	public static Object serializableOpenAndReadFile(String fileName) {
		try {
			fis = new FileInputStream(new File(url + fileName));
		} catch (FileNotFoundException e) {
			try {
				System.out.println("Archivo serializado no encontrado, creandolo ahora mismo.");
				File temp = new File(url + fileName);
				temp.createNewFile();
				fis = new FileInputStream(new File(url + fileName));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		Object content = null;
		try {
			ois = new ObjectInputStream(fis);
			content = ois.readObject();
			ois.close();
		} catch (IOException e) {
			System.out.println("No se pudo escribir en el archivo serializado.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al obtener el contenido.");
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * Abre y guarda en el archivo (serializado) todo el contenido que recibe la
	 * funcion en el String.
	 * 
	 * @param fileName - Nombre del archivo CSV serializado a buscar.
	 * @param content  - Todo el contenido que se guardara dentro del archivo CSV
	 *                 serializado.
	 */
	public static void serializableOpenAndWriteFile(String fileName, Object content) {
		try {
			fos = new FileOutputStream(new File(url + fileName));
		} catch (FileNotFoundException e) {
			File temp = new File(url + fileName);
			try {
				fos = new FileOutputStream(temp);
			} catch (FileNotFoundException e1) {
				System.out.println("Problemas de escritura al crear o buscar el archivo serializado.");
				e1.printStackTrace();
			}
		}
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			oos.close();
		} catch (IOException e2) {
			System.out.println("Problemas de escritura al abrir el archivo serializado.");
			e2.printStackTrace();
		}
	}
}