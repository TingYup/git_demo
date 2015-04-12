package com.tr.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.alertdialogdemo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	private LinearLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		 ll = (LinearLayout) findViewById(R.id.ll);
	}
	public void adapter(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请选择一种总颜色");
		
		 final BaseAdapter adapter = new Adapter();
		
		builder.setAdapter(adapter, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Drawable drawable= adapter.getView(which, null, null).findViewById(R.id.color).getBackground();
				ll.setBackgroundDrawable(drawable);
			}
		});
		
		builder.setNegativeButton("取消", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				dialog.dismiss();
			}
		});
		
		AlertDialog dialog = builder.create();
		dialog.show();
		
	}
	class Adapter extends BaseAdapter{
		public List<Integer> list = new ArrayList<Integer>();
		
		public void setList(List<Integer> list) {
			this.list = list;
		}
		public Adapter() {
			list.add(Color.BLUE);
			list.add(Color.CYAN);
			list.add(Color.GREEN);
			list.add(Color.LTGRAY);
			list.add(Color.RED);
		}
		@Override
		public int getCount() {
			return list.size();
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
		public View getView(int position, View view, ViewGroup arg2) {
			View v = getLayoutInflater().inflate(R.layout.adapter, null);
			
			TextView tv = (TextView) v.findViewById(R.id.color);
			
			Integer i = list.get(position);
			
			tv.setBackgroundColor(i);
			return v;
		}
		
	}
}
