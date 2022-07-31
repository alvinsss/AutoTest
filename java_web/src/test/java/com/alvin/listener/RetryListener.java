
package com.alvin.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.DisabledRetryAnalyzer;

/**
* @Title: RetryListener
* @Description: 
* @author: alvin
* @date 2022年7月31日 上午9:24:11
*/


public class RetryListener implements IAnnotationTransformer {
	
	/**
	 * 动态修改@Test增加retryAnalyzer=TestngRetry.class
	 */
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
//		 String dataProvider = annotation.getDataProvider();
//		 System.out.println("transform dataProvider--->"+dataProvider);
		 /*TestNG 7.0以上版本已经弃用了annotation.getRetryAnalyzer() 这个方法,
		 如果是低版本使用itestretryAnalyzer == null判断*/
		 Class<? extends IRetryAnalyzer> itestretryAnalyzer = annotation.getRetryAnalyzerClass();
//		 System.out.println("itestretryAnalyzer--->"+itestretryAnalyzer);
		 //为空，表示属性没设置 
		 if (itestretryAnalyzer == DisabledRetryAnalyzer.class) {
			 //设置属性
			 annotation.setRetryAnalyzer(TestngRetry.class);
		 }
	 
	}
}
