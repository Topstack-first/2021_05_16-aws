package org.sid.Application.Model;

import org.sid.Application.Entities.Pakage;
import org.sid.Application.Interfaces.PackageInterface;

public class PackageModel implements PackageInterface{

	@Override
	public void ruleOfDimensions(Pakage pakage) {

		double tmp;
		if(pakage.getHeight() < pakage.getDepth()) {
			tmp = pakage.getDepth();
			pakage.setDepth(pakage.getHeight());
			pakage.setHeight(tmp);
		}
		if(pakage.getDepth() < pakage.getWidth()) {
			tmp = pakage.getWidth();
			pakage.setWidth(pakage.getDepth());
			pakage.setDepth(tmp);
		}
		if(pakage.getHeight() < pakage.getDepth()) {
			tmp = pakage.getDepth();
			pakage.setDepth(pakage.getHeight());
			pakage.setHeight(tmp);
		}
		
	}

}
