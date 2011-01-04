package org.dcache.boot;

/**
 * Constants for property names used by the boot loader.
 */
public class Properties
{
    public static final String PROPERTY_DCACHE_LAYOUT_URI = "dcache.layout.uri";
    public static final String PROPERTY_HOST_NAME = "host.name";
    public static final String PROPERTY_HOST_FQDN = "host.fqdn";
    public static final String PROPERTY_DOMAIN_NAME = "domain.name";
    public static final String PROPERTY_DOMAIN_SERVICE = "domain.service";
    public static final String PROPERTY_DOMAIN_SERVICE_URI = "domain.service.uri";
    public static final String PROPERTY_DOMAIN_PRELOAD = "domain.preload";
    public static final String PROPERTY_LOG_CONFIG = "dcache.log.configuration";

    public static final String PROPERTY_DOMAINS = "dcache.domains";
    public static final String PROPERTY_CELL_NAME = "cell.name";

    protected Properties()
    {
    }
}