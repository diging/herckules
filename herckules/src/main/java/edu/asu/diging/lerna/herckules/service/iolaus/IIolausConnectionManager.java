package edu.asu.diging.lerna.herckules.service.iolaus;

import java.util.List;

import edu.asu.diging.lerna.herckules.domain.IIolausDetails;
import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herckules.exceptions.HerckulesException;
import edu.asu.diging.lerna.herckules.exceptions.HerckulesStorageException;

public interface IIolausConnectionManager {

	public static final String SUCCESS_MESSAGE="success";
	public static final String FAILURE_MESSAGE="failure";
	public static final String AUTHENTICATION_FAILURE_MESSAGE="authentication_failure";
	
	/**
	 * the method will check that particular iolaus instance is running or not.
	 * 
	 * @param iolausDetails
	 *            IolausDetails object having required host and port
	 *            information as well as credentials.
	 * @return SUCCESS_MESSAGE - if ioluas instance is running on given host and port and user authentication is passed.
	 *         FAILURE_MESSAGE- if iolaus instance is not running on given host and port.
	 *         AUTHENTICATION_FAILURE_MESSAGE: if iolaus instance is  running on given host and port, but user authentication did not pass.
	 */
	public String checkIolausStatus(IIolausDetails iolausDetails);

	
	/**
	 * The method will query iolaus instance for a given project. if the project
	 * has particular neo4j instance id, this method will update XML for
	 * particular instance. otherwise method will send XML as it is. Iolaus is
	 * supposed to choose instance randomly and should return the instance id
	 * where the data is inserted. 
	 * 
	 * @param projectid
	 * @param Xml
	 *            :
	 * @return Id of instance in which data is inserted
	 * @throws HerckulesException 
	 * @throws HerckulesStorageException 
	 *
	 */
	public String insertData(IIolausDetails details, String Xml) throws HerckulesStorageException, HerckulesException;


	
	/**
	 * 
	 * @param iolausDetails
	 * @return
	 */
	List<String> getNeo4jInstances(IIolausDetails iolausDetails);


	/**
	 * This method makes sure of the rest service in Iolaus to fetch all the data in the dataset associated with the dataset.
	 * 
	 * @param projectIdentifier
	 * @return
	 * @throws HerckulesStorageException
	 * @throws HerckulesException
	 */
	public abstract String getData(String projectIdentifier) throws HerckulesStorageException,
			HerckulesException;


	/**
	 * This method makes sure of the rest service in Iolaus to fetch the data based on the query, 
	 * in the dataset associated with the dataset.
	 * 
	 * @param project
	 * @param query			XML query generated based on the selected nodes and relations.
	 * @return
	 */
	public abstract String getData(IProject project, String query);

}
