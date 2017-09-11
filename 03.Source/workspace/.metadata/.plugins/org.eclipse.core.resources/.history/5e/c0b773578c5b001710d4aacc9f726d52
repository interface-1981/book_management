package finance.common.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDBAccessService {

	private static SessionFactory sessionfactory;

	public AbstractDBAccessService() {

		if (sessionfactory == null) {
			Configuration config = new Configuration();
			config = config.configure();
			AbstractDBAccessService.sessionfactory = config.buildSessionFactory();
		}
	}

	protected Session createSession() {

		return AbstractDBAccessService.sessionfactory.openSession();
	}

}
