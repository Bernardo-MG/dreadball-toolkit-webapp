module.exports = (process.env.NODE_ENV === 'production') ? require('containers/Root.prod') : require('containers/Root.dev');
