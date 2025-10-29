package ntu.tienthinh.gki1hanguyentienthinh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;

public class ChucNang3Activity extends AppCompatActivity {

    private ListView lvMonAn;
    private final ArrayList<String> tenMonAnList = new ArrayList<>();
    private final ArrayList<String> chiTietList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang3);

        lvMonAn = findViewById(R.id.lv_mon_an);

        docDuLieuTuJSON(); // Gọi hàm đọc JSON

        // 1.0 đ: Hiển thị danh sách
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                tenMonAnList
        );

        lvMonAn.setAdapter(adapter);

        // 0.5 đ: Chuyển nội dung sang ChiTietMonActivity (thay cho Toast)
        lvMonAn.setOnItemClickListener((parent, view, position, id) -> {

            String tenMonAnDuocChon = tenMonAnList.get(position);
            String chiTietDuocChon = chiTietList.get(position);

            Intent intent = new Intent(ChucNang3Activity.this, ChiTietMonActivity.class);

            intent.putExtra("TEN_MON", tenMonAnDuocChon);
            intent.putExtra("CHI_TIET", chiTietDuocChon);

            startActivity(intent);
        });
    }

    private void docDuLieuTuJSON() {
        try {
            // Đọc file mon_an.json từ thư mục raw (0.5 điểm)
            InputStream is = getResources().openRawResource(R.raw.mon_an);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String jsonString = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject monAn = jsonArray.getJSONObject(i);

                String ten = monAn.getString("ten");
                String thanhPhan = monAn.getString("thanh_phan");

                tenMonAnList.add(ten);
                chiTietList.add(thanhPhan);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Lỗi đọc dữ liệu JSON", Toast.LENGTH_LONG).show();
        }
    }
}
