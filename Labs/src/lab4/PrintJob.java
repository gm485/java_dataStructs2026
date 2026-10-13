package lab4;

public class PrintJob {
    private int id;
    private String doc_name;
    private int pages;

    @Override
    public String toString() {
        return doc_name + ",";
    }

    public int getId() {
        return id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public int getPages() {
        return pages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
