import * as types from '../constants/ActionTypes'
import fetch from 'isomorphic-fetch'

export const requestUnits = () => ({
  type: types.REQUEST_UNITS
})

export const receiveUnits = (json) => ({
  type: types.RECEIVE_UNITS,
  units: transformJson(json)
})

const transformJson = (json) => {
    var result = [];
    var entry;
    var mapped;

    for (var i=0; i<json.length; i++) {
        entry = json[i];
        mapped = {
            name : entry.name,
            role : entry.role,
            move : entry.attributes.movement,
            strength : entry.attributes.strength,
            speed : entry.attributes.speed,
            skill : entry.attributes.skill,
            armor : entry.attributes.armor,
            abilities : joinAbilities(entry.abilities),
            stranger_cost : entry.strangerCost,
            ally_cost : entry.allyCost,
            friend_cost : entry.friendCost
        }
        result.push(mapped);
    };
    
    return result;
}

const joinAbilities = (abilities) => {
    var ability;
    var result;
    
    result = '';
    for (var i=0; i<abilities.length; i++) {
        if(result.length>0){
            result += ', ';
        }
        result += abilities[i].name;
    }
    
    return result;
}

export const fetchUnits = () => dispatch => {
    dispatch(requestUnits())
    
    return fetch('./rest/codex/unit')
      .then(response => response.json())
      .then(json =>
        dispatch(receiveUnits(json))
      )
}