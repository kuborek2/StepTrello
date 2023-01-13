import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    boardName: "",
    boardId: -1,
}

const boardSlice = createSlice({
    name: 'name',
    initialState,
    reducers: {
        setBoardName: (state, action) => {
            [ state.boardName, state.boardId ] = action.payload
        },
    },
});

export const { setBoardName, getBoardName } = boardSlice.actions;

export default boardSlice.reducer;