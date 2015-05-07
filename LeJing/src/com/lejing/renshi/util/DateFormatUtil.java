package com.lejing.renshi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
@SuppressLint("SimpleDateFormat")
public class DateFormatUtil {

	
	public static String getDate(String str){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = dateFormat.parse(str);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.format(date);
		} catch (ParseException e) {
			LogUtil.e(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 获取本周�?��时间
	 * @param week
	 * @return
	 */
	public static String getWeekStart(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		int w = c.get(7) - 1;
		c.add(Calendar.DATE, -w + 1);
		return format.format(c.getTime());
	}
	
	/**
	 * 获取上周�?��时间
	 * @param week
	 * @return
	 */
	public static String getLastWeekStart(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		int w = c.get(7) - 1 + 7;
		c.add(Calendar.DATE, -w + 1);
		return format.format(c.getTime());
	}
	
	/**
	 * 获取上周周末日期
	 * @return
	 */
	public static String getLastWeekEnd(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		int w = c.get(7) - 1;
		c.add(Calendar.DATE, -w + 1);
		c.set(Calendar.DATE, (c.get(Calendar.DATE) - 1));
		
		return format.format(c.getTime());
	}
	
	/**
	 * 获取上月�?
	 * @return
	 */
	public static String getLastMonthStart(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(c.getTime());
	}
	
	/**
	 * 获取上月月末
	 * @return
	 */
	public static String getLastMonthEnd(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 0);
		return format.format(c.getTime());
	}
	
	/**
	 * 获取本月�?
	 * @return
	 */
	public static String getMonthStart(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(c.getTime());
	}
	
	/**
	 * 获取本月�?���?��
	 * @return
	 */
	public static String getMonthLastDay(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		return format.format(c.getTime());
	}
	
	
	/**
	 * 获取今日
	 * @return
	 */
	public static String getToday(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		Date date = c.getTime();
		return format.format(date);
	}
	
	/**
	 * 获取去年今日
	 * @return
	 */
	public static String getLastYearToday(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -1);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		Date date = c.getTime();
		return format.format(date);
	}
	
	/**
	 * 获取第二�?
	 * @return
	 */
	public static String getTomorrow(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		Date date = c.getTime();
		return format.format(date);
	}
	
	/**
	 * 日期比较
	 * @return
	 */
	public static boolean compareDate(String begin, String end){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date start = null;
		Date endDate = null;
		try {
			start = format.parse(begin);
			endDate = format.parse(end);
			
			if(endDate.before(start)){
				return false;
			}else{
				return true;
			}
		} catch (ParseException e) {
			LogUtil.e(e.getMessage(), e);
		}
		
		return false;
	}
	
	/**
	 * 获取前几月的月初
	 * @param addMonth
	 * @return
	 */
	public static String getAMonthStartDay(int addMonth){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, addMonth);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(c.getTime());
	}
	
	/**
	 * 获取几月前后的月�?
	 * @param addMonth
	 * @return
	 */
	public static String getAMonthEndDay(int addMonth){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, addMonth+1);
		c.set(Calendar.DAY_OF_MONTH, 0);
		return format.format(c.getTime());
	}
	
	/**
	 * 调整FrameLayout大小
	 * @param tp
	 */
	public static void resizePikcer(FrameLayout tp, Context context){
		List<NumberPicker> npList = findNumberPicker(tp);
		for(NumberPicker np:npList){
			resizeNumberPicker(np, context);
		}
	}
	
	/**
	 * 得到viewGroup里面的numberpicker组件
	 * @param viewGroup
	 * @return
	 */
	public static List<NumberPicker> findNumberPicker(ViewGroup viewGroup){
		List<NumberPicker> npList = new ArrayList<NumberPicker>();
		View child = null;
		if(null != viewGroup){
			for(int i = 0;i<viewGroup.getChildCount();i++){
				child = viewGroup.getChildAt(i);
				if(child instanceof NumberPicker){
					npList.add((NumberPicker)child);
				}
				else if(child instanceof LinearLayout){
					List<NumberPicker> result = findNumberPicker((ViewGroup)child);
					if(result.size()>0){
						return result;
					}
				}
			}
		}
		return npList;
	}
	
	/*
	 * 调整numberpicker大小
	 */
	public static void resizeNumberPicker(NumberPicker np, Context context){
		int screenWidth = ScreenUtils.getScreenWidth(context);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) (screenWidth/7.2), LayoutParams.WRAP_CONTENT);
		params.setMargins(10, 0, 10, 0);
		np.setLayoutParams(params);
	}
}
