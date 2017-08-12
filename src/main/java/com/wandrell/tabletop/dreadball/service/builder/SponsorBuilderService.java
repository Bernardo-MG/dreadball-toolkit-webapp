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

package com.wandrell.tabletop.dreadball.service.builder;

import java.util.Collection;

import com.wandrell.tabletop.dreadball.web.toolkit.controller.builder.dbx.bean.SponsorAffinities;
import com.wandrell.tabletop.dreadball.web.toolkit.controller.builder.dbx.bean.SponsorAffinitiesSelection;
import com.wandrell.tabletop.dreadball.web.toolkit.controller.builder.dbx.bean.SponsorTeamAssets;

/**
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public interface SponsorBuilderService {

    public SponsorAffinitiesSelection getSelectionResult(
            final Collection<String> affinities, final Collection<String> units,
            final SponsorTeamAssets assets, final Integer baseRank);

    public SponsorAffinities
            selectAffinities(final Collection<String> affinities);

}
