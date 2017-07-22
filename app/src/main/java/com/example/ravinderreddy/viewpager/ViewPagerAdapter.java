package com.example.ravinderreddy.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
	Context context;
	List<Model> stringList;
	LayoutInflater inflater;

	public ViewPagerAdapter(Context context, List<Model> stringList) {
		this.context = context;
		this.stringList = stringList;


	}
 
	@Override
	public int getCount() {
		return stringList.size();
	}
 
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((LinearLayout) object);
	}
 
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
 
		ImageView imgflag;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpager_item, container, false);

		imgflag = (ImageView) itemView.findViewById(R.id.flag);
		Model model=stringList.get(position);

		Picasso.with(context).load(model.getImage()).fit().into(imgflag);
		(container).addView(itemView);
		return itemView;
	}
 
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// Remove viewpager_item.xml from ViewPager
		((ViewPager) container).removeView((LinearLayout) object);
 
	}
}