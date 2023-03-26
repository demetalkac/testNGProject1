package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class ListenersRetryAnalyzer implements IAnnotationTransformer {
//    This is used to to automatically trigger the ListenersRetry class
//    So that the failed test case automatically will be run 3 times
//    Bu classın amacı, tum fail eden  test caseleri bir kez daha otomatik olarak xml file ile run etmek
//    fail olan testleri tekrar calıstırır,"ListenersRetryAnalyzer" tüm framework'a uygulayabiliriz
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//  bununla "ListenersRetry" classını gorur ve tekrardan run yapabilr
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }

}
