import { configureStore } from '@reduxjs/toolkit';
import boardSlice from './boardSlice';
import loginSlice from './loginSlice';

export default configureStore({
    reducer: {
      login: loginSlice,
      board: boardSlice,
    }
  });