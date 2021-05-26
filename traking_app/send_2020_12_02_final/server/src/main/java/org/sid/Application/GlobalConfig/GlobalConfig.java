package org.sid.Application.GlobalConfig;

import org.sid.Application.Entities.Countries;
import org.sid.Application.Entities.DeliveryAddress;
import org.sid.Application.Entities.Feedback_rating;
import org.sid.Application.Entities.Pakage;
import org.sid.Application.Entities.Shipment;
import org.sid.Application.Entities.Shipment_status;
import org.sid.Application.Entities.Status;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SuppressWarnings("deprecation")
public class GlobalConfig extends RepositoryRestConfigurerAdapter{
   
	public void configureRepositoryRestConfiguaration(RepositoryRestConfiguration repositoryRestConfiguration) {
		
		repositoryRestConfiguration.setReturnBodyOnCreate(true);
		repositoryRestConfiguration.setReturnBodyOnUpdate(true);
		repositoryRestConfiguration.exposeIdsFor(Shipment.class);
		repositoryRestConfiguration.exposeIdsFor(Shipment_status.class);
		repositoryRestConfiguration.exposeIdsFor(Status.class);
		repositoryRestConfiguration.exposeIdsFor(Feedback_rating.class);
		repositoryRestConfiguration.exposeIdsFor(Pakage.class);
		repositoryRestConfiguration.exposeIdsFor(DeliveryAddress.class);
		repositoryRestConfiguration.exposeIdsFor(Countries.class);
		repositoryRestConfiguration.getCorsRegistry().addMapping("/**").allowedOrigins("http:/localhost:8080").allowedHeaders("*")
		.allowedMethods("POST","GET","PUT","PATCH","DELETE","HEAD","OPTIONS");
	}
}

