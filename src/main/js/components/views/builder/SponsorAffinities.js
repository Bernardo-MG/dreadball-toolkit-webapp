import React from 'react';
import { List, ListSubHeader, ListCheckbox } from 'react-toolbox/lib/list';

const SponsorAffinities = () => {
   return (
      <div className="horizontal">
         <List selectable ripple className="horizontalChild">
            <ListSubHeader caption='list_a' />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
         </List>
         <List selectable ripple className="horizontalChild">
            <ListSubHeader caption='list_b' />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
            <ListCheckbox
               caption='affinity'
               checked={false} />
         </List>
      </div>
   );
};

export default SponsorAffinities;