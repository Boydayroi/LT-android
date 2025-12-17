package ntu.tienthinh.duancuoiki.model;

import com.google.gson.annotations.SerializedName;

// Class này ánh xạ phần tử trong mảng "weather" của JSON
public class Weather {

    // Tên trường trong JSON: "description"
    @SerializedName("description")
    private String description;

    // Tên trường trong JSON: "icon" (dùng để lấy hình ảnh)
    @SerializedName("icon")
    private String icon;

    // Constructor
    public Weather(String description, String icon) {
        this.description = description;
        this.icon = icon;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}