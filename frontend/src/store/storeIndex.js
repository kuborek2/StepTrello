import { configureStore } from '@reduxjs/toolkit';
import boardSlice from './boardSlice';
import loginSlice from './loginSlice';
import noteSlice from './noteSlice';

export default configureStore({
    reducer: {
      login: loginSlice,
      board: boardSlice,
      note: noteSlice,
    }
  });