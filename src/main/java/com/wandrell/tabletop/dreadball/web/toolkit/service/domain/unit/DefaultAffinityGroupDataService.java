/**
 * Copyright 2015 the original author or authors
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

package com.wandrell.tabletop.dreadball.web.toolkit.service.domain.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.web.toolkit.repository.unit.AffinityGroupRepository;

/**
 * Implementation of {@link AffinityGroupDataService} working behind the scenes
 * with JPA.
 * <p>
 * This is prepared to be used with Spring, as part of the dependency injection
 * process.
 * 
 * @author Bernardo Martínez Garrido
 */
@Service("affinityGroupDataService")
public final class DefaultAffinityGroupDataService implements AffinityGroupDataService {

	/**
	 * Repository for the {@code AffinityGroup} instances.
	 */
	private final AffinityGroupRepository affinityRepository;

	/**
	 * Constructs a {@code JPAAffinityGroupService} with the specified
	 * repository.
	 * <p>
	 * Said repository is meant to be injected through Spring.
	 * 
	 * @param repository
	 *            the repository to be used by the service
	 */
	@Autowired
	public DefaultAffinityGroupDataService(final AffinityGroupRepository repository) {
		super();

		affinityRepository = checkNotNull(repository, "Received a null pointer as abilities repository");
	}

	@Override
	public final AffinityGroup getAffinityGroupById(final Integer id) {
		return getRepository().findOne(id);
	}

	@Override
	public final Iterable<? extends AffinityGroup> getAllAffinityGroups() {
		return getRepository().findAll();
	}

	/**
	 * Returns the repository being used by the service.
	 * 
	 * @return the repository being used by the service
	 */
	private final AffinityGroupRepository getRepository() {
		return affinityRepository;
	}

}
