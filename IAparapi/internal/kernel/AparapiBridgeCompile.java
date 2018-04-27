package com.amd.aparapi.internal.kernel;

import com.amd.aparapi.internal.instruction.Instruction;
import com.amd.aparapi.internal.model.ClassModel;
import com.amd.aparapi.internal.model.ClassModel.ConstantPool;
import com.amd.aparapi.internal.model.Entrypoint;
import com.amd.aparapi.internal.model.MethodModel;
import com.amd.aparapi.internal.writer.KernelWriter;
import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2018/3/22.
 */
public class AparapiBridgeCompile {

	static Kernel kernel;

	public static void setKernel(Kernel _kernel)
	{
		kernel = _kernel;
	}

	public static String writeCL() {

		String  openCL = null;

		double start = System.currentTimeMillis();

		try {
			final ClassModel classModel = new ClassModel(kernel.getClass());

			Class<?> list = classModel.getClassWeAreModelling();

			/*
			for(Field feildEntry : list.getDeclaredFields()){
				// System.out.println( feildEntry.getType() );
			}

			// MethodModel model =  classModel.getMethodModel();
			*/

			//获取对象模型的时候就做了很多事情
			Entrypoint entrypoint = classModel.getEntrypoint();
			openCL = KernelWriter.writeToString(entrypoint);
			System.out.println(""+openCL);

		} catch (Exception e) {
			e.printStackTrace();
		}

		double end = System.currentTimeMillis();

		System.out.println("ccccccccccccccccccccccc:"+(end-start));

		return  openCL;
	}


}
