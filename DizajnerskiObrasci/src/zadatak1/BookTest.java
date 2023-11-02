package zadatak1;

public class BookTest {

	public static void main(String[] args) {
		Book bookOne = new Book();
		Book bookTwo = new Book("Roman1", "Jovan Granic", 800, 699.00);

		bookOne.setName("Roman2");
		bookOne.setAuthor("Cristiano Ronaldo");
		bookOne.setPrice(950.00);
		bookOne.setNameOfPages(445);

		System.out.println(bookOne.calculateDiscountPrice(15));

		if (bookOne.calculateDiscountPrice(15) < bookTwo.calculateDiscountPrice(20)) {
			System.out.println(bookOne.getName());
		} else {
			System.out.println(bookTwo.getName());
		}
		
		

	}

}
