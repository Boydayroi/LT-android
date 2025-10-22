package ntu.tienthinh.recycle;

public class landscape {
    private String landscapeName;
    private String landscapeImage;

    public String getLandscapeName() {
        return landscapeName;
    }

    public void setLandscapeName(String landscapeName) {
        this.landscapeName = landscapeName;
    }

    public String getLandscapeImage() {
        return landscapeImage;
    }

    public void setLandscapeImage(String landscapeImage) {
        this.landscapeImage = landscapeImage;
    }

    public landscape(String landscapeName, String landscapeImage) {
        this.landscapeName = landscapeName;
        this.landscapeImage = landscapeImage;
    }
}
