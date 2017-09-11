package finance.product.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trade implements Serializable {

	private TradePK tradePK;
	private String Product;
	private Date StartDate;
	private Date MaturityDate;
	private Date ExpiryDate;
	private String CounterpartyID;
	private String Status;
	private Date AuditTimeStamp;
	private List<Leg> legs;

	public Trade() {

	}

	@Id
	public TradePK getTradePK() {
		return tradePK;
	}

	public void setTradePK(TradePK tradePK) {
		this.tradePK = tradePK;
	}

	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getMaturityDate() {
		return MaturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		MaturityDate = maturityDate;
	}
	public Date getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		ExpiryDate = expiryDate;
	}
	public String getCounterpartyID() {
		return CounterpartyID;
	}
	public void setCounterpartyID(String counterpartyID) {
		CounterpartyID = counterpartyID;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getAuditTimeStamp() {
		return AuditTimeStamp;
	}
	public void setAuditTimeStamp(Date auditTimeStamp) {
		AuditTimeStamp = auditTimeStamp;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="trade")
	public List<Leg> getLegs() {
		return legs;
	}
	public void setLegs(List<Leg> legs) {
		this.legs = legs;
	}

	@Embeddable
	public static class TradePK implements Serializable{

		private int TradeID;
		private int VersionNumber;


		public TradePK() {

		}

		public TradePK(int tradeID, int versionNumber) {
			super();
			TradeID = tradeID;
			VersionNumber = versionNumber;
		}

		public int getTradeID() {
			return TradeID;
		}
		public void setTradeID(int tradeID) {
			TradeID = tradeID;
		}
		public int getVersionNumber() {
			return VersionNumber;
		}
		public void setVersionNumber(int versionNumber) {
			VersionNumber = versionNumber;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + TradeID;
			result = prime * result + VersionNumber;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TradePK other = (TradePK) obj;
			if (TradeID != other.TradeID)
				return false;
			if (VersionNumber != other.VersionNumber)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "TradePK [TradeID=" + TradeID + ", VersionNumber=" + VersionNumber + "]";
		}

	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer(  "Trade [tradePK=" + tradePK + ", Product=" + Product + ", StartDate=" + StartDate + ", MaturityDate="
				+ MaturityDate + ", ExpiryDate=" + ExpiryDate + ", CounterpartyID=" + CounterpartyID + ", Status="
				+ Status + ", AuditTimeStamp=" + AuditTimeStamp + "]");
		//getLegs();
		for(Iterator<Leg> iterator = legs.iterator(); iterator.hasNext(); ) {
			Leg l = iterator.next();
			s.append("\n");
			s.append(l.toString());
		}
		return s.toString();


	}

}

