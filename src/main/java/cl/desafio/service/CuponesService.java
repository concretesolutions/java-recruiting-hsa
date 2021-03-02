package cl.desafio.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cl.desafio.model.Cupon;

@Service
public class CuponesService {
	private static final Logger LOG = LoggerFactory.getLogger(CuponesService.class);

	@Autowired
	private CuponService cuponService;

	@Cacheable(value = "cuponesCache", unless = "#result.empty")
	@HystrixCommand(fallbackMethod = "CuponServiceFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public List<Cupon> getCuponesCache() {
		return getCuponesVigentes();
	}

	@HystrixCommand(fallbackMethod = "CuponServiceFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
	        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
})
	public List<Cupon> getCuponesSinCache() {
		return getCuponesVigentes();
	}

	public List<Cupon> getCuponesVigentes() {
		LOG.info("SERVICIO: ");
		List<Cupon> cuponesFilter = cuponService.getCupones().stream().filter(x -> x.getExpiresAt().after(new Date()))
				.collect(Collectors.toList());

		return cuponesFilter;
	}

	public List<Cupon> CuponServiceFallback() {
		LOG.error("SERVICIO FALLBACK: ");

		return Collections.emptyList();
	}
}
