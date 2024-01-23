package accenture.challenge.recruiting.bff.aspects;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class MarcaFlujoAop {

    @After("@annotation(marcaFlujo)")
    public void imprimirLogEstandar(final JoinPoint joinPoint, MarcaFlujo marcaFlujo) {
        // hacer log transaccional
        log.info("Lista categorias top 5 aop ".concat(joinPoint.toString()));
    }

}