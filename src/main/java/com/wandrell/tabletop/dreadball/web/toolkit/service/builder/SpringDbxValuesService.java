
package com.wandrell.tabletop.dreadball.web.toolkit.service.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("dbxValuesService")
public class SpringDbxValuesService implements DbxValuesService {

    @Value("${sponsor.rank.initial}")
    private Integer initialRank;

    @Value("${sponsor.players.max}")
    private Integer maxTeamUnits;

    public SpringDbxValuesService() {
        super();
    }

    @Override
    public final Integer getInitialRank() {
        return initialRank;
    }

    @Override
    public final Integer getMaxTeamUnits() {
        return maxTeamUnits;
    }

}
