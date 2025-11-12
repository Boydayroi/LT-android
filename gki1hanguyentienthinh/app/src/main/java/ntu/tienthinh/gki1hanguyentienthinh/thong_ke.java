package ntu.tienthinh.gki1hanguyentienthinh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thong_ke extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thong_ke);

        // Ánh xạ nút Quay lại
        Button btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(v -> {
            // Sử dụng finish() để đóng Activity hiện tại
            finish();
        });
    }
}
