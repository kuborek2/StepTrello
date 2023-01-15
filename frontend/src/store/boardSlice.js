import { createSlice } from "@reduxjs/toolkit";
import axios from "axios";

const initialState = {
    boardName: "",
    boardId: -1,
    boardsList: []
}

const boardSlice = createSlice({
    name: 'name',
    initialState,
    reducers: {
        setBoardName: (state, action) => {
            [ state.boardName, state.boardId ] = action.payload
        },
        setBoardsList: (state, action) => {
            state.boardsList = action.payload;
        }
    },
});

export const { setBoardName, setBoardsList } = boardSlice.actions;

export default boardSlice.reducer;