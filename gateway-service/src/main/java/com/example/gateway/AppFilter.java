package com.example.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class AppFilter implements GatewayFilterFactory<AppFilter.Config> {

	@Override
	public GatewayFilter apply(Config config) {
		return (ex, ch) -> {
			if (!ex.getRequest().getHeaders().containsKey("spring-cloud-course")) {
				ex.getResponse().setStatusCode(FORBIDDEN);
				return ex.getResponse().setComplete();
			}
			ex.getRequest().mutate()
					.headers(headers -> headers.remove("spring-cloud-course"));
			return ch.filter(ex);
		};
	}

	@Override
	public Config newConfig() {
		return new Config();
	}

	@Override
	public Class<Config> getConfigClass() {
		return Config.class;
	}

	public static class Config {

	}
}