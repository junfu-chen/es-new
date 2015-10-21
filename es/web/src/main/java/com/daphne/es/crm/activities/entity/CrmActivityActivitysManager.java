package com.daphne.es.crm.activities.entity;
// Generated 2015-9-15 17:04:38 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.jpa.criteria.ValueHandlerFactory.BigDecimalValueHandler;
import org.springframework.format.annotation.DateTimeFormat;

import com.daphne.es.common.entity.AbstractEntity;
import com.daphne.es.common.plugin.entity.TransientTreeable;
import com.daphne.es.common.plugin.entity.Treeable;

/**
 * CrmActivityActivitysManager generated by hbm2java
 */
@Entity
@Table(name = "CRM_ACTIVITY_ACTIVITYS_MANAGER", schema = "MAS")
public class CrmActivityActivitysManager extends TransientTreeable<BigDecimal>  implements Treeable<BigDecimal>{

	private BigDecimal   caamId;

	// private BigDecimal casId;
	//
	// private BigDecimal caId;

	private String scripts;

	private Date startDate;

	private Date endDate;

	private String sendMsg;

	private Date createDate;

	private String createDt;

	private Date updateDate;

	private String updateDt;
	private CrmActivitySteps crmActivitySteps;

	private CrmActivity crmActivity;

	public CrmActivityActivitysManager() {
	}

	public CrmActivityActivitysManager(CrmActivity crmActivity) {
		this.crmActivity=crmActivity;
	}

	public CrmActivityActivitysManager(BigDecimal caamId) {
		this.caamId = caamId;
	}

	public CrmActivityActivitysManager(BigDecimal caamId, String scripts, Date startDate, Date endDate, String sendMsg,
			Date createDate, String createDt, Date updateDate, String updateDt) {
		this.caamId = caamId;
		// this.casId = casId;
		// this.caId = caId;
		this.scripts = scripts;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sendMsg = sendMsg;
		this.createDate = createDate;
		this.createDt = createDt;
		this.updateDate = updateDate;
		this.updateDt = updateDt;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	@Column(name = "CREATE_DT", length = 30)
	public String getCreateDt() {
		return this.createDt;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CA_ID", insertable = true, updatable = true)
	public CrmActivity getCrmActivity() {
		return crmActivity;
	}

	@ManyToOne
	@JoinColumn(name = "CAS_ID", insertable = true, updatable = true)
	public CrmActivitySteps getCrmActivitySteps() {
		return crmActivitySteps;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", length = 7)
	public Date getEndDate() {
		return this.endDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "CRM_ACTIVITY_ACT_MANAGER_S", allocationSize = 1)
	@Column(name = "CAAM_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@Override
	public BigDecimal getId() {
		return this.caamId;
	}

	// @Column(name = "CAS_ID", precision = 22, scale = 0)
	// public BigDecimal getCasId() {
	// return this.casId;
	// }
	//
	// public void setCasId(BigDecimal casId) {
	// this.casId = casId;
	// }
	//
	// @Column(name = "CA_ID", precision = 22, scale = 0)
	// public BigDecimal getCaId() {
	// return this.caId;
	// }
	//
	// public void setCaId(BigDecimal caId) {
	// this.caId = caId;
	// }

	@Column(name = "SCRIPTS", length = 2500)
	public String getScripts() {
		return this.scripts;
	}

	@Column(name = "SEND_MSG", length = 1000)
	public String getSendMsg() {
		return this.sendMsg;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", length = 7)
	public Date getStartDate() {
		return this.startDate;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE", length = 7)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	@Column(name = "UPDATE_DT", length = 30)
	public String getUpdateDt() {
		return this.updateDt;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public void setCrmActivity(CrmActivity crmActivity) {
		this.crmActivity = crmActivity;
	}

	public void setCrmActivitySteps(CrmActivitySteps crmActivitySteps) {
		this.crmActivitySteps = crmActivitySteps;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public void setId(BigDecimal caamId) {
		this.caamId = caamId;
	}

	public void setScripts(String scripts) {
		this.scripts = scripts;
	}

	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	@Transient
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return getSendMsg();
	}
	@Transient
	@Override
	public String getDiy() {
		// TODO Auto-generated method stub
		return getId()+"";
	}
}
