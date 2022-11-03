import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    name: '',
}

const boardSlice = createSlice({
    name: 'board',
    initialState,
    reducers: {
        setBoardName: (state, action) => {
            state.name = action.payload
        },
    },
});

export const { setBoardName } = boardSlice.actions;

export default boardSlice.reducer;