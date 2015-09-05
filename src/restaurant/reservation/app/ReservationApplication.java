package restaurant.reservation.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class ReservationApplication extends ResourceConfig {
	public ReservationApplication(){
		packages("restaurant.reservation.controller");
		
		register(io.swagger.jaxrs.listing.ApiListingResource.class);
        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		
		BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setBasePath("/hema-restaurant-api/api");
        beanConfig.setResourcePackage("restaurant.reservation.controller");
        beanConfig.setTitle("Restaurant Reservation");
        beanConfig.setScan(true);
        
        
		
		
	}

}
