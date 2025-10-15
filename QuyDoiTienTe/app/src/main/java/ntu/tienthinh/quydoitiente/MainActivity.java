package ntu.tienthinh.quydoitiente;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến View
    private EditText etAmount;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private Button btnConvert;
    private TextView tvResult;

    // Định nghĩa các tỷ giá hối đoái CỐ ĐỊNH (cơ sở: 1 USD)
    private final Map<String, Double> rates = new HashMap<String, Double>() {{
        put("USD", 1.0);      // Đô la Mỹ
        put("EUR", 0.93);     // Euro
        put("VND", 25000.0);  // Việt Nam Đồng
        put("JPY", 150.0);    // Yên Nhật
        put("GBP", 0.81);     // Bảng Anh
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Gắn file XML

        // 1. ÁNH XẠ (findViewById) - Đây là nơi lỗi thường xảy ra
        etAmount = findViewById(R.id.et_amount);
        spinnerFrom = findViewById(R.id.spinner_from);
        spinnerTo = findViewById(R.id.spinner_to);
        btnConvert = findViewById(R.id.btn_convert);
        tvResult = findViewById(R.id.tv_result);

        // 2. Thiết lập Spinner (Dropdown)
        List<String> currencies = new ArrayList<>(rates.keySet());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                currencies
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        // Đặt giá trị mặc định: USD -> VND
        spinnerFrom.setSelection(currencies.indexOf("USD"));
        spinnerTo.setSelection(currencies.indexOf("VND"));

        // 3. Xử lý sự kiện khi nhấn nút "Quy đổi"
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrencyHandler();
            }
        });
    }

    /**
     * Hàm xử lý logic quy đổi tiền tệ.
     */
    private void convertCurrencyHandler() {
        String amountStr = etAmount.getText().toString();

        // Kiểm tra đầu vào rỗng
        if (TextUtils.isEmpty(amountStr)) {
            Toast.makeText(this, "Vui lòng nhập số tiền", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Số tiền không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy tiền tệ nguồn và đích từ Spinner
        String fromCurrency = spinnerFrom.getSelectedItem().toString();
        String toCurrency = spinnerTo.getSelectedItem().toString();

        // Thực hiện quy đổi
        double result = calculateConversion(amount, fromCurrency, toCurrency);

        // Định dạng kết quả (ví dụ: 100,000.00)
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        String formattedResult = formatter.format(result);

        tvResult.setText("Kết quả: " + formattedResult + " " + toCurrency);
    }

    /**
     * Hàm tính toán quy đổi.
     * Logic: Chuyển tiền nguồn về USD, sau đó từ USD chuyển sang tiền đích.
     */
    private double calculateConversion(double amount, String from, String to) {
        // Lấy tỷ giá (đảm bảo rằng các khóa tồn tại)
        double fromRate = rates.containsKey(from) ? rates.get(from) : 1.0;
        double toRate = rates.containsKey(to) ? rates.get(to) : 1.0;

        // 1. Chuyển tiền nguồn về USD: Amount_USD = Amount_FROM / Rate_FROM
        double amountInUSD = amount / fromRate;

        // 2. Chuyển từ USD sang tiền đích: Result = Amount_USD * Rate_TO
        double result = amountInUSD * toRate;

        return result;
    }
}