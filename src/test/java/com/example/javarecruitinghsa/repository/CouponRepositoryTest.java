package com.example.javarecruitinghsa.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class CouponRepositoryTest {

    @InjectMocks
    CouponRepository repository;
    @Mock
    RestTemplateBuilder builder;

    @Before
    public void setup() {
        Mockito.when(builder
                .setConnectTimeout(any(Duration.class))).thenReturn(builder);
        Mockito.when(builder
                .build()).thenReturn(new RestTemplate());
    }

    @Test
    public void findCouponList_ok() {
        Assert.assertNotNull(repository.findCouponList());
    }
}
