package beca.java.everis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CSVFileReader {

	public void read(String fileName) {
		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName));
			Set<Book> books = new HashSet<Book>();

			adicionarBook(br, books);

			imprimirOrdenadoPorIbsn(books);

		} catch (FileNotFoundException ex) {
			System.out.println("Não foi possível encontrar o arquivo." + ex);
		} catch (IOException e) {
			System.out.println("Erro de entrada ou saída na aplicação. " + e);
		} catch (Exception e) {
			System.out.println("Erro inesperado. " + e);
		}

	}

	private void adicionarBook(BufferedReader br, Set<Book> books) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			String[] values = line.split(";");
			Book book = new Book(values[0], values[1], values[2], Integer.parseInt(values[3]));
			books.add(book);
		}
	}

	private void imprimirOrdenadoPorIbsn(Set<Book> books) throws IOException {
		
		String dir = System.getProperty("user.dir");
		FileWriter arq = new FileWriter(dir+"/lista.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.printf("---Impressão ordenado---%n");
		books.stream().sorted(Comparator.comparing(Book::getIsbn))
				.forEach(e -> gravarArq.printf("Titulo: " + e.getTitle()
						+ "%nAutor: " + e.getAuthor() + "%nISBN: " + e.getIsbn() + "%nAno: " + e.getYear()
						+"%n--------------------------------%n"));
		arq.close();
	}

}