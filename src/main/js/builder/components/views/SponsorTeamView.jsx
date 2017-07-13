import React from 'react';

import Article from 'grommet/components/Article';
import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import EditIcon from 'grommet/components/icons/base/Edit';
import Form from 'grommet/components/Form';
import FormField from 'grommet/components/FormField';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import TextInput from 'grommet/components/TextInput';
import NumberInput from 'grommet/components/NumberInput';
import Section from 'grommet/components/Section';

import SponsorTeamUnitTable from 'builder/containers/SponsorTeamUnitTable';
import SponsorAddUnitTable from 'builder/containers/SponsorAddUnitTable';
import SponsorAffinityList from 'builder/containers/SponsorAffinityList';
import CheerleadersInput from 'builder/containers/CheerleadersInput';
import CoachingDiceInput from 'builder/containers/CoachingDiceInput';
import MediBotInput from 'builder/containers/MediBotInput';
import NastySurpriseCardInput from 'builder/containers/NastySurpriseCardInput';
import SpecialMoveCardInput from 'builder/containers/SpecialMoveCardInput';
import WagerInput from 'builder/containers/WagerInput';

import CheerleadersValue from 'builder/containers/value/CheerleadersValue';
import MediBotValue from 'builder/containers/value/MediBotValue';
import NastySurpriseCardValue from 'builder/containers/value/NastySurpriseCardValue';
import SpecialMoveCardValue from 'builder/containers/value/SpecialMoveCardValue';
import SponsorCoachingDiceValue from 'builder/containers/value/SponsorCoachingDiceValue';
import SponsorRankValue from 'builder/containers/value/SponsorRankValue';
import SponsorTeamValue from 'builder/containers/value/SponsorTeamValue';
import WagerValue from 'builder/containers/value/WagerValue';

import SponsorAssetsForm from 'builder/components/forms/SponsorAssetsForm';

const SponsorTeamView = (props) => {
   return (
         <div>
            <Article>
               <Header>
                  <Heading>sponsor_data</Heading>
               </Header>
               <Section pad="medium">
                  <Box direction='row'>
                     <Heading tag='h2'>assets</Heading>
                     <Button icon={<EditIcon />} a11yTitle='edit_assets' />
                  </Box>
                  <Box direction='row'>
                     <Box pad='medium'>
                        <SponsorCoachingDiceValue />
                     </Box>
                     <Box pad='medium'>
                        <SpecialMoveCardValue />
                     </Box>
                     <Box pad='medium'>
                        <NastySurpriseCardValue />
                     </Box>
                     <Box pad='medium'>
                        <WagerValue />
                     </Box>
                     <Box pad='medium'>
                        <MediBotValue />
                     </Box>
                     <Box pad='medium'>
                        <CheerleadersValue />
                     </Box>
                  </Box>
               </Section>
            </Article>
            <Form>
               <FormField label='sponsor_name'>
                  <TextInput id='sponsor_name' name='sponsor_name'/>
               </FormField>
               <Box direction='row'>
                  <Box pad='medium'>
                     <SponsorRankValue />
                  </Box>
                  <Box pad='medium'>
                     <SponsorTeamValue />
                  </Box>
               </Box>
               <h1>spend_rank</h1>
               <Button label='additional_affinity' />
               <SponsorAffinityList />
            </Form>
            <SponsorAssetsForm />
            <SponsorTeamUnitTable />
            <h1>add_player</h1>
            <SponsorAddUnitTable />
         </div>
   );
};

export default SponsorTeamView;
