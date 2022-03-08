package com.yy.example.groovy.web;

import com.yy.config.ResponseObj;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Description:
 * <pre>
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2021-11-19 at 11:27
 */
@Slf4j
@RestController
public class GroovyController {

	@GetMapping("/ctrl/testGroovy")
	public ResponseObj testGroovy(@RequestParam("type") Integer type) throws IOException, IllegalAccessException, InstantiationException {
		Object result = null;
		ResourceScriptSource script = new ResourceScriptSource(new ClassPathResource("groovy/TestResourcePath.groovy"));
		File file = script.getResource().getFile();
		 log.info("file url:{}", file.getAbsolutePath());

		// Path path = Paths.get(System.getProperty("user.dir"), "/groovy/Starter1.groovy");
		// log.info("absolutePath:{}", path.toAbsolutePath());
		switch (type) {
			case 1:
				System.out.println("");
				break;
			default:
				// Java使用GroovyClassLoader动态加载Groovy脚本，调用脚本中的方法
				ClassLoader loader = this.getClass().getClassLoader();
				GroovyClassLoader groovyClassLoader = new GroovyClassLoader(loader);

				Class groovyClass = groovyClassLoader.parseClass(file);
				GroovyObject groovyObject = (GroovyObject)groovyClass.newInstance();
				result = groovyObject.invokeMethod("test", type + "-param");
				System.out.println("case default" + result);
		}

		return new ResponseObj().success(result);
	}

	public static void main(String[] args) throws IllegalAccessException, IOException, InstantiationException {

//		ResourceScriptSource script = new ResourceScriptSource(new ClassPathResource("groovy/TestResourcePath.groovy"));
//		File file = script.getResource().getFile();
//		System.out.println(file.exists());


		GroovyController groovyController = new GroovyController();
		System.out.println("result:" + groovyController.testGroovy(10));

	}
}
