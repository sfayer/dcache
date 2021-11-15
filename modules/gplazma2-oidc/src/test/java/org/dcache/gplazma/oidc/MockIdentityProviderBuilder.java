/* dCache - http://www.dcache.org/
 *
 * Copyright (C) 2022 Deutsches Elektronen-Synchrotron
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.dcache.gplazma.oidc;

import java.net.URI;
import org.mockito.BDDMockito;

import static org.mockito.Mockito.mock;

/**
 * A fluent class for building a mock IdentityProvider.
 */
public class MockIdentityProviderBuilder {
    private final IdentityProvider provider = mock(IdentityProvider.class);

    static public MockIdentityProviderBuilder anIp(String name) {
        return new MockIdentityProviderBuilder(name);
    }

    public MockIdentityProviderBuilder(String name) {
        BDDMockito.given(provider.getName()).willReturn(name);
    }

    public MockIdentityProviderBuilder withEndpoint(String endpoint) {
        URI url = URI.create(endpoint);
        BDDMockito.given(provider.getIssuerEndpoint()).willReturn(url);

        String withTrailingSlash = endpoint.endsWith("/") ? endpoint : (endpoint + "/");
        URI config = URI.create(withTrailingSlash + ".well-known/openid-configuration");
        BDDMockito.given(provider.getConfigurationEndpoint()).willReturn(config);

        return this;
    }

    public MockIdentityProviderBuilder withAcceptedGroups() {
        BDDMockito.given(provider.areGroupsAccepted()).willReturn(true);
        return this;
    }

    public MockIdentityProviderBuilder withAcceptedUsername() {
        BDDMockito.given(provider.isUsernameAccepted()).willReturn(true);
        return this;
    }

    public IdentityProvider build() {
        return provider;
    }
}
