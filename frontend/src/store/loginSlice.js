import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    isUserLoggedIn: true,
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