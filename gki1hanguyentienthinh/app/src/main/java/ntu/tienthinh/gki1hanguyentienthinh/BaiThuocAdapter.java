package ntu.tienthinh.gki1hanguyentienthinh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BaiThuocAdapter extends RecyclerView.Adapter<BaiThuocAdapter.ViewHolder> {
    private final List<BaiThuoc> baiThuocList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(BaiThuoc baiThuoc);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { this.listener = listener; }

    public BaiThuocAdapter(List<BaiThuoc> baiThuocList) { this.baiThuocList = baiThuocList; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bai_thuoc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiThuoc currentBaiThuoc = baiThuocList.get(position);
        holder.tvTen.setText(currentBaiThuoc.getTenBaiThuoc());
        holder.tvCongDung.setText("Công dụng: " + currentBaiThuoc.getCongDungChinh());
        holder.ivAnh.setImageResource(currentBaiThuoc.getAnhMinhHoaId());

        holder.itemView.setOnClickListener(v -> { // Xử lý click
            if (listener != null) {
                listener.onItemClick(currentBaiThuoc);
            }
        });
    }

    @Override
    public int getItemCount() { return baiThuocList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAnh;
        TextView tvTen;
        TextView tvCongDung;

        public ViewHolder(View itemView) {
            super(itemView);
            ivAnh = itemView.findViewById(R.id.iv_anh_bai_thuoc);
            tvTen = itemView.findViewById(R.id.tv_ten_bai_thuoc);
            tvCongDung = itemView.findViewById(R.id.tv_cong_dung);
        }
    }
}