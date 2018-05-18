import { defineMessages } from 'react-intl';

/**
 * Player roles internationalized names.
 */
const roleMessages = defineMessages({
   guard: {
      id: 'role.guard',
      defaultMessage: 'Guard'
   },
   jack: {
      id: 'role.jack',
      defaultMessage: 'Jack'
   },
   keeper: {
      id: 'role.keeper',
      defaultMessage: 'Keeper'
   },
   striker: {
      id: 'role.striker',
      defaultMessage: 'Striker'
   }
});

export default roleMessages;
