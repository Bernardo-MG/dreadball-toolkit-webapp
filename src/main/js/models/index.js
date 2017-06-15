import { ORM } from 'redux-orm';
import { Ability, Affinity, Player, SponsorAffinityAvailability } from 'models/models';

const orm = new ORM();

orm.register(Player, Ability, Affinity, SponsorAffinityAvailability);

export default orm;
