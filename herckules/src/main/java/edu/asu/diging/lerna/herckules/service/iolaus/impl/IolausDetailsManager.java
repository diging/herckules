package edu.asu.diging.lerna.herckules.service.iolaus.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.diging.lerna.herckules.domain.IIolausDetails;
import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herckules.exceptions.HerckulesException;
import edu.asu.diging.lerna.herckules.exceptions.HerckulesStorageException;
import edu.asu.diging.lerna.herckules.exceptions.IExceptionMessages;
import edu.asu.diging.lerna.herckules.service.iolaus.IIolausConnectionManager;
import edu.asu.diging.lerna.herckules.service.iolaus.IIolausDetailsManager;

@Service
public class IolausDetailsManager implements IIolausDetailsManager {

	@Autowired
	IIolausConnectionManager iolausConnectionManager;

	@Autowired
	IDBManagerInstance dbManagerInstance;

	@Autowired
	IDBManagerProject dbManagerProject;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int addIolausDetails(IIolausDetails iolausdetail)
			throws HerckulesStorageException, HerckulesException {

		if (iolausdetail == null || iolausdetail.getHost() == null
				|| iolausdetail.getHost().trim().equals("")
				|| iolausdetail.getPort() == null
				|| iolausdetail.getPort().trim().equals(""))
			throw new HerckulesException(IExceptionMessages.OPERATION_EXCEPTION);

		if (iolausConnectionManager.checkIolausStatus(iolausdetail).equals(IIolausConnectionManager.SUCCESS_MESSAGE)) {

			return dbManagerInstance.addInstance(iolausdetail);
		}
		else{
			return 0;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int checkForDuplictes(IIolausDetails instance)
			throws HerckulesStorageException, HerckulesException {

		if (instance == null || instance.getHost() == null
				|| instance.getHost().trim().equals("")
				|| instance.getPort() == null
				|| instance.getPort().trim().equals(""))
			throw new HerckulesException(IExceptionMessages.OPERATION_EXCEPTION);

		List<IIolausDetails> iolausDetails = getIolausDetails();

		for (IIolausDetails i : iolausDetails) {
			if (i.equals(instance))
				return 1;
		}

		return 0;

		// call db layer method
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int deleteIolausDetails(String id)
			throws HerckulesStorageException, HerckulesException {

		if (id == null || id.trim().equals(""))
			throw new HerckulesException(IExceptionMessages.OPERATION_EXCEPTION);

		IIolausDetails instance = dbManagerInstance.getInstance(id);
		List<IProject> listOfProjects = dbManagerProject.getAllProjects();
		
		for(IProject project : listOfProjects)
		{
			if(project.getIolausDetails().getHost().equals(instance.getHost()) && project.getIolausDetails().getPort().equals(instance.getPort()))
			{
				return 1;
			}
			
		}
		

		dbManagerInstance.deleteInstance(instance);
		return 0;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateIolausDetails(IIolausDetails instance)
			throws HerckulesStorageException, HerckulesException {

		if (instance == null || instance.getId() == null
				|| instance.getId().trim().equals("")
				|| instance.getHost() == null
				|| instance.getHost().trim().equals("")
				|| instance.getPort() == null
				|| instance.getPort().trim().equals(""))
			throw new HerckulesException(IExceptionMessages.OPERATION_EXCEPTION);

		dbManagerInstance.updateIolausInstance(instance);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IIolausDetails> getIolausDetails()
			throws HerckulesStorageException {

		return dbManagerInstance.getAllInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IIolausDetails getIolausDetailsbyid(String id)
			throws HerckulesStorageException, HerckulesException {
		if (id == null || id.trim().equals(""))
			throw new HerckulesException(IExceptionMessages.OPERATION_EXCEPTION);

		// call db layer method

		return dbManagerInstance.getInstance(id);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IIolausDetails getIolausDetailsbyhost(String host)
			throws HerckulesStorageException, HerckulesException {
		if (host == null || host.trim().equals(""))
			throw new HerckulesException(IExceptionMessages.OPERATION_EXCEPTION);

		// call db layer method

		return dbManagerInstance.getInstanceByHost(host);

	}

}
