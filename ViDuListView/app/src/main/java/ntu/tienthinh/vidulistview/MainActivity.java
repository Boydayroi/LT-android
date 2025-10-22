package ntu.tienthinh.vidulistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView Lv;
    private void TimDK() {
        Lv = findViewById(R.id.Lv);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      TimDK();
      //chuan bi nguon du lieu
            //khai bao
            ArrayList<String> lstName = new ArrayList<>();
            lstName = new ArrayList<>();
            lstName = getData();
            //tao adapter
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lstName);
        Lv.setAdapter(adapter);
        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //cach 1: lay gian tiep qua adapter
               String name = adapter.getItem(position).toString();
               //cach 2:lay truc tiep qua ds
                //String name2 = adapter.getItem(position);
               String thongbao = "Ban chon "+name;
               Toast.makeText(MainActivity.this,thongbao,Toast.LENGTH_SHORT).show();
            }

    });
    }
        ArrayList<String> getData(){
        ArrayList<String> ds = new ArrayList<String>();
        // code o day
            ds.add("Nguyễn Văn A");
            ds.add("Nguyễn Văn B");
            ds.add("Nguyễn Văn C");
            ds.add("Nguyễn Văn D");
            ds.add("Nguyễn Văn E");
            return ds;
        }

    }
