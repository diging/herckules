package edu.asu.diging.lerna.herckules.service.d3.factory.impl;

import org.springframework.stereotype.Service;

import edu.asu.diging.lerna.herckules.service.d3.IJsonRelation;
import edu.asu.diging.lerna.herckules.service.d3.factory.IJsonRelationFactory;
import edu.asu.diging.lerna.herckules.service.d3.impl.JsonRelation;

@Service
public class JsonRelationFactory implements IJsonRelationFactory{
	
	@Override
	public IJsonRelation createJsonRelation()
	{
		IJsonRelation jsonRelationObject = new JsonRelation();
		return jsonRelationObject;
	}

}
