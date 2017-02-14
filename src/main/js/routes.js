import React from 'react'
import { Route, IndexRoute } from 'react-router'
import DbxPlayers from './view/DbxPlayers';
import MainLayout from './components/MainLayout';
import Home from './view/Home';

export default <Route path="/dreadball/" component={MainLayout}>
   <IndexRoute component={Home}/>
   <Route path="/players" activeClassName="dbxPlayersLink" component={DbxPlayers}/>
</Route>