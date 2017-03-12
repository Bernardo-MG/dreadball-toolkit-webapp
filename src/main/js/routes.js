import React from 'react'
import { Route, IndexRoute } from 'react-router'
import DbxPlayers from './components/views/codex/DbxPlayers';
import SponsorAffinities from './components/views/builder/SponsorAffinities';
import MainLayout from './components/layout/MainLayout';
import Home from './components/views/Home';

export default <Route path="/" component={MainLayout}>
   <IndexRoute component={Home}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
   <Route path="/team/affinities" activeClassName="sponsorAffinitiesLink" component={SponsorAffinities}/>
</Route>