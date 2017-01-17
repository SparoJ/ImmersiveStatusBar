package com.pingan.apple.immersivestatusbar.recyclerviewdemo.complexdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pingan.apple.immersivestatusbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author apple
 * @Description :
 * @date 17/1/16  下午4:47
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<Category> lists = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public CategoryAdapter(Context context, List<Category> lists) {
        this.context = context;
        this.lists = lists;
        this.layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getItemViewType(int position) {
        return lists.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Category.SECOND_TYPE) {
            return new SecondViewHolder(layoutInflater.inflate(R.layout.item_list_category_second, null, false));
        } else {
            return new ThirdViewHolder(layoutInflater.inflate(R.layout.item_list_category_third, null, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case Category.SECOND_TYPE:
                SecondViewHolder secondViewHolder = (SecondViewHolder) holder;
                secondViewHolder.secondCategory.setText(lists.get(position).getCategoryName());
                break;
            case Category.THIRD_TYPE:
                ThirdViewHolder thirdViewHolder = (ThirdViewHolder) holder;
                thirdViewHolder.thirdCategory.setText(lists.get(position).getCategoryName());
                break;

        }
    }

    @Override
    public int getItemCount() {
        if (lists != null) {
            return lists.size();
        } else {
            return 0;
        }
    }


    public static class SecondViewHolder extends RecyclerView.ViewHolder {

        private TextView secondCategory;

        public SecondViewHolder(View itemView) {
            super(itemView);
            secondCategory = (TextView) itemView.findViewById(R.id.second_cat_name);
        }
    }

    public static class ThirdViewHolder extends RecyclerView.ViewHolder {

        private TextView thirdCategory;

        public ThirdViewHolder(View itemView) {
            super(itemView);
            thirdCategory = (TextView) itemView.findViewById(R.id.third_cat_name_first);
        }
    }
}
