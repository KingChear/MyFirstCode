package com.example.kingching.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KingChing on 2017/8/31.
 */
public class FruitAdapter extends BaseAdapter {

    private Context context;
    private int resourceId;
    private List<Fruit> data;

    public FruitAdapter(Context context, int resourceId, List<Fruit> data) {
        this.context = context;
        this.resourceId = resourceId;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder {
        public TextView fruitName;
        public ImageView fruitImage;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Fruit fruit = (Fruit) getItem(i);
        ViewHolder viewHolder = null;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(resourceId, viewGroup, false);
            viewHolder.fruitImage = view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = view.findViewById(R.id.fruit_name);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        return view;
    }

}
