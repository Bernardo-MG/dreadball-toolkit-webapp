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

package com.wandrell.tabletop.dreadball.web.toolkit.builder.dbx.controller.bean;

/**
 * Form data for the Sponsor team players.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public class TeamPlayer {

    /**
     * Player position in the team.
     */
    private Integer position;

    /**
     * Template name for the player.
     */
    private String  templateName;

    /**
     * Default constructor.
     */
    public TeamPlayer(final String name) {
        super();

        templateName = name;
    }

    /**
     * Default constructor.
     */
    public TeamPlayer() {
        super();
    }

    /**
     * Returns the player team position.
     * 
     * @return the player team position
     */
    public final Integer getPosition() {
        return position;
    }

    /**
     * Returns the player template name.
     * 
     * @return the player template name
     */
    public final String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the player position in the team.
     * 
     * @param value
     *            the player position in the team
     */
    public final void setPosition(final Integer value) {
        position = value;
    }

    /**
     * Sets the player template name.
     * 
     * @param value
     *            the player template name
     */
    public final void setTemplateName(final String value) {
        templateName = value;
    }

}
