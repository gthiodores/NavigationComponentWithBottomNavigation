package com.example.android.navigationcomponentwithbottomnavigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KakaoAdapter extends RecyclerView.Adapter<KakaoAdapter.ViewHolder> {
    private itemClickListener mItemClickListener;

    private List<InformasiKakao> listKakao;

    public KakaoAdapter(List<InformasiKakao> listKakao, itemClickListener clickListener) {
        this.listKakao = listKakao;
        this.mItemClickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler__item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(listKakao.get(position));
    }

    @Override
    public int getItemCount() {
        return listKakao.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvKakaoTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKakaoTitle = itemView.findViewById(R.id.item_nama);
            itemView.setOnClickListener(this);
        }

        public void bind(InformasiKakao item) {
            tvKakaoTitle.setText(item.getJudulInformasi());
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null)
                mItemClickListener.onItemClick(getAdapterPosition());
        }
    }

    interface itemClickListener {
        public void onItemClick(int position);
    }

}


