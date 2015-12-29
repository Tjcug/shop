package com.shop.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.shop.model.Sorder;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sorder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.shop.model.Sorder
 * @author MyEclipse Persistence Tools
 */
@Repository("sorderDAO")
public class SorderDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SorderDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String NUMBER = "number";

	public void save(Sorder transientInstance) {
		log.debug("saving Sorder instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sorder persistentInstance) {
		log.debug("deleting Sorder instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sorder findById(java.lang.Integer id) {
		log.debug("getting Sorder instance with id: " + id);
		try {
			Sorder instance = (Sorder) getSession().get(
					"com.shop.model.Sorder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sorder instance) {
		log.debug("finding Sorder instance by example");
		try {
			List results = getSession().createCriteria("com.shop.model.Sorder")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sorder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sorder as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findAll() {
		log.debug("finding all Sorder instances");
		try {
			String queryString = "from Sorder";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sorder merge(Sorder detachedInstance) {
		log.debug("merging Sorder instance");
		try {
			Sorder result = (Sorder) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sorder instance) {
		log.debug("attaching dirty Sorder instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sorder instance) {
		log.debug("attaching clean Sorder instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}