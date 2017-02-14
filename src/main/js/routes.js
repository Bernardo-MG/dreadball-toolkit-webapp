import React from 'react'
import { Route, IndexRoute } from 'react-router'
import DbxPlayers from './components/DbxPlayers';
import MainLayout from './components/MainLayout';
import Home from './components/Home';

export default <Route path="/dreadball/" component={MainLayout}>
   <IndexRoute component={Home}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
</Route>