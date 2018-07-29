package myMovieFinder;

public class Movie {
    private String rtId;
    private String imgUrl;
    private String title;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Movie (String rtId) {
        this.rtId = rtId;
    }

    public String getRtId() {
        return rtId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
