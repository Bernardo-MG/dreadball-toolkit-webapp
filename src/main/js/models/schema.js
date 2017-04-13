import { Schema } from "redux-orm";
import { Ability, Player } from "models/models";

const schema = new Schema();

schema.register(Player, Ability);

export default schema;