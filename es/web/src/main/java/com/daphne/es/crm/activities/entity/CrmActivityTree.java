package com.daphne.es.crm.activities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Formula;

import com.daphne.es.common.entity.BaseEntity;
import com.daphne.es.common.plugin.entity.Treeable;

@Entity
@Table(name = "crm_activity_tree", schema = "MAS")
public class CrmActivityTree extends BaseEntity<Long> implements Treeable<Long> {
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
	@Column(name = "parent_id")
	private Long parentId;

	@Column(name = "parent_ids")
	private String parentIds;

	private Integer weight;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 是否有叶子节点
	 */
	@Formula(value = "(select count(*) from sys_resource f_t where f_t.parent_id = id)")
	private boolean hasChildren;

	/**
	 * 是否显示
	 */
	@Column(name = "is_show")
	private Boolean show = Boolean.FALSE;

	private String diy;

	/**
	 * 树枝节点默认图标 如果没有默认 空即可
	 *
	 * @return
	 */
	@Override
	public String getBranchDefaultIcon() {
		return "ztree_folder";
	}

	@Override
	public String getDiy() {
		return diy;
	}

	@Override
	public String getIcon() {
		if (!StringUtils.isEmpty(icon)) {
			return icon;
		}
		if (isRoot()) {
			return getRootDefaultIcon();
		}
		if (isLeaf()) {
			return getLeafDefaultIcon();
		}
		return getBranchDefaultIcon();
	}

	public String getIdentity() {
		return identity;
	}

	/**
	 * 树叶节点默认图标 如果没有默认 空即可
	 *
	 * @return
	 */
	@Override
	public String getLeafDefaultIcon() {
		return "ztree_file";
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public Long getParentId() {
		return parentId;
	}

	@Override
	public String getParentIds() {
		return parentIds;
	}

	/**
	 * 根节点默认图标 如果没有默认 空即可
	 *
	 * @return
	 */
	@Override
	public String getRootDefaultIcon() {
		return "ztree_setting";
	}

	@Override
	public String getSeparator() {
		return "/";
	}

	public Boolean getShow() {
		return show;
	}

	public String getTreetableIds() {
		String selfId = makeSelfAsNewParentIds().replace("/", "-");
		return selfId.substring(0, selfId.length() - 1);
	}

	public String getTreetableParentIds() {
		String parentIds = getParentIds().replace("/", "-");
		return parentIds.substring(0, parentIds.length() - 1);
	}

	public String getUrl() {
		return url;
	}

	@Override
	public Integer getWeight() {
		return weight;
	}

	@Override
	public boolean isHasChildren() {
		return hasChildren;
	}

	@Override
	public boolean isLeaf() {
		if (isRoot()) {
			return false;
		}
		if (isHasChildren()) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isRoot() {
		if (getParentId() != null && getParentId() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String makeSelfAsNewParentIds() {
		return getParentIds() + getId() + getSeparator();
	}

	@Override
	public void setDiy(String diy) {
		this.diy = diy;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	@Override
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
