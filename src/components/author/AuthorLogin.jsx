import React, { useState } from 'react';
import axios from 'axios';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';
import './Styles2.css';
const AuthorLogin = () => {
  const [authorName, setAuthorName] = useState('');
  const [authorId, setAuthorId] = useState('');
  const [authorPassword, setAuthorPassword] = useState('');
  const navigate = useNavigate();
  const handleLogin = async () => {
    try {
      const response = await axios.post(`http://localhost:8080/login/author`, {
        authorName,
        authorId,
        authorPassword,

      });
      if (response.data === 'Author login successful') {
        toast.success('Author login successful',{
          position:'top-left',
          autoClose:2000,
          hideProgressBar:false,
          closeOnClick:true,
          style:{
            fontSize:'16px',
            padding:'16px',
            whiteSpace:'nowrap'},
          });
        navigate('/author-display', { state: { authorId } });
      } else {
        toast.error('Invalid author credentials');
      }
    } catch (error) {
      console.error('Error during author login:', error);
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
    <div className="author-login-container">
      <h2>Author Login</h2>
      <ToastContainer />
      <form>
        <label htmlFor="authorName">Author Name:</label>
        <input
          type="text"
          id="authorName"
          value={authorName}
          onChange={(e) => setAuthorName(e.target.value)}
        />
         <label htmlFor="authorId">Author Id:</label>
        <input
          type="text"
          id="authorId"
          value={authorId}
          onChange={(e) => setAuthorId(e.target.value)}
        />
         <label htmlFor="authorPassword">Author Password:</label>
        <input
          type="password"
          id="authorPassword"
          value={authorPassword}
          onChange={(e) => setAuthorPassword(e.target.value)}
        />
        <button type="button" onClick={handleLogin}>
          Login
        </button>
      </form>
    </div>
  );
};
export default AuthorLogin;
