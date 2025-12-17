package ntu.tienthinh.duancuoiki.network;

import ntu.tienthinh.duancuoiki.model.WeatherResponse; // Import model class

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Interface định nghĩa các endpoint của API
public interface WeatherService {

    // Gọi HTTP GET tới endpoint /data/2.5/weather
    @GET("data/2.5/weather")
    Call<WeatherResponse> getCurrentWeather(
            // @Query sẽ thêm các tham số vào URL (ví dụ: ?q=Hanoi&appid=...)
            @Query("q") String city,       // Tên thành phố
            @Query("appid") String apiKey, // Khóa API
            @Query("units") String units   // Đơn vị nhiệt độ (metric = Celsius)
    );
}