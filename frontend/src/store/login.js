export default function login(state = false, action) {
    switch (action.type) {
      case 'CHECK':
        return state + 1
      case 'SET_TRUE':
        return state - 1
      default:
        return state
    }
  }