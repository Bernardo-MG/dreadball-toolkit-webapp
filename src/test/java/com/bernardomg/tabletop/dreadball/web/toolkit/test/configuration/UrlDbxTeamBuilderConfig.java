/**
 * Copyright 2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bernardomg.tabletop.dreadball.web.toolkit.test.configuration;

/**
 * Contains configuration information for the builder controller URLs.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class UrlDbxTeamBuilderConfig {

    /**
     * Affinity groups REST URL.
     */
    public static final String URL_AFFINITIES          = "/rest/builder/affinity";

    /**
     * Team validation REST URL.
     */
    public static final String URL_REPORT              = "/rest/builder/report";

    /**
     * Affinity groups REST URL.
     */
    public static final String URL_PLAYERS               = "/rest/builder/players";

    /**
     * Affinities validation REST URL.
     */
    public static final String URL_VALIDATE_AFFINITIES = "/rest/builder/validation/affinities";

    /**
     * Team validation REST URL.
     */
    public static final String URL_VALIDATE_TEAM       = "/rest/builder/validation";

    /**
     * Default constructor to avoid initialization.
     */
    private UrlDbxTeamBuilderConfig() {
        super();
    }

}
