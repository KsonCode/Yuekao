package com.laoxu.yuekao.model.adapteer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.laoxu.yuekao.R;
import com.laoxu.yuekao.model.entity.ProductEntity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context context;
    private List<ProductEntity.Product> list;

    public ProductAdapter(Context context, List<ProductEntity.Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = View.inflate(context,R.layout.product_item_layout,null);
       MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.nameTv.setText(list.get(position).commodityName);
        Glide.with(context).load(list.get(position).masterPic)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .circleCrop()
                .into(holder.iconIv);

        //点击事件，通过下面声明的接口，发送商品标题

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvItemClick.onClick(list.get(position).commodityName);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iconIv;
        private TextView nameTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconIv = itemView.findViewById(R.id.iv);
            nameTv = itemView.findViewById(R.id.name);
        }
    }


    //声明接口
    private RvItemClick rvItemClick;

    public void setRvItemClick(RvItemClick rvItemClick) {
        this.rvItemClick = rvItemClick;
    }

    public interface RvItemClick{
        void onClick(String name);
    }
}
