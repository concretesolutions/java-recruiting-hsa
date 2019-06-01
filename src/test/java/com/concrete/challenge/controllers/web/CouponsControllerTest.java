package com.concrete.challenge.controllers.web;

import com.concrete.challenge.controllers.CouponsController;
import com.concrete.challenge.service.CouponsService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CouponsControllerTest {

    @InjectMocks
    private CouponsController couponsController;

    @Mock
    private CouponsService couponsService;


}
