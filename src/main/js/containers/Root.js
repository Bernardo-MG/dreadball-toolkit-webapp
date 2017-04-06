import React, { PropTypes } from 'react'
import { Provider } from 'react-redux'
import routes from '../routes'
import { Router } from 'react-router'
import { IntlProvider } from 'react-intl';
import Cookie from 'js-cookie';
import DevTools from './DevTools';

const locale = Cookie.get('locale') || 'en';

const isProduction = (process.env.NODE_ENV === 'production');

const Root = ({ store, history }) => (
   <IntlProvider locale={locale}>
      <Provider store={store}>
         <div>
            <Router history={history} routes={routes} />
            {!isProduction && <DevTools />}
         </div>
      </Provider>
   </IntlProvider>
)

Root.propTypes = {
   store: PropTypes.object.isRequired,
   history: PropTypes.object.isRequired
}

export default Root