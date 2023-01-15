import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    name: '',
}

const noteSlice = createSlice({
    name: 'note',
    initialState,
    reducers: {
        setNoteName: (state, action) => {
            state.name = action.payload
        },
    },
});

export const { setNoteName } = noteSlice.actions;

export default noteSlice.reducer;