package yurchenko.creational.prototype;

public class Book implements Clone {
    private String title;
    private String author;
    private String genre;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public Clone getCopy() {
        Book cloneObject = new Book();
        cloneObject.setTitle(title);
        cloneObject.setAuthor(author);
        cloneObject.setGenre(genre);
        return cloneObject;
    }

    @Override
    public String toString() {
        return "Book{" + "Title=" + title + ", author=" + author + ", genre=" + genre + '}';
    }
}
