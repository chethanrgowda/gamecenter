package com.example.mmsviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MatchPagesAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    String[] teamName1;
	public MatchPagesAdapter(Context context, String[] teamName1) {
		this.context = context;
		this.teamName1 = teamName1;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return teamName1.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return view == ((RelativeLayout) object);
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		TextView teamOne;
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View matchPage = inflater.inflate(R.layout.match_pages, container,false);
		
		teamOne = (TextView) matchPage.findViewById(R.id.teamName1);
		teamOne.setText(teamName1[position]);
		((ViewPager) container).addView(matchPage);
		return matchPage;
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		// Remove view page item from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
	}

}
