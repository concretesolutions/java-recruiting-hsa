package com.desafio.java.concrete.backend.settings;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ApiSettings {

    @Value("${url.api.categoria}")
    String categoriaURL;

    @Value("${url.api.cupons}")
    String cuponURL;
}
