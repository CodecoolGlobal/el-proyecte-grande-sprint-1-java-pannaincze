import 'bootstrap/dist/css/bootstrap.css';
import "bootstrap/dist/css/bootstrap.min.css";
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import Register from "./pages/Register";
import Layout from "./Layout";
import HomePage from "./pages/HomePage";
import ProfilePage from "./pages/ProfilePage";

import GetActivity from "./pages/GetActivity";
import {ActivityCreator} from "./pages/ActivityCreator";
import Login from "./pages/Login";


const router = createBrowserRouter([

    {
        path: "/",
        element: <Layout />,
        children: [
            {
                path: "/",
                element: <HomePage />
            },
            {
                path: "/register",
                element: <Register />
            },
            {
                path: "/profile",
                element: <ProfilePage />
            },
            {
                path: "/login",
                element: <Login />
            },
            {
                path:"/activities/:id",
                element: <GetActivity />
            },
            {
                path:"activities/create",
                element: <ActivityCreator/>
            }
        ]

    }

])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
      <RouterProvider router={router}/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
