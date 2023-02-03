import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    isUserLoggedIn: false,
    userName: "",
    access_token: "",
}

const loginSlice = createSlice({
    name: 'login',
    initialState,
    reducers: {
        toggleLogin: (state, action) => {
            state.isUserLoggedIn = !(state.isUserLoggedIn)
            state.userName = action.payload
        },
        setAccessToken: (state, action) => {
            state.access_token = action.payload;
        },
    },
});

export const { toggleLogin, setAccessToken } = loginSlice.actions;

export default loginSlice.reducer;