package lab4;

public class PrintJob {
    public int id;
    public String doc_name;
    public int pages;

    @Override
    public String toString() {
        return "PrintJob{" +
                ", doc_name='" + doc_name + '\'' +
                '}';
    }

}
