package uml_practice_implementation.sample_test1.q2.dubdevs;

public class Video {
    private String format;
    private Integer sizeMegabytes;

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getSizeMegabytes() {
        return this.sizeMegabytes;
    }

    public void setSizeMegabytes(Integer sizeMegabytes) {
        this.sizeMegabytes = sizeMegabytes;
    }

    public Video(String format, Integer sizeMegabytes) {
        this.format = format;
        this.sizeMegabytes = sizeMegabytes;
    }


}
