package edu.asu.diging.lerna.herckules.service.iolaus.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import edu.asu.diging.lerna.herckules.domain.IIolausDetails;
import edu.asu.diging.lerna.herckules.domain.IProject;
import edu.asu.diging.lerna.herckules.exceptions.HerckulesException;
import edu.asu.diging.lerna.herckules.exceptions.HerckulesStorageException;
import edu.asu.diging.lerna.herckules.service.iolaus.IIolausConnectionManager;

@Service
public class IolausConnectionManager implements IIolausConnectionManager {

	/**
	 * 
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String checkIolausStatus(IIolausDetails iolausDetails) {

		try {
			WebResource resource = Client.create().resource(
					"http://" + iolausDetails.getHost() + ":"
							+ iolausDetails.getPort()
							+ "/iolaus/rest/authenticate");

			HttpHeaders headers = getHeaders(iolausDetails.getUsername() + ":"
					+ iolausDetails.getPassword());

			System.out.println(headers.get("Authorization").get(0));

			WebResource.Builder r = resource.header("Authorization", headers
					.get("Authorization").get(0));

			ClientResponse response = r.get(ClientResponse.class);

			System.out.println(response.getStatus());
			if (response.getStatus() == 200) {
				return IIolausConnectionManager.SUCCESS_MESSAGE;
			} else if (response.getStatus() == 401) {
				return IIolausConnectionManager.AUTHENTICATION_FAILURE_MESSAGE;
			} else {
				return IIolausConnectionManager.FAILURE_MESSAGE;
			}
		} catch (Exception e) {
			return IIolausConnectionManager.FAILURE_MESSAGE;

		}

	}

	// TODO : put entrypoint uri's in the interface
	/**
	 * {@inheritDoc}
	 * 
	 * @throws HerckulesException
	 * @throws HerckulesStorageException
	 */
	@Override
	public String insertData(IIolausDetails iolausDetails, String Xml)
			throws HerckulesStorageException, HerckulesException {

		
		WebResource resource = Client.create().resource(
				"http://" + iolausDetails.getHost() + ":"
						+ iolausDetails.getPort()
						+ "/iolaus/rest/data/uploadDataset");

		HttpHeaders headers = getHeaders(iolausDetails.getUsername() + ":"
				+ iolausDetails.getPassword());

		ClientResponse response = resource.header("Authorization",
				headers.get("Authorization").get(0)).post(ClientResponse.class,
						Xml);

		Map<String, String> result;
		try {
			result = new ObjectMapper().readValue(
					response.getEntity(String.class), HashMap.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClientHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (UniformInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return ((String) result.get("id"));
//
				
//		if (response.getStatus() == 200) {
//
//			if (project.getInstanceid() == null
//					|| project.getInstanceid().equals("")) {
//
//				try {
//					Map<String, String> result = new ObjectMapper().readValue(
//							response.getEntity(String.class), HashMap.class);
//
//					project.setInstanceid(((String) result.get("id")));
//
//					projectManager.modifyProject(project);
//
//				} catch (JsonParseException e) {
//
//					throw new HerckulesException(e);
//				} catch (JsonMappingException e) {
//					throw new HerckulesException(e);
//				} catch (ClientHandlerException e) {
//					throw new HerckulesException(e);
//				} catch (UniformInterfaceException e) {
//					throw new HerckulesException(e);
//				} catch (IOException e) {
//					throw new HerckulesException(e);
//				}
//
//			}
//			return true;
//
//		} else {
//			return false;
//		}
	}

	private HttpHeaders getHeaders(String auth) {
		HttpHeaders headers = new HttpHeaders();

		byte[] encodedAuthorisation = Base64.encode(auth.getBytes());
		headers.add("Authorization", "Basic "
				+ new String(encodedAuthorisation));

		return headers;
	}



	//TODO: Remove strings in the code
	//TODO: Add javadocs once code is finalized 
	@Override
	public String getData(String projectIdentifier) throws HerckulesStorageException, HerckulesException{

		String outputData = null;		

		//Get the project based on project identifier
		IProject project = projectManager.getProjectByIdentifier(projectIdentifier);
		if(project != null)
		{
			IIolausDetails iolausDetails = project.getIolausDetails();
			
			//Check all invalid cases
			if(iolausDetails != null && project.getDataset() != null && iolausDetails.getHost() != null && iolausDetails.getPort() != null 
					&& iolausDetails.getUsername() != null && iolausDetails.getPassword() != null)
			{
				WebResource resource = Client.create().resource("http://"+
						iolausDetails.getHost() + ":" + iolausDetails.getPort()
						+ "/iolaus/rest/query/getAll?instance="+project.getInstanceid()+"&dataset="+project.getDataset());

				HttpHeaders headers = getHeaders(iolausDetails.getUsername() + ":"
						+ iolausDetails.getPassword());

				WebResource.Builder r = resource.header("Authorization",headers.get("Authorization").get(0));

				ClientResponse response = r.get(ClientResponse.class);
				outputData = response.getEntity(String.class);
				
				//TODO: If empty resultset then reset outputData to null
				if(outputData.contains("<resultSet>\n</resultSet>"))
					outputData = null;
			}
		}

		return outputData;
	}


	@Override
	public String getData(IProject project, String query)
	{
		String outputData = null;		

		/*Pass query to Iolaus so that it can filter the data. This code for now does not make use of input query.
		 * It fetches all the data for the given project
		 * */
		if(project != null)
		{
			IIolausDetails iolausDetails = project.getIolausDetails();
			
			//Check all invalid cases
			if(iolausDetails != null && project.getDataset() != null && iolausDetails.getHost() != null && iolausDetails.getPort() != null 
					&& iolausDetails.getUsername() != null && iolausDetails.getPassword() != null)
			{
				WebResource resource = Client.create().resource("http://"+
						iolausDetails.getHost() + ":" + iolausDetails.getPort()
						+ "/iolaus/rest/query/getAll?instance="+project.getInstanceid()+"&dataset="+project.getDataset());

				HttpHeaders headers = getHeaders(iolausDetails.getUsername() + ":"
						+ iolausDetails.getPassword());

				WebResource.Builder r = resource.header("Authorization",headers.get("Authorization").get(0));

				ClientResponse response = r.get(ClientResponse.class);
				outputData = response.getEntity(String.class);
				
				//TODO: If empty resultset then reset outputData to null
				if(outputData.contains("<resultSet>\n</resultSet>"))
					outputData = null;
			}
		}

		return outputData;
	}

	/**
	 * 
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getNeo4jInstances(IIolausDetails iolausDetails) {

		WebResource resource = Client.create().resource(
				"http://" + iolausDetails.getHost() + ":"
						+ iolausDetails.getPort()
						+ "/iolaus/rest/getNeo4jInstances");

		HttpHeaders headers = getHeaders(iolausDetails.getUsername() + ":"
				+ iolausDetails.getPassword());

		Instance instance = resource.header("Authorization",
				headers.get("Authorization")).get(Instance.class);

		return instance.getInstanceList();

	}



}
