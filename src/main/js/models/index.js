import { ORM } from 'redux-orm';
import { Ability, Affinity, Player, SponsorAffinityAvailability, RatedPlayer } from 'models/models';

const orm = new ORM();

orm.register(Player, RatedPlayer, Ability, Affinity, SponsorAffinityAvailability);

export default orm;
