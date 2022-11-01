import { createSlice } from "@reduxjs/toolkit";

const initalState = {
    isUserLoggedIn: false
}

export const loginSlice = createSlice({
    name: 'login',
    initalState,
    reducers: {
        toggleLogin: (state) => {
            state.isUserLoggedIn = !state.isUserLoggedIn
        },
    },
});

export const { toggleLogin } = loginSlice.actions;

export default loginSlice.reducer;