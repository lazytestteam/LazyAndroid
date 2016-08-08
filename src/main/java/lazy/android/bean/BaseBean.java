package lazy.android.bean;

import io.appium.java_client.AppiumDriver;
import lazy.android.annotations.Description;
import lazy.android.annotations.FullIndexXpath;
import lazy.android.annotations.Xpath;
import lazy.android.controls.ControlType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

public class BaseBean {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	protected AppiumDriver driver;

	public BaseBean(AppiumDriver aDriver) {
		this.driver = aDriver;
		try {
			Field[] fields = this.getClass().getDeclaredFields();

			for (Field field : fields) {
				try {
					ControlType.valueOf(field.getType().getSimpleName()
							.toUpperCase());
				} catch (Exception e) {
					continue;
				}

				field.setAccessible(true);
				Object object = field.getType().newInstance();

				if (field.isAnnotationPresent(Xpath.class)) {
					String[] xpath = field.getAnnotation(Xpath.class).xpath();

					Field xpathField = getAbstractControl(field)
							.getDeclaredField("xpath");
					xpathField.setAccessible(true);
					xpathField.set(object, xpath);
				}

				if (field.isAnnotationPresent(FullIndexXpath.class)) {
					String fullIndexXpath = field.getAnnotation(
							FullIndexXpath.class).fullIndexXpath();

					Field fullIndexXpathField = getAbstractControl(field)
							.getDeclaredField("fullIndexXpath");
					fullIndexXpathField.setAccessible(true);
					fullIndexXpathField.set(object, fullIndexXpath);
				}

				if (field.isAnnotationPresent(Description.class)) {
					String description = field.getAnnotation(Description.class)
							.description();

					Field descField = getAbstractControl(field)
							.getDeclaredField("description");
					descField.setAccessible(true);
					descField.set(object, description);
				}

				Field beField = getAbstractControl(field).getDeclaredField(
						"driver");
				beField.setAccessible(true);
				beField.set(object, driver);

				field.set(this, object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Class<?> getAbstractControl(Field field) {
		Class<?> abstractControl = field.getType();

		while (!abstractControl.getSimpleName().equals("AbstractControl")) {
			abstractControl = abstractControl.getSuperclass();
		}

		return abstractControl;
	}

}