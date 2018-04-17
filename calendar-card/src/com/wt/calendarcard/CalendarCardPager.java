package com.wt.calendarcard;

import java.util.Calendar;

import android.content.Context;
import android.provider.CalendarContract.CalendarEntity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CalendarCardPager extends ViewPager {

	private CardPagerAdapter mCardPagerAdapter;
	private OnCellItemClick mOnCellItemClick;

	public CalendarCardPager(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);
		init(context);
	}

	public CalendarCardPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public CalendarCardPager(Context context) {
		super(context);
		init(context);
	}
	
	private void init(Context context) {
		mCardPagerAdapter = new CardPagerAdapter(context);
		setAdapter(mCardPagerAdapter);
		setCurrentItem(1073741823);
	}

	public CardPagerAdapter getCardPagerAdapter() {
		return mCardPagerAdapter;
	}

	public OnCellItemClick getOnCellItemClick() {
		return mOnCellItemClick;
	}

	public void setOnCellItemClick(OnCellItemClick mOnCellItemClick) {
		this.mOnCellItemClick = mOnCellItemClick;
		mCardPagerAdapter.setDefaultOnCellItemClick(this.mOnCellItemClick);
		if (getChildCount() > 0) {
			for(int i=0; i<getChildCount(); i++) {
				View v = getChildAt(i);
				if (v instanceof CalendarCard) {
					((CalendarCard) v).setOnCellItemClick(this.mOnCellItemClick);
				}
			}
		}
	}
	public void setToday(){
		CalendarCard card = (CalendarCard) this.getChildAt(1);
		mCardPagerAdapter.setIndex(this.getCurrentItem());
		Calendar dateDisplay = Calendar.getInstance();
		card.setDateDisplay(dateDisplay);
		card.notifyChanges();
		CalendarCard card0 = (CalendarCard) this.getChildAt(0);
		dateDisplay.add(Calendar.MONTH, -1);
		Log.i("==", "=="+dateDisplay.get(Calendar.MONTH));
		card0.setDateDisplay(dateDisplay);
		card0.notifyChanges();
		CalendarCard card2 = (CalendarCard) this.getChildAt(2);
		dateDisplay.add(Calendar.MONTH, 2);
		Log.i("==", "=="+dateDisplay.get(Calendar.MONTH));
		card2.setDateDisplay(dateDisplay);
		card2.notifyChanges();
	}

}
