module.exports = (process.env.NODE_ENV === 'production') ? require('store/configureStore.prod') : require('store/configureStore.dev');
