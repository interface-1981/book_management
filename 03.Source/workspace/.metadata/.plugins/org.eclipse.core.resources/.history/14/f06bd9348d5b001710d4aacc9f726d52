package finance.product.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;

import finance.common.CommonUtil;
import finance.common.service.AbstractDBAccessService;
import finance.product.dto.TradeSummery;
import finance.product.dto.TradeSummeryFilter;
import finance.product.entity.Cashflow;
import finance.product.entity.Leg;
import finance.product.entity.Trade;
import finance.product.model.Product;
import finance.product.service.ProductService;


@Component
public class ProductServiceImpl extends AbstractDBAccessService implements ProductService{


	@Override
	public void save(Product product) {

		Session session = super.createSession();
		Transaction trans = session.beginTransaction();
		Trade trade = product.getTrade();
		trade.setAuditTimeStamp(new Date());
		try {
			if (product.getTradeID() == 0) {
				@SuppressWarnings({ "rawtypes", "deprecation" })
				NativeQuery query = session.createSQLQuery("select coalesce(max(tradeid),0) from trade");
				@SuppressWarnings("deprecation")
				int id = (int) query.list().get(0);

				++id;
				product.setTradeID(id);
				if (!product.existsCashflow()) {
					product.generateCashflows();
				}

				session.save(product.getTrade());
				session.flush();
				trans.commit();
			} else {
				if (!product.existsCashflow()) {
					product.generateCashflows();
				}
				session.update(product.getTrade());
				session.flush();
				trans.commit();
			}
		} finally {
			if(trans.getStatus().canRollback()) {
				trans.rollback();
			}

			session.close();
		}
	}

	@Override
	public List<TradeSummery> getTradeSummery(TradeSummeryFilter filter ) {

		List<TradeSummery> results = new ArrayList<TradeSummery>();
		Session session = super.createSession();

		try {
			//@SuppressWarnings({ "rawtypes", "deprecation" })
			Criteria criteria = session.createCriteria(Trade.class);
			criteria.add(Restrictions.between("expiryDate", filter.getCriteriaExpiryDateFrom(), filter.getCriteriaExpiryDateTo()));
			criteria.add(Restrictions.between("startDate", filter.getCriteriaStartDateFrom(), filter.getCriteriaStartDateTo()));

			if (!CommonUtil.isEmpty(filter.getProduct())) {
				criteria.add(Restrictions.eq("product", filter.getProduct()));
			}

			if (!CommonUtil.isEmpty(filter.getStatus())) {
				criteria.add(Restrictions.eq("status", filter.getStatus()));
			}

			List<Trade> list = criteria.list();

			TradeSummery ts;
			for(Trade t : list) {

				ts = new TradeSummery();
				ts.setTradeID(t.getTradePK().getTradeID());
				ts.setProduct(t.getProduct());
				ts.setCounterpartyID(t.getCounterpartyID());
				ts.setStartDate(t.getStartDate());
				ts.setMaturityDate(t.getMaturityDate());
				ts.setExpiryDate(t.getExpiryDate());
				ts.setStatus(t.getStatus());
				ts.setAuditTimeStamp(t.getAuditTimeStamp());

				if(t.getLegs().size() > 0) {

					ts.setLeg1Currency(t.getLegs().get(0).getCurrency());
					ts.setLeg1PrincipalAmount(t.getLegs().get(0).getPrincipalAmount());
					ts.setLeg1FixOrFloat(t.getLegs().get(0).getFixOrFloat());
					ts.setLeg1PayOrRec(t.getLegs().get(0).getPayOrRec());

				}

				if(t.getLegs().size() > 1) {

					ts.setLeg2Currency(t.getLegs().get(1).getCurrency());
					ts.setLeg2PrincipalAmount(t.getLegs().get(1).getPrincipalAmount());
					ts.setLeg2FixOrFloat(t.getLegs().get(1).getFixOrFloat());
					ts.setLeg2PayOrRec(t.getLegs().get(1).getPayOrRec());

				}

				results.add(ts);

			}
			return results;
		} finally {
			session.close();
		}
	}

	@Override
	public void load(Product product, int tradeID) {
		product.setTrade(this.getTrade(tradeID));

	}

	private Trade getTrade(int tradeID) {

		Session session = super.createSession();

		try {
			//@SuppressWarnings({ "rawtypes", "deprecation" })
			Criteria criteria = session.createCriteria(Trade.class);
			criteria.add(Restrictions.eq("tradePK", new Trade.TradePK(tradeID, 0)));
			List<Trade> list = criteria.list();

			if(list.size() != 1) {

				return null;
			}
			Hibernate.initialize(list.get(0).getLegs());
			for (Leg l : list.get(0).getLegs()) {
				Hibernate.initialize(l.getCashflows());
				for(Cashflow c : l.getCashflows()) {
					Hibernate.initialize(c.getResets());
				}
			}
			return list.get(0);
		} finally {
			session.close();
		}
	}
}
