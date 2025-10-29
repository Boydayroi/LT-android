package ntu.tienthinh.gki1hanguyentienthinh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ChucNang3Activity extends AppCompatActivity {

    private String[] danhSachMonAn = {
            "Phở Bò Truyền Thống",
            "Bún Chả Hà Nội",
            "Bánh Mì Kẹp Thịt",
            "Gỏi Cuốn Tôm Thịt",
            "Cơm Tấm Sườn Bì Chả",
            "Bún Riêu Cua",
            "Canh Chua Cá Lóc"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang3); // Đảm bảo tên layout đúng

        ListView lvMonAn = findViewById(R.id.lv_mon_an);

        // 1. Tạo Adapter
        // Sử dụng layout đơn giản có sẵn của Android (simple_list_item_1)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                danhSachMonAn
        );

        // 2. Gán Adapter vào ListView
        lvMonAn.setAdapter(adapter);

        // 3. Bắt sự kiện click vào từng item (1.0 điểm)
        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String tenMonAnDuocChon = danhSachMonAn[position];

                // Yêu cầu 1.0 đ: Thông báo mục được click (Toast)
                Toast.makeText(ChucNang3Activity.this,
                        "Bạn đã chọn: " + tenMonAnDuocChon,
                        Toast.LENGTH_SHORT).show();

                // Yêu cầu 0.5 đ: Chuyển nội dung sang Item3Activity
                Intent intent = new Intent(ChucNang3Activity.this, Item3Activity.class);

                // Gửi dữ liệu đi bằng Intent.putExtra
                intent.putExtra("TEN_MON_AN", tenMonAnDuocChon);

                startActivity(intent);
            }
        });
    }
}
