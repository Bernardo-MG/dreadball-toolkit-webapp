'use strict';

const React = require('react');

class Header extends React.Component {

   render() {
        return (
              <header class="header">
              <nav id="navbar-main" class="navbar navbar-main navbar-default">
                  <div class="container-fluid">
                      <div class="navbar-header">
                          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                  data-target="#navbar-main-body"
                                  aria-expanded="false" aria-controls="navbar-main">
                              <span class="sr-only">Toggle navigation</span>
                              <span class="icon-bar"></span>
                              <span class="icon-bar"></span>
                              <span class="icon-bar"></span>
                          </button>
                          <a class="navbar-brand" href="./index.html">Dreadball Webapp Template Demo</a>
                      </div>

                      <div id="navbar-main-body" class="navbar-body navbar-collapse collapse">
                          <ul class="nav navbar-nav navbar-right">
                              <li><a href="./dbo_team_pick.html">Dreadball</a></li>
                              <li><a href="./dbx_create_sponsor.html">Dreadball Xtreme</a></li>
                              <li class="dropdown">
                                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                     aria-expanded="false">Codex
                                      <span class="chevron_toggleable fa fa-chevron-up"
                                            aria-hidden="true"></span>
                                  </a>
                                  <ul class="dropdown-menu" role="menu">
                                      <li><a href="./dbo_players_list.html">DBO Players</a></li>
                                      <li><a href="./dbx_players_list.html">DBX Players</a></li>
                                      <li><a href="./mvp_list.html">MVPs</a></li>
                                      <li><a href="./team_list.html">Teams</a></li>
                                  </ul>
                              </li>
                          </ul>
                      </div>
                  </div>
              </nav>
          </header>
        )
    }
}

module.exports = Header;