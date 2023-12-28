import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Display from './components/Display/Display';
import AdminLogin from './components/admin/AdminLogin';
import AuthorLogin from './components/author/AuthorLogin';
import ReaderLogin from './components/reader/ReaderLogin';
import AdminDisplay from './components/admindisplay/AdminDisplay';
import AuthorDisplay from './components/authorDisplay/AuthorDisplay';
import ReaderDisplay from './components/readerDisplay/ReaderDisplay' ;
import './App.css';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Display />} />
        <Route path="/admin-login" element={<AdminLogin />} />
        <Route path="/author-login" element={<AuthorLogin />} />
        <Route path="/reader-login" element={<ReaderLogin />} />
        <Route path="/admin-display" element={<AdminDisplay />} />
        <Route path="/author-display" element={<AuthorDisplay />} />
        <Route path="/reader-display" element={<ReaderDisplay/>} />
      </Routes>
      <ToastContainer />
    </Router>
  );
}

export default App;
