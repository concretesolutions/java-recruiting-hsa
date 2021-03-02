package cl.desafio.listener;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomCacheEventLogger  implements CacheEventListener<Object, Object>{
	private static final Logger LOG = LoggerFactory.getLogger(CustomCacheEventLogger.class);
	 @Override
	    public void onEvent(
	      CacheEvent<? extends Object, ? extends Object> cacheEvent) {
		 LOG.info("CACHEEE Key = {},  Old value = {}, New value = {}",
	          cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
	    }

}
