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

package com.wandrell.tabletop.dreadball.web.toolkit.service.faction;

import com.wandrell.tabletop.dreadball.model.faction.TeamType;

/**
 * Interface for a service which handles {@link TeamType} instances.
 * 
 * @author Bernardo Martínez Garrido
 */
public interface TeamTypeDataService {

	/**
	 * Returns all {@code TeamType} instances.
	 * 
	 * @return all {@code TeamType} instances
	 */
	public Iterable<? extends TeamType> getAllTeamTypes();

	/**
	 * Acquires an {@code TeamType} based on its id.
	 * 
	 * @param id
	 *            the {@code TeamType} id
	 * @return the {@code TeamType} with that id
	 */
	public TeamType getTeamTypeById(final Integer id);

}
