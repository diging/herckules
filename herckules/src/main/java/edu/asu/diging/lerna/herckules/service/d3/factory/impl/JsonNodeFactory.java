package edu.asu.diging.lerna.herckules.service.d3.factory.impl;

import org.springframework.stereotype.Service;

import edu.asu.diging.lerna.herckules.service.d3.IJsonNode;
import edu.asu.diging.lerna.herckules.service.d3.factory.IJsonNodeFactory;
import edu.asu.diging.lerna.herckules.service.d3.impl.JsonNode;


@Service
public class JsonNodeFactory implements IJsonNodeFactory{
	
		@Override
		public IJsonNode createJsonNode()
		{
			IJsonNode jsonNodeObject = new JsonNode();
			return jsonNodeObject;
		}
}
