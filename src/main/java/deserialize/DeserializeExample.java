package deserialize;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class DeserializeExample {
	public static void main(String[] args){

		long start = System.currentTimeMillis();

		String jsonStr =
				"[{" +
						"'title' : 'Java Puzzlers : Traps, PitFalls, and Corner Cases'," +
						"'isbn-10' : '032133678X'," +
						"'isbn-13' : '978-0321336781'," +
						"'authors' : [" +
							"{ 'id' : 1, 'name' : 'Joshua Bloch'}," +
							"{ 'id' : 2, 'name' : 'Neal Gafter'}" +
						"]" +
				"},"+
				"{" +
						"'title' : 'Effective Java'," +
						"'isbn-10' : '032139875X'," +
						"'isbn-13' : '978-03213325987'," +
						"'authors' : [" +
							"{ 'id' : 1, 'name' : 'Joshua Bloch2'}," +
							"{ 'id' : 2, 'name' : 'Neal Gafter2'}" +
						"]" +
				"}" +
				"]";


		GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
		gsonBuilder.registerTypeAdapter(Book.class, new BookDeserializer());
		gsonBuilder.registerTypeAdapter(Author.class, new AuthorDeserializer());
		Gson gson = gsonBuilder.create();
		Book[] bookArr = gson.fromJson(jsonStr, Book[].class);
		List<Book> bookList = Arrays.asList(bookArr);
		for (int i=0; i<bookList.size(); i++){
			System.out.println(bookList.get(i).getTitle()+"|"+bookList.get(i).getIsbn10()+"|"+bookList.get(i).getIsbn13()+"|");
			for(Author author : bookList.get(i).getAuthors()){
				System.out.println(author.getId()+"|"+author.getName());
			}
		}

		long end = System.currentTimeMillis();
		System.out.println("실행시간 : " + (end - start)/1000.0);
	}
}

class Book {
	String title;
	String isbn10;
	String isbn13;
	Author[] authors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public Author[] getAuthors() {
		return authors;
	}

	public void setAuthors(Author[] authors) {
		this.authors = authors;
	}
}

class Author {
	int id;
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
