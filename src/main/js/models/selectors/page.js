
export const sponsorselectCurrentUnitPage = (state) => state.pagination.ratedUnits.page;

export const selectCurrentUnitPage = (state) => state.pagination.units.page;

export const selectCurrentUnitPageVisual = (state) => state.pagination.units.page + 1;

export const selectTotalUnitPages = (state) => state.pagination.units.totalPages;
