import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanOperation{
    //典型的工具类，不需要实例化对象
    private BeanOperation (){}

    /**
     *
     * @param actionObj xxAction对象
     * @param value emp.name:yuisama|emp.job:Linux Coder
     */
    public static void setBeanValue(Object actionObj,String value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //进行字符串的拆分
        //按照竖线进行拆分
        String[] temp = value.split("\\|");
        //emp.name:yuisama
        //emp.job:Linux Coder
        for(int i = 0; i < temp.length; i++){
            //按照冒号进行拆分
            String[] result = temp[i].split(":");
            //得到真实的值
            String realValue = result[1];
            //取得要设置的真实类名称
            String reslClassName = result[0].split("\\.")[0];
            //取得要设置的属性名称
            String attrName = result[0].split("\\.")[1];
            //通过反射取得xxAction中的真实对象
            //取得了emp对象
            Object realObj = getRealObject(actionObj,reslClassName);
            //取得setter方法
            //1.取得真实类的Class对象
            Class<?> cls = realObj.getClass();
            //2.拼装setter方法名称
            String setName = "set" + initCap(attrName);
            Method setMethod = cls.getDeclaredMethod(setName,String.class);
            setMethod.invoke(realObj,realValue);
        }
    }

    private static Object getRealObject(Object actionObj, String realClassName){
        //取得action对象的class对象
        Class<?> cls = actionObj.getClass();
        String methodName = "get" + initCap(realClassName);
        Object realObj = null;
        //取得Method对象
        try {
            Method method = cls.getDeclaredMethod(methodName);
            //相当于调用了empaction.getEmp();
            try {
                realObj = method.invoke(actionObj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return realObj;
    }

    /**
     * 首字母大写
     * @param str
     * @return
     */
    private static String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }

}