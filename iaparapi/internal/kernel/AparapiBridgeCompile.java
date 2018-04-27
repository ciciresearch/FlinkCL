package iaparapi.internal.kernel;

import iaparapi.internal.model.ClassModel;
import iaparapi.internal.model.Entrypoint;
import iaparapi.internal.writer.KernelWriter;
import iaparapi.Kernel;

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
