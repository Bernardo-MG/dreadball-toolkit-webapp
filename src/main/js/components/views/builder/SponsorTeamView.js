import React, { Component } from 'react';
import Input from 'react-toolbox/lib/input';
import { Button } from 'react-toolbox/lib/button';
import SponsorAffinitiesLine from '../../../containers/SponsorAffinitiesLine';

const SponsorTeamView = (props) => {
   let builder;
   let affinities;
   
   builder = props.source;
   affinities = builder.sponsorChosenAffinities.join(", ");
   
   return (
      <section>
         <Input type='text' label='sponsor_name' name='name' maxLength={16} />
         <p>chosen_affinities: {affinities}</p>
         <Button label='additional_affinity' raised primary />
         <p>sponsor_rank: {builder.sponsor.rank}</p>
      </section>
   );
};

export default SponsorTeamView;