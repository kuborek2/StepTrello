import React from 'react';
import ReactDOM from 'react-dom/client';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import RegisterPage from './components/RegisterPage';
import AccessPage from './components/reusable/AccessPage';
import SignInPage from './components/SignInPage';
import { Provider } from 'react-redux'
import store from './store/storeIndex';
import DashboardPage from './components/dashboard/DashboardPage';
import BoardPage from './components/dashboard/board/BoardPage';
import BoardsList from './components/dashboard/boardlist/BoardsList';
import AddBoard from './components/dashboard/board/AddBoard';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
    <BrowserRouter>
      <Provider store={store}>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="access" element={<AccessPage />}>
          <Route path="register" element={<RegisterPage />}/>
          <Route path="signin" element={<SignInPage />}/>
          <Route path="dashboard" element={<DashboardPage />}>
            <Route path="" element={<BoardsList />}/>
            <Route path="board" element={<BoardPage />}/>
            <Route path="add-board" element={<AddBoard/>}/>
            
          </Route>

        </Route>
      </Routes>
      </Provider>
    </BrowserRouter>
    </React.StrictMode>,
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
