package com.kiri.hackjak.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiri.hackjak.R;
import com.kiri.hackjak.RouteMapActivity;
import com.kiri.hackjak.db.TrayekRouteDetail;

public class ResultAdapter extends ArrayAdapter<TrayekRouteDetail> {
	private List<TrayekRouteDetail> mList;
	private Context mContext;
	private int mResource;
	private LayoutInflater mInflater;

	public ResultAdapter(Context context, int resource,
			List<TrayekRouteDetail> list) {
		super(context, resource, list);
		this.mContext = context;
		this.mResource = resource;
		this.mList = list;
		this.mInflater = ((Activity) mContext).getLayoutInflater();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			this.mInflater = ((Activity) mContext).getLayoutInflater();
			convertView = mInflater.inflate(mResource, null);
		}

		TrayekRouteDetail step = mList.get(position);

		TextView textNoTrayek = (TextView) convertView
				.findViewById(R.id.textNoTrayek);
		TextView textResult = (TextView) convertView
				.findViewById(R.id.textStep);
		ImageView imageMap = (ImageView) convertView
				.findViewById(R.id.imageMap);

		textNoTrayek.setText(step.getIdRuteTrayek() + "");
		textResult.setText(step.getIdWaypoint() + "");
		imageMap.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, RouteMapActivity.class);
				mContext.startActivity(intent);
			}
		});

		return convertView;
	}

}
