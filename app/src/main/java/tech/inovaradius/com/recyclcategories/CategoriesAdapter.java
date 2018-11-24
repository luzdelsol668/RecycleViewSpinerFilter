package tech.inovaradius.com.recyclcategories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyShopHolder> {
    List<Shop> shopList;
    Context mContext;
    View rootView;

    public CategoriesAdapter(List<Shop> shopList, Context mContext) {
        this.shopList = shopList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyShopHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        rootView = LayoutInflater.from(mContext).inflate(R.layout.shop_item,viewGroup,false);
        MyShopHolder myShopHolder = new MyShopHolder(rootView);
        return myShopHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyShopHolder myShopHolder, int i) {
      final Shop shopPosition = shopList.get(i);
      myShopHolder.name.setText(shopPosition.getName());
      myShopHolder.price.setText("Price " + shopPosition.getPrice());


    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public void updateList(List<Shop> countryModels) {
        shopList = new ArrayList<>();
        shopList.addAll(countryModels);
        notifyDataSetChanged();
    }


    public class MyShopHolder extends RecyclerView.ViewHolder {
        TextView price, name;
        public MyShopHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price);
            name = itemView.findViewById(R.id.name);
        }
    }
}
