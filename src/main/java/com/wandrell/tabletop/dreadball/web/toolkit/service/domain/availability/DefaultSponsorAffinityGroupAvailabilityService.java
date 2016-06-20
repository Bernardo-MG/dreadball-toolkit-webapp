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
package com.wandrell.tabletop.dreadball.web.toolkit.service.domain.availability;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.persistence.availability.unit.PersistentSponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.availability.SponsorAffinityGroupAvailabilityRepository;

@Service("sponsorAffinityGroupAvailabilityService")
public final class DefaultSponsorAffinityGroupAvailabilityService implements SponsorAffinityGroupAvailabilityService {

	private final SponsorAffinityGroupAvailabilityRepository affinityAvasRepository;

	@Autowired
	public DefaultSponsorAffinityGroupAvailabilityService(final SponsorAffinityGroupAvailabilityRepository repository) {
		super();

		affinityAvasRepository = checkNotNull(repository,
				"Received a null pointer as affinity availabilities repository");
	}

	@Override
	public final Iterable<? extends PersistentSponsorAffinityGroupAvailability> getAllSponsorAffinityGroupAvailabilities() {
		return getRepository().findAll();
	}

	private final SponsorAffinityGroupAvailabilityRepository getRepository() {
		return affinityAvasRepository;
	}

}
