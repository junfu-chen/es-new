package com.daphne.es.crm.activities.entity;
// Generated 2015-9-15 17:04:38 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

import com.daphne.es.common.plugin.entity.TransientTreeable;
import com.daphne.es.common.plugin.entity.Treeable;

/**
 * CrmActivityHpoint generated by hbm2java
 */
@Entity
@Table(name = "CRM_ACTIVITY_HPOINT", schema = "MAS")
public class CrmActivityHpoint extends TransientTreeable<BigDecimal>implements Treeable<BigDecimal>  {

	private BigDecimal cahId;
	// private BigDecimal casId;
	// private BigDecimal caId;
	private Date startDate;
	private Date endDate;
	private String title;
	private String brand;
	private String calcType;
	private String weekDay;
	private BigDecimal hpointType;
	private BigDecimal rate;
	private BigDecimal point;
	private String sendMsg;
	private Date createDate;
	private String createDt;
	private Date updateDate;
	private String updateDt;
	
	/**
	 * 标题
	 */
	private String name;

	/**
	 * 资源标识符 用于权限匹配的 如sys:resource
	 */
	private String identity = "";

	/**
	 * 点击后前往的地址 菜单才有
	 */
	private String url;

	/**
	 * 父路径
	 */

	private BigDecimal parentId;

	private String parentIds;

	private Integer weight;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 是否有叶子节点
	 */
	// @Formula(value = "(select count(*) from sys_resource f_t where
	// f_t.parent_id = id)")
	private boolean hasChildren;

	/**
	 * 是否显示
	 */

	private Boolean show = Boolean.FALSE;

	private String diy;

	private CrmActivitySteps crmActivitySteps;

	private CrmActivity crmActivity;

	public CrmActivityHpoint() {
	}

	public CrmActivityHpoint(BigDecimal cahId) {
		this.cahId = cahId;
	}

	public CrmActivityHpoint(BigDecimal cahId, Date startDate, Date endDate, String title, String brand,
			String calcType, String weekDay, BigDecimal hpointType, BigDecimal rate, BigDecimal point, String sendMsg,
			Date createDate, String createDt, Date updateDate, String updateDt) {
		this.cahId = cahId;
		// this.casId = casId;
		// this.caId = caId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.title = title;
		this.brand = brand;
		this.calcType = calcType;
		this.weekDay = weekDay;
		this.hpointType = hpointType;
		this.rate = rate;
		this.point = point;
		this.sendMsg = sendMsg;
		this.createDate = createDate;
		this.createDt = createDt;
		this.updateDate = updateDate;
		this.updateDt = updateDt;
	}

	@Column(name = "BRAND", length = 10)
	public String getBrand() {
		return this.brand;
	}

	@Column(name = "CALC_TYPE", length = 10)
	public String getCalcType() {
		return this.calcType;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	@Column(name = "CREATE_DT", length = 30)
	public String getCreateDt() {
		return this.createDt;
	}

	@ManyToOne
	@JoinColumn(name = "CA_ID", insertable = true, updatable = true)
	public CrmActivity getCrmActivity() {
		return crmActivity;
	}

	@ManyToOne
	@JoinColumn(name = "CAS_ID", insertable = true, updatable = true)
	public CrmActivitySteps getCrmActivitySteps() {
		return crmActivitySteps;
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

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", length = 7)
	public Date getEndDate() {
		return this.endDate;
	}

	@Column(name = "HPOINT_TYPE", precision = 22, scale = 0)
	public BigDecimal getHpointType() {
		return this.hpointType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "CRM_ACTIVITY_HPOINT_S", allocationSize = 1)
	@Column(name = "CAH_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@Override
	public BigDecimal getId() {
		return this.cahId;
	}

	@Column(name = "POINT", precision = 22, scale = 0)
	public BigDecimal getPoint() {
		return this.point;
	}

	@Column(name = "RATE", precision = 22, scale = 0)
	public BigDecimal getRate() {
		return this.rate;
	}

	@Column(name = "SEND_MSG", length = 1000)
	public String getSendMsg() {
		return this.sendMsg;
	}

//	@Temporal(TemporalType.DATE)
//	@Column(name = "START_DATE", length = 7)
//	public Date getStartDate() {
//		return this.startDate;
//	}

	@Column(name = "TITLE", length = 200)
	public String getTitle() {
		return this.title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", length = 7)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	@Column(name = "UPDATE_DT", length = 30)
	public String getUpdateDt() {
		return this.updateDt;
	}

	@Column(name = "WEEK_DAY", length = 90)
	public String getWeekDay() {
		return this.weekDay;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCalcType(String calcType) {
		this.calcType = calcType;
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

	public void setHpointType(BigDecimal hpointType) {
		this.hpointType = hpointType;
	}

	@Override
	public void setId(BigDecimal cahId) {
		this.cahId = cahId;
	}

	public void setPoint(BigDecimal point) {
		this.point = point;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	@Transient
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return getTitle();
	}
	@Transient
	@Override
	public String getDiy() {
		// TODO Auto-generated method stub
		return getId()+"";
	}
}