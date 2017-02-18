import React from 'react'
import { Route, IndexRoute } from 'react-router'
import DbxPlayers from './components/views/DbxPlayers';
import MainLayout from './components/layout/MainLayout';
import Home from './components/views/Home';

export default <Route path="/dreadball/" component={MainLayout}>
   <IndexRoute component={Home}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
</Route>