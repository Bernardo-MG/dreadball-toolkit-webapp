import { ORM } from "redux-orm";
import { Ability, Affinity, Player } from "models/models";

const orm = new ORM();

orm.register(Player, Ability, Affinity);

export default orm;