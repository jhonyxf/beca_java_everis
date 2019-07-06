package beca.java.everis;

public class Book{

  private String title;
  private String author;
  private String isbn;
  private int year;

  public Book(){}

  public Book(String title, String author, String isbn, int year){
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.year = year;
  }

  public String getTitle(){
    return this.title;
  }
  public String getAuthor(){
    return this.author;
  }
  public String getIsbn(){
    return this.isbn;
  }
  public int getYear(){
    return this.year;
  }

  public void setTitle(String t){
    this.title = t;
  }
  public void setAuthor(String a){
    this.author = a;
  }
  public void setIsbn(String i){
    this.isbn = i;
  }
  public void setYear(int y){
    this.year = y;
  }
  
  public String toString(){
		return "Titulo: "+this.getTitle()+"\nAutor: "+ this.getAuthor()+"\nISBN: "+this.getIsbn()+"\nAno: "+this.getYear()+
    "\n--------------------------------";
	}
}