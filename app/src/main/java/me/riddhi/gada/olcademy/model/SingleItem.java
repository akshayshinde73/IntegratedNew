package me.riddhi.gada.olcademy.model;

public class SingleItem {

    private String name;
    private int image;
    private String url;
    private String description;

    public SingleItem() {
    }

    public SingleItem(String name, int image, String url) {
        this.name = name;
        this.image = image;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
