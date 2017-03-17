import React from 'react';
import StatefulInput from '../../StatefulInput';
import { Button } from 'react-toolbox/lib/button';

const SponsorTeamView = (props) => {
   let builder;
   let affinities;
   
   builder = props.source;
   affinities = builder.sponsorChosenAffinities.join(", ");
   
   return (
      <section>
         <StatefulInput type='text' label='sponsor_name' maxLength={16} />
         <p>chosen_affinities: {affinities}</p>
         <p>sponsor_rank: {builder.sponsor.rank}</p>
         <h1>spend_rank</h1>
         <Button label='additional_affinity' raised primary />
         <StatefulInput type='number' label='coaching_dice' maxLength={3} />
         <StatefulInput type='number' label='special_move_card' maxLength={3} />
         <StatefulInput type='number' label='nasty_surprise_card' maxLength={3} />
         <StatefulInput type='number' label='wager' maxLength={3} />
      </section>
   );
};

export default SponsorTeamView;