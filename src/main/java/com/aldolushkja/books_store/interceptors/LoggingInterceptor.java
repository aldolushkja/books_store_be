package com.aldolushkja.books_store.interceptors;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Loggable
public class LoggingInterceptor {

    @Inject
    Logger LOGGER;

    @AroundInvoke
    public Object logEntryMethod(InvocationContext ctx) throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            LOGGER.info("Entering method: " + ctx.getMethod().getName());
            return ctx.proceed();
        } finally {
            long endtime = System.currentTimeMillis();
            LOGGER.info("Exit method: " + ctx.getMethod().getName() + ". Execution took " + (endtime - startTime) + " ms.");
        }
    }
}
