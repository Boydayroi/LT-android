package ntu.tienthinh.gki1hanguyentienthinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ChucNang4 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BaiThuocAdapter adapter;
    private List<BaiThuoc> baiThuocList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chuc_nang_4);

        recyclerView = findViewById(R.id.rv_bai_thuoc);
        baiThuocList = new ArrayList<>();
        khoiTaoDuLieu();

        adapter = new BaiThuocAdapter(baiThuocList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(baiThuoc -> {

            Intent intent = new Intent(ChucNang4.this, ChiTietBaiActivity.class);

            // CHUYỂN NỘI DUNG SANG ChiTietBaiActivity
            intent.putExtra("TEN_BT", baiThuoc.getTenBaiThuoc());
            intent.putExtra("CONG_DUNG", baiThuoc.getCongDungChinh());

            startActivity(intent);
        });
    }

    private void khoiTaoDuLieu() {
        baiThuocList.add(new BaiThuoc("Trà Gừng", "Làm ấm, trị cảm lạnh nhẹ", R.drawable.ic_launcher_background));
        baiThuocList.add(new BaiThuoc("Nước Chanh Mật Ong", "Tăng cường miễn dịch, giảm ho", R.drawable.ic_launcher_background));
        baiThuocList.add(new BaiThuoc("Lá Tía Tô", "Giải cảm, hạ sốt tự nhiên", R.drawable.ic_launcher_background));
    }
}
