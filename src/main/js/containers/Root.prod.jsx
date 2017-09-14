import React, { PropTypes } from 'react';
import { Provider } from 'react-redux';
import routes from 'routes';
import { Router } from 'react-router';
import { IntlProvider } from 'react-intl';
import Cookie from 'js-cookie';

const locale = Cookie.get('locale') || 'en';

const Root = ({ store, history }) => (
   <IntlProvider locale={locale}>
      <Provider store={store}>
         <Router history={history} routes={routes} />
      </Provider>
   </IntlProvider>
);

Root.propTypes = {
   store: PropTypes.object.isRequired,
   history: PropTypes.object.isRequired
};

export default Root;
