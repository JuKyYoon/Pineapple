package pineapple.iq_quest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pineapple.for_future.R;
import pineapple.iq_quest.data.InfoClass;


public class CustomAdapter extends BaseAdapter{
	
	private LayoutInflater inflater;
	private ArrayList<InfoClass> infoList;
	private ViewHolder viewHolder;
	
	public CustomAdapter(Context c , ArrayList<InfoClass> array){
		inflater = LayoutInflater.from(c);
		infoList = array;
	}

	@Override
	public int getCount() {
		return infoList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertview, ViewGroup parent) {
		
		View v = convertview;
		
		if(v == null){
			viewHolder = new ViewHolder();
			v = inflater.inflate(R.layout.list_row, null);
			viewHolder.name = (TextView)v.findViewById(R.id.tv_name);
			viewHolder.contact = (TextView)v.findViewById(R.id.tv_contact);
			viewHolder.email = (TextView)v.findViewById(R.id.tv_email);
			v.setTag(viewHolder);
			
		}else {
			viewHolder = (ViewHolder)v.getTag();
		}
		
		viewHolder.name.setText(infoList.get(position).name);
		viewHolder.contact.setText(infoList.get(position).contact);
		viewHolder.email.setText(infoList.get(position).email);
		
		return v;
	}
	
	public void setArrayList(ArrayList<InfoClass> arrays){
		this.infoList = arrays;
	}
	
	public ArrayList<InfoClass> getArrayList(){
		return infoList;
	}
	
	
	/*
	 * ViewHolder
	 */
	class ViewHolder{
		TextView name;
		TextView contact;
		TextView email;
	}
	

}







