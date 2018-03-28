package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.app.domain.Project;
import com.app.utility.HibernateUtil;

public class ManyToManyDaoImpl implements ManyToManyDao {

	private static final String HQL_GET_ALL_PROJECTS_PROGRAMMERS = "from Project";
	private static final String SQL_DELETE_PROGRAMMER_BY_NO = "DELETE FROM PROGRAMMERS_PROJECTS WHERE  PROGRAMMER_ID=:prgmrId AND PROJECT_ID=:projId";
	private static final String SQL_GET_PROJECTS_WHERE_PROGRAMMER_NOT_WORKING = " select distinct(Project_id) from programmers_projects where project_id in(select project_id from programmers_projects where project_id not in(select project_id from programmers_projects where programmer_id=:prgmrId))";
	private static final String SQL_CHAAGE_PROGRAMMER_TO_NEWPORJECT = "UPDATE PROGRAMMERS_PROJECTS SET PROJECT_ID=:newprojId WHERE PROGRAMMER_ID=:prgmrId AND PROJECT_ID=:oldprojId";

	@Override
	public List<Project> ListAllProjectWithProgrammers() {
		Session ses = null;
		List<Project> list = null;
		Query query = null;
		// get Session
		ses = HibernateUtil.getSession();
		// get All Projects and associated programmers
		query = ses.createQuery(HQL_GET_ALL_PROJECTS_PROGRAMMERS);
		list = query.list();
		System.out.println("dao" + list.size());
		return list;
	}

	@Override
	public int removeProgrammerFromProject(int prgmrId, int projId) {
		Session ses = null;
		SQLQuery query = null;
		Transaction tx = null;
		int result = 0;
		// get Session
		ses = HibernateUtil.getSession();
		// prepare Query
		query = ses.createSQLQuery(SQL_DELETE_PROGRAMMER_BY_NO);
		// set param values
		query.setInteger("prgmrId", prgmrId);
		query.setInteger("projId", projId);
		try {
			tx = ses.beginTransaction();
			result = query.executeUpdate();
			tx.commit();
		} // try
		catch (HibernateException e) {
			tx.rollback();
			throw e;
		}
		return result;
	}

	@Override
	public List<Project> listOtherProjectsInfoWhereProgrammerNotWorking(int prgmrId) {
		Session ses = null;
		SQLQuery query = null;
		Transaction tx = null;
		List<Integer> listProjIds = null;
		List<Project> listProjs = null;
		Project project = null;

		int result = 0;
		// get Session
		ses = HibernateUtil.getSession();
		// prepare Query
		query = ses.createSQLQuery(SQL_GET_PROJECTS_WHERE_PROGRAMMER_NOT_WORKING);
		// set param values
		query.setInteger("prgmrId", prgmrId);
		query.addScalar("PROJECT_ID", StandardBasicTypes.INTEGER);
		// execute Query
		listProjIds = query.list();

		// get ListProjects using ProjectIds[]
		listProjs = new ArrayList();
		for (Integer projNo : listProjIds) {
			System.out.println(projNo);
			project = (Project) ses.get(Project.class, projNo);
			listProjs.add(project);
		}
		System.out.println("11-->" + listProjs.size());
		return listProjs;
	}

	@Override
	public int moveProgrammerToAnotherExistingProject(int prgmrId, int oldProjId, int newProjId) {
		Session ses = null;
		SQLQuery query = null;
		Transaction tx = null;
		int result = 0;
		// get Session
		ses = HibernateUtil.getSession();
		// prepare Query
		query = ses.createSQLQuery(SQL_CHAAGE_PROGRAMMER_TO_NEWPORJECT);
		// set param values
		query.setInteger("newprojId", newProjId);
		query.setInteger("prgmrId", prgmrId);
		query.setInteger("oldprojId", oldProjId);
		try {
			tx = ses.beginTransaction();
			result = query.executeUpdate();
			tx.commit();
		} // try
		catch (HibernateException e) {
			tx.rollback();
			throw e;
		}
		return result;
	}// method
}