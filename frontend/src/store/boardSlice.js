import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    boardName: "",
}

const boardSlice = createSlice({
    name: 'name',
    initialState,
    reducers: {
        setBoardName: (state, action) => {
            state.boardName = action.payload
        },
    },
});

export const { setBoardName, getBoardName } = boardSlice.actions;

export default boardSlice.reducer;