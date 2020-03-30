package yurchenko.creational.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book newBook = new Book();
        newBook.setTitle("Мастер и Маргарита");
        newBook.setAuthor("Булгаков");
        newBook.setGenre("Мистика");

        Book bookClone = (Book) newBook.getCopy();

        System.out.println("Parent object");
        System.out.println(newBook);
        System.out.println("Clone object");
        System.out.println(bookClone);
    }
}
