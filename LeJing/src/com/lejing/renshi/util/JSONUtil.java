package com.lejing.renshi.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lejing.renshi.po.ListItem;



public class JSONUtil {
	@SuppressWarnings("unchecked")
	public static <T extends com.lejing.renshi.po.ListItem> List<T> getList(JSONObject jsonData,
			String key, T t) {
		if (jsonData == null) {
			return null;
		}

		if (!jsonData.has(key)) {
			return null;
		}

		try {
			JSONArray jsArr = jsonData.getJSONArray(key);
			if (jsArr == null || jsArr.length() == 0) {
				return null;
			}

			List<T> res = new ArrayList<T>();

			T nt = t;
			for (int i = 0; i < jsArr.length(); i++) {
				if (nt == null) {
					nt = (T) t.newObject();
				}
				nt.parseFromJson(jsArr.getJSONObject(i));

				res.add(nt);

				nt = null;
			}
			return res;
		} catch (JSONException e) {
			LogUtil.e(e.getMessage(), e);
		}

		return null;
	}
	
	/**
	 * set集合
	 * @param jsonData
	 * @param key
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ListItem> Set<T> getSetList(JSONObject jsonData,
			String key, T t) {
		if (jsonData == null) {
			return null;
		}

		if (!jsonData.has(key)) {
			return null;
		}

		try {
			JSONArray jsArr = jsonData.getJSONArray(key);
			if (jsArr == null || jsArr.length() == 0) {
				return null;
			}

			Set<T> res = new HashSet<T>();

			T nt = t;
			for (int i = 0; i < jsArr.length(); i++) {
				if (nt == null) {
					nt = (T) t.newObject();
				}
				nt.parseFromJson(jsArr.getJSONObject(i));

				res.add(nt);

				nt = null;
			}
			return res;
		} catch (JSONException e) {
			LogUtil.e(e.getMessage(), e);
		}

		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends ListItem> List<T> getList(JSONArray jsArr, T t) {
		try {
			if (jsArr == null || jsArr.length() == 0) {
				return null;
			}

			List<T> res = new ArrayList<T>();

			T nt = t;
			for (int i = 0; i < jsArr.length(); i++) {
				if (nt == null) {
					nt = (T) t.newObject();
				}
				nt.parseFromJson(jsArr.getJSONObject(i));

				res.add(nt);

				nt = null;
			}
			return res;
		} catch (JSONException e) {
			LogUtil.e(e.getMessage(), e);
		}

		return null;
	}
	
	/**
	 * set集合
	 * @param jsArr
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends ListItem> Set<T> getSetList(JSONArray jsArr, T t) {
		try {
			if (jsArr == null || jsArr.length() == 0) {
				return null;
			}

			Set<T> res = new HashSet<T>();

			T nt = t;
			
			for (int i = 0; i < jsArr.length(); i++) {
				if (nt == null) {
					nt = (T) t.newObject();
				}
				nt.parseFromJson(jsArr.getJSONObject(i));

				res.add(nt);

				nt = null;
			}
			return res;
		} catch (JSONException e) {
			LogUtil.e(e.getMessage(), e);
		}

		return null;
	}
	
	public static <T extends ListItem> T getObject(JSONObject jsArr, T t) {
		try {
			if (jsArr == null ) {
				return null;
			}
			T nt = t;
			nt = t.newObject();
			nt.parseFromJson(jsArr);
			return nt;
		} catch (JSONException e) {
			LogUtil.e(e.getMessage(), e);
		}
		return null;
	}


}
