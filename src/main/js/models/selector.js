mport schema from './schema';

export const playerSelector = schema.createSelector(session => {
    return session.Player.map(player => {
        const obj = player.toPlain();
        return Object.assign(obj, {
            genres: author.writesGenres(),
        });
    });
});