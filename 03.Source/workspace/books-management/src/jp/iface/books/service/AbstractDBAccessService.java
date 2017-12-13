package jp.iface.books.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jp.iface.books.dto.AbstractPagerListDto;
import jp.iface.books.util.CommonUtil;

public abstract class AbstractDBAccessService {

	protected CommonUtil util = new CommonUtil();
	private static SessionFactory sessionfactory;

	private Session session;
	private Transaction trans;

	public AbstractDBAccessService() {

		if (sessionfactory == null) {
			Configuration config = new Configuration();
			config = config.configure();
			AbstractDBAccessService.sessionfactory = config.buildSessionFactory();
		}
	}

	protected void save(Object entity) {
		if (this.session == null || !this.session.isOpen()) {
			this.createSession();
			this.session.saveOrUpdate(entity);
			this.close();

		} else {
			this.session.saveOrUpdate(entity);
		}

	}

	protected void beginTransaction() {
		createSession();
		this.trans = this.session.beginTransaction();
	}

	protected void commit() {

		if(this.trans != null) {
			this.session.flush();
			this.trans.commit();
			this.trans = null;
		}
	}

	protected void rollback() {
		if(this.trans != null && this.trans.getStatus().canRollback()) {
			this.trans.rollback();
			this.trans = null;
		}
	}

	protected void close() {

		if(this.trans != null && this.trans.getStatus().canRollback()) {
			this.trans.rollback();
			this.trans = null;
		}

		if (this.session != null && this.session.isOpen()) {
			this.session.close();
			this.session = null;
		}
	}

	protected Criteria getCriteria(Class arg0) {
		if (this.session == null || !this.session.isOpen()) {
			this.createSession();

		}
		return this.session.createCriteria(arg0);
	}
	private void createSession() {
		this.session = AbstractDBAccessService.sessionfactory.openSession();
	}

	protected void setPagerCriteria(Criteria criteria, long recordCount, AbstractPagerListDto pagerListDto) {

		if (recordCount != pagerListDto.getRecordCount()) {
			pagerListDto.setRecordCount(recordCount);
			pagerListDto.pageInit();

		}
		if (pagerListDto.getDisplayCount() != 0) {
			criteria.setFirstResult(pagerListDto.getOffset()).setMaxResults(pagerListDto.getDisplayCount()).list();
		}
	}
}
