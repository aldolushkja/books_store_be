package com.aldolushkja.books_store;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class LoggerProducer {

    @Produces
    public Logger buildLogger(InjectionPoint ip) {
        return Logger.getLogger(ip.getBean().getBeanClass().getName());
    }
}
