package com.concrete.challenge.client.base;

import com.concrete.challenge.configuration.ContainerConfiguration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
@Service
public abstract class AbstractClient<T> implements ClientOperations<T> {

    @Autowired
    protected ContainerConfiguration containerConfiguration;
    @Autowired
    protected RestTemplate template;
    private Class<T> clazz;
    private Class<T[]> arrayClazz;
    private T[] arrayReturn;
    private T elementReturn;

    @PostConstruct
    public abstract void construct();

    @Override
    public T getObject(String url) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build().toUri();
        return Optional.ofNullable(template.getForObject(uri, getClazz())).orElse(getElementReturn());
    }

    @Override
    public T getObjectById(String url, String id) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).pathSegment(id).build().toUri();
        return Optional.ofNullable(template.getForObject(uri, getClazz())).orElse(getElementReturn());
    }

    @Override
    public T getObjectByQueryParams(String url, MultiValueMap<String, String> queryParams) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).queryParams(queryParams).build().toUri();
        return Optional.ofNullable(template.getForObject(uri, getClazz())).orElse(getElementReturn());
    }

    @Override
    public T[] getObjects(String url) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).build().toUri();
        return Optional.ofNullable(template.getForObject(uri, getArrayClazz())).orElse(getArrayReturn());
    }

    @Override
    public T[] getObjectsByQueryParams(String url, MultiValueMap<String, String> queryParams) {
        URI uri = UriComponentsBuilder.fromHttpUrl(url).queryParams(queryParams).build().toUri();
        return Optional.ofNullable(template.getForObject(uri, getArrayClazz())).orElse(getArrayReturn());
    }

}
