package iaparapibridge.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * Created by cc on 2017/10/3.
 */
@Retention(RetentionPolicy.RUNTIME)
public  @interface FieldAnn {

	public int order() default -1;
	public boolean array() default true;
	public int length() default -1;

}
