package ntu.tienthinh.duancuoiki.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Class Singleton để khởi tạo và quản lý đối tượng Retrofit
public class RetrofitClient {
    // URL cơ sở của OpenWeatherMap API
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit = null;

    // Phương thức để lấy instance Retrofit (chỉ tạo 1 lần)
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // Thiết lập bộ chuyển đổi JSON sang Java Object
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    // Phương thức tiện ích để lấy dịch vụ API
    public static WeatherService getWeatherService() {
        return getClient().create(WeatherService.class);
    }
}