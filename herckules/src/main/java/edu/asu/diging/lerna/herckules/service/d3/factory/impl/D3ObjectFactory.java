package edu.asu.diging.lerna.herckules.service.d3.factory.impl;

import org.springframework.stereotype.Service;

import edu.asu.diging.lerna.herckules.service.d3.ID3Object;
import edu.asu.diging.lerna.herckules.service.d3.factory.ID3ObjectFactory;
import edu.asu.diging.lerna.herckules.service.d3.impl.D3Object;

@Service
public class D3ObjectFactory implements ID3ObjectFactory {

	@Override
	public ID3Object createD3Object()
	{
		ID3Object D3Object = new D3Object();
		return D3Object;
	}
}
