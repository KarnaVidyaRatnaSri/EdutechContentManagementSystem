import React, { useState } from 'react';
import axios from 'axios';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';
import './Styles3.css';

const ReaderLogin = () => {
  const [readerName, setReaderName] = useState('');
  const [readerId, setReaderId] = useState('');
  const [readerPassword, setReaderPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await axios.post(`http://localhost:8080/login/reader`, {
        readerName,
        readerId,
        readerPassword,
      });

      console.log(response);
      if (response.data === 'Reader login successful') {
        toast.success('Reader login successful',{
          position:'top-left',
          autoClose:2000,
          hideProgressBar:false,
          closeOnClick:true,
          style:{
            fontSize:'16px',
            padding:'16px',
            whiteSpace:'nowrap'},
          });
        // Navigate to ReaderDisplay after successful login
        navigate('/reader-display');
      } else {
        toast.error('Invalid reader credentials',{
          position:toast.POSITION.TOP.MIDDILE,
          autoClose:2000,
          hideProgressBar:false,
          closeOnClick:true,
          style:{
            fontSize:'16px',
            padding:'16px',
            whiteSpace:'nowrap'},
          });
      }
    } catch (error) {
      console.error('Error during reader login:', error);
      if (error.response && error.response.status === 401) {
        toast.error('Invalid author credentials',{
          position:'top-left',
          autoClose:2000,
          hideProgressBar:false,
          closeOnClick:true,
          style:{
            fontSize:'16px',
            padding:'16px',
            whiteSpace:'nowrap'},
          });
      } else {
        toast.error('Error during login');
      }
    }
  };

  return (
    <div className="reader-login-container">
      <h2>Reader Login</h2>
      <ToastContainer />
      <form>
        <label htmlFor="readerName">Reader Name:</label>
        <input
          type="text"
          id="readerName"
          value={readerName}
          onChange={(e) => setReaderName(e.target.value)}
        />
        <label htmlFor="readerId">Reader ID:</label>
        <input
          type="text"
          id="readerId"
          value={readerId}
          onChange={(e) => setReaderId(e.target.value)}
        />
        <label htmlFor="readerPassword">Password:</label>
        <input
          type="password"
          id="readerPassword"
          value={readerPassword}
          onChange={(e) => setReaderPassword(e.target.value)}
        />

        <button type="button" onClick={handleLogin}>
          Login
        </button>
      </form>
    </div>
  );
};

export default ReaderLogin;
