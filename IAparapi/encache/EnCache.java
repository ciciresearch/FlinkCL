package com.amd.aparapi.encache;

import java.util.*;
import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2018/3/26.
 */
public class EnCache {
	public static HashMap<String, Kernel> kernelCache = new HashMap<String, Kernel>();

	public static HashMap<String, String> openclCache = new HashMap<String, String>();

	public static void resetKernelCache()
	{
		kernelCache.clear();
	}

	public static void resetOpenclCache()
	{
		openclCache.clear();
	}

}
