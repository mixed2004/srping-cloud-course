package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GatewayConfig {

	@Bean
	public RouteLocator locator(RouteLocatorBuilder routeLocatorBuilder,
	                            AppFilter appFilter) {
		return routeLocatorBuilder.routes()
				.route("route1", r -> r.path("/api/client/**")
						.filters(f -> f.filter(appFilter
								.apply(new AppFilter.Config())))
						.uri("lb://client-service"))
				.route("route2", r -> r.path("/api/update/**")
						.filters(f -> f.filter(appFilter
								.apply(new AppFilter.Config())))
						. uri("lb://client-update"))
				.build();
	}

}
