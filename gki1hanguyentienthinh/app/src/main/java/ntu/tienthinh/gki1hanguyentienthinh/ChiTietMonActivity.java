package ntu.tienthinh.gki1hanguyentienthinh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChiTietMonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_mon_an);

        TextView tvTenMon = findViewById(R.id.tv_ten_mon);
        TextView tvChiTiet = findViewById(R.id.tv_thanh_phan);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String tenMon = extras.getString("TEN_MON");
            String chiTiet = extras.getString("CHI_TIET");

            if (tenMon != null) {
                tvTenMon.setText(tenMon);
            }
            if (chiTiet != null) {
                tvChiTiet.setText(chiTiet);
            }
        } else {
            tvTenMon.setText("Không có dữ liệu món ăn!");
        }
    }
}

