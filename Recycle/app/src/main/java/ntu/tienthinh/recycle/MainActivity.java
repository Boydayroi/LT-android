package ntu.tienthinh.recycle;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    landscapeadapter landscapeadapter;
    ArrayList<landscape> dsList;
    RecyclerView rvLandscape;
    void Tim() {
        rvLandscape = findViewById(R.id.rvlandscape);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tim();
        dsList=getData();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLandscape.setLayoutManager(layoutManager);
        landscapeadapter = new landscapeadapter(this, dsList);
        rvLandscape.setAdapter(landscapeadapter);



    }
    ArrayList<landscape> getData() {
        ArrayList<landscape> dsList = new ArrayList<>();
        dsList.add(new landscape("anh1","anh1"));
        dsList.add(new landscape("anh2","anh2"));
        dsList.add(new landscape("anh3","anh3"));
        dsList.add(new landscape("anh4","anh4"));
        return dsList;
    }

}