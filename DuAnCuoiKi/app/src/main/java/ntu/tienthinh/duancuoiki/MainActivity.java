package ntu.tienthinh.duancuoiki;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ntu.tienthinh.duancuoiki.model.WeatherResponse;
import ntu.tienthinh.duancuoiki.network.RetrofitClient;
import ntu.tienthinh.duancuoiki.network.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private EditText etCityName;
    private Button btnGetWeather;

    // Khối chính
    private TextView tvCity;
    private TextView tvTemperature;
    private TextView tvDescription;


    private TextView tvHumidity;
    private TextView tvWindSpeed;
    private TextView tvPressure;    // Áp suất
    private TextView tvFeelsLike;   // Nhiệt độ cảm nhận (Feels like)
    private TextView tvTempMax;     // Nhiệt độ tối đa (Max Temp)
    private TextView tvTempMin;     // Nhiệt độ tối thiểu (Min Temp)

    private ProgressBar progressBar;
    private static final String API_KEY = "c1a2988591c7c511f180c60702f653fc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etCityName = findViewById(R.id.et_city_name);
        btnGetWeather = findViewById(R.id.btn_get_weather);
        tvCity = findViewById(R.id.tv_city);
        tvTemperature = findViewById(R.id.tv_temperature);
        tvDescription = findViewById(R.id.tv_description);
        tvHumidity = findViewById(R.id.tv_humidity);
        tvWindSpeed = findViewById(R.id.tv_wind_speed);
        progressBar = findViewById(R.id.progress_bar);
        tvPressure = findViewById(R.id.tv_pressure);
        tvFeelsLike = findViewById(R.id.tv_feels_like);
        tvTempMax = findViewById(R.id.tv_temp_max);
        tvTempMin = findViewById(R.id.tv_temp_min);


        btnGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = etCityName.getText().toString().trim();
                if (!cityName.isEmpty()) {
                    getWeatherData(cityName);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên thành phố", Toast.LENGTH_SHORT).show();
                }
            }
        });


        getWeatherData("Hanoi");
    }

    private void getWeatherData(String city) {

        progressBar.setVisibility(View.VISIBLE);
        tvCity.setText("Đang tải...");
        tvTemperature.setText("");
        tvDescription.setText("");
        tvHumidity.setText("");
        tvWindSpeed.setText("");
        tvPressure.setText("");
        tvFeelsLike.setText("");
        tvTempMax.setText("");
        tvTempMin.setText("");


        WeatherService service = RetrofitClient.getWeatherService();
        Call<WeatherResponse> call = service.getCurrentWeather(city, API_KEY, "metric");

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    updateUI(response.body());
                } else {
                    Toast.makeText(MainActivity.this, "Không tìm thấy dữ liệu thời tiết cho: " + city, Toast.LENGTH_LONG).show();
                    tvCity.setText("Lỗi Tải Dữ Liệu");
                    Log.e("API_CALL", "Lỗi: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Lỗi kết nối mạng: " + t.getMessage(), Toast.LENGTH_LONG).show();
                tvCity.setText("Lỗi Mạng");
                Log.e("API_CALL", "Lỗi gọi API: " + t.getMessage());
            }
        });
    }

    private void updateUI(WeatherResponse response) {

        // 1. Nhiệt độ & Mô tả (Phần chính)
        double temp = response.getMain().getTemp();
        String tempDisplay = String.format("%.0f°C", temp);

        String rawDescription = response.getWeather().get(0).getDescription();
        String description = rawDescription.substring(0, 1).toUpperCase() + rawDescription.substring(1);

        // Cập nhật TextViews chính
        tvCity.setText(response.getName());
        tvTemperature.setText(tempDisplay);
        tvDescription.setText(description);

        // 2. LOGIC ĐỂ HIỂN THỊ CÁC TRƯỜNG CHI TIẾT MỚI:

        // Độ ẩm
        int humidity = response.getMain().getHumidity();
        tvHumidity.setText(humidity + "%");


        double windSpeed = response.getWind().getSpeed();
        tvWindSpeed.setText(String.format("%.1f m/s", windSpeed));

        // Áp suất
        int pressure = response.getMain().getPressure();
        tvPressure.setText(pressure + " hPa");

        // Nhiệt độ cảm nhận
        double feelsLike = response.getMain().getFeelsLike();
        tvFeelsLike.setText(String.format("%.0f°C", feelsLike));

        // Max Temp
        double tempMax = response.getMain().getTempMax();
        tvTempMax.setText(String.format("%.0f°C", tempMax));

        // Min Temp
        double tempMin = response.getMain().getTempMin();
        tvTempMin.setText(String.format("%.0f°C", tempMin));
    }
}