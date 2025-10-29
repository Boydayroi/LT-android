package ntu.tienthinh.gki1hanguyentienthinh;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các nút
        Button btnChucNang2 = findViewById(R.id.btn_chucnang2);
        Button btnChucNang3 = findViewById(R.id.btn_chucnang3);
        Button btnChucNang4 = findViewById(R.id.btn_chucnang4);
        Button btnAboutMe = findViewById(R.id.btn_about_me);

        // 1. Chuyển sang Chức năng 2: Tính BMI
        btnChucNang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChucNang2Activity.class);
                startActivity(intent);
            }
        });

        // 2. Chuyển sang Chức năng 3: Món Ăn (ListView)
        btnChucNang3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChucNang3Activity.class);
                startActivity(intent);
            }
        });

        // 3. Chuyển sang Chức năng 4: Bài Thuốc (RecyclerView)
        btnChucNang4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChucNang4Activity.class);
                startActivity(intent);
            }
        });

        // 4. Chuyển sang About Me
        btnAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });
    }
}