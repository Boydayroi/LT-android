package ntu.tienthinh.duancuoiki.model;

import com.google.gson.annotations.SerializedName;

public class Main {

    // Nhiệt độ hiện tại
    @SerializedName("temp")
    private double temp;

    // Độ ẩm
    @SerializedName("humidity")
    private int humidity;

    // Áp suất (MỚI)
    @SerializedName("pressure")
    private int pressure;

    // Nhiệt độ cảm nhận (MỚI)
    @SerializedName("feels_like")
    private double feelsLike;

    // Nhiệt độ tối đa (MỚI)
    @SerializedName("temp_max")
    private double tempMax;

    // Nhiệt độ tối thiểu (MỚI)
    @SerializedName("temp_min")
    private double tempMin;

    public Main(double temp, int humidity, int pressure, double feelsLike, double tempMax, double tempMin) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.feelsLike = feelsLike;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    // Getters

    public double getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    // Getters MỚI
    public int getPressure() {
        return pressure;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }
}