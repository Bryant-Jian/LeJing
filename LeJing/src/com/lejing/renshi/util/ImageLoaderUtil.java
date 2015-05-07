package com.lejing.renshi.util;

import java.io.File;

import android.content.Context;
import android.graphics.Bitmap;

import com.lejing.renshi.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class ImageLoaderUtil {
	
	public static ImageLoaderConfiguration config;
	
	public static DisplayImageOptions options;
	
	@SuppressWarnings("deprecation")
	public static void initImageLoader(Context context){
		
		File cacheDir = StorageUtils.getCacheDirectory(context);
		
		config = new ImageLoaderConfiguration.Builder(context)
				.memoryCacheExtraOptions(480, 800)
				// default = device screen dimensions
				.diskCacheExtraOptions(480, 800, null)
				.taskExecutor(null)
				.taskExecutorForCachedImages(null)
				.threadPoolSize(3)
				// default
				.threadPriority(Thread.NORM_PRIORITY - 1)
				// default
				.tasksProcessingOrder(QueueProcessingType.FIFO)
				// default
				.denyCacheImageMultipleSizesInMemory()
				.memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.memoryCacheSize(2 * 1024 * 1024).memoryCacheSizePercentage(13)
				// default
				.diskCache(new UnlimitedDiscCache(cacheDir))
				// default
				.diskCacheSize(50 * 1024 * 1024).diskCacheFileCount(100)
				.diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
				.imageDownloader(new BaseImageDownloader(context)) // default
				.imageDecoder(new BaseImageDecoder(true)) // default
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
				.writeDebugLogs().build();

		options = new DisplayImageOptions.Builder()
				.cacheInMemory(true).cacheOnDisc(true)
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.bitmapConfig(Bitmap.Config.RGB_565)// 防止内存溢出的，图片太多就这这个。还有其他设�?
				// 如Bitmap.Config.ARGB_8888
				.showImageOnLoading(R.drawable.ic_launcher) // 默认图片
				.showImageForEmptyUri(R.drawable.ic_launcher) // url爲空會显示该图片，自己放在drawable里面�?
				.showImageOnFail(R.drawable.ic_launcher)// 加载失败显示的图�?
				.displayer(new RoundedBitmapDisplayer(5)) // 圆角，不�?��请删�?
				.build();
	}
	
}
