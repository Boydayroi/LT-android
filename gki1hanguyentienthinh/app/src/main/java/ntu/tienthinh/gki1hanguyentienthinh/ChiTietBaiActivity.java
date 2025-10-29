package ntu.tienthinh.gki1hanguyentienthinh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChiTietBaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_bai);

        TextView tvTenBT = findViewById(R.id.tv_ten_bai_thuoc_ct);
        TextView tvCongDungCT = findViewById(R.id.tv_cong_dung_ct);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String tenBT = extras.getString("TEN_BT");
            String congDung = extras.getString("CONG_DUNG");

            if (tenBT != null) {
                tvTenBT.setText(tenBT);
            }
            if (congDung != null) {
                tvCongDungCT.setText(congDung);
            }
        } else {
            tvTenBT.setText("Không tìm thấy dữ liệu bài thuốc!");
        }
    }
}
