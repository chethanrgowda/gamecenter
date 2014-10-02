package com.example.mmsviewpager;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	ViewPager matchPages;
	MatchPagesAdapter matchPagesAdapter;
	LinearLayout dotsLayout;
	ImageButton dotImage;
	String[] teamNames1 = { "India", "Australia", "New Zealand", "Zimbabwe" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		matchPages = (ViewPager) findViewById(R.id.matchPages);
		matchPagesAdapter = new MatchPagesAdapter(MainActivity.this, teamNames1);
		matchPages.setAdapter(matchPagesAdapter);
		dotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);
		dotCreate();
		pageChangeListener();
	}

	private void dotCreate() {
	
		for (int i = 0; i < matchPagesAdapter.getCount(); i++) {
			dotImage = new ImageButton(this);
			dotImage.setTag(i);
			dotImage.setImageResource(R.drawable.dot_selector);
			dotImage.setPadding(5, 5, 5, 5);
			dotImage.setBackgroundResource(0);
			dotImage.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					matchPages.setCurrentItem(Integer.valueOf(v.getTag().toString()));
				}
			});
			LayoutParams param = new LayoutParams(30, 30);
			dotImage.setLayoutParams(param);
			if (i == 0)
				dotImage.setSelected(true);
			dotsLayout.addView(dotImage);
		}
	
	}

	private void pageChangeListener() {
		matchPages.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int position) {
				
			}

			@Override
			public void onPageScrolled(int position, float arg1, int arg2) {
			}

			@Override
			public void onPageSelected(int position) {
				for (int i = 0; i < matchPagesAdapter.getCount(); i++) {
					if (i != position) {
						((ImageView) dotsLayout.findViewWithTag(i))
								.setSelected(false);
					}

				}
				((ImageView) dotsLayout.findViewWithTag(position))
						.setSelected(true);
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
