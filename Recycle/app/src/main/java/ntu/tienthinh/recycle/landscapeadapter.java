package ntu.tienthinh.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class landscapeadapter extends RecyclerView.Adapter<landscapeadapter.ItemViewHolder> {
    Context context;
    ArrayList<landscape> dsList;

    public landscapeadapter(Context context, ArrayList<landscape> dsList) {
        this.context = context;
        this.dsList = dsList;
    }

    @NonNull
    @Override
    public landscapeadapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.landscape_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        landscape Landscape= dsList.get(position);
        String Caption= Landscape.getLandscapeName();
        String img= Landscape.getLandscapeImage();
        holder.textView.setText(Caption);
        String packageName = holder.itemView.getContext().getPackageName();
        int resId = holder.itemView.getContext().getResources().getIdentifier(img, "mipmap", packageName);;
        holder.img1.setImageResource(resId);

    }

    @Override
    public int getItemCount() {
        return dsList.size();
    }
    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
