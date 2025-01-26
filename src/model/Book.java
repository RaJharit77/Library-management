package model;

public class Book {
    private String id;
    private String bookName;
    private Author author_id;
    private int pageNumbers;
    private Topic topic;
    private String releaseDate;

    public Book(String id, String bookName, Author author_id, int pageNumbers, Topic topic, String releaseDate) {
        this.id = id;
        this.bookName = bookName;
        this.author_id = author_id;
        this.pageNumbers = pageNumbers;
        this.topic = topic;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Author author_id) {
        this.author_id = author_id;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author_id=" + author_id +
                ", pageNumbers=" + pageNumbers +
                ", topic='" + topic + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
