package ntu.tienthinh.duancuoiki.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

// Class này ánh xạ toàn bộ phản hồi JSON từ API
public class WeatherResponse {

    // Tên trường trong JSON: "name" (Tên thành phố)
    @SerializedName("name")
    private String name;

    // Tên trường trong JSON: "main" (Sử dụng lớp Main đã tạo)
    @SerializedName("main")
    private Main main;


    @SerializedName("weather")
    private List<Weather> weather;


    @SerializedName("wind")
    private wind wind;

    public WeatherResponse(String name, Main main, List<Weather> weather) {
        this.name = name;
        this.main = main;
        this.weather = weather;


    }

    // Getters
    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }


    public wind getWind() {
        return wind;
    }
}