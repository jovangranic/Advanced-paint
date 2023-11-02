package zadatak1;

public class Book {
	private int nameOfPages;
	private String name;
	private String author;
	private double price;

	public Book() {
		
		
	}
	   
	   public Book (String name, String author,int nameOfPages) {
		   this.name = name;
		   this.author = author;
		   this.nameOfPages = nameOfPages;
		   
	   }
	   
	   public Book(String name,String author,int nameOfPages, double price) {
		  this(name, author, nameOfPages);
		  this.price = price;
		  
	   }
	   
	   private double calculateDiscount(int percent) {
			return (this.price * percent) / 100;
		}

		protected double calculateDiscountPrice(int percent) {
			return price - calculateDiscount(percent);
		}
			
			
	public int getNameOfPages() {
		return nameOfPages;
	}

	public void setNameOfPages(int nameOfPages) {
		if(nameOfPages > 0) {
			this.price = nameOfPages;
		}
		else 
			System.out.println("Broj stranica ne moze biti negativan");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price > 0) {
			this.price = price;
		}
		else 
			System.out.println("Cena ne moze biti negativna");
	}

}
