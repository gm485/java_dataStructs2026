package uml_practice_implementation.sample_test1.q2.netflix;

public class Video {

    private Integer netflixId;

    private String contentCategory;


    public Video(Integer netflixId, String contentCategory) {
        this.netflixId = netflixId;
        this.contentCategory = contentCategory;
    }

    public Integer getNetflixId() {
        return this.netflixId;
    }

    public void setNetflixId(Integer netflixId) {
        this.netflixId = netflixId;
    }

    public String getContentCategory() {
        return this.contentCategory;
    }

    public void setContentCategory(String contentCategory) {
        this.contentCategory = contentCategory;
    }
}
