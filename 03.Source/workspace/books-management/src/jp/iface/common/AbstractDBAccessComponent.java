package jp.iface.common;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 
 * hibernateを使用しDBへアクセスするクラスの抽象クラス
 * 
 * @author yk
 *
 */
public abstract class AbstractDBAccessComponent implements Constants{

	protected CommonUtil util = new CommonUtil();
	private static SessionFactory sessionfactory;

	private Session session;
	private Transaction trans;

	/**
	 * デフォルトコンストラクタ
	 * SessionFactoryをSingletonインスタンスとして生成する
	 */
	public AbstractDBAccessComponent() {

		if (sessionfactory == null) {
			Configuration config = new Configuration();
			config = config.configure();
			AbstractDBAccessComponent.sessionfactory = config.buildSessionFactory();
		}
	}

	/**
	 * 引数のレコード情報をDBへ登録する
	 *
	 * @param entity 任意のテーブルのレコード情報
	 */
	protected void save(Object entity) {
		if (this.session == null || !this.session.isOpen()) {
			this.getSession();
			this.session.saveOrUpdate(entity);
			this.close();

		} else {
			this.session.saveOrUpdate(entity);
		}

	}

	/**
	 * トランザクションを開始する
	 */
	protected void beginTransaction() {
		this.getSession();
		this.trans = this.session.beginTransaction();
	}

	/**
	 * トランザクションをコミットする
	 */
	protected void commit() {

		if(this.trans != null) {
			this.session.flush();
			this.trans.commit();
			this.trans = null;
		}
	}

	/**
	 * トランザクションをロールバックする
	 */
	protected void rollback() {
		if(this.trans != null && this.trans.getStatus().canRollback()) {
			this.trans.rollback();
			this.trans = null;
		}
	}

	/**
	 * DBへの接続を閉じる
	 * コミットされていないトランザクションはロールバックされる
	 */
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

	/**
	 *引数のテーブルクラスに対する抽出条件オブジェクを生成する
	 *
	 * @param entity 任意のテーブルを表現するクラス
	 * @return 抽出条件オブジェクト
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	protected Criteria getCriteria(Class entityClass) {
		if (this.session == null || !this.session.isOpen()) {
			this.getSession();

		}
		return this.session.createCriteria(entityClass);
	}
	
	/**
	 * DBへ接続する
	 */
	private void getSession() {
		this.session = AbstractDBAccessComponent.sessionfactory.openSession();
	}

	/**
	 * 抽出条件オブジェクトに対象ページに該当するレコードの抽出条件を追加する
	 * 
	 * @param criteria 抽出条件オブジェクト
	 * @param recordCount 抽出レコード件数
	 * @param pagerListDto ページ情報
	 */
	protected void setPagerCriteria(Criteria criteria, long recordCount, AbstractPagerListDto pagerListDto) {

		if (recordCount != pagerListDto.getRecordCount()) {
			pagerListDto.setRecordCount(recordCount);
			pagerListDto.pageInit();

		}
		if (pagerListDto.getPageDisplayCount() != 0) {
			criteria.setFirstResult(pagerListDto.getOffset()).setMaxResults(pagerListDto.getPageDisplayCount()).list();
		}
	}
}
