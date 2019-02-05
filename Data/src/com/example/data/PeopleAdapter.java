package com.example.data;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PeopleAdapter extends BaseAdapter{

	private final Context context;
    private ArrayList<People> peoplelist;
    public PeopleAdapter(Context context)
    {
        this.context = context;
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return peoplelist!=null?peoplelist.size():0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return peoplelist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View View, ViewGroup parent) {
		PeopleHolder holder=null;
        if(View==null){
            //object
            LayoutInflater inflater = LayoutInflater.from(context);
            View = inflater.inflate(R.layout.new_layout,parent,false);
            holder = new PeopleHolder(View);
            View.setTag(holder);
        }else{
            //use existed object
            holder =(PeopleHolder) View.getTag();
        }
        People p = peoplelist.get(position);
        holder.nameView.setText(p.getName());
        holder.phoneView.setText(p.getPhone());

        return View;
	}

	public void setDataSource(ArrayList<People> peoplelist) {
        this.peoplelist = peoplelist;
    }
}
class PeopleHolder{
    TextView nameView , phoneView;
   PeopleHolder(View view)
   {
        nameView =(TextView) view.findViewById(R.id.textView);
        phoneView =(TextView) view.findViewById(R.id.textView2);
   }
        
    
}
