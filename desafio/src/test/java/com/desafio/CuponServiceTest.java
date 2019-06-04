package com.desafio;

import com.Utils.CallApiUtils;
import com.desafio.entidades.Cupon;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CuponServiceTest {

    @Mock
    private CallApiUtils apiUtils;
    @Mock
    private CuponRepositorie cuponRepositorie;
    private CuponService cuponService;

    @Before
    public void setup() {
        cuponService = new CuponServiceImpl(cuponRepositorie);
    }

    @Test
    public void validaExpireDateWhenDateIsAfter() throws IOException
    {
        when(cuponRepositorie.getListCupon()).thenReturn(CuponMock.withExpiredCupons());
        final List<Cupon> cupon = cuponService.getCuponsValid();
        assertEquals(2,cupon.size());
    }

}
