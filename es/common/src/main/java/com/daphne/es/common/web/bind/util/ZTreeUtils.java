package com.daphne.es.common.web.bind.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.daphne.es.common.entity.AbstractEntity;
import com.daphne.es.common.entity.BaseEntity;
import com.daphne.es.common.plugin.entity.Treeable;
import com.daphne.es.common.plugin.web.controller.entity.ZTree;
import com.google.common.collect.Lists;

public class ZTreeUtils {
	public static <M extends AbstractEntity<ID> & Treeable<ID>, ID extends Serializable> List<ZTree<ID>> convertToZtreeList(
			String contextPath, List<M> models, boolean async, boolean onlySelectLeaf) {
		List<ZTree<ID>> zTrees = Lists.newArrayList();

		if (models == null || models.isEmpty()) {
			return zTrees;
		}

		for (M m : models) {
			ZTree zTree = convertToZtree(m, !async, onlySelectLeaf);
			zTrees.add(zTree);
		}
		return zTrees;
	}

	public static <M extends AbstractEntity<ID> & Treeable<ID>, ID extends Serializable> List<ZTree<ID>> convertToZtreeListIdTotal(
			String contextPath, List<M> models, boolean async, boolean onlySelectLeaf) {
		List<ZTree<ID>> zTrees = Lists.newArrayList();

		if (models == null || models.isEmpty()) {
			return zTrees;
		}

		for (M m : models) {
			ZTree zTree = convertToZtreeIdTotal(m, !async, onlySelectLeaf);
			zTrees.add(zTree);
		}
		return zTrees;
	}

	public static <M extends AbstractEntity<ID> & Treeable<ID>, ID extends Serializable> ZTree<ID> convertToZtree(M m,
			boolean open, boolean onlyCheckLeaf) {
		ZTree<ID> zTree = new ZTree<ID>();
		zTree.setId(m.getId());
		zTree.setPid(m.getParentId());
		zTree.setName(m.getName());
		zTree.setIconSkin(m.getIcon());
		zTree.setOpen(open);
		zTree.setRoot(m.isRoot());
		zTree.setIsParent(m.isHasChildren());

		if (onlyCheckLeaf && zTree.isIsParent()) {
			zTree.setNocheck(true);
		} else {
			zTree.setNocheck(false);
		}

		return zTree;
	}

	/***
	 * ZTree ID 用完整层级路径ids ZTree ID 输出 String 类型。 适合多表，多中类型的id。
	 * 
	 * @param m
	 * @param open
	 * @param onlyCheckLeaf
	 * @return
	 */
	public static <M extends AbstractEntity<ID> & Treeable<ID>, ID extends Serializable> ZTree<String> convertToZtreeIdTotal(
			M m, boolean open, boolean onlyCheckLeaf) {
		ZTree<String> zTree = new ZTree<String>();
		zTree.setId(m.getParentIds() + m.getId());

		zTree.setPid(StringUtils.removeEnd(m.getParentIds(), "/"));

		zTree.setName(m.getName());
		zTree.setIconSkin(m.getIcon());
		zTree.setOpen(open);
		zTree.setRoot(m.isRoot());
		zTree.setIsParent(m.isHasChildren());
		zTree.setDiy(m.getDiy());
		if (onlyCheckLeaf && zTree.isIsParent()) {
			zTree.setNocheck(true);
		} else {
			zTree.setNocheck(false);
		}

		return zTree;
	}

	public static <M extends AbstractEntity<ID> & Treeable<ID>, ID extends Serializable, P extends AbstractEntity<ID> & Treeable<ID>> void relation(
			Collection<M> list, P parent) {
		for (M m : list) {
			m.setParentId(parent.getId());
			m.setParentIds(parent.makeSelfAsNewParentIds());
		}
	}

}
