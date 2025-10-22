package ntu.tienthinh.pheptoansohoc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText; // Cần import cho EditText
import android.widget.TextView; // Cần import cho TextView
import android.widget.Toast; // Cần import để hiển thị thông báo lỗi

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    EditText edtA;
    EditText edtB;
    TextView tvKetqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Thiết lập giao diện
        setContentView(R.layout.activity_main);


        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        tvKetqua = findViewById(R.id.tvKetqua);
    }

    private double[] layDuLieu() {
        String strSoA = edtA.getText().toString();
        String strSoB = edtB.getText().toString();

        if (strSoA.isEmpty() || strSoB.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ cả hai số A và B!", Toast.LENGTH_SHORT).show();
            return null;
        }

        try {
            // Chuyển đổi sang số thực (double) để xử lý kết quả chính xác hơn
            double soA = Double.parseDouble(strSoA);
            double soB = Double.parseDouble(strSoB);
            return new double[]{soA, soB};
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dữ liệu nhập vào không hợp lệ (phải là số).", Toast.LENGTH_SHORT).show();
            return null;
        }
    }


    // 4. Các hàm xử lý sự kiện onClick (KHỚP với thuộc tính onClick trong XML)

    public void TinhTong(View v){
        double[] duLieu = layDuLieu();
        if (duLieu != null) {
            double ketQua = duLieu[0] + duLieu[1];
            tvKetqua.setText(String.valueOf(ketQua));
        }
    }

    public void TinhTru(View v){
        double[] duLieu = layDuLieu();
        if (duLieu != null) {
            double ketQua = duLieu[0] - duLieu[1];
            tvKetqua.setText(String.valueOf(ketQua));
        }
    }

    // Thêm hàm Tính Nhân
    public void TinhNhan(View v){
        double[] duLieu = layDuLieu();
        if (duLieu != null) {
            double ketQua = duLieu[0] * duLieu[1];
            tvKetqua.setText(String.valueOf(ketQua));
        }
    }

    // Thêm hàm Tính Chia
    public void TinhChia(View v){
        double[] duLieu = layDuLieu();
        if (duLieu != null) {
            double soA = duLieu[0];
            double soB = duLieu[1];

            if (soB == 0) {
                // Xử lý lỗi chia cho 0
                tvKetqua.setText("Lỗi: Chia cho 0");
                Toast.makeText(this, "Không thể chia cho số 0!", Toast.LENGTH_SHORT).show();
            } else {
                double ketQua = soA / soB;
                tvKetqua.setText(String.valueOf(ketQua));
            }
        }
    }
}