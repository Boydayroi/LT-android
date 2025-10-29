package ntu.tienthinh.gki1hanguyentienthinh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChucNang2Activity extends AppCompatActivity {

    private EditText etCanNang, etChieuCao;
    private TextView tvKetQua;
    private Button btnTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chucnang2);

        // 1. Ánh xạ các View từ XML
        etCanNang = findViewById(R.id.et_can_nang);
        etChieuCao = findViewById(R.id.et_chieu_cao);
        tvKetQua = findViewById(R.id.tv_ket_qua);
        btnTinh = findViewById(R.id.btn_tinh_bmi);

        // 2. Thiết lập sự kiện click cho nút Tính BMI
        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhBMI();
            }
        });
    }

    private void tinhBMI() {
        String strCanNang = etCanNang.getText().toString().trim();
        String strChieuCao = etChieuCao.getText().toString().trim();

        // 3. Xử lý lỗi: Dữ liệu trống
        if (strCanNang.isEmpty() || strChieuCao.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ cân nặng và chiều cao.", Toast.LENGTH_SHORT).show();
            tvKetQua.setText("---");
            return;
        }

        try {
            // 4. Chuyển đổi sang kiểu số thực (float)
            float canNang = Float.parseFloat(strCanNang);
            float chieuCao = Float.parseFloat(strChieuCao); // Đơn vị: mét

            // 5. Xử lý lỗi: Giá trị không hợp lệ (nhỏ hơn hoặc bằng 0)
            if (canNang <= 0 || chieuCao <= 0) {
                Toast.makeText(this, "Cân nặng và chiều cao phải lớn hơn 0.", Toast.LENGTH_LONG).show();
                tvKetQua.setText("Lỗi giá trị!");
                return;
            }

            // 6. Tính toán BMI
            float bmi = canNang / (chieuCao * chieuCao);

            // 7. Phân loại tình trạng sức khỏe
            String tinhTrang = phanLoaiBMI(bmi);

            // 8. Hiển thị kết quả (làm tròn 2 chữ số)
            String ketQua = String.format("BMI: %.2f\nTình trạng: %s", bmi, tinhTrang);
            tvKetQua.setText(ketQua);

        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu người dùng nhập ký tự không phải số
            Toast.makeText(this, "Dữ liệu nhập vào phải là số.", Toast.LENGTH_SHORT).show();
            tvKetQua.setText("Lỗi định dạng!");
        }
    }

    // Hàm phân loại tình trạng BMI
    private String phanLoaiBMI(float bmi) {
        if (bmi < 18.5) {
            return "Thiếu cân";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Bình thường (Khỏe mạnh)";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Thừa cân";
        } else {
            return "Béo phì";
        }
    }
}
