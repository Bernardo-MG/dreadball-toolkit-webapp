const players = (state = {}, action) => {
  switch (action.type) {
    case 'LOAD_PLAYERS':
      return { source: action.units }
    default:
      return state
  }
}

export default players