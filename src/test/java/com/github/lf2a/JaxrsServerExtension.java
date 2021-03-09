package com.github.lf2a;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.testutil.common.TestUtil;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * <h1>JaxrsServerExtension.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 08/03/2021
 */
public class JaxrsServerExtension<I> implements BeforeEachCallback, AfterEachCallback {

    private final Class<I> service;
    private final Supplier<? extends I> supplierInstance;
    private final List<Object> providers = new LinkedList<>();
    private Server server;
    private String baseUrl;

    private JaxrsServerExtension(Class<I> service, Supplier<? extends I> supplierInstance) {
        this.service = service;
        this.supplierInstance = supplierInstance;
    }

    public static <I> JaxrsServerExtension<I> jaxrsServer(Class<I> serviceInterface, Supplier<? extends I> serviceImplementationSupplier) {
        return new JaxrsServerExtension<>(serviceInterface, serviceImplementationSupplier);
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        server.destroy();
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        final JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();

        baseUrl = String.format("http://localhost:%s/", TestUtil.getNewPortNumber(service));
        factory.setAddress(baseUrl);
        factory.setProviders(providers);
        factory.setFeatures(List.of(new LoggingFeature()));
        factory.setResourceClasses(service);
        factory.setResourceProvider(service, new SingletonResourceProvider(supplierInstance.get(), true));
        factory.setFeatures(List.of(new LoggingFeature()));

        this.server = factory.create();
    }

    public String baseUrl() {
        return baseUrl;
    }

    public JaxrsServerExtension<I> withProvider(Object provider) {
        providers.add(provider);
        return this;
    }
}
