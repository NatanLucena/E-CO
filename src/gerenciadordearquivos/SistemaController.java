package gerenciadordearquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import controladores.ControladorGeral;

public class SistemaController {
	
	/**
	 * Salva a instancia de controlador geral em arquivo.
	 * 
	 * @param controller Controlador geral a ser salvo.
	 */
	public static void salvaSistema(ControladorGeral controller) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(new File("arquivos_sistema/sistema.txt"));
			oos = new ObjectOutputStream(fos);

			oos.writeObject(controller);
			
		} catch (FileNotFoundException fnf) {
			System.out.println("Arquivo nao encontrado!");
		} catch (IOException e) {
			System.out.println("");
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println("Erro ao fechar conexao...");
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("Erro ao fechar conexao...");
				}
			}
		}

	}
	
	public static ControladorGeral carregaSistema() {
		ControladorGeral controller = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(new File("arquivos_sistema/sistema.txt"));
			ois = new ObjectInputStream(fis);

			controller = (ControladorGeral) ois.readObject();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado!");
		} catch (IOException e) {
			System.out.println("");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("Erro ao fechar conexao...");
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					System.out.println("Erro ao fechar conexao...");
				}
			}
		}

		return controller;
	}
	
	public static void limpaSistema() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(new File("arquivos_sistema/sistema.txt"));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new ControladorGeral());
			
		} catch (FileNotFoundException fnf) {
			System.out.println("Arquivo nao encontrado!");
		} catch (IOException e) {
			System.out.println("");
		}

	}

}
