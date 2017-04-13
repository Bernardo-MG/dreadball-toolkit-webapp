import { ORM } from "redux-orm";
import { Ability, Player } from "models/models";

const orm = new ORM();

orm.register(Player, Ability);

export default orm;