package edu.asu.diging.lerna.herckules.service.iolaus;

import java.util.List;

import edu.asu.spring.herckules.domain.IIolausDetails;
import edu.asu.spring.herckules.exceptions.HerckulesException;
import edu.asu.spring.herckules.exceptions.HerckulesStorageException;

public interface IIolausDetailsManager {

	/**
	 * The method is use to add iolaus detail to database. The method first
	 * check that iolaus instance is running or not with iolaus and if the
	 * instance is running calls db layer method to add instance in the databse.
	 * 
	 * @param iolausdetail
	 *            : filled iolaus detail object from controller  @return
	 *            Success 1: successfully added instance. 0: failure: instance
	 *            is not running.
	 * 
	 * @throws HerckulesStorageException
	 *             If any database errors faced, it will throw the exception
	 * @throws HerckulesException 			Exception thrown when the input does not contain the minimum required data to be used in the system.
	 */
	int addIolausDetails(IIolausDetails iolausdetail)
			throws HerckulesStorageException, HerckulesException;

	/**
	 * The method is used to delete iolaus instance from the database.
	 * 
	 * @param id
	 *            : id of iolaus instance to be deleted
	 * @throws HerckulesStorageException
	 *             If any database errors faced for example if database is down or id doesn't exist in the database, it will throw the exception
	 * @throws HerckulesException 			Exception thrown when the input does not contain the minimum required data to be used in the system.
	 */
	int deleteIolausDetails(String id) throws HerckulesStorageException, HerckulesException;;

	/**
	 * The method is used to get all iolaus instance from the database
	 * 
	 * @return list of iolaus instances from the database
	 * @throws HerckulesStorageException
	 *             If any database errors faced, it will throw the exception
	 */
	List<IIolausDetails> getIolausDetails() throws HerckulesStorageException;;

	/**
	 * The method is used to update iolaus instance in the database.
	 * 
	 * @param instance
	 *            modified instance object. Id must be the same to modify the
	 *            particular iolaus instance.
	 * @throws HerckulesStorageException
	 *             If any database errors faced, it will throw the exception
	 * @throws HerckulesException 			Exception thrown when the input does not contain the minimum required data to be used in the system.
	 */
	void updateIolausDetails(IIolausDetails instance)
			throws HerckulesStorageException, HerckulesException;

	/**
	 * The method is used to get Iolaus instance by its id from the db.
	 * 
	 * @param id
	 *            : id of the iolaus instance to fetch
	 * @return :Iolaus instance having given id
	 * @throws HerckulesStorageException	If any database errors faced, it will throw the exception
	 * @throws HerckulesException 			Exception thrown when the input does not contain the minimum required data to be used in the system.
	 */
	IIolausDetails getIolausDetailsbyid(String id)
			throws HerckulesStorageException, HerckulesException;

	/**
	 * The method is used to get Iolaus instance by its host from the db
	 * 
	 * @param host
	 *            : host name for the Iolaus instance to fetch.
	 * @return Iolaus instance having given host name
	 * @throws HerckulesStorageException
	 *             If any database errors faced, it will throw the exception
	 * @throws HerckulesException 			Exception thrown when the input does not contain the minimum required data to be used in the system.
	 */
	IIolausDetails getIolausDetailsbyhost(String host)
			throws HerckulesStorageException, HerckulesException;

	/**
	 * The method checks if there exists iolaus instance having same id or same
	 * host. It is used for validation
	 * 
	 * @param instance
	 *            : the instance for which duplication needs to be checked
	 * @return 1 duplicate instance found, 0 no duplicate instance found.
	 * @throws HerckulesStorageException
	 *             If any database errors faced, it will throw the exception
	 * @throws HerckulesException 			Exception thrown when the input does not contain the minimum required data to be used in the system.
	 */
	int checkForDuplictes(IIolausDetails instance)
			throws HerckulesStorageException, HerckulesException;;

}
