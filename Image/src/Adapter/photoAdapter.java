package Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.image.*;

import modle.photo;

public class photoAdapter extends BaseAdapter {
    private  Context context;
    private  ArrayList<photo> photolist;

    public photoAdapter(ArrayList<photo> photolist , Context context) {
        this.photolist =photolist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photolist.size();
    }

    @Override
    public photo getItem(int position) {
        return photolist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if(view==null){
            //object
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.photo_row,parent,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            //use existed object
            holder =(ViewHolder) view.getTag();
        }
        photo p = photolist.get(position);
        holder.imageView.setImageResource(p.getImage());
        holder.textView.setText(p.getName());

        return view;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
        ViewHolder(View view){
            imageView  =(ImageView) view.findViewById(R.id.imageView1);
            textView  =(TextView) view.findViewById(R.id.textView);
        }
    }
}
