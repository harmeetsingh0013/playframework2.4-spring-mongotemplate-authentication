import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.SpringDataMongoConfiguration;
import play.Application;
import play.GlobalSettings;

/**
 * 
 */

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
public class Global extends GlobalSettings{

	private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	@Override
	public void onStart(final Application app) {
		super.onStart(app);
		context.register(SpringDataMongoConfiguration.class);
		context.scan("app");
		context.refresh();
		context.start();
	}
	
	@Override
	public void onStop(final Application app) {
		context.stop();
		super.onStop(app);
	}
}
