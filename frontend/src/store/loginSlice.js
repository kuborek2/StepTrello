import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    isUserLoggedIn: false,
}

const loginSlice = createSlice({
    name: 'login',
    initialState,
    reducers: {
        toggleLogin: (state) => {
            state.isUserLoggedIn = !(state.isUserLoggedIn)
        },
    },
});

export const { toggleLogin } = loginSlice.actions;

export default loginSlice.reducer;